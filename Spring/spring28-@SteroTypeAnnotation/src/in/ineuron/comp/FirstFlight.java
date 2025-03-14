package in.ineuron.comp;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value="fFlight")
@Lazy(true) //used for lazy loading
public class FirstFlight implements Courier {

	static {
		System.out.println("FirstFlight.class file is loding...");
	}
	
	public FirstFlight() {
		System.out.println("FirstFlight :: Zero param constructor...");
	}
	
	@Override
	public String deliver(int oid) {
		return "FirstFlight courier will be delivered with the order id :: "+oid+" for the ordered products.";
	}

}
