package in.ineuron.comp;

public class Printer {
	
	private static Printer INSTANCE = null;
	
	static {
		System.out.println("Printer.class file is loading...");
	}
	
	private Printer() {
		System.out.println("Printer :: Zero param coanstructor");
	}
	
	public static Printer getInstance() {
		System.out.println("Printer.getInstaPrinter()");
		if (INSTANCE == null) {
			INSTANCE = new Printer();
		}
		return INSTANCE;
	}

	@Override
	public String toString() {
		return "Printer [hashCode()=" + hashCode() + "]";
	}
	
}
