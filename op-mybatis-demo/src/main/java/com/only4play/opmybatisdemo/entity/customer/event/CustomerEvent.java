package com.only4play.opmybatisdemo.entity.customer.event;

import com.only4play.opmybatisdemo.entity.customer.Customer;
import lombok.Value;

public interface CustomerEvent {

  @Value
  class CustomerUpdateEvent{
    private Customer customer;
  }

}
