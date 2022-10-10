package com.pc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@MapperScan(basePackages = {"com.mapper.sso"})
@ServletComponentScan(basePackages = {"com.common.filter"})
public class SpringBootPcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPcApplication.class, args);
    }

}
