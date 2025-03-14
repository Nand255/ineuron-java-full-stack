package in.ineuron.comp;

public class A {
	private B b;
	
	static {
		System.out.println("A.class file is loading...");
	}

	public A() {
		System.out.println("A :: Zero param constructor");
	}
	
	public A(B b) {
		this.b = b;
		System.out.println("A :: One param constructor");
	}

	public void setB(B b) {
		this.b = b;
		System.out.println("A.setB()");
	}

	@Override
	public String toString() {
		return "A [b=" + b + "]";
	}
}
