package in.ineuron.comp;

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
