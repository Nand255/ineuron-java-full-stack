package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Student;

public class TestApp {

	public static void main(String[] args) throws Exception {
		
		//when we use ClassPathXmlApplicationContext it uses advanse-container and while using Beanfactory uses basic container
		// advance container --> eager loading and basic container --> lazy loading
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("*******Container Started*********");
		System.out.println("Bean id is :: "+Arrays.toString(factory.getBeanDefinitionNames()));
		System.in.read();
		
		Student student1 = factory.getBean("in.ineuron.comp.Student#0",Student.class);
		System.out.println(student1);
		System.out.println("Hash :: "+student1.hashCode());
		Student student2 = factory.getBean("in.ineuron.comp.Student#1",Student.class);
		System.out.println(student2);
		System.out.println("Hash :: "+student2.hashCode());
		
		factory.close();
		System.out.println("*******Container Stoped*********");
	}

}
