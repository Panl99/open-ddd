package com.only4play.system.domain.invoice.orderreceipt;

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
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.invoice.orderreceipt.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.orderreceipt.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.orderreceipt.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.orderreceipt.repository")
@GenService(pkgName = "com.only4play.system.domain.invoice.orderreceipt.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.invoice.orderreceipt.service")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.orderreceipt.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.orderreceipt.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.invoice.orderreceipt.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.invoice.orderreceipt.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.invoice.orderreceipt.request")
@GenResponse(pkgName = "com.only4play.system.domain.invoice.orderreceipt.response")
@Entity
@Table(name = "receipt_item")
@Data
public class ReceiptItem extends BaseJpaAggregate {

  @FieldDesc(name = "凭据id")
  private Long receiptId;

  @FieldDesc(name = "商品名称")
  private String skuName;

  @FieldDesc(name = "skuId")
  private String skuId;

  @FieldDesc(name = "税收分类编码")
  private String taxCategoryCode;

  @FieldDesc(name = "税率")
  private BigDecimal taxRate;

  @FieldDesc(name = "税收分类")
  private String taxCategory;

  @FieldDesc(name = "金额")
  private BigDecimal amount;

  @FieldDesc(name = "发票显示名称")
  private String displayName;

  @FieldDesc(name = "数量")
  private Integer count;

  @FieldDesc(name = "单位")
  private String itemUnit;
}