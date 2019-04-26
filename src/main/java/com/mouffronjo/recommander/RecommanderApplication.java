package com.mouffronjo.recommander;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
public class RecommanderApplication {

    @Autowired
    Environment env;

    public static void main(String[] args) {
        SpringApplication.run(RecommanderApplication.class, args);
    }

    @Bean
    public DataSource getDataSource(){
        return DataSourceBuilder
                .create()
                .driverClassName(env.getRequiredProperty("driverClassName"))
                .url(env.getRequiredProperty("jdbcUrl"))
                .username(env.getRequiredProperty("login"))
                .password(env.getRequiredProperty("password"))
                .build();
    }
}
