package com.selling.system.data.sales.opt.get;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,
        scanBasePackages = {
                "com.selling.system.query.shared.module",
                "com.selling.system.shared.module",
                "com.selling.system.query.sales.opt.get",
        })
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "APIs", version = "1.0", description = "Documentation APIs v1.0"))
public class SalesOptQueryGetApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesOptQueryGetApplication.class, args);
    }

}