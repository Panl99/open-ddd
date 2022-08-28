package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register;

import com.only4play.common.exception.BusinessException;
import com.only4play.order.commons.filters.AbstractOrderFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterModel.OrderRegisterItem;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.model.register.OrderRegisterResultModel.ReceiptItemModel;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.context.OrderReceiptContext;
import com.only4play.system.domain.invoice.taxrateconfig.vo.TaxRateConfigVO;
import com.only4play.system.domain.objectsku.vo.ObjectSkuVO;
import com.only4play.system.infrastructure.constants.InvoiceErrorCode;
import com.only4play.system.infrastructure.facade.IInvoicePipeLineFacadeService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 解析订单项到凭据项
 */
@RequiredArgsConstructor
@Slf4j
public class PopulateReceiptItemFilter extends AbstractOrderFilter<OrderReceiptContext> {

  private final IInvoicePipeLineFacadeService facadeService;

  @Override
  protected void handle(OrderReceiptContext orderReceiptContext) {
    List<OrderRegisterItem> orderItems = orderReceiptContext.getModel().getOrderItems();
    List<ReceiptItemModel> resultItems = orderItems.stream()
        .map(item -> {
          Long skuId = item.getSkuId();
          ObjectSkuVO skuVo = facadeService.getOrderFacadeService()
              .findSkuInfoById(skuId);
          Optional<TaxRateConfigVO> taxRateConfig = facadeService.getInvoiceFacadeService()
              .findRateConfigByTaxCategoryCode(skuVo.getTaxCategoryNo());
          if (!taxRateConfig.isPresent()) {
            throw new BusinessException(InvoiceErrorCode.TAX_RATE_NOT_CONFIG);
          }
          return orderItemConvert(item, taxRateConfig.get(), skuVo);
        }).collect(Collectors.toList());
    orderReceiptContext.getRegisterResultModel().setItems(resultItems);
  }

  private ReceiptItemModel orderItemConvert(OrderRegisterItem item, TaxRateConfigVO vo,ObjectSkuVO skuVo){
    ReceiptItemModel resultItem = new ReceiptItemModel();
    resultItem.setItemUnit(item.getItemUnit());
    resultItem.setCount(item.getCount());
    resultItem.setDisplayName(vo.getDisplayName());
    resultItem.setSkuId(skuVo.getId());
    resultItem.setSkuName(skuVo.getSkuName());
    resultItem.setTaxRate(vo.getTaxRate());
    resultItem.setTaxCategory(vo.getTaxCategory());
    resultItem.setTaxCategoryCode(vo.getTaxCategoryCode());
    resultItem.setAmount(item.getAmount());
    return resultItem;
  }
}
