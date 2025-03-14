package in.ineuron.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.EmpDaoLayer;
import in.ineuron.dto.EmployeeDTO;

@Service(value="service")
public class EmpServiceLayerImpl implements EmpServiceLayer {
	
	static {
		System.out.println("EmpSeviceImpl.class file is loading...");
	}
	
	public EmpServiceLayerImpl() {
		System.out.println("EmpSeviceImpl :: zero param constructor...");
	}
	
	@Autowired
	private EmpDaoLayer dao;
	
	public String insert(EmployeeDTO dto) throws Exception {
		int count = 0;
		
		//instead doing this manually you can use--> BeanUtils.copyProperties(dto,bo);(copy from, to); 
		//this can be used for copying when data types are same or does not change
		EmployeeBO bo = new EmployeeBO();
		bo.seteName(dto.geteName());
		bo.setSalary(dto.getSalary());
		bo.setDept(dto.getDept());
		bo.seteAddress(dto.geteAddress());		
		
		count = dao.insert(bo);
		
		return count==0?"Employee registration failed" : "Employee regidtered successfully";
	}

	@Override
	public EmployeeDTO search(Integer eid) throws Exception {
		
		EmployeeBO bo =  dao.search(eid);
		
		EmployeeDTO dto = new EmployeeDTO();
		
		BeanUtils.copyProperties(bo,dto);
		
		return dto;
	}

	@Override
	public String delete(Integer eid) throws Exception {
		int count = 0;
		
		count = dao.delete(eid);
		
		return count==0?"Employee deletion failed" : "Employee deleted successfully";
	}

	@Override
	public String update(EmployeeDTO dto) throws Exception {
		int count = 0;
		EmployeeBO bo = new EmployeeBO();
		bo.seteId(dto.geteId());
		bo.seteName(dto.geteName());
		bo.setSalary(dto.getSalary());
		bo.setDept(dto.getDept());
		bo.seteAddress(dto.geteAddress());
		
		count = dao.update(bo);
		
		return count==0?"Employee updation failed" : "Employee updated successfully";
	}
	
}
