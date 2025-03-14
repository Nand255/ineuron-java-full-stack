package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.model.BankAccountDetail;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordUsingHql {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		int rowCount = 0;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			/*Query<BankAccountDetail> query = session.createQuery("DELETE FROM in.ineuron.model.BankAccountDetail WHERE accno=:no");
			  This query will delete the row, it is not going to consider @SQLXXXXX tag 
			  So we need to explicitly write "update sql query" for soft deletion
			  
			  While working with @SQLXXX annotations/custom queries execution takes only for single row operaion,
			  So if we use HQL, NativeSql, QBC logics then we need to explicitly write "update sql query" for soft deletion
			*/
			Query<BankAccountDetail> query = session.createQuery("UPDATE in.ineuron.model.BankAccountDetail SET STATUS='closed' WHERE accno=:no");
			query.setParameter("no", 2344);
			
			rowCount = query.executeUpdate();
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object status changed to closed/blocked==> soft deletion :: "+rowCount);
			} else {
				transaction.rollback();
				System.out.println("Object status not changed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
