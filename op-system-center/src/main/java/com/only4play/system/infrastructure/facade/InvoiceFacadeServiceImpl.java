package com.only4play.system.infrastructure.facade;

import static io.vavr.API.$;
import static io.vavr.API.Match;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.NumberUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.only4play.common.constants.ValidStatus;
import com.only4play.common.exception.BusinessException;
import com.only4play.system.domain.invoice.enterpriseentity.service.IEnterpriseEntityService;
import com.only4play.system.domain.invoice.enterpriseentity.vo.EnterpriseEntityVO;
import com.only4play.system.domain.invoice.enterpriserouter.EnterpriseRouter;
import com.only4play.system.domain.invoice.enterpriserouter.repository.EnterpriseRouterRepository;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceStyle;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.InvoiceItemModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.InvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.OperateUserModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.SellerModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel.ReceiptItemModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.ExchangeInvoiceContext;
import com.only4play.system.domain.invoice.payitemconfig.PayItemConfig;
import com.only4play.system.domain.invoice.payitemconfig.repository.PayItemConfigRepository;
import com.only4play.system.domain.invoice.payitemconfig.vo.PayItemConfigVO;
import com.only4play.system.domain.invoice.taxrateconfig.TaxRateConfig;
import com.only4play.system.domain.invoice.taxrateconfig.repository.TaxRateConfigRepository;
import com.only4play.system.domain.invoice.taxrateconfig.vo.TaxRateConfigVO;
import com.only4play.system.infrastructure.config.InvoiceOperateProperties;
import com.only4play.system.infrastructure.constants.InvoiceErrorCode;
import com.only4play.system.infrastructure.elastic.OrderReceiptDocument;
import com.only4play.system.infrastructure.elastic.OrderReceiptDocumentRepository;
import com.only4play.system.infrastructure.model.CodeValue;
import io.vavr.API;
import io.vavr.Tuple2;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.assertj.core.util.Streams;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceFacadeServiceImpl implements IInvoiceFacadeService {

  private final EnterpriseRouterRepository enterpriseRouterRepository;

  private final IEnterpriseEntityService enterpriseEntityService;

  private final PayItemConfigRepository payItemConfigRepository;

  private final TaxRateConfigRepository taxRateConfigRepository;

  private final OrderReceiptDocumentRepository receiptDocumentRepository;

  private final InvoiceOperateProperties operateProperties;

  /**
   * 一般公司也不会有太多的企业开票主体,太多就加缓存
   *
   * @param orderAttr
   * @return
   */
  @Override
  public EnterpriseEntityVO orderRouter2TaxCode(List<CodeValue> orderAttr) {
    //根据排序匹配到最优路由
    List<RouterCheckerModel> models = orderAttr.stream()
        .map(v -> new RouterCheckerModel(v.getK(), v.getV())).collect(Collectors.toList());
    Optional<EnterpriseRouter> enterpriseRouter = enterpriseRouterRepository.findAll()
        .stream()
        .filter(r -> Objects.equals(ValidStatus.VALID, r.getValidStatus()))
        .sorted(Comparator.comparingInt(EnterpriseRouter::getSortNum))
        .filter(router -> models.containsAll(
            router.getCodeValueList()
                .stream()
                .map(v -> new RouterCheckerModel(v.getK(), v.getV()))
                .collect(Collectors.toList())))
        .findFirst();
    if (enterpriseRouter.isPresent()) {
      EnterpriseEntityVO vo = enterpriseEntityService.findById(
          enterpriseRouter.get().getEnterpriseId());
      return vo;
    } else {
      throw new BusinessException(InvoiceErrorCode.ENTERPRISE_NOT_FIND);
    }
  }

  @Override
  public List<PayItemConfigVO> getPayItemConfigs(String tradeTypeCode) {
    List<PayItemConfig> configs = payItemConfigRepository.findPayItemConfigsByTradeTypeCode(
        tradeTypeCode);
    return configs.stream().map(entity -> new PayItemConfigVO(entity)).collect(Collectors.toList());
  }


  @Override
  public Optional<TaxRateConfigVO> findRateConfigByTaxCategoryCode(String taxCategoryCode) {
    Optional<TaxRateConfig> taxRate = taxRateConfigRepository.findByTaxCategoryCode(
        taxCategoryCode);
    if (taxRate.isPresent()) {
      return Optional.of(new TaxRateConfigVO(taxRate.get()));
    }
    return Optional.empty();
  }

  /**
   * 根据配置的票面最大金额拆票
   *
   * @param context
   */
  @Override
  public List<Tuple2<String, Map<Integer, List<OrderReceiptDocument>>>> splitInvoice(
      ExchangeInvoiceContext context) {
    //查询到所有的凭据
    Iterable<OrderReceiptDocument> all = receiptDocumentRepository.findAllById(
        context.getExchangeInvoiceModel().getFlowNos().stream().map(f -> String.valueOf(f)).collect(
            Collectors.toList()));
    InvoiceType invoiceType = context.getExchangeInvoiceModel().getInvoiceType();
    //根据企业的税务编码进行分组
    Map<String, List<OrderReceiptDocument>> enterpriseMap = Streams.stream(all)
        .collect(Collectors.groupingBy(doc -> doc.getTaxCode()));
    //企业的税务编码 -> 第几张发票 -> 发票对应的所有凭据信息
    List<Tuple2<String, Map<Integer, List<OrderReceiptDocument>>>> list = Lists.newArrayList();
    //根据配置的票面金额 然后算出发票索引号，然后分组
    enterpriseMap.entrySet().stream().forEach(m -> {
      //记录当前企业票面总额，用于计算发票索引号,需要排序是为了尽量让所有的票 依次累加
      Map<String, BigDecimal> totalAmount = Maps.newConcurrentMap();
      Map<Integer, List<OrderReceiptDocument>> invoiceMap = m.getValue()
          .stream()
          .sorted(Comparator.comparing(OrderReceiptDocument::getValidAmount))
          .collect(Collectors.groupingBy(
              doc -> getIndexKey(m.getKey(), doc.getValidAmount(), totalAmount, invoiceType)));
      list.add(new Tuple2<>(m.getKey(), invoiceMap));
    });
    return list;
  }

  @Override
  public void populateInvoice(ExchangeInvoiceContext context) {
    //获取拆票结果
    List<Tuple2<String, Map<Integer, List<OrderReceiptDocument>>>> splitResult = context.getSplitResult();
    if (IterUtil.isEmpty(splitResult)) {
      throw new BusinessException(InvoiceErrorCode.SPLIT_RESULT_EMPTY);
    }
    List<InvoiceModel> invoiceModels = Lists.newArrayList();
    splitResult.stream()
        .forEach(tp -> {
          //税务编码
          String taxCode = tp._1;
          //发票信息
          Map<Integer, List<OrderReceiptDocument>> invoiceInfo = tp._2;
          //查询企业信息
          EnterpriseEntityVO vo = enterpriseEntityService.findByTaxCode(taxCode);
          InvoiceModel im = new InvoiceModel();
          //销方信息即企业信息
          SellerModel sm = vo2SellerModel(vo);
          im.setSellerModel(sm);
          //设置操作人信息
          im.setOperateUserModel(getOperateUserModel());
          //获取开票方式
          InvoiceStyle invoiceStyle = context.getExchangeInvoiceModel().getInvoiceStyle();
          List<InvoiceItemModel> itemModels = Lists.newArrayList();
          invoiceInfo.entrySet().forEach(info -> {
            im.setIndexNo(info.getKey());
            im.setReceiptDocuments(info.getValue());
            List<ReceiptItemModel> allModels = info.getValue()
                .stream()
                .map(m -> m.getReceiptItemModels())
                .flatMap(p -> p.stream())
                .collect(Collectors.toList());
            //根据条目或者类别
            Map<String, List<ReceiptItemModel>> itemMap;
            if (Objects.equals(InvoiceStyle.CATEGORY, invoiceStyle)) {
              //如果按类别开票 则根据类别分组计算求和
              itemMap = allModels.stream()
                  .collect(Collectors.groupingBy(ReceiptItemModel::getTaxCategoryCode));
            } else {
              //如果按商品开票，则根据商品分组计算求和
              itemMap = allModels.stream()
                  .collect(Collectors.groupingBy(r -> String.valueOf(r.getSkuId())));
            }
            AtomicInteger lineCode = new AtomicInteger(0);
            itemMap.entrySet()
                .forEach(ey -> {
                  InvoiceItemModel model = new InvoiceItemModel();
                  //数量求和
                  int totalCount = ey.getValue().stream().mapToInt(v -> v.getCount())
                      .reduce(0, (a, b) -> (a + b));
                  model.setCount(totalCount);
                  BigDecimal totalAmount = ey.getValue().stream().map(v -> v.getAmount())
                      .reduce(BigDecimal.ZERO, (a, b) -> NumberUtil.add(a, b));
                  model.setAmount(totalAmount);
                  //金额求和
                  //根据类别的话可以随便找个第一个商品set
                  ReceiptItemModel first = ey.getValue().get(0);
                  model.setDisplayName(first.getDisplayName());
                  model.setItemUnit(first.getItemUnit());
                  model.setSkuId(first.getSkuId());
                  model.setTaxRate(first.getTaxRate());
                  model.setSkuName(first.getSkuName());
                  model.setTaxCategory(first.getTaxCategory());
                  model.setTaxCategoryCode(first.getTaxCategoryCode());
                  //金税要求设置一下行号
                  model.setLineCode(lineCode.incrementAndGet());
                  itemModels.add(model);
                });
          });
          im.setItemList(itemModels);
          invoiceModels.add(im);
        });
    context.getResultModel().setInvoiceList(invoiceModels);
  }

  /**
   * 开票人信息
   *
   * @return
   */
  private OperateUserModel getOperateUserModel() {
    OperateUserModel model = new OperateUserModel();
    model.setDrawer(operateProperties.getDrawer());
    model.setPayee(operateProperties.getPayee());
    model.setReviewer(operateProperties.getReviewer());
    return model;
  }

  /**
   * 组装销方信息
   *
   * @param vo
   * @return
   */
  private SellerModel vo2SellerModel(EnterpriseEntityVO vo) {
    SellerModel sm = new SellerModel();
    sm.setSellerAccount(vo.getBankAccount());
    sm.setSellerAddress(vo.getRegisterAddress());
    sm.setSellerName(vo.getEnterpriseName());
    sm.setSellerPhone(vo.getRegisterPhone());
    sm.setSellerTaxNo(vo.getTaxNo());
    sm.setSellerOpenBank(vo.getOpenBank());
    return sm;
  }

  /**
   * 获取发票的索引编号  这里可能出现一个订单拆成多个发票的问题，这里一般情况下遇不到，可以考虑
   *
   * @param taxCode
   * @param amount
   * @param totalAmount
   * @param invoiceType
   * @return
   */
  private Integer getIndexKey(String taxCode, BigDecimal amount,
      Map<String, BigDecimal> totalAmount, InvoiceType invoiceType) {
    BigDecimal max = getMaxMoneyConfig(invoiceType, taxCode);
    BigDecimal old = totalAmount.getOrDefault(taxCode, new BigDecimal(0));
    BigDecimal addResult = NumberUtil.add(old, amount);
    totalAmount.put(taxCode, addResult);
    return (addResult.intValue() / max.intValue()) + 1;
  }

  /**
   * 根据企业税号获取配置的最大限额
   *
   * @param invoiceType
   * @param taxCode
   * @return
   */
  private BigDecimal getMaxMoneyConfig(InvoiceType invoiceType, String taxCode) {
    EnterpriseEntityVO vo = enterpriseEntityService.findByTaxCode(taxCode);
    BigDecimal max = Match(invoiceType).of(
        API.Case($(InvoiceType.GENERAL_ELECTRONIC), vo.getElectronicInvoiceMaxLimit()),
        API.Case($(InvoiceType.SPECIAL), vo.getSpecialInvoiceMaxLimit()),
        API.Case($(InvoiceType.GENERAL_PAPER), vo.getGeneralInvoiceMaxLimit())
    );
    return max;
  }

  @Value
  class RouterCheckerModel {

    private String code;
    private String value;
  }

}
