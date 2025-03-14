package in.ineuron.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.comp.Flipkart;

public class TestApp {
	
	public static void main(String[] args) throws Exception {
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("in/ineuron/cfg/applicationContext.xml");
		System.out.println("****Container started****");
		
		System.in.read();
		
		Flipkart flipkart = factory.getBean("fpkt",Flipkart.class);
		System.out.println("\n"+flipkart);
		String result = flipkart.doShopping(new String[] {"fossil", "omegha"}, new float[] {13458.69f, 54213.99f});
		System.out.println("\n"+result);
				
		System.out.println("****Container closed****");
		
	}
	
}
