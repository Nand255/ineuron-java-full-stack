package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.StudentInfo;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
			
			Query<StudentInfo> query = session.createQuery("from in.ineuron.model.StudentInfo where address.cityName =:city");
			query.setParameter("city", "gandhinagar");
			
			List<StudentInfo> info = query.getResultList();
			
			info.forEach(System.out::println);
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