package com.only4play.opmybatisdemo.entity.customer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.only4play.opmybatisdemo.entity.customer.Customer;
import com.only4play.opmybatisdemo.entity.customer.CustomerDTO;
import com.only4play.opmybatisdemo.entity.customer.CustomerUpdater;

public interface ICustomerService extends IService<Customer> {

  Long createCustomer(CustomerDTO dto);

  void updateCustomer(CustomerUpdater updater);

}