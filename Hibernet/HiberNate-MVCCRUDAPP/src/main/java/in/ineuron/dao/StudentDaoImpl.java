package in.ineuron.dao;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dto.Student;
import in.ineuron.util.*;

public class StudentDaoImpl implements IStudentDao {
	
	Session session = HibernateUtil.getSession();
	
	@Override
	public String addStudent(Student student) throws IOException {
		
		Transaction transaction = null;
		String status = null;
		Boolean flag = false;
		try {			
			if(session != null) {
				transaction = session.beginTransaction();
				if(transaction != null) {
					session.save(student);
				
					flag = true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}

	@Override
	public Student searchStudent(Integer sid) throws IOException {
		Student student = session.get(Student.class, sid);
		if(student != null)
			return student;
		else 
			return null;
	}

	@Override
	public String updateStudent(Student student) throws IOException {
		Transaction transaction = null;
		String status = null;
		Boolean flag = false;
		
		try {			
			
			if(session != null) {
				transaction = session.beginTransaction();
				if(transaction != null) {
					
					student.setSid(student.getSid());
					student.setSname(student.getSname());
					student.setSaddress(student.getSaddress());
					student.setSage(student.getSage());
					session.merge(student);
					flag = true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag == true) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}	

	@Override
	public String deleteStudent(Integer sid) throws IOException {
		Transaction transaction = null;
		String status = null;
		Boolean flag = false;
		
		Student student = session.get(Student.class, sid);
		
		try {			
			if(session != null) {
				transaction = session.beginTransaction();
				if(transaction != null) {
					session.delete(student);
					flag = true;
				} else {
					return "not found";
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(flag == true) {
				transaction.commit();
				status = "success";
			} else {
				transaction.rollback();
				status = "failure";
			}
		}
		return status;
	}

}
