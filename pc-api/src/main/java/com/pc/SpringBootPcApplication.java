package com.pc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.common.filter"})
public class SpringBootPcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPcApplication.class, args);
    }

}
