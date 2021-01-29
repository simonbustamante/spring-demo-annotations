package com.bustamante.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thisIsAnExplicitBeanId")
//Default bean ID is "tennisCoach"
@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	/*
	 * @Autowired 
	 * public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService; }
	 */
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	/*
	 * public FortuneService getFortuneService() { return fortuneService; }
	 */

	/*
	 * @Autowired 
	 * public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println(">> TennisCoach: inside setter fortuneService");
	 * this.fortuneService = fortuneService; }
	 */
	
	//define my init method - code will execute after constructor and after injection of dependencies
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside doMyStartupStuff()");
	}
	
	//define my destroy method - code will execute before bean is destroyed
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
	}
	

}
