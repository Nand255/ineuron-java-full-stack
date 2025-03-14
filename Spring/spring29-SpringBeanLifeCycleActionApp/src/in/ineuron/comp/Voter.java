package in.ineuron.comp;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "voter")
@PropertySource(value="in/ineuron/commons/application.properties")
public class Voter {
	
	@Value("${voter.info.name}")
	private String name;

	@Value("${voter.info.age}")
	private int age;
	
	private Date dov;
	
	static {
		System.out.println("Voter.class file is loading...");
	}

	public Voter() {
		System.out.println("Voter object instantiated...");
		System.out.println(this);
	}
	
	@PostConstruct
	public void myInit() throws Exception {
		System.out.println("Voter.myInit()");
		dov = new Date();
		boolean flag = false;
		
		if(name == null) {
			System.out.println("Name must not be null.");
			flag = true;
		}
		
		if(age < 0) 
			age *= -1;
		
		if(age >100) {
			System.out.println("you are one lucky people.");
			flag = true;
		}
		
		if(flag)
			throw new IllegalAccessException("Invalid inputs...");
	}

	//Business logic method
	public String CheckVotingEligibility() {
		
		System.out.println(this);
		if(age >=18)
			return "Mr./Mrs. :: "+name+", you are eligibile to vote on :: "+dov;
		else
			return "Mr./Mrs. :: "+name+", you are not eligibile to vote on :: "+dov;
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("Voter.myDestroy()");
		
		//nullify the bean properties
		name = null;
		age = 0;
		dov = null;
	}
	
	@Override
	public String toString() {
		return "Voter [name=" + name + ", age=" + age + ", dov=" + dov + "]";
	}
	
}
