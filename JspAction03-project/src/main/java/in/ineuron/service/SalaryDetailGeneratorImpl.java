package in.ineuron.service;

import in.ineuron.dto.EmployeeDto;

public class SalaryDetailGeneratorImpl implements SalaryDetailGenerator {

	@Override
	public void generateSalaryDetails(EmployeeDto dto) {
		
		// generate gross salary and net salary
		float grossSalary = dto.getBsalary() + (dto.getBsalary()*0.3f);
		float netSalary = grossSalary - (dto.getBsalary()*0.2f);
		
		// set those values into dto
		dto.setGrossSalary(grossSalary);
		dto.setNetSalary(netSalary);
	}

}
