package in.ineuron.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.WishMessageGenerator;

@SuppressWarnings("deprecation")
public class SetterInjection {
	
	public static void main(String[] args) {
		
		FileSystemResource resource = new FileSystemResource("src/in/ineuron/cfg/applicationContext.xml");
		
		System.out.println("***********BeanFactory container starting...***********");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("***********BeanFactory container started.***********");
		
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
	
		System.out.println("***********Container is closing***********");
	}
}
