package in.ineuron.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.EmpServiceLayer;
import in.ineuron.vo.EmployeeVO;

@Component(value="controller")
public class MainController {
	
	static {
		System.out.println("MainController.class file is loading...");
	}
	
	public MainController() {
		System.out.println("MainController :: zero param constructor");
	}
	
	@Autowired
	private EmpServiceLayer service;
	
	public String insert(EmployeeVO vo) throws Exception {
		
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.seteName(vo.geteName());
		dto.setDept(vo.getDept());
		dto.setSalary(Float.parseFloat(vo.getSalary()));
		dto.seteAddress(vo.geteAddress());
		
		String result = service.insert(dto);
		
		return result;
	}
	
	public EmployeeDTO search(Integer eid) throws Exception {
					
		EmployeeDTO result = service.search(eid);
		
		return result;
	}
	
	public String delete(Integer eid) throws Exception {
		
		String result = service.delete(eid);
		
		return result;
	}
	
	public String update(EmployeeVO vo) throws Exception {
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.seteId(Integer.parseInt(vo.geteId()));
		dto.seteName(vo.geteName());
		dto.setDept(vo.getDept());
		dto.setSalary(Float.parseFloat(vo.getSalary()));
		dto.seteAddress(vo.geteAddress());
		
		String result = service.update(dto);
		
		return result;
	}
}
