package com.gdpi.groups;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.gdpi.groups.dao")
public class GroupsApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GroupsApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run( args);
        /*SpringApplication.run(GroupsApplication.class, args);*/
    }
}
