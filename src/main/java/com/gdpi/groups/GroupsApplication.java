package com.gdpi.groups;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gdpi.groups.dao")
public class GroupsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroupsApplication.class, args);
    }
}
