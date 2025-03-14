package in.ineuron.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Printer;

public class TestApp {

	public static void main(String[] args) throws Exception {
		
		//when we use ClassPathXmlApplicationContext it uses advanse-container and while using Beanfactory uses basic container
		// advance container --> eager loading and basic container --> lazy loading
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("*******Container Started*********");
		System.in.read();
		
		Printer p1 = factory.getBean("printer",Printer.class);
		System.out.println(p1);

		Printer p2 = factory.getBean("printer",Printer.class);
		System.out.println(p2);
		
		factory.close();
		System.out.println("*******Container Stoped*********");
	}

}
