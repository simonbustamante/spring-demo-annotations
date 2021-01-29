package com.bustamante.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BeerCoach implements Coach {
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	public BeerCoach() {
		System.out.println(">> BeerCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		
		return "Let's Drink Beers";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
