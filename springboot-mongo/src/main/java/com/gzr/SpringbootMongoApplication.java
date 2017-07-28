package com.gzr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongoApplication.class, args);
	}
}
