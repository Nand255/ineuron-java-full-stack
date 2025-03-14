package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelecttApp3 {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		int rowTransfered = 0;
		Boolean flag = false;
 		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			//Creating a query
			NativeQuery<Object[]> nativeQuery = session.createSQLQuery("SELECT pid, pname, ptype FROM INSURANCEPOLICY WHERE TENURE>=:min AND TENURE<=:max");
			
			//setting the parameters
			nativeQuery.setParameter("min", 15);
			nativeQuery.setParameter("max", 30);
			
			// Binding the datatype of output parameters
			// without binding you will get same output
			// But it is good practice to bind EntityQueru result with Entity class and Scalar query result with HIBERNATE data types
			nativeQuery.addScalar("pid",StandardBasicTypes.INTEGER);
			nativeQuery.addScalar("pname",StandardBasicTypes.STRING);
			nativeQuery.addScalar("ptype",StandardBasicTypes.STRING);
			
			//Executing to get the result
			List<Object[]> policies = nativeQuery.getResultList();
			
			// Process the result
			System.out.println("PICD\tPNAME\t\tPTYPE");
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
