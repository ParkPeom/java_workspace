package ½Ì±ÛÅæÆĞÅÏ2;

public class Bokuk extends AirconAttribute implements Aircon {

	private static Bokuk bokuk = null;
	
	AirconAttribute attribute;
	
	private Bokuk() {
		attribute = new AirconAttribute();
		attribute.setColor("white");
		attribute.setPower(false);
		attribute.setTemperture(0);
	}
	
	public static Bokuk getInstance() {
		if(bokuk == null) {
			bokuk = new Bokuk();
		}
		return bokuk;
	}
	@Override
	public void windcomingout() {
		System.out.println("º¸Äî ¹Ù¶÷ÀÌ ºĞ´Ù~ ");
	}
	@Override
	public void tunrOn() {
		System.out.println("º¸Äî Àü¿øÅ´");
	}
	@Override
	public void turnOff() {
		System.out.println("º¸Äî Àü¿ø²û");
	}
}
