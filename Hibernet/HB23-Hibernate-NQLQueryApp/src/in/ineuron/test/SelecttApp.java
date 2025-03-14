package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelecttApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		int rowTransfered = 0;
		Boolean flag = false;
 		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			//Creating a query
			NativeQuery<Object[]> nativeQuery = session.createSQLQuery("SELECT * FROM INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?");
			
			//setting the parameters
			nativeQuery.setParameter(1, 15);
			nativeQuery.setParameter(2, 30);
			
			//Executing to get the result
			List<Object[]> policies = nativeQuery.getResultList();
			
			// Process the result
			policies.forEach(row->{
				for(Object obj : row) {
					System.out.print(obj+"\t\t");					
				}
				System.out.println();
			});
			
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
