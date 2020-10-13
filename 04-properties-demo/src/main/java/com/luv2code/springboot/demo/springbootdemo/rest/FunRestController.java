package com.luv2code.springboot.demo.springbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	//inject props for: coaach, team
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world! time on server is " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkOut() {
		return "Run hard 5km!";
	}
	
	@GetMapping("/anotherpaath")
	public String getAnotherPath() {
		return "This is another path";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + ", team name: " + teamName;
	}
}