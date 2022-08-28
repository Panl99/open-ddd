package com.only4play.opmybatisdemo;

import com.google.common.eventbus.EventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OpMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpMybatisDemoApplication.class, args);
    }


    @Bean
    public EventBus eventBus(){
        return new EventBus();
    }

}
