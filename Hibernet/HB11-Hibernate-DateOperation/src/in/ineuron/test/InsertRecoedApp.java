package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class InsertRecoedApp {
	
	public static void main(String[] args) {
	
		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				transaction = session.beginTransaction();
				
				if(transaction != null) {
					
					PersonInfo personInfo = new PersonInfo();
					personInfo.setPname("sachin");
					personInfo.setDob(LocalDate.of(1973, 04, 24));
					personInfo.setDom(LocalDateTime.of(1995, 5, 25, 7, 45));
					personInfo.setDoj(LocalTime.of(9, 45));
					
					id = (Integer)session.save(personInfo);
					flag = true;
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag == true) {
				transaction.commit();
				System.out.println("Object inserted to database..."+id);
			} else {
				transaction.rollback(); 
				System.out.println("Object not inserted to database...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
