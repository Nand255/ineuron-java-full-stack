package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.model.Payment;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			
			session = HibernateUtil.getSession();
			
			Query<Payment> query = session.createQuery("from in.ineuron.model.Payment");
			List<Payment> payments = query.list();
			payments.forEach(System.out::println);

			Query<CardPayment> query1 = session.createQuery("from in.ineuron.model.CardPayment");
			List<CardPayment> payments1 = query1.list();
			payments1.forEach(System.out::println);
			
			Query<ChequePayment> query2 = session.createQuery("from in.ineuron.model.ChequePayment");
			List<ChequePayment> payments2 = query2.list();
			payments2.forEach(System.out::println);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
