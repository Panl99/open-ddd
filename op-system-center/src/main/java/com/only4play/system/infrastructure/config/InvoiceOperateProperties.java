package com.only4play.system.infrastructure.config;

import com.only4play.common.annotation.FieldDesc;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "invoice.operate")
@Component
@Data
public class InvoiceOperateProperties {

  @FieldDesc(name = "开票人")
  private String drawer;

  @FieldDesc(name = "复核人")
  private String reviewer;

  @FieldDesc(name = "收款人")
  private String payee;


}
