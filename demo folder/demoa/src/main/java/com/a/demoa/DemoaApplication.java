package com.a.demoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
@EnableAutoConfiguration
public class DemoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoaApplication.class, args);
	}

	@RequestMapping(value = "/demoa")
	public String demoa() {
		return "demoa";
	}
}
