package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.College;
import in.ineuron.comp.ContactsInfo;
import in.ineuron.comp.MarksInfo;
import in.ineuron.comp.UniversityInfo;

public class TestApp {

	public static void main(String[] args) throws Exception {
		
		//when we use ClassPathXmlApplicationContext it uses advanse-container and while using Beanfactory uses basic container
		// advance container --> eager loading and basic container --> lazy loading
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("*******Container Started*********");
		System.out.println("Bean id is :: "+Arrays.toString(factory.getBeanDefinitionNames()));
		
		System.out.println();
		
		MarksInfo info = factory.getBean("marks",MarksInfo.class);
		System.out.println(info);

		College clg = factory.getBean("clg",College.class);
		System.out.println(clg);
		
		ContactsInfo contactInfo = factory.getBean("contact",ContactsInfo.class);
		System.out.println(contactInfo);
		
		UniversityInfo uInfo = factory.getBean("uInfo",UniversityInfo.class);
		System.out.println(uInfo);
		
		factory.close();
		System.out.println("*******Container Stoped*********");
	}

}
