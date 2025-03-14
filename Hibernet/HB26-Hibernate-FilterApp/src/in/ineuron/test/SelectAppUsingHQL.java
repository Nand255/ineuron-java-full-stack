package in.ineuron.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccountDetail;
import in.ineuron.util.HibernateUtil;

public class SelectAppUsingHQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			filter.setParameter("accType1", "closed");
			filter.setParameter("accType2", "blocked");
						
			Query<BankAccountDetail> query = session.createQuery("from in.ineuron.model.BankAccountDetail where balance>=:amt");
			query.setParameter("amt", 15000.0f);
			
			List<BankAccountDetail> accounts = query.list();
			accounts.forEach(System.out::println);
			
			System.out.println();
			
			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			Query<BankAccountDetail> query1 = session.createQuery("from in.ineuron.model.BankAccountDetail where balance>=:amt");
			query1.setParameter("amt", 15000.0f);
			
			List<BankAccountDetail> accounts1 = query.list();
			accounts1.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
