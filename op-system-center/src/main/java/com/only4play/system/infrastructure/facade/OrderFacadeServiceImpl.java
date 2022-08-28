package com.only4play.system.infrastructure.facade;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.system.domain.objectsku.ObjectSku;
import com.only4play.system.domain.objectsku.repository.ObjectSkuRepository;
import com.only4play.system.domain.objectsku.vo.ObjectSkuVO;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderFacadeServiceImpl implements IOrderFacadeService{

  private final ObjectSkuRepository skuRepository;

  @Override
  public ObjectSkuVO findSkuInfoById(Long skuId) {
    Optional<ObjectSku> sku = skuRepository.findById(skuId);
    if(!sku.isPresent()){
      throw new BusinessException(CodeEnum.NotFindError);
    }
    return new ObjectSkuVO(sku.get());
  }
}
