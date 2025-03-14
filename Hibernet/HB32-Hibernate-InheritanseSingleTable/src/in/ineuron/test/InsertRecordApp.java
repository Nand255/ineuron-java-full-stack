package in.ineuron.test;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
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
				
				CardPayment cardPayment = new CardPayment();
				cardPayment.setPid(3251);
				cardPayment.setAmount(8000.5f);
				
				cardPayment.setCardNo(1247L);
				cardPayment.setCardType("Debit");
				cardPayment.setPaymentGateway("visa");
				
				ChequePayment chequePayment = new ChequePayment();
				chequePayment.setPid(6514);
				chequePayment.setAmount(6500.45f);
				
				chequePayment.setChequeNo(859429L);
				chequePayment.setChequeType("self");
				chequePayment.setExpiryDate(LocalDate.of(23, 4, 27));
				
				session.save(cardPayment);
				session.save(chequePayment);
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
