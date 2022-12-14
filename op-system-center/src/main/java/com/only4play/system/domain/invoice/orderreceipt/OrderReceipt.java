package com.only4play.system.domain.invoice.orderreceipt;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.nacos.common.utils.Objects;
import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.common.exception.BusinessException;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceResultModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel;
import com.only4play.system.domain.invoice.orderreceipt.events.OrderReceiptEvents.OrderRegisterEvent;
import com.only4play.system.infrastructure.constants.InvoiceErrorCode;
import com.only4play.system.infrastructure.converter.CodeValueListConverter;
import com.only4play.system.infrastructure.converter.PayItemListConverter;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.invoice.orderreceipt.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.orderreceipt.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.orderreceipt.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.orderreceipt.repository")
@GenService(pkgName = "com.only4play.system.domain.invoice.orderreceipt.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.invoice.orderreceipt.service")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.orderreceipt.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.orderreceipt.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.invoice.orderreceipt.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.invoice.orderreceipt.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.invoice.orderreceipt.request")
@GenResponse(pkgName = "com.only4play.system.domain.invoice.orderreceipt.response")
@Entity
@Table(name = "order_receipt")
@Data
public class OrderReceipt extends BaseJpaAggregate {

  @FieldDesc(name = "???????????????")
  private Long registerFlowNo;

  @FieldDesc(name = "??????????????????")
  private String bizSystemCode;

  @FieldDesc(name = "??????????????????")
  private String tradeTypeCode;

  @FieldDesc(name = "??????????????????")
  private String tradeTypeName;

  @FieldDesc(name = "???????????????")
  private String orderFlowNo;

  @Column(columnDefinition = "text")
  @FieldDesc(name = "????????????")
  @Convert(converter = CodeValueListConverter.class)
  private List<CodeValue> orderAttrs;

  @FieldDesc(name = "??????????????????")
  private BigDecimal validAmount;

  @FieldDesc(name = "????????????")
  private BigDecimal invalidAmount;

  @FieldDesc(name = "??????????????????")
  @Convert(converter = PayItemListConverter.class)
  @Column(columnDefinition = "text")
  private List<PayItem> validList;

  @FieldDesc(name = "?????????????????????")
  @Convert(converter = PayItemListConverter.class)
  @Column(columnDefinition = "text")
  private List<PayItem> invalidList;

  @FieldDesc(name = "????????????")
  @Convert(converter = ReceiptStatusConverter.class)
  @IgnoreCreator
  @IgnoreUpdater
  private ReceiptStatus receiptStatus;

  @FieldDesc(name = "????????????")
  @IgnoreCreator
  @IgnoreUpdater
  @Convert(converter = ValidStatusConverter.class)
  private ValidStatus validStatus;

  @FieldDesc(name = "????????????????????????")
  private String taxCode;


  public void init() {
    setValidStatus(ValidStatus.VALID);
    setReceiptStatus(ReceiptStatus.UNMAKING);
  }

  /**
   * ?????????????????????
   *
   * @param registerModel
   * @param resultModel
   */
  public void orderRegister(OrderRegisterModel registerModel,
      OrderRegisterResultModel resultModel) {
    setValidStatus(ValidStatus.VALID);
    setReceiptStatus(ReceiptStatus.UNMAKING);
    if (IterUtil.isNotEmpty(resultModel.getValidList())) {
      setValidList(resultModel.getValidList());
      setValidAmount(resultModel.getValidList()
          .stream()
          .map(r -> r.getMoney())
          .reduce(BigDecimal.ZERO, (a, b) -> NumberUtil.add(a, b)));
    } else {
      setValidList(Collections.emptyList());
      setValidAmount(BigDecimal.ZERO);
    }
    if (IterUtil.isNotEmpty(resultModel.getInvalidList())) {
      setInvalidList(resultModel.getInvalidList());
      setInvalidAmount(resultModel.getInvalidList()
          .stream()
          .map(r -> r.getMoney())
          .reduce(BigDecimal.ZERO, (a, b) -> NumberUtil.add(a, b)));
    } else {
      setInvalidList(Collections.emptyList());
      setInvalidAmount(BigDecimal.ZERO);
    }
    setTaxCode(resultModel.getTaxCode());
    registerEvent(new OrderRegisterEvent(this, registerModel, resultModel));
  }


  public void valid() {
    setValidStatus(ValidStatus.VALID);
  }

  public void invalid() {
    setValidStatus(ValidStatus.INVALID);
  }
}
