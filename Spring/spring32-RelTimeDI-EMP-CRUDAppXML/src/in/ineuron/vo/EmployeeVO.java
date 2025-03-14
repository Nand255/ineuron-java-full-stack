package in.ineuron.vo;

// VO -> value object(taking value from the user)
public class EmployeeVO {
	public String eId;
	public String eName;
	public String eAddress;
	public String salary;
	public String dept;
	
	static {
		System.out.println("EmployeeVO.class file is loading....");
	}
	
	public EmployeeVO() {
		System.out.println("EmployeeVO :: zero param constructor...");
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
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
		return "EmployeeVO [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + ", salary=" + salary
				+ ", dept=" + dept + "]";
	}
	
}
