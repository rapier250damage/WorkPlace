package demo.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	private String[] data = {
			"first"
			, "second"
			, "third"
			, "fourth"
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		return data[myRandom.nextInt(data.length)];
	}

}
