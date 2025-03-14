package in.ineuron.bo;

// BO -> Business object
public class EmployeeBO {
	
	public Integer eId;
	public String eName;
	public String eAddress;
	public Float salary;
	public String dept;
	
	static {
		System.out.println("EmployeeBO.class file is loading...");
	}
	public EmployeeBO() {
		System.out.println("EmployeeBO :: zero param constructor..");
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

	public void setSalary(Float f) {
		this.salary = f;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "EmployeeBO [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + ", salary=" + salary
				+ ", dept=" + dept + "]";
	}

}
