package in.ineuron.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Flipkart;

public class TestAppUsingApplicationContext {
	
	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("****Container started****");
		
		System.in.read();
		
		Flipkart flipkart = factory.getBean("fpkt",Flipkart.class);
		System.out.println("\n"+flipkart);
		String result = flipkart.doShopping(new String[] {"fossil", "omegha"}, new float[] {13458.69f, 54213.99f});
		System.out.println("\n"+result);
				
		System.out.println("****Container closed****");
		
	}
	
}
