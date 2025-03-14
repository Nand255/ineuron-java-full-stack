package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;

public class InsertRecoedApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		ProgrammerProjId pkId = null;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				transaction = session.beginTransaction();
				if(transaction != null) {
					ProgrammerProjId projId = new ProgrammerProjId();
					projId.setPid(102);
					projId.setProjid(500);
					
					ProgrammerProjInfo projInfo = new ProgrammerProjInfo();
					projInfo.setId(projId);
					projInfo.setPname("sachin");
					projInfo.setProjname("IPL");
					projInfo.setDeptno(10);
					
					pkId = (ProgrammerProjId)session.save(projInfo);
					
					flag = true;
				}
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object inserted to database..."+ pkId);
			} else {
				transaction.rollback(); 
				System.out.println("Object not inserted to database...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
