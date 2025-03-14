package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository(value="dao")
public class EmpDaoLayerImpl implements EmpDaoLayer {
	
	static {
		System.out.println("EmpDAOLayerImpl.class file is loading...");
	}
	
	public EmpDaoLayerImpl() {
		System.out.println("EmpDAOLayerImpl :: zero param constructor...");
	}
	
	private static final String REALTIMEDI_EMPLOYEE_INSERT_QUERY = "insert into emp (ename,eaddress,dept,salary) values(?,?,?,?)";
	private static final String REALTIMEDI_EMPLOYEE_SEARCH_QUERY = "select eid,ename,eaddress,dept,salary from emp where eid = ?";
	private static final String REALTIMEDI_EMPLOYEE_DELETE_QUERY = "delete from emp where eid = ?";
	private static final String REALTIMEDI_EMPLOYEE_UPDATE_QUERY = "update emp set ename = ? , eaddress = ?, dept = ? , salary = ? where eid = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		
		int count = 0;
		try (Connection connection = dataSource.getConnection(); 
			PreparedStatement pstmt = connection.prepareStatement(REALTIMEDI_EMPLOYEE_INSERT_QUERY);) {
			pstmt.setString(1, bo.geteName());
			pstmt.setString(2, bo.geteAddress());
			pstmt.setString(3, bo.getDept());
			pstmt.setFloat(4, bo.getSalary());
			
			count = pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			throw se;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

	@Override
	public EmployeeBO search(Integer eid) throws Exception {
		EmployeeBO bo = null;
		try (Connection connection = dataSource.getConnection(); 
			PreparedStatement pstmt = connection.prepareStatement(REALTIMEDI_EMPLOYEE_SEARCH_QUERY);) {
			pstmt.setInt(1, eid);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			if (resultSet.next()) {				   
				bo = new EmployeeBO();
				bo.seteId(resultSet.getInt(1));
				bo.seteName(resultSet.getString(2));
				bo.seteAddress(resultSet.getString(3));
				bo.setDept(resultSet.getString(4));
				bo.setSalary(resultSet.getFloat(5));
				} 
			
		} catch(SQLException se) {
			se.printStackTrace();
			throw se;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return bo;
	}

	@Override
	public int delete(Integer eid) throws Exception {
		int count = 0;
		try (Connection connection = dataSource.getConnection(); 
			PreparedStatement pstmt = connection.prepareStatement(REALTIMEDI_EMPLOYEE_DELETE_QUERY);) {
			pstmt.setInt(1, eid);
			
			count = pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			throw se;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

	@Override
	public int update(EmployeeBO bo) throws Exception {
		int count = 0;
		try (Connection connection = dataSource.getConnection(); 
				PreparedStatement pstmt = connection.prepareStatement(REALTIMEDI_EMPLOYEE_UPDATE_QUERY);) {
					pstmt.setString(1, bo.geteName());
					pstmt.setString(2, bo.geteAddress());
					pstmt.setString(3, bo.getDept());
					pstmt.setFloat(4, bo.getSalary());
					pstmt.setInt(5, bo.geteId());
					
					count = pstmt.executeUpdate();
				
			} catch(SQLException se) {
				se.printStackTrace();
				throw se;
			} catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
			return count;
	}
	
}
