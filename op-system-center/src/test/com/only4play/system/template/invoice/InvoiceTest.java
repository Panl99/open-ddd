package com.only4play.system.template.invoice;

import com.google.common.collect.Lists;
import com.only4play.common.constants.ValidStatus;
import com.only4play.order.commons.pay.CoinPayItem;
import com.only4play.order.commons.pay.PayGroup;
import com.only4play.order.commons.pay.PayItem;
import com.only4play.order.commons.pay.PayType;
import com.only4play.system.domain.invoice.enterpriseentity.creator.EnterpriseEntityCreator;
import com.only4play.system.domain.invoice.enterpriseentity.service.IEnterpriseEntityService;
import com.only4play.system.domain.invoice.enterpriserouter.creator.EnterpriseRouterCreator;
import com.only4play.system.domain.invoice.enterpriserouter.service.IEnterpriseRouterService;
import com.only4play.system.domain.invoice.invoice.TitleType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.IOrderReceiptDomainService;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceStyle;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.CustomerModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel.OrderRegisterItem;
import com.only4play.system.domain.invoice.orderreceipt.service.IOrderReceiptService;
import com.only4play.system.domain.invoice.payitemconfig.creator.PayItemConfigCreator;
import com.only4play.system.domain.invoice.payitemconfig.service.IPayItemConfigService;
import com.only4play.system.domain.invoice.taxrateconfig.creator.TaxRateConfigCreator;
import com.only4play.system.domain.invoice.taxrateconfig.service.ITaxRateConfigService;
import com.only4play.system.domain.objectsku.SkuType;
import com.only4play.system.domain.objectsku.creator.ObjectSkuCreator;
import com.only4play.system.domain.objectsku.service.IObjectSkuService;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class InvoiceTest {

  @Autowired
  private IOrderReceiptDomainService orderReceiptDomainService;

  @Autowired
  private IEnterpriseRouterService enterpriseRouterService;

  @Autowired
  private ITaxRateConfigService taxRateConfigService;

  @Autowired
  private IEnterpriseEntityService enterpriseEntityService;

  @Autowired
  private IObjectSkuService objectSkuService;

  @Autowired
  private IPayItemConfigService payItemConfigService;

  @Autowired
  private IOrderReceiptService orderReceiptService;


  @Test
  public void testAddSku(){
    ObjectSkuCreator creator = new ObjectSkuCreator();
    creator.setSkuName("??????");
    creator.setTaxCategoryNo("10101999");
    creator.setSkuType(SkuType.SINGLE);
    creator.setMeasureUnit("???");
    creator.setChildren(Lists.newArrayList());
    objectSkuService.createObjectSku(creator);
  }

  @Test
  public void testAddEnterprise(){
    EnterpriseEntityCreator entityCreator = new EnterpriseEntityCreator();
    entityCreator.setBankAccount("bank");
    entityCreator.setTaxCode("8888");
    enterpriseEntityService.createEnterpriseEntity(entityCreator);
  }


  /**
   * ?????????????????????
   */
  @Test
  public void testAddPayItemConfig(){

    PayItemConfigCreator creator = new PayItemConfigCreator();
    creator.setPayType(PayType.WECHAT);
    creator.setTradeTypeCode("shop");
    creator.setValidStatus(ValidStatus.VALID);
    payItemConfigService.createPayItemConfig(creator);

    PayItemConfigCreator creator2 = new PayItemConfigCreator();
    creator2.setPayType(PayType.COIN);
    creator2.setTradeTypeCode("shop");
    creator2.setValidStatus(ValidStatus.INVALID);
    payItemConfigService.createPayItemConfig(creator2);

  }

  /**
   * ??????????????????
   */
  @Test
  public void testAddEnterpriseRouter(){
    EnterpriseRouterCreator routerCreator = new EnterpriseRouterCreator();
    routerCreator.setEnterpriseId(2L);
    routerCreator.setTaxCode("8888");
    routerCreator.setSortNum(1);
    List<CodeValue> codeValues = Lists.newArrayList();
    CodeValue codeValue = new CodeValue();
    codeValue.setK("city");
    codeValue.setV("??????");
    codeValues.add(codeValue);
    routerCreator.setCodeValueList(codeValues);
    enterpriseRouterService.createEnterpriseRouter(routerCreator);

  }

  /**
   * ??????????????????
   */
  @Test
  public void testAddTaxRateConfig(){
    TaxRateConfigCreator taxRateConfigCreator = new TaxRateConfigCreator();
    taxRateConfigCreator.setTaxRate(new BigDecimal("0.08"));
    taxRateConfigCreator.setTaxCategoryCode("10101999");
    taxRateConfigCreator.setTaxCategory("?????????");
    taxRateConfigCreator.setDisplayName("??????");
    taxRateConfigService.createTaxRateConfig(taxRateConfigCreator);

  }

  /**
   * ????????????????????????
   */
  @Test
  public void testOrderReceipt(){

    //?????????
    List<PayItem> payItemList = Lists.newArrayList();
    WechatPay wechatPay = new WechatPay();

    CoinPayItem coinPayItem = new CoinPayItem(new BigDecimal(8));
    payItemList.add(wechatPay);
    payItemList.add(coinPayItem);

    //?????????
    List<OrderRegisterItem> orderItems = Lists.newArrayList();
    OrderRegisterItem registerItem = new OrderRegisterItem();
    registerItem.setItemUnit("???");
    registerItem.setSkuId(2L);
    registerItem.setCount(1);
    registerItem.setAmount(new BigDecimal("13"));
    orderItems.add(registerItem);

    OrderRegisterModel registerModel = new OrderRegisterModel();
    registerModel.setAccountId("1L");
    registerModel.setAccountType(1);
    registerModel.setBizSystemCode("system_22222");
    registerModel.setTradeTypeCode("shop");
    registerModel.setOrderFlowNo("666666");
    registerModel.setPayItemList(payItemList);
    registerModel.setOrderItems(orderItems);

    //????????????
    List<CodeValue> codeValues = Lists.newArrayList();

    CodeValue c1 = new CodeValue();
    c1.setK("city");
    c1.setV("??????");
    c1.setL("??????");
    codeValues.add(c1);

    CodeValue c2 = new CodeValue();
    c2.setK("corpCode");
    c2.setV("1111");
    c2.setL("????????????");
    codeValues.add(c2);
    registerModel.setOrderAttrs(codeValues);

    orderReceiptService.createOrderReceipt(registerModel);
  }



  @Test
  public void testExchangeInvoice(){
    ExchangeInvoiceModel invoiceModel = new ExchangeInvoiceModel();
    invoiceModel.setInvoiceStyle(InvoiceStyle.CATEGORY);
    invoiceModel.setInvoiceType(InvoiceType.GENERAL_ELECTRONIC);
    invoiceModel.setTitleType(TitleType.ENTERPRISE);
    invoiceModel.setApplyChannelCode("applyChannal");
    List<CodeValue> extAttr = Lists.newArrayList();
    CodeValue cv = new CodeValue();
    cv.setK("shop_name");
    cv.setV("?????????1");
    extAttr.add(cv);
    invoiceModel.setExtAttrs(extAttr);
    invoiceModel.setFlowNos(Lists.newArrayList(1560245592050872320L));
    invoiceModel.setOperateUser("user1");
    invoiceModel.setPreview(false);
    CustomerModel customerModel = new CustomerModel();
    customerModel.setCustomerAccount("gdgdgdg");
    customerModel.setCustomerAddress("???????????????");
    customerModel.setCustomerName("??????????????????");
    customerModel.setCustomerPhone("1234353535");
    customerModel.setCustomerTaxNo("343434");
    customerModel.setCustomerOpenBank("????????????");
    invoiceModel.setCustomerModel(customerModel);
    orderReceiptService.exchangeInvoice(invoiceModel);
  }


  @Data
  static class WechatPay implements PayItem{

    @Override
    public BigDecimal getMoney() {
      return new BigDecimal("5");
    }

    @Override
    public PayGroup getPayGroup() {
      return PayGroup.THIRD_PAY;
    }

    @Override
    public PayType getPayType() {
      return PayType.WECHAT;
    }
  }




}
