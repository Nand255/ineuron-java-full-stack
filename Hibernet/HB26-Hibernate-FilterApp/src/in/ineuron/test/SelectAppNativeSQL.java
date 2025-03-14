package in.ineuron.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccountDetail;
import in.ineuron.util.HibernateUtil;

public class SelectAppNativeSQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			// Here filters won't be applied
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			filter.setParameter("accType1", "closed");
			filter.setParameter("accType2", "blocked");
						
			NativeQuery<BankAccountDetail> nQuery = session.createSQLQuery("select * from bankaccountdetail where balance>=:amt");
			nQuery.setParameter("amt", 15000.0f);
			nQuery.addEntity(BankAccountDetail.class);
			
			List<BankAccountDetail> accounts = nQuery.list();
			accounts.forEach(System.out::println);
			
			System.out.println();
			
			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			NativeQuery<BankAccountDetail> nQuery1 = session.createSQLQuery("select * from bankaccountdetail where balance>=:amt");
			nQuery1.setParameter("amt", 15000.0f);
			nQuery1.addEntity(BankAccountDetail.class);
			
			List<BankAccountDetail> accounts1 = nQuery1.list();
			accounts1.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
