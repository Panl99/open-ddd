package com.only4play.opmybatisdemo.entity.customer.event;

import com.only4play.opmybatisdemo.entity.customer.event.CustomerEvent.CustomerUpdateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventProcessor {


  @EventListener
  public void handleCustomerUpdateEvent(CustomerUpdateEvent e){
    System.out.println("收到消息");
    System.out.println(e.getCustomer().getId());
    System.out.println(e.getCustomer().getGrade());
    System.out.println(e.getCustomer().getUsername());
  }

  /**
   * 有事务问题
   * @param e
   */
  @EventListener
  public void handleCustomerUpdateEventForException(CustomerUpdateEvent e){
    System.out.println("异常了");
    throw new RuntimeException();
  }

}
