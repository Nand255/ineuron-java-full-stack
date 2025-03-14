package in.ineuron.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccountDetail;
import in.ineuron.util.HibernateUtil;

public class SelectQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			Query<BankAccountDetail> query = session.createQuery("from in.ineuron.model.BankAccountDetail");
			List<BankAccountDetail> accounts = query.getResultList();
			accounts.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
