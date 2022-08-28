package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange;

import com.only4play.common.exception.BusinessException;
import com.only4play.order.commons.filters.AbstractOrderFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.InvoiceType;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.exchange.ExchangeInvoiceModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.ExchangeInvoiceContext;
import com.only4play.system.infrastructure.constants.InvoiceErrorCode;
import com.only4play.system.infrastructure.utils.GBKUtil;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 用户输入校验，这里需要按照税务系统的要求进行数据格式的校验
 */
@Slf4j
public class InputCheckFilter extends AbstractOrderFilter<ExchangeInvoiceContext> {

  @Override
  protected void handle(ExchangeInvoiceContext context) {
    ExchangeInvoiceModel invoiceModel = context.getExchangeInvoiceModel();
    if(Objects.equals(InvoiceType.SPECIAL,invoiceModel.getInvoiceType())){
      //专票的税务编码不能为空
      if(StringUtils.isEmpty(invoiceModel.getCustomerModel().getCustomerTaxNo())){
        throw new BusinessException(InvoiceErrorCode.TAX_NO_EMPTY);
      }
    }
    Optional.ofNullable(invoiceModel.getCustomerModel().getCustomerAccount())
        .ifPresent(tx -> {
          if(!GBKUtil.matchesX(tx)){
            throw new BusinessException(InvoiceErrorCode.BANK_ACCOUNT_ILLEGAL);
          }
        });
    Optional.ofNullable(invoiceModel.getCustomerModel().getCustomerAddress())
        .ifPresent(tx -> {
          if(!GBKUtil.matchesX(tx)){
            throw new BusinessException(InvoiceErrorCode.ADDRESS_ILLEGAL);
          }
        });
    Optional.ofNullable(invoiceModel.getCustomerModel().getCustomerPhone())
        .ifPresent(tx -> {
          if(!GBKUtil.matchesX(tx)){
            throw new BusinessException(InvoiceErrorCode.PHONE_ILLEGAL);
          }
        });
    Optional.ofNullable(invoiceModel.getCustomerModel().getCustomerOpenBank())
        .ifPresent(tx -> {
          if(!GBKUtil.matchesX(tx)){
            throw new BusinessException(InvoiceErrorCode.OPEN_BANK_ILLEGAL);
          }
        });

  }
}
