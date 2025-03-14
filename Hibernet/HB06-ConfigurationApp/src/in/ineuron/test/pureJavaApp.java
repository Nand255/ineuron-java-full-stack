package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import in.ineuron.model.Student;

public class pureJavaApp {
	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		int id = 7;
		
		try {
			configuration = new Configuration();
			
			// setting the properties for configuration object using pure java code
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///student");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "2525");
			
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			configuration.setProperty("hibernate.show_sql", "true");
			configuration.setProperty("hibernate.format_sql", "true");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			
			// providing information about mapping file
			configuration.addAnnotatedClass(Student.class);
			
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Student student = session.get(Student.class, id);
			if(student != null) {
				System.out.println(student);
			} else {
				System.out.println("Record not available for given ID :: "+id);
			}
			
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}
}
