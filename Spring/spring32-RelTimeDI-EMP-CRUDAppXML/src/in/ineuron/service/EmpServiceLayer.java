package in.ineuron.service;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.vo.EmployeeVO;

public interface EmpServiceLayer {

	public String insert(EmployeeDTO dto) throws Exception;
	public EmployeeDTO search(Integer eid) throws Exception;
	public String delete(Integer eid) throws Exception;
	public String update(EmployeeDTO dto) throws Exception;
}
