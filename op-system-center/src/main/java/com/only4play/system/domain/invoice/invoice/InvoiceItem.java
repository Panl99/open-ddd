package com.only4play.system.domain.invoice.invoice;

import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.invoice.invoice.vo")
@GenCreator(pkgName = "com.only4play.system.domain.invoice.invoice.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.invoice.invoice.updater")
@GenRepository(pkgName = "com.only4play.system.domain.invoice.invoice.repository")
@GenQuery(pkgName = "com.only4play.system.domain.invoice.invoice.query")
@GenMapper(pkgName = "com.only4play.system.domain.invoice.invoice.mapper")
@Entity
@Table(name = "invoice_item")
@Data
public class InvoiceItem extends BaseJpaAggregate {

  @FieldDesc(name = "发票id")
  private Long invoiceId;

  @FieldDesc(name = "申请批次号")
  private String applyBatchNo;

  @FieldDesc(name = "商品名称")
  private String skuName;

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

  @FieldDesc(name = "订单数量")
  private Integer count;

  @FieldDesc(name = "单位")
  private String itemUnit;

  @FieldDesc(name = "行号")
  private Integer lineCode;
}
