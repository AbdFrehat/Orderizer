package com.selling.system.export.data.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        scanBasePackages = {
                "com.selling.system.export.data.manager",
                "com.orderizer.core",
        }
)

public class ExportDataManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExportDataManagerApplication.class, args);
    }

}
