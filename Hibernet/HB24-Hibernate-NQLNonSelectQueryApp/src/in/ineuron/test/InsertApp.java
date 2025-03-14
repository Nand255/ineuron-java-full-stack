package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	private static int rowTransfered;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		int rowTransfered = 0;
		Boolean flag = false;
 		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			//Creating a query
			NativeQuery<String> nativeQuery = session.createSQLQuery("insert into insurancePolicy(pname, ptype, tenure) values(:pname, :ptype, :tenure)");
			
			nativeQuery.setParameter("pname", "LIC");
			nativeQuery.setParameter("ptype","monthly");
			nativeQuery.setParameter("tenure", 28);
			
			rowTransfered = nativeQuery.executeUpdate();
			
			flag = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Record inserted :: "+rowTransfered);
			} else {
				transaction.rollback();
				System.out.println("Record not inserted.");
			}
		}
		
	}
}
