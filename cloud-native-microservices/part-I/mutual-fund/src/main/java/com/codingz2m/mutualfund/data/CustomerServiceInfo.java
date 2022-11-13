package com.codingz2m.mutualfund.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter @Setter @ToString
@ConfigurationProperties(prefix="mutualfund")
public class CustomerServiceInfo {
	
	 private String message;
	 private String mail;
	 private String contact;
	 
}
