package com.only4play.system.infrastructure.facade;

import com.only4play.system.domain.objectsku.vo.ObjectSkuVO;

/**
 * 订单门面
 */
public interface IOrderFacadeService {

  /**
   * 获取sku的详情
   * @param skuId
   * @return
   */
  ObjectSkuVO findSkuInfoById(Long skuId);

}
