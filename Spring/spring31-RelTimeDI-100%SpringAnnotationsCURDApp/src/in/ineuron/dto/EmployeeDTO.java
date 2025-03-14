package in.ineuron.dto;


//DTO -> data transfer object
public class EmployeeDTO {
	public Integer eId;
	public String eName;
	public String eAddress;
	public Float salary;
	public String dept;
	
	static {
		System.out.println("EmployeeDTO.class is loading...");
	}
	
	public EmployeeDTO() {
		System.out.println("EmployeeDTO object is instantiated...");
	}
	
	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteAddress() {
		return eAddress;
	}

	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + ", salary=" + salary
				+ ", dept=" + dept + "]";
	}
}
