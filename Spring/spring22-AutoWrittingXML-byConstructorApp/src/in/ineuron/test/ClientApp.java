package in.ineuron.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Flipkart;

import org.springframework.context.ApplicationContext;

public class ClientApp {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		Flipkart flipkart = factory.getBean("fpkt",Flipkart.class);
		System.out.println(flipkart.doShopping(new String[] {"hmt","omega"},new float[] {4500.0f,13299.9f}));
		System.out.println(flipkart);
		
		((AbstractApplicationContext)factory).close();
	}
}
