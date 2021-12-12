package product_aircon_attribute;


// 속성 모음 
public class AirconAttribute {
	
	private String color;
	private boolean power;
	private int temperture;
	
	public AirconAttribute() {}

	public AirconAttribute(String color, boolean power, int temperture) {
		super();
		this.color = color;
		this.power = power;
		this.temperture = temperture;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getTemperture() {
		return temperture;
	}

	public void setTemperture(int temperture) {
		this.temperture = temperture;
	}

	@Override
	public String toString() {
		return "AirconAttribute [color=" + color + ", power=" + power + ", temperture=" + temperture + "]";
	}
}
