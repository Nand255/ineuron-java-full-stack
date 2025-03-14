package in.ineuron.service;

import java.io.IOException;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.dao.IStudentDao;
import in.ineuron.servicefactory.StudentServiceFactory;;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao = null; 
	@Override
	public String addStudent(Student student) throws IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		if (stdDao != null) 
			return stdDao.addStudent(student);
		else
			return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) throws IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) throws IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) throws IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}

}
