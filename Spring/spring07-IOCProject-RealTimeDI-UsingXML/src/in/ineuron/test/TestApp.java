package in.ineuron.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.controller.MainController;
import in.ineuron.vo.CustomerVO;

public class TestApp {
	public static void main(String[] args) throws Exception {
		
		//Reading the inputs
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the customerName::");
		String customerName = sc.next();

		System.out.print("Enter the customerAddress::");
		String customerAddress = sc.next();
		
		System.out.print("Enter the principalAmount::");
		String principleAmount = sc.next();
		
		System.out.print("Enter the RateOfInterest::");
		String RateOfInterest = sc.next();
		
		System.out.print("Enter the TimePeriod::");
		String TimePeriod = sc.next();
		
		CustomerVO customerVO = new CustomerVO();
		customerVO.setCustomerAddress(customerAddress);
		customerVO.setCustomerName(customerName);
		customerVO.setPamt(principleAmount);
		customerVO.setRate(RateOfInterest);
		customerVO.setTime(TimePeriod);
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("in/ineuron/cfg/applicationContext.xml");
		System.out.println("*******Container Started*******");
		
		MainController controller = factory.getBean("customerController",MainController.class);
		try {
			String result = controller.processCustomer(customerVO);
			System.out.println(result);
			
		} catch (Exception e) {
			System.out.println("Internal problem... Try Again....."+e.getMessage());
		}
		System.out.println("\n*******Container Stopped*******");
		sc.close();
	}
}
