package com.only4play.system.domain.invoice.invoice;

import cn.hutool.core.util.NumberUtil;
import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import com.only4play.system.domain.invoice.invoice.events.InvoiceEvents.InvoiceCreateEvent;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.InvoiceModel;
import com.only4play.system.infrastructure.converter.CodeValueListConverter;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.invoice.invoice.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.invoice.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.invoice.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.invoice.repository")
@GenService(pkgName = "com.only4play.system.domain.invoice.invoice.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.invoice.invoice.service")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.invoice.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.invoice.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.invoice.invoice.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.invoice.invoice.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.invoice.invoice.request")
@GenResponse(pkgName = "com.only4play.system.domain.invoice.invoice.response")
@Entity
@Table(name = "invoice")
@Data
public class Invoice extends BaseJpaAggregate {

  @FieldDesc(name = "发票类型")
  @Convert(converter = InvoiceTypeConverter.class)
  private InvoiceType invoiceType;

  @FieldDesc(name = "发票种类")
  @Convert(converter = InvoiceKindConverter.class)
  private InvoiceKind invoiceKind;

  @FieldDesc(name = "抬头类型")
  @Convert(converter = TitleTypeConverter.class)
  private TitleType titleType;

  @FieldDesc(name = "批次号")
  private String batchNo;

  @FieldDesc(name = "第几张发票")
  private Integer indexNo;

  @FieldDesc(name = "申请渠道编码")
  private String applyChannelNo;

  @FieldDesc(name = "发票金额")
  private BigDecimal invoiceAmount;

  @FieldDesc(name = "金税申请流水")
  private String applyFlowNo;

  /**
   * 销方开票主体
   */
  @FieldDesc(name = "名称")
  private String sellerName;

  @FieldDesc(name = "纳税人识别号")
  private String sellerTaxNo;

  @FieldDesc(name = "地址")
  private String sellerAddress;

  @FieldDesc(name = "电话")
  private String sellerPhone;

  @FieldDesc(name = "销方开户银行")
  private String sellerOpenBank;

  @FieldDesc(name = "销方账号")
  private String sellerAccount;

  @FieldDesc(name = "税务编码")
  private String taxCode;

  /**
   * 操作人信息
   */
  @FieldDesc(name = "开票人")
  private String drawer;

  @FieldDesc(name = "复核人")
  private String reviewer;

  @FieldDesc(name = "收款人")
  private String payee;

  /**
   * 客户信息
   */

  @FieldDesc(name = "名称")
  private String customerName;

  @FieldDesc(name = "纳税人识别号")
  private String customerTaxNo;

  @FieldDesc(name = "客户地址")
  private String customerAddress;

  @FieldDesc(name = "客户电话")
  private String customerPhone;

  @FieldDesc(name = "客户开户银行")
  private String customerOpenBank;

  @FieldDesc(name = "客户银行账号")
  private String customerAccount;

  @Convert(converter = ValidStatusConverter.class)
  @IgnoreUpdater
  @IgnoreCreator
  private ValidStatus validStatus;

  @Convert(converter = CodeValueListConverter.class)
  @FieldDesc(name = "开票时传递的扩展属性信息")
  private List<CodeValue> extAttrs;


  /**
   * 发票生成
   * @param exchangeInvoiceModel
   * @param invoiceModel
   */
  public void doCreate(ExchangeInvoiceModel exchangeInvoiceModel, InvoiceModel invoiceModel) {
    setBatchNo(exchangeInvoiceModel.getBatchNo());
    setValidStatus(ValidStatus.VALID);
    setIndexNo(invoiceModel.getIndexNo());

    setCustomerAccount(exchangeInvoiceModel.getCustomerModel().getCustomerAccount());
    setCustomerName(exchangeInvoiceModel.getCustomerModel().getCustomerName());
    setCustomerOpenBank(exchangeInvoiceModel.getCustomerModel().getCustomerOpenBank());
    setCustomerPhone(exchangeInvoiceModel.getCustomerModel().getCustomerPhone());
    setCustomerTaxNo(exchangeInvoiceModel.getCustomerModel().getCustomerTaxNo());
    setCustomerAddress(exchangeInvoiceModel.getCustomerModel().getCustomerAddress());

    setSellerAccount(invoiceModel.getSellerModel().getSellerAccount());
    setSellerAddress(invoiceModel.getSellerModel().getSellerAddress());
    setSellerOpenBank(invoiceModel.getSellerModel().getSellerOpenBank());
    setSellerName(invoiceModel.getSellerModel().getSellerName());
    setSellerPhone(invoiceModel.getSellerModel().getSellerPhone());
    setSellerTaxNo(invoiceModel.getSellerModel().getSellerTaxNo());
    //默认为蓝票
    setInvoiceKind(InvoiceKind.BLUE_TICKET);
    setInvoiceType(exchangeInvoiceModel.getInvoiceType());
    setTitleType(exchangeInvoiceModel.getTitleType());
    setApplyChannelNo(exchangeInvoiceModel.getApplyChannelCode());
    BigDecimal totalValidAmount = invoiceModel.getReceiptDocuments()
        .stream()
        .map(m -> m.getValidAmount())
        .reduce(BigDecimal.ZERO, (a, b) -> NumberUtil.add(a, b));
    setInvoiceAmount(totalValidAmount);
    setDrawer(invoiceModel.getOperateUserModel().getDrawer());
    setPayee(invoiceModel.getOperateUserModel().getPayee());
    setReviewer(invoiceModel.getOperateUserModel().getReviewer());
    setTaxCode(invoiceModel.getReceiptDocuments().get(0).getTaxCode());
    setExtAttrs(exchangeInvoiceModel.getExtAttrs());

    registerEvent(new InvoiceCreateEvent(this, exchangeInvoiceModel, invoiceModel));
  }


  public void init() {
    setValidStatus(ValidStatus.VALID);
  }

  public void valid() {
    setValidStatus(ValidStatus.VALID);
  }

  public void invalid() {
    setValidStatus(ValidStatus.INVALID);
  }
}