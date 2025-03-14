package in.ineuron.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	@Override
	public String tranferPolicies(int minTenure) {
		
		Session session = null;
		Transaction transaction = null;
		@SuppressWarnings("rawtypes")
		Query query = null;
		int rowTransfered = 0;
		Boolean flag = false;
		String msg = null;
		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			query = session.getNamedQuery("HQL_TRANSFER_POLICIES");
			query.setParameter("min", minTenure);
			
			rowTransfered = query.executeUpdate();
			flag = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				msg = "No of rows transfered is ::"+rowTransfered;
			} else {
				transaction.rollback();
				msg = "records not coplied to table";
			}
		}
		
		
		return msg;
	}

}
