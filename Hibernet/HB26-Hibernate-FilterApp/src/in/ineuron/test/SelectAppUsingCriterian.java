package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition;

import in.ineuron.model.BankAccountDetail;
import in.ineuron.util.HibernateUtil;

public class SelectAppUsingCriterian {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			filter.setParameter("accType1", "closed");
			filter.setParameter("accType2", "blocked");
						
			Criteria criteria = session.createCriteria(BankAccountDetail.class);
			
			Criterion cond = Restrictions.ge("balance", 15000f);
			criteria.add(cond);
			
			List<BankAccountDetail> accounts = criteria.list();
			accounts.forEach(System.out::println);
			
			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			
			Criteria criteria1 = session.createCriteria(BankAccountDetail.class);
			
			Criterion cond1 = Restrictions.ge("balance", 15000f);
			criteria1.add(cond1);
			
			List<BankAccountDetail> accounts1 = criteria1.list();
			accounts1.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
