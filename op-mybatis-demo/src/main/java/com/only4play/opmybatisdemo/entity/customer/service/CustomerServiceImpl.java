package com.only4play.opmybatisdemo.entity.customer.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.only4play.mybatis.support.EntityOperations;
import com.only4play.opmybatisdemo.entity.customer.Customer;
import com.only4play.opmybatisdemo.entity.customer.CustomerDTO;
import com.only4play.opmybatisdemo.entity.customer.CustomerUpdater;
import com.only4play.opmybatisdemo.entity.customer.event.CustomerEvent.CustomerUpdateEvent;
import com.only4play.opmybatisdemo.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService{

  @Autowired
  private ApplicationEventPublisher eventPublisher;

  @Override
  public Long createCustomer(CustomerDTO dto) {
    Customer customer = new Customer();
    customer.setGrade(dto.getGrade());
    customer.setUsername(dto.getUsername());
    EntityOperations
        .doCreate(getBaseMapper())
        .create(() -> customer)
        .update(e -> e.init())
        .execute();
    return null;
  }

  @Override
  @Transactional
  public void updateCustomer(CustomerUpdater updater) {
    EntityOperations
        .doUpdate(getBaseMapper())
        .load(() -> getById(updater.getId()))
        .update(e -> e.doUpdate(updater))
        .successHook(e -> eventPublisher.publishEvent(new CustomerUpdateEvent(e)))
        .execute();
  }


}
