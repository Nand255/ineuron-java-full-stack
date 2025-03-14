package in.ineuron.test;

import org.springframework.context.support.AbstractApplicationContext;

import in.ineuron.cfg.AppConfig;
import in.ineuron.comp.WishMessageGenerator;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApp {
	
	public static void main(String[] args) {
		System.out.println("****Container Started****");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class) ;
		System.out.println("Bean id information :: "+Arrays.toString(context.getBeanDefinitionNames()));
		
		WishMessageGenerator wmg = context.getBean(WishMessageGenerator.class);
		System.out.println(wmg);
		String message = wmg.generateWishMessage("nand");
		System.out.println(message);
		
		((AbstractApplicationContext) context).close();
		System.out.println("****Container Stoped****");
	}
}