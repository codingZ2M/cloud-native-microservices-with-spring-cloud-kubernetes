package com.codingz2m.mutualfundservice.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotation Based Configuration
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MutualFundScheme {
	
	private List<String> schemeDescription;


}
