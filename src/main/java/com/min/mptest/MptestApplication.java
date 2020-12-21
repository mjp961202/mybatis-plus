package com.min.mptest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.min.mptest.mapper")
public class MptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MptestApplication.class, args);
    }

}
