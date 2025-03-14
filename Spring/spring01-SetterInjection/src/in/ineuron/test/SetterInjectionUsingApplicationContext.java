package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.WishMessageGenerator;

public class SetterInjectionUsingApplicationContext {
	
	public static void main(String[] args) {
		
		System.out.println("***********Application container starting...***********");
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("***********Application container started\n***********");
		
		System.out.println("No of beans is :: "+factory.getBeanDefinitionCount());
		System.out.println("Bean id is :: "+ Arrays.toString(factory.getBeanDefinitionNames()));
		
		WishMessageGenerator wmg =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("Hashcode value of wmg is :: "+wmg.hashCode());
		System.out.println(wmg);
		
		String result = wmg.generateMessage("Nand");
		System.out.println(result+"\n");
		
		System.out.println("No of ");
		
		WishMessageGenerator wmg1 =(WishMessageGenerator) factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("Hashcode value of wmg is :: "+wmg1.hashCode());
		System.out.println(wmg1);
		
		String result1 = wmg1.generateMessage("patel");
		System.out.println(result1+"\n");
	
		System.out.println("***********Application Container is closing***********");
		factory.close();
	}
}
