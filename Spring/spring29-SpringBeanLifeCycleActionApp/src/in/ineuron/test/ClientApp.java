package in.ineuron.test;

import in.ineuron.comp.Voter;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

public class ClientApp {
	
	public static void main(String[] args) {
		System.out.println("****Container Started****\n");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("Bean id information :: "+Arrays.toString(context.getBeanDefinitionNames()));
		
		Voter voter = context.getBean(Voter.class);
		System.out.println(voter);
		
		System.out.println(voter.CheckVotingEligibility());
		
		((AbstractApplicationContext) context).close();
		System.out.println("\n****Container Stoped****");
	}
}
