package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SearchRecoedApp {
	public static void main(String[] args) {
		Session session = null;
		InsurancePolicy policy = null;
		
		try {
			session = HibernateUtil.getSession();
			
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("1."+policy); 
			System.out.println("---------------------------------------------"); //gets from DB put in L1-cache

			// here it will get from L1-cache no select query will be generated
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("2."+policy); 
			System.out.println("---------------------------------------------"); //gets from L1-cache
			
			session.evict(policy); // Remove policy object from L1-cache
			
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("3."+policy); 
			System.out.println("---------------------------------------------"); //gets from DB put in L1-cache

			// here it will get from L1-cache no select query will be generated
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("4."+policy); 
			System.out.println("---------------------------------------------"); //gets from L1-cache
			
			// all of these policy2,3,4 object will point to same policy object present in session
			// So query generation won't happen or there is no need to generate select query
			InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L);
			System.out.println("5."+policy2);
			System.out.println("---------------------------------------------"); //gets from L1-cache
			InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1L);
			System.out.println("6."+policy3);
			System.out.println("---------------------------------------------"); //gets from L1-cache
			InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1L);
			System.out.println("7."+policy4);
			System.out.println("---------------------------------------------"); //gets from L1-cache
			
			// Remove all objects from cache
			session.clear(); 
			
			// new object will be created it means select query will be generated for policy5 object
			InsurancePolicy policy5 = session.get(InsurancePolicy.class, 1L);
			System.out.println("8."+policy5);
			System.out.println("---------------------------------------------"); //gets from L1-cache
			
			// New object will be created , for different ID
			InsurancePolicy policy6 = session.get(InsurancePolicy.class, 2L);
			System.out.println("9."+policy6);
			System.out.println("---------------------------------------------"); //gets from L1-cache
			
			 
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
