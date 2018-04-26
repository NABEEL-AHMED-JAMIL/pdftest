package com.ballistic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Nabeel on 12/25/2017.
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.ballistic.*"})
@EnableJpaRepositories(basePackages = {"com.ballistic.*"})
@ComponentScan(basePackages = {"com.ballistic.*"})
public class MultiModuleApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleApplicaiton.class);
    }
}
