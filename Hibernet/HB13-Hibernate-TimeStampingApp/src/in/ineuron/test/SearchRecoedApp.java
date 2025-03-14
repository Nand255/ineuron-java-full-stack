package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SearchRecoedApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		BankAccount account = null;
		Long id = 1L;
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				account = session.get(BankAccount.class, id);
				System.out.println("Before Update :: "+account);
				if (account != null) {
					account.setBalance(1234567.89);
					
					transaction = session.beginTransaction();
					// object is in synchronization ,so no need to write sesion.save(account);
					flag = true;					
				} else {
					System.out.println("Record not found for the given id :: "+id);
					System.exit(0);
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
				System.out.println("Account Opening Date :: "+account.getOpeningDate());
				System.out.println("Account lastly modified :: "+account.getLastUpdated());
				System.out.println("Account version count :: "+account.getCount());
			} else {
				transaction.rollback();
				System.out.println("Object not updated...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
