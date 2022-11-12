package com.codingz2m.springaoprestservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.codingz2m.springaoprestservice.models",
				"com.codingz2m.springaoprestservice.aspects"})
@EnableAspectJAutoProxy
public class BeansConfig {
	
}
