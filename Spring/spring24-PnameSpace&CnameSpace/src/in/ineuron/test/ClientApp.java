package in.ineuron.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.commons.Employee;

import org.springframework.context.ApplicationContext;

public class ClientApp {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		Employee employee = factory.getBean("employee",Employee.class);
		System.out.println(employee);
		
		((AbstractApplicationContext)factory).close();
	}
}
