package com.dimaspramantya.springcoredemo.common;

import org.springframework.stereotype.Component;

// Component means it is Spring beans and it will be available for dependency injection
@Component
public class CricketCoach implements Coach{
	
	public CricketCoach() {
		System.out.println("In Constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}
}
