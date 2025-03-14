package in.ineuron.comp;

public class BlueDart implements Courier {

	static {
		System.out.println("BlueDart.class file is loding...");
	}
	
	public BlueDart() {
		System.out.println("BlueDart :: Zero param constructor...");
	}
	
	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		return "BlurDart courier will be delivered with the order id :: "+oid+" for the ordered products.";
	}

}
