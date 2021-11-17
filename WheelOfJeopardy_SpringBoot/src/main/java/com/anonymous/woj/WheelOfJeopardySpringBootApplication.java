package com.anonymous.woj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.anonymous.woj.dao")
public class WheelOfJeopardySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WheelOfJeopardySpringBootApplication.class, args);
    }

}
