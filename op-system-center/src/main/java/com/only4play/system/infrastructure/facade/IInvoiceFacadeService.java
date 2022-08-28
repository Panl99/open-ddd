package com.only4play.system.infrastructure.facade;

import com.only4play.system.domain.invoice.enterpriseentity.vo.EnterpriseEntityVO;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.ExchangeInvoiceContext;
import com.only4play.system.domain.invoice.payitemconfig.vo.PayItemConfigVO;
import com.only4play.system.domain.invoice.taxrateconfig.vo.TaxRateConfigVO;
import com.only4play.system.infrastructure.elastic.OrderReceiptDocument;
import com.only4play.system.infrastructure.model.CodeValue;
import io.vavr.Tuple2;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IInvoiceFacadeService {

  /**
   * 根据订单信息找到企业信息
   * @param orderAttr
   * @return
   */
  EnterpriseEntityVO orderRouter2TaxCode(List<CodeValue> orderAttr);

  /**
   * 根据交易类型找到配置的支付可不可以开票配置项  -》 这里可以进行扩展，配置到交易单位，根据订单属性获取都可以的，满足公司的任何需求
   * @param tradeTypeCode
   * @return
   */
  List<PayItemConfigVO> getPayItemConfigs(String tradeTypeCode);

  /**
   * 根据税收分类编码 找到税率相关的配置信息
   * @param taxCategoryCode
   * @return
   */
  Optional<TaxRateConfigVO> findRateConfigByTaxCategoryCode(String taxCategoryCode);

  /**
   * 拆票
   * @param context
   */
  List<Tuple2<String, Map<Integer,List<OrderReceiptDocument>>>> splitInvoice(ExchangeInvoiceContext context);

  /**
   * 填充票面信息
   * @param context
   */
  void populateInvoice(ExchangeInvoiceContext context);

}
