package in.ineuron.dao;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dto.EmployeeDTO;

public interface EmpDaoLayer {
	
	public int insert(EmployeeBO bo) throws Exception;
	public EmployeeDTO search(Integer eid) throws Exception;
	public int delete(Integer eid) throws Exception;
	public int update(EmployeeBO bo) throws Exception;
}
