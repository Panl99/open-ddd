package com.only4play.system.domain.invoice.orderreceipt;

import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenRepository(pkgName = "com.only4play.system.domain.invoice.orderreceipt.repository")
@Entity
@Table(name = "receipt_invoice_rel")
@Data
public class ReceiptInvoiceRel extends BaseJpaAggregate {

  @FieldDesc(name = "订单流水号")
  private String orderFlowNo;

  @FieldDesc(name = "注册流水号")
  private String registerFlowNo;

  @FieldDesc(name = "发票的批号")
  private String batchNo;
}
