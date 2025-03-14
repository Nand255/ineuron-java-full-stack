package in.ineuron.vo;

// VO -> value object(taking value from the user)
public class CustomerVO {
	public String customerName;
	public String customerAddress;
	public String pamt;
	public String rate;
	public String time;
	
	static {
		System.out.println("CustomerVO.class file is loading....");
	}
	
	public CustomerVO() {
		System.out.println("CustomerVO object is instantiated...");
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setPamt(String pamt) {
		this.pamt = pamt;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getPamt() {
		return pamt;
	}

	public String getRate() {
		return rate;
	}

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "CustomerVO [customerName=" + customerName + ", customerAddress=" + customerAddress + ", pamt=" + pamt
				+ ", rate=" + rate + ", time=" + time + "]";
	}
	
}
