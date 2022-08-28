package com.only4play.system.template;

import com.google.common.collect.Lists;
import com.only4play.system.domain.asset.asset.domainservice.IAssetDomainService;
import com.only4play.system.domain.asset.asset.domainservice.model.BatchInOutModel;
import com.only4play.system.domain.asset.assetrecord.InOutBizType;
import com.only4play.system.domain.asset.warehouse.creator.WarehouseCreator;
import com.only4play.system.domain.asset.warehouse.service.IWarehouseService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AssetServiceTest {

  @Autowired
  private IAssetDomainService assetDomainService;

  @Autowired
  private IWarehouseService warehouseService;

  /**
   * 添加一个仓库
   */
  @Test
  public void testWarehouseCreate(){
    WarehouseCreator creator = new WarehouseCreator();
    creator.setCreateUser("默认");
    creator.setName("仓库2");
    creator.setCode("warehouse");
    creator.setAddress("默认地址");
    warehouseService.createWarehouse(creator);
  }

  @Test
  public void testSkuIn() {
    List<String> uniqueCodes = Lists.newArrayList();
    uniqueCodes.add("123456");
    uniqueCodes.add("234567");
    BatchInOutModel model = new BatchInOutModel();
    model.setSkuId(3L);
    model.setBatchNo("11111");
    model.setInOutBizType(InOutBizType.IN_FIRST);
    model.setOperateUser("用户2");
    model.setHouseId(1L);
    model.setUniqueCodes(uniqueCodes);
    model.setName("白色苹果手机");
    assetDomainService.handleAssetIn(model);
  }

  @Test
  public void testSkuIn2() {
    List<String> uniqueCodes = Lists.newArrayList();
    uniqueCodes.add("222222");
    uniqueCodes.add("333333");
    uniqueCodes.add("444444");
    BatchInOutModel model = new BatchInOutModel();
    model.setSkuId(2L);
    model.setBatchNo("22222");
    model.setInOutBizType(InOutBizType.IN_FIRST);
    model.setOperateUser("用户2");
    model.setHouseId(1L);
    model.setUniqueCodes(uniqueCodes);
    model.setName("黑色苹果手机");
    assetDomainService.handleAssetIn(model);
  }

  @Test
  public void testSkuOut(){
    List<String> uniqueCodes = Lists.newArrayList();
    uniqueCodes.add("123456");
    BatchInOutModel model = new BatchInOutModel();
    model.setSkuId(3L);
    model.setBatchNo("77777");
    model.setInOutBizType(InOutBizType.OUT_SALE);
    model.setOperateUser("测试用户1");
    model.setHouseId(1L);
    model.setUniqueCodes(uniqueCodes);
    model.setName("白色苹果手机");
    assetDomainService.handleAssetOut(model);
  }

}
