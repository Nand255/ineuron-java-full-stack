package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Car;

public class TestApp {

	public static void main(String[] args) throws Exception {
		
		//when we use ClassPathXmlApplicationContext it uses advanse-container and while using Beanfactory uses basic container
		// advance container --> eager loading and basic container --> lazy loading
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("*******Container Started*********");
		System.out.println("Bean id is :: "+Arrays.toString(factory.getBeanDefinitionNames()));
		
		System.out.println();
		
		Car c1 = factory.getBean("car1",Car.class);
		System.out.println(c1+"\thashCode is :: "+c1.hashCode());
		
		Car c2 = factory.getBean("car2",Car.class);
		System.out.println(c2+"\thashCode is :: "+c2.hashCode());
		
		factory.close();
		System.out.println("\n*******Container Stoped*********");
	}

}
