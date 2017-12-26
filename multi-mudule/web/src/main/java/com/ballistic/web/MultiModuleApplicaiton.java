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
@EnableJpaRepositories(basePackages = {"com.ballistic.persistence"})
@EntityScan(basePackages = {"com.ballistic.domain"})
@ComponentScan(basePackages = {"com.ballistic.domain", "com.ballistic.persistence", "com.ballistic.web"})
public class MultiModuleApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleApplicaiton.class);
    }
}
