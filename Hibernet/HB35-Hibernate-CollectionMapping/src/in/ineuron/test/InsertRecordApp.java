package in.ineuron.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		try {
			
			session = HibernateUtil.getSession();
			
			if (session != null) 
				transaction = session.beginTransaction();
			
			if (transaction != null) {
				
				Employee employee = new Employee();
				employee.setEid(10);
				employee.setEaddress("MI");
				employee.setEname("sachin");
				
				employee.setFriendList(List.of("saurav","dravid","sehwagh"));
				employee.setPhones(Set.of(99988877745L,5555666621L,9996663331L));
				employee.setBankAccounts(Map.of("SBI",112233L,"HDFC",223344L,"ICICI",112244L));
				
				session.save(employee);
				flag = true;
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to the database");
			} else {
				transaction.rollback();
				System.out.println("Object not saved to the database...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
