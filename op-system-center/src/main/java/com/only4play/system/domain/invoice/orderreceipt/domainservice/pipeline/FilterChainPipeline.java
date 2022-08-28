package com.only4play.system.domain.invoice.orderreceipt.domainservice.pipeline;

import com.only4play.order.commons.filters.DefaultFilterChain;
import com.only4play.order.commons.filters.OrderFilter;

public class FilterChainPipeline<T extends OrderFilter> {
  private DefaultFilterChain last;

  public FilterChainPipeline() {
  }

  public DefaultFilterChain getFilterChain() {
    return this.last;
  }

  public FilterChainPipeline addFilter(T filter) {
    DefaultFilterChain newChain = new DefaultFilterChain(this.last, filter);
    this.last = newChain;
    return this;
  }

  public FilterChainPipeline addFilter(String desc, T filter) {
    DefaultFilterChain newChain = new DefaultFilterChain(this.last, filter);
    this.last = newChain;
    return this;
  }
}
