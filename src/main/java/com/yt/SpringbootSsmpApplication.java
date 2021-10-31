package com.yt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yt.mapper")
public class SpringbootSsmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSsmpApplication.class, args);
    }

}
