package com.bustamante.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//you will need to comment ComponetScan if you are using Beans on SportConfig
@Configuration
//@ComponentScan("com.bustamante.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	//define a bean for a sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	//define a bean for a swimCoach and inject dependency
	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
		return mySwimCoach;
	}
	

}
