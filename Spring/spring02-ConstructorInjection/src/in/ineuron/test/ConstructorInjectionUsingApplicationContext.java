package in.ineuron.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.WishMessageGenerator;

public class ConstructorInjectionUsingApplicationContext {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		System.out.println("***********BeanFactory container starting...***********");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********BeanFactory container started***********");
		
		WishMessageGenerator wmg =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("Hashcode value of wmg is :: "+wmg.hashCode());
		System.out.println(wmg);
		
		String result = wmg.generateMessage("Nand");
		System.out.println(result+"\n");

		WishMessageGenerator wmg1 =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("Hashcode value of wmg is :: "+wmg1.hashCode());
		System.out.println(wmg1);
		
		String result1 = wmg1.generateMessage("patel");
		System.out.println(result1+"\n");
		
		System.out.println("\n*********BeanFactory closing*********");
	}
}
