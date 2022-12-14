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

  @FieldDesc(name = "????????????")
  @Convert(converter = InvoiceTypeConverter.class)
  private InvoiceType invoiceType;

  @FieldDesc(name = "????????????")
  @Convert(converter = InvoiceKindConverter.class)
  private InvoiceKind invoiceKind;

  @FieldDesc(name = "????????????")
  @Convert(converter = TitleTypeConverter.class)
  private TitleType titleType;

  @FieldDesc(name = "?????????")
  private String batchNo;

  @FieldDesc(name = "???????????????")
  private Integer indexNo;

  @FieldDesc(name = "??????????????????")
  private String applyChannelNo;

  @FieldDesc(name = "????????????")
  private BigDecimal invoiceAmount;

  @FieldDesc(name = "??????????????????")
  private String applyFlowNo;

  /**
   * ??????????????????
   */
  @FieldDesc(name = "??????")
  private String sellerName;

  @FieldDesc(name = "??????????????????")
  private String sellerTaxNo;

  @FieldDesc(name = "??????")
  private String sellerAddress;

  @FieldDesc(name = "??????")
  private String sellerPhone;

  @FieldDesc(name = "??????????????????")
  private String sellerOpenBank;

  @FieldDesc(name = "????????????")
  private String sellerAccount;

  @FieldDesc(name = "????????????")
  private String taxCode;

  /**
   * ???????????????
   */
  @FieldDesc(name = "?????????")
  private String drawer;

  @FieldDesc(name = "?????????")
  private String reviewer;

  @FieldDesc(name = "?????????")
  private String payee;

  /**
   * ????????????
   */

  @FieldDesc(name = "??????")
  private String customerName;

  @FieldDesc(name = "??????????????????")
  private String customerTaxNo;

  @FieldDesc(name = "????????????")
  private String customerAddress;

  @FieldDesc(name = "????????????")
  private String customerPhone;

  @FieldDesc(name = "??????????????????")
  private String customerOpenBank;

  @FieldDesc(name = "??????????????????")
  private String customerAccount;

  @Convert(converter = ValidStatusConverter.class)
  @IgnoreUpdater
  @IgnoreCreator
  private ValidStatus validStatus;

  @Convert(converter = CodeValueListConverter.class)
  @FieldDesc(name = "????????????????????????????????????")
  private List<CodeValue> extAttrs;


  /**
   * ????????????
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
    //???????????????
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