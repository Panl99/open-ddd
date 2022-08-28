package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.config;

import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.FilterChainPipeline;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.InputCheckFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.PopulateInvoiceFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.SaveExchangeLogFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.exchange.SplitAmountFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.CalculateValidAmountFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.EnterpriseRouterFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.PopulateReceiptItemFilter;
import com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline.filters.register.SaveRegisterLogFilter;
import com.only4play.system.infrastructure.facade.IInvoicePipeLineFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PipelineConfig {

  @Autowired
  private IInvoicePipeLineFacadeService pipeLineFacadeService;

  /**
   * 订单注册pipeline
   * @return
   */
  @Bean
  public FilterChainPipeline orderRegisterPipeline() {
    FilterChainPipeline filterChainPipeline = new FilterChainPipeline();
    filterChainPipeline.addFilter("填充小票项信息",populateReceiptItemFilter());
    filterChainPipeline.addFilter("计算有效金额",calculateValidAmountFilter());
    filterChainPipeline.addFilter("企业路由",enterpriseRouterFilter());
    filterChainPipeline.addFilter("保存注册记录",saveRegisterLogFilter());
    return filterChainPipeline;
  }

  @Bean
  public EnterpriseRouterFilter enterpriseRouterFilter(){
    return new EnterpriseRouterFilter(pipeLineFacadeService);
  }

  @Bean
  public PopulateReceiptItemFilter populateReceiptItemFilter() {
    return new PopulateReceiptItemFilter(pipeLineFacadeService);
  }

  @Bean
  public CalculateValidAmountFilter calculateValidAmountFilter(){
    return new CalculateValidAmountFilter(pipeLineFacadeService);
  }


  @Bean
  public SaveRegisterLogFilter saveRegisterLogFilter(){
    return new SaveRegisterLogFilter(pipeLineFacadeService);
  }


  /**
   * 凭据开票pipeline
   * @return
   */
  @Bean
  public FilterChainPipeline exchangeInvoicePipeline() {
    FilterChainPipeline filterChainPipeline = new FilterChainPipeline();
    filterChainPipeline.addFilter("填充发票信息",populateInvoiceFilter());
    filterChainPipeline.addFilter("拆票",splitAmountFilter());
    filterChainPipeline.addFilter("输入校验",inputCheckFilter());
    filterChainPipeline.addFilter("保存请求信息",saveExchangeLogFilter());
    return filterChainPipeline;
  }

  @Bean
  public SaveExchangeLogFilter saveExchangeLogFilter(){
    return new SaveExchangeLogFilter(pipeLineFacadeService);
  }

  @Bean
  public SplitAmountFilter splitAmountFilter(){
    return new SplitAmountFilter(pipeLineFacadeService);
  }

  @Bean
  public PopulateInvoiceFilter populateInvoiceFilter(){
    return new PopulateInvoiceFilter(pipeLineFacadeService);
  }

  @Bean
  public InputCheckFilter inputCheckFilter(){
    return new InputCheckFilter();
  }

}
