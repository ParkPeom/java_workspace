package ½Ì±ÛÅæÆĞÅÏ2;


public class LGAircon extends AirconAttribute implements Aircon {

	private static LGAircon lg = null;
	
	AirconAttribute attribute;
	
	private LGAircon() {
		attribute = new AirconAttribute();
		attribute.setColor("white");
		attribute.setPower(false);
		attribute.setTemperture(0);
	}
	public static LGAircon getInstance() {
		if(lg == null) {
			lg = new LGAircon();
		}
		return lg;
	}
	@Override
	public void windcomingout() {
		System.out.println("LG¿¡¾îÄÜ ¹Ù¶÷ÀÌ ºĞ´Ù.");
	}

	@Override
	public void tunrOn() {
		System.out.println("¿¤Áö Àü¿øÅ´");
	}

	@Override
	public void turnOff() {
		System.out.println("¿¤Áö Àü¿ø²û");
	}
}
