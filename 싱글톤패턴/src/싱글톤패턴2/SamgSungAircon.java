package ½Ì±ÛÅæÆĞÅÏ2;

public class SamgSungAircon extends AirconAttribute implements Aircon {

	private static SamgSungAircon samsung = null;		
	private AirconAttribute attribute = null;

	private SamgSungAircon() {
		attribute = new AirconAttribute();
		attribute.setColor("white");
		attribute.setPower(false);
		attribute.setTemperture(0);
	}
	public static SamgSungAircon getInstance() {
		if(samsung == null) {
			samsung = new SamgSungAircon();
		}
		return samsung;
	}
	@Override
	public void windcomingout() {
		System.out.println("»ï¼º¿¡¾îÄÜ ¹Ù¶÷ÀÌ ºĞ´Ù.");
	}
	@Override
	public void tunrOn() {
		System.out.println("»ï¼º Àü¿øÅ´");
	}
	@Override
	public void turnOff() {
		System.out.println("»ï¼º Àü¿ø²û");
	}
}
