package in.ineuron.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.WishMessageGenerator;

public class TestApp {

	public static void main(String[] args) {
		
		//when we use ClassPathXmlApplicationContext it uses advanse-container and while using Beanfactory uses basic container
		// advance container --> eager loading and basic container --> lazy loading
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		
		WishMessageGenerator wmg1 = factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("\n"+wmg1 +" available at :: "+wmg1.hashCode());

		WishMessageGenerator wmg2 = factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println(wmg2+" available at :: "+wmg2.hashCode());
		
		factory.close();
	}

}
