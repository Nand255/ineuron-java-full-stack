package in.ineuron.bo;

// BO -> Business object
public class CustomerBO {
	public String CustomerName;
	public String CustomerAddress;
	
	public Float pamt;
	public Float rate;
	public Float time;
	
	private Float intrAmount;

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public void setPamt(Float pamt) {
		this.pamt = pamt;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public void setIntrAmount(Float intrAmount) {
		this.intrAmount = intrAmount;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public Float getPamt() {
		return pamt;
	}

	public Float getRate() {
		return rate;
	}

	public Float getTime() {
		return time;
	}

	public Float getIntrAmount() {
		return intrAmount;
	}

	@Override
	public String toString() {
		return "CustomerBO [CustomerName=" + CustomerName + ", CustomerAddress=" + CustomerAddress + ", pamt=" + pamt
				+ ", rate=" + rate + ", time=" + time + ", intrAmount=" + intrAmount + "]";
	}
	
}
