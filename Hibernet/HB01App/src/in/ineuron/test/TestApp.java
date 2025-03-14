package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class TestApp {

	public static void main(String[] args) throws Exception {
		
		// 1. Inform JVM to activate HIBERNATE
		Configuration configuration = new Configuration();
		configuration.configure();
		
		// creating a SessionFactory object to hold many other objects required for Hibernate
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		// using SessionFactory object, get only one session object to perform our persistence operation
		Session session = sessionFactory.openSession(); // connection object, ORM-dialects, L1-Cache, TXTManagement
		
		Transaction transection = session.beginTransaction();  // Transaction begin
		
		// 2. Create persistence object
		Student student = new Student();
		student.setSid(11);
		student.setSname("nand");
		student.setSaddress("earth");
		student.setSage(55);
		
		// 3. Perform persistence operation using entity/model/POJO object
		session.save(student);
		
		System.in.read();
		
		//4. Commit the operation based on the result
		transection.commit();
		
		System.out.println("Object saved to databse...");
		
		session.close();
	}

}
