package com.only4play.system.template;

import com.google.common.collect.Lists;
import com.only4play.system.domain.trade.order.OrderType;
import com.only4play.system.domain.trade.order.domainservice.IOrderDomainService;
import com.only4play.system.domain.trade.order.domainservice.model.OrderCreateModel;
import com.only4play.system.domain.trade.order.domainservice.model.OrderItemModel;
import com.only4play.system.domain.user.AccountType;
import com.only4play.system.infrastructure.model.CodeValue;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OrderServiceTest {

  @Autowired
  private IOrderDomainService orderDomainService;

  @Test
  public void testOrderCreate(){
    OrderCreateModel model = new OrderCreateModel();
    model.setAccountId(2L);
    model.setOrderType(OrderType.SHOP);
    model.setAccountType(AccountType.CORP);
    model.setOperateUser("管理员");
    model.setPayList(Collections.EMPTY_LIST);
    List<CodeValue> attrs = Lists.newArrayList();
    CodeValue kv = new CodeValue();
    kv.setK("channel");
    kv.setV("ios");
    kv.setL("渠道");
    attrs.add(kv);

    CodeValue kv1 = new CodeValue();
    kv1.setK("city");
    kv1.setV("河北");
    kv1.setL("城市");
    attrs.add(kv1);

    CodeValue kv2 = new CodeValue();
    kv2.setK("shop");
    kv2.setV("二号店");
    kv2.setL("二号店");
    attrs.add(kv2);
    model.setAttrs(attrs);

    List<OrderItemModel> itemModels = Lists.newArrayList();
    OrderItemModel orderItemModel = new OrderItemModel();
    orderItemModel.setSkuId(1L);
    orderItemModel.setItemCount(1);
    orderItemModel.setFeeRemark("衣服一件");
    orderItemModel.setGoodsName("衣服");
    orderItemModel.setRealAmount(new BigDecimal(String.valueOf(103.2)));
    OrderItemModel orderItemModel2 = new OrderItemModel();
    orderItemModel2.setSkuId(2L);
    orderItemModel2.setItemCount(1);
    orderItemModel2.setFeeRemark("鞋子");
    orderItemModel2.setGoodsName("鞋子");
    orderItemModel2.setRealAmount(new BigDecimal(String.valueOf(106.4)));
    itemModels.add(orderItemModel);
    itemModels.add(orderItemModel2);
    model.setItemInfoList(itemModels);
    orderDomainService.orderCreate(model);
  }

}
