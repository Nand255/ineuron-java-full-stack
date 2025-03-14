package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelecttApp4 {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		int rowTransfered = 0;
		Boolean flag = false;
 		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			//Creating a query
			NativeQuery<String> nativeQuery = session.createSQLQuery("SELECT pname FROM INSURANCEPOLICY WHERE TENURE>=:min AND TENURE<=:max");
			
			//setting the parameters
			nativeQuery.setParameter("min", 15);
			nativeQuery.setParameter("max", 30);
			
			//Executing to get the result
			List<String> policies = nativeQuery.getResultList();
			
			// Process the result
			policies.forEach(System.out::println);
			
			flag = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
		}
		
	}
}
