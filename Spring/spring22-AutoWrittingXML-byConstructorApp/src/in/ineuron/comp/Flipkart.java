package in.ineuron.comp;

import java.util.Arrays;
import java.util.Random;

// Target class
public class Flipkart {
	
	// Dependent class
	private Courier courier;
	private float discount;
	
	static {
		System.out.println("Flipkart.class file is loading...");
	}
	
	private Flipkart() {
		System.out.println("Flipkart :: Zero param constructor");
	}
	
	
	
	public Flipkart(Courier courier, float discount) {
		this.courier = courier;
		this.discount = discount;
		System.out.println("Flipkart :: Two param constructor");
		System.out.println(this);
	}



	public String doShopping(String[] items, float[] prices) {
		System.out.println("Flipkart.doShopping()");
		System.out.println("Implementation class is :: "+courier.getClass().getName());
		System.out.println("Discount amount is :: "+discount);
		
		float billAmt = 0.0f;
		int oid = 0;
		Random random = new Random();
		
		for (float price : prices) {
			billAmt += price;
		}
		oid = random.nextInt(1000);
		billAmt = (billAmt - discount*100)/ 100.0f;
		System.out.println("Order id is :: "+oid);
		String msg = courier.deliver(oid);
	
		return Arrays.toString(items)+" are purched having prices "+Arrays.toString(prices)+" with bill amount of "+billAmt+"---->"+msg;
	}

	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + ", discount=" + discount + "]";
	}

}
