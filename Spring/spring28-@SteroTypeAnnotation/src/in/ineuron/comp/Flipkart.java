package in.ineuron.comp;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Target class
@Component
@Scope(scopeName = "singleton")
@PropertySource(value="in/ineuron/commons/application.properties")
public class Flipkart {
	
	// Dependent class
	@Autowired
	//Qualifier() has higher presence then @Primary
	@Qualifier(value="fFlight")
	private Courier courier;
	
	@Value("${flipkart.info.discount}")
	private float discount;
	
	static {
		System.out.println("Flipkart.class file is loading...");
	}
	
	private Flipkart() {
		System.out.println("Flipkart :: Zero param constructor");
	}
	
	public void setCourier(Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart.setCourier()");
		System.out.println(this);
	}

	public void setDiscount(float discount) {
		this.discount = discount;
		System.out.println("Flipkart.setDiscount()");
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
