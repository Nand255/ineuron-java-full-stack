package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import in.ineuron.comp.WishMessageGenerator;

public class SetterInjectionUsingApplicationContext {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		System.out.println("No of beans is :: "+factory.getBeanDefinitionCount());
		System.out.println("Bean id is :: "+ Arrays.toString(factory.getBeanDefinitionNames()));

		System.out.println("No of is :: "+factory.getBeanDefinitionCount());
		System.out.println("Bean id is :: "+Arrays.toString(factory.getBeanDefinitionNames()));
		
		WishMessageGenerator wmg =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("Hashcode value of wmg is :: "+wmg.hashCode());
		System.out.println(wmg);
		
		System.out.println("***********Application Container is closing***********");
		((AbstractApplicationContext)factory).close();
	}
}
