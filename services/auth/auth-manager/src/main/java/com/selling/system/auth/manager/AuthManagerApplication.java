package com.selling.system.auth.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(scanBasePackages = {
        "com.selling.system.auth.manager",
        "com.orderizer.core"
}, exclude = DataSourceAutoConfiguration.class)
public class AuthManagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(AuthManagerApplication.class, args);
    }


}
