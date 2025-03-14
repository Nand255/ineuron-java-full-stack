package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;

public class SearchRecoedApp {
	public static void main(String[] args) {
		Session session = null;
		
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				ProgrammerProjId id = new ProgrammerProjId();
				id.setPid(101);
				id.setProjid(500);
				
				ProgrammerProjInfo info = session.get(ProgrammerProjInfo.class, id);
				if (info != null) {
					System.out.println(info);
				} else {
					System.out.println("Record does not exist for given ID :: "+id);
				}
			}
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
