package com.dimaspramantya.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dimaspramantya.springcoredemo.common.Coach;
import com.dimaspramantya.springcoredemo.common.SwimCoach;

@Configuration
public class CoachConfig {
	
	//this is for injection, the bean id is same as method name
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
}
