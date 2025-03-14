package in.ineuron.comp;

import java.util.Date;

//Target class(userDefined=>WishMessageGenerator)
public class WishMessageGenerator {

	// Dependent class(PreDefined=> java.util.Date)
	private Date date;

	static {
		System.out.println("\nWishMessageGenerator.class file is loading...");
	}
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator object is instantiated using:: zero param constructor...");
	}
	
	public void setDate(Date date) {
		this.date = date;
		System.out.println("Setter method is called to perform setter injection...");
	}
	
	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}

}