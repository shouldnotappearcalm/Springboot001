package com.gzr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringbootBackstageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackstageApplication.class, args);
	}
}
