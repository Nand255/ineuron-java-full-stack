package in.ineuron.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Flipkart;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;

public class ClientApp {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("Bean information :: "+Arrays.toString(factory.getBeanDefinitionNames()));
		
		Flipkart flipkart = factory.getBean("flipkart",Flipkart.class);
		System.out.println(flipkart.doShopping(new String[] {"Rolex","maxima"}, new float[] {259000.0f,1599.9f}));
		
		((AbstractApplicationContext)factory).close();
	}
}
