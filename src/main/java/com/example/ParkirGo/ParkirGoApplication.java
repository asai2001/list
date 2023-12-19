package com.example.ParkirGo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.ParkirGo")
public class ParkirGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkirGoApplication.class, args);
	}

}
