package com.dimaspramantya.springcoredemo.common;

public class SwimCoach implements Coach{
	
	public SwimCoach() {
		System.out.println("In Constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 500m as a warm up!";
	}
}
