package in.ineuron.dao;

import java.io.IOException;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;

import in.ineuron.dto.Student;
import in.ineuron.util.*;

public class StudentDaoImpl implements IStudentDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	@Override
	public String addStudent(Student student) throws IOException {
		
		String sqlInsertQuery = "insert into studentbatch(name,age,address) values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
		
			if(pstmt != null) {
			
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());
			
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				} 
			}
		
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) throws IOException {
		Student std = null;
		
		String sqlSearchQuery = "select id,name,age,address from studentbatch where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null)
				pstmt = connection.prepareStatement(sqlSearchQuery);
		
			if(pstmt != null) {
				pstmt.setInt(1, sid);
				
				resultSet = pstmt.executeQuery();
			}
			
			if (resultSet != null) {
				if (resultSet.next()) {
					std = new Student();
					
					//copy resultset data to student object
					std.setSid(resultSet.getInt(1));
					std.setSname(resultSet.getString(2));
					std.setSage(resultSet.getInt(3));
					std.setSaddress(resultSet.getString(4));
					
					return std;
				} 
			} 
		
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		return std;
	}

	@Override
	public String updateStudent(Student student) throws IOException {
		
		String sqlUpdateQuery = "update studentbatch set name = ? , age = ?, address = ? where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);
		
			if(pstmt != null) {
			
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());
				pstmt.setInt(4, student.getSid());
			
				int rowAffected = pstmt.executeUpdate();
				
				if (rowAffected == 1) {
					return "success";
				} else {
					return "not found";
				}
			}
		
		} catch (SQLException e) {
				e.printStackTrace();
				return "failure";
		}
		
		return "failure";
	}	

	@Override
	public String deleteStudent(Integer sid) throws IOException {
		String sqlDeleteQuery = "delete from studentbatch where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);
		
			if(pstmt != null) {
			
				pstmt.setInt(1, sid);
			
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				} else {
					return"not found";
				}
			}
		
		} catch (SQLException e) {
				e.printStackTrace();
				return "failure";
		}
		
		return "failure";
	}

}
