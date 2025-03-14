package in.ineuron.comp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="dtdc")
@Scope(scopeName = "prototype")
// when @Primary is used with @Scope(scopeName = "prototype") it will perform eager loading, so using both at the same time dose not make sense
//@Primary
public class DTDC implements Courier {
	
	static {
		System.out.println("DTDC.class file is loding...");
	}
	
	public DTDC() {
		System.out.println("DTDC :: Zero param constructor...");
	}
	
	@Override
	public String deliver(int oid) {
		return "DTDC courier will be delivered with the order id :: "+oid+" for the ordered products.";
	}

}
