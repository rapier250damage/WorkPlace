package demo.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("databaseFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("TennisCoachConstructor");
	}
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println("In setter setFortuneService");
//		fortuneService = theFortuneService;
//	}
	
	@PostConstruct
	public void doPostInitProcedure() {
		System.out.println("Inside of doPostInitProcedure");
	}
	
	@PreDestroy
	public void doPreDestroyProcedure() {
		System.out.println("Inside of doPreDestroyProcedure");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	
}
