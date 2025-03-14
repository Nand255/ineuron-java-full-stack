package in.ineuron.test;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ineuron.cfg.AppConfig;
import in.ineuron.controller.MainController;
import in.ineuron.vo.EmployeeVO;

public class TestApp {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		int command = 0;
		boolean exit = false;
        
		printCommand();
        
		while (!exit){
            System.out.println("Enter your command/choice: ");
            command = sc.nextInt();
            sc.nextLine();

            switch (command){
                case 0:
                    printCommand();
                    break;
                case 1:
                	insert();
                    break;
                case 2:
                	search();
                    break;
                case 3:
                	delete();
                    break;
                case 4:
                	update();
                	break;
                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("please pick from given Commands");
            }
        }
		  
		sc.close();
	}
	
	public static void printCommand() {
		System.out.println("Commands:");
        System.out.println("Press 0 : To print the commands");
        System.out.println("Press 1 : To insert");
        System.out.println("Press 2 : To select");
        System.out.println("Press 3 : To delet");
        System.out.println("Press 4 : To update");
        System.out.println("Press 5 : To exit the app");
	}
	
	public static void insert() {
		
		System.out.print("Enter the Employee name::"); 
		String empName =sc.next();

		System.out.print("Enter the Employee salary::"); 
		String salary =sc.next();
		
		System.out.print("Enter the Employee department::"); 
		String dept =sc.next();

		System.out.print("Enter the Employee address::"); 
		String empAddress =sc.next();
		
		EmployeeVO empVO = new EmployeeVO();
		empVO.seteName(empName);
		empVO.setSalary(salary);
		empVO.setDept(dept);
		empVO.seteAddress(empAddress);
		
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		MainController controller = factory.getBean(MainController.class);
		
		try { String result = controller.insert(empVO);
		  System.out.println(result);
		  
		  } catch (Exception e) {
		  System.out.println("Internal problem... Try Again....."+e.getMessage()); 
		  }
		factory.close();
	}
	public static void search() {
		EmployeeVO result = null;
		
		System.out.println("Enter the ID you want to search :: ");
		Integer eId = sc.nextInt();
	
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		MainController controller = factory.getBean(MainController.class);
		
		try { 
		  result = controller.search(eId);
		  System.out.println(result);
		  
		  } catch (Exception e) {
		  System.out.println("Internal problem... Try Again....."+e.getMessage()); 
		  }
		
		factory.close();
	}
	public static void delete() {
		String result = null;
		
		System.out.println("Enter the ID you want to delete :: ");
		Integer eId = sc.nextInt();
		
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		MainController controller = factory.getBean(MainController.class);
		
		try {
			result = controller.delete(eId);
			  System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem... Try Again....."+e.getMessage()); 
		}
		
		factory.close();
	}
	public static void update() {
		EmployeeVO dto = null;
		String result = null;
		
		System.out.println("Enter the ID you want to update :: ");
		String eId = sc.next();
		
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		MainController controller = factory.getBean(MainController.class);
		
		try { 
			dto = controller.search(Integer.parseInt(eId));
			System.out.println("Employee data before updation ::");
			System.out.println("Employee name :: "+dto.geteName());
			System.out.println("Employee Id :: "+dto.geteId());
			System.out.println("Employee Address :: "+dto.geteAddress());
			System.out.println("Employee Department :: "+dto.getDept());
			System.out.println("Employee Salary :: "+dto.getSalary());
			
			System.out.println("Enter the changes you want to make ::");
			System.out.print("Enter the Employee name::"); 
			String empName =sc.next();

			System.out.print("Enter the Employee salary::"); 
			String salary =sc.next();
			
			System.out.print("Enter the Employee department::"); 
			String dept =sc.next();

			System.out.print("Enter the Employee address::"); 
			String empAddress =sc.next();
			
			EmployeeVO empVO = new EmployeeVO();
			empVO.seteId(eId);
			empVO.seteName(empName);
			empVO.setSalary(salary);
			empVO.setDept(dept);
			empVO.seteAddress(empAddress);
			
		  result = controller.update(empVO);
		  System.out.println(result);
		  
		  } catch (Exception e) {
		  System.out.println("Internal problem... Try Again....."+e.getMessage()); 
		  }
		
		factory.close();
	}
}
