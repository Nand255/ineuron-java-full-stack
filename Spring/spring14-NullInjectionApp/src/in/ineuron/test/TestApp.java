package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.PersonInfo;

public class TestApp {

	public static void main(String[] args) throws Exception {
		
		//when we use ClassPathXmlApplicationContext it uses advanse-container and while using Beanfactory uses basic container
		// advance container --> eager loading and basic container --> lazy loading
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("*******Container Started*********");
		System.out.println("Bean id is :: "+Arrays.toString(factory.getBeanDefinitionNames()));
		
		System.out.println();
		
		PersonInfo info = factory.getBean("pinfo", PersonInfo.class);
		System.out.println(info);
		
		factory.close();
		System.out.println("*******Container Stoped*********");
	}

}
