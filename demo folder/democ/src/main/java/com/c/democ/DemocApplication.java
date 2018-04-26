package com.c.democ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemocApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocApplication.class, args);
	}

	@RequestMapping(value = "/democ")
	public String democ() {
		return "democ";
	}


}
