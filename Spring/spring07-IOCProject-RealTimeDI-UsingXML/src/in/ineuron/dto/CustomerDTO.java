package in.ineuron.dto;

//DTO -> data transfer object
public class CustomerDTO {
	public String CustomerName;
	public String CustomerAddress;
	
	public Float pamt;
	public Float rate;
	public Float time;
	
	static {
		System.out.println("CustomerDTO.class is loading...");
	}
	
	public CustomerDTO() {
		System.out.println("CustomerDTO object is instantiated...");
	}

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

	@Override
	public String toString() {
		return "CustomerDTO [CustomerName=" + CustomerName + ", CustomerAddress=" + CustomerAddress + ", pamt=" + pamt
				+ ", rate=" + rate + ", time=" + time + "]";
	}
	
}
