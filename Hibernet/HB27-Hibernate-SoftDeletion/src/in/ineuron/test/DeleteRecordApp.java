package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccountDetail;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			BankAccountDetail account = new BankAccountDetail();
			account.setAccno(1258);
			
			session.delete(account);
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object status changed to closed/blocked==> soft deletion");
			} else {
				transaction.rollback();
				System.out.println("Object status not changed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
