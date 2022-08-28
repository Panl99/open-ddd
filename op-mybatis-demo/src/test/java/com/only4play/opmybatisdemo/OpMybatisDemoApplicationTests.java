package com.only4play.opmybatisdemo;

import com.only4play.opmybatisdemo.entity.customer.CustomerDTO;
import com.only4play.opmybatisdemo.entity.customer.CustomerUpdater;
import com.only4play.opmybatisdemo.entity.customer.service.ICustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class OpMybatisDemoApplicationTests {

    @Autowired
    private ICustomerService customerService;

    @Test
    public void testCustomerAdd(){
        CustomerDTO dto = new CustomerDTO();
        dto.setGrade("一年级");
        dto.setUsername("张三");
        customerService.createCustomer(dto);
    }

    @Test
    public void testUpdate(){
        CustomerUpdater updater = new CustomerUpdater();
        updater.setId(2L);
        updater.setUsername("888");
        customerService.updateCustomer(updater);
    }

}
