package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + "DOING stuff: adding a membership account");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + "falls asleep...");
	}
}
