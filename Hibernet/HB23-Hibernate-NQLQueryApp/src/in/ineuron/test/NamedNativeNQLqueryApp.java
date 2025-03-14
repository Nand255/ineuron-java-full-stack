package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class NamedNativeNQLqueryApp {

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
			NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("GET_ALL_POLICIES_TYPE");
			
			nativeQuery.setParameter("ptype", "yearly");
			
			List<Object[]> policies = nativeQuery.getResultList();
			
			System.out.println("pid\tpname\t\tptype");
			policies.forEach(row->{
				for(Object obj : row) {
					System.out.print(obj+"\t");
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
