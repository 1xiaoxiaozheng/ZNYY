package com.springbootTz.ZNYY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class ZnyyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZnyyApplication.class, args);
    }

}
