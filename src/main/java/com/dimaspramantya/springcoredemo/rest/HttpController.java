package com.dimaspramantya.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dimaspramantya.springcoredemo.common.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class HttpController {
	
	// define a private filed for the dependency
	private Coach myCoach;
	
	
	//define a constructor for dependency injection (CONSTRUCTOR INJECTION)
	@Autowired
	public HttpController(@Qualifier("swimCoach") Coach theCoach) {
		myCoach = theCoach;
	}
	
	
	//SETTER INJECTION
	/*
	@Autowired
	public void setCoach(@Qualifier("trackCoach") Coach theCoach) {
		myCoach = theCoach;
	}
	*/
	
	
	//init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
	}
	
	//destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
	}
	
	//
	
	// expose GET /dailyworkout
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
