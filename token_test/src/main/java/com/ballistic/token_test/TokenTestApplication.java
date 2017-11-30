package com.ballistic.token_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TokenTestApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TokenTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TokenTestApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Look in application.yml for the  directory path. Files will be created every 30 seconds.");

	}
}
