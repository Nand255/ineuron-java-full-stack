package in.ineuron.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.commons.PersonInfo;

import org.springframework.context.ApplicationContext;

public class ClientApp {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		PersonInfo personInfo = factory.getBean("personInfo",PersonInfo.class);
		System.out.println(personInfo);
		
		((AbstractApplicationContext)factory).close();
	}
}
