package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


//	@Before("execution(public void addAccount())")
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void add*(com.luv2code.aopdemo.Account))")
//	@Before("execution(public void add*(com.luv2code.aopdemo.Account, ..))")
//	@Before("execution(public void com.luv2code.aopdemo.dao.*.*(..))")
//	@Before("execution(public void add*())")
//	@Before("execution(* * *Account())")
//	@Before("execution(public void updateAccount())")
//	public void beforeAddAccount() {
//		System.out.println("\n ======> executing @Before advice on addAccount()");
//	}
	
	
	@Pointcut("execution(public void com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(public void com.luv2code.aopdemo.dao.*.goTo*(..))")
	private void forDaoPackageGoTo() {}
	
	@Pointcut("forDaoPackage() && !(forDaoPackageGoTo())")
	private void forDaoPackageWithoutGoTo() {}

	@Before("forDaoPackage()")
	public void beforeAddAccount() {
		System.out.println("\n ======> executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageWithoutGoTo()")
	public void performAnalytics() {
		System.out.println("\n =====> perform API analytics");
	}

	
}
