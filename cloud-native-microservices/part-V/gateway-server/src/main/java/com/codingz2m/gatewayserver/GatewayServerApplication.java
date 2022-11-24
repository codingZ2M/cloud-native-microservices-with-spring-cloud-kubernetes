package com.codingz2m.gatewayserver;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


// Registering Spring Cloud Gateway Server as a client of Eureka Server and fetching all 
// the details from Eureka Server, such as types of services it exposes and its registry

@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
		
	}
		@Bean
		public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		    return builder.routes()

		        .route(p -> p

		            .path("/codingz2m/SAVINGSACCOUNT/**")
                    /* Rewriting the path by removing 'codingz2m/SAVINGSACCOUNT' and just pass it whatever segment, we received after 'codingz2m/SAVINGSACCOUNT'
                     
                     */
		            .filters(f -> f.rewritePath("/codingz2m/SAVINGSACCOUNT/(?<segment>.*)","/${segment}")

		            				.addResponseHeader("X-Response-Time",new Date().toString()))

		            .uri("lb://SAVINGSACCOUNT")).


		        route(p -> p

			            .path("/codingz2m/MUTUALFUND/**")

			            .filters(f -> f.rewritePath("/codingz2m/MUTUALFUND/(?<segment>.*)","/${segment}")

			            		.addResponseHeader("X-Response-Time",new Date().toString()))

			            .uri("lb://MUTUALFUND")).build();

		}
	
}
