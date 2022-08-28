package com.only4play.system.domain.trade.orderitem;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.trade.orderitem.vo")
@GenCreator(pkgName = "com.only4play.system.domain.trade.orderitem.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.trade.orderitem.updater")
@GenRepository(pkgName = "com.only4play.system.domain.trade.orderitem.repository")
@GenService(pkgName = "com.only4play.system.domain.trade.orderitem.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.trade.orderitem.service")
@GenQuery(pkgName = "com.only4play.system.domain.trade.orderitem.query")
@GenMapper(pkgName = "com.only4play.system.domain.trade.orderitem.mapper")
@GenCreateRequest(pkgName = "com.only4play.system.domain.trade.orderitem.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.trade.orderitem.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.trade.orderitem.request")
@GenResponse(pkgName = "com.only4play.system.domain.trade.orderitem.response")
@Entity
@Table(name = "order_item")
@Data
public class OrderItem extends BaseJpaAggregate {

  @FieldDesc(name = "订单id")
  private Long orderId;

  @FieldDesc(name = "唯一流水号")
  private Long flowNo;

  @FieldDesc(name = "真实金额")
  private BigDecimal realAmount;

  @FieldDesc(name = "计量数量")
  private BigDecimal itemCount;

  @FieldDesc(name = "skuId")
  private String skuId;

  @FieldDesc(name = "单位")
  private String itemUnit;

  @FieldDesc(name = "商品名称")
  private String goodsName;

  @FieldDesc(name = "费用描述")
  private String feeRemark;

}