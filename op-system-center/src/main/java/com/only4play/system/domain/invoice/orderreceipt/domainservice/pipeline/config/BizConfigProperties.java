package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.config;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gim
 * 业务线编码 --》 filter 配置表 ,实现业务线filter 动态配置化,nacos,redis等其他动态存储的地方
 * biz1:filter1,filter2,filter3
 * biz2:filter1,filter2,filter4
 */
@Component
@ConfigurationProperties(prefix = "biz")
@Data
public class BizConfigProperties {

  private Map<String, List<String>> configs;
}
