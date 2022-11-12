package com.codingz2m.springiocrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
//@Component
public class SpringIocRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIocRestServiceApplication.class, args);
	}

}
