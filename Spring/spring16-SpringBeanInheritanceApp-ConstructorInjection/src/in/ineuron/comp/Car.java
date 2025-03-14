package in.ineuron.comp;

public class Car {
	
	private String regNo;
	private String engineNo;
	private String model;
	private String compny;
	private String type;
	private int engineCC;
	private String color;
	private String owner;
	private String fuelType;
	
	static {
		System.out.println("Car.class file is loading...");
	}
	
	public Car() {
		System.out.println("Car object is instantiated...");
	}
	
	public Car(String regNo, String engineNo, String model, String compny, String type, int engineCC, String color,
			String owner, String fuelType) {
		super();
		this.regNo = regNo;
		this.engineNo = engineNo;
		this.model = model;
		this.compny = compny;
		this.type = type;
		this.engineCC = engineCC;
		this.color = color;
		this.owner = owner;
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", engineNo=" + engineNo + ", model=" + model + ", compny=" + compny + ", type="
				+ type + ", engineCC=" + engineCC + ", color=" + color + ", owner=" + owner + ", fuelType=" + fuelType
				+ "]";
	}
}
