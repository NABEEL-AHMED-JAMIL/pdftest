package com.b.demob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemobApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemobApplication.class, args);
	}

	@RequestMapping(value = "/demob")
	public String demob() {
		return "demoab";
	}
}
