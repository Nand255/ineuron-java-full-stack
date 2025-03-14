package in.ineuron.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.EnggCource;

public class ClientApp {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		EnggCource bean = factory.getBean("CS",EnggCource.class);
		
		System.out.println(bean);
		
		factory.close();
	}
	
}
