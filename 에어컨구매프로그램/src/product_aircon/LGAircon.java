package product_aircon;

import product_aircon_attribute.AirconAttribute;

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
		System.out.println("LG에어콘 바람이 분다.");
	}

	@Override
	public void tunrOn() {
		System.out.println("엘지 전원킴");
	}

	@Override
	public void turnOff() {
		System.out.println("엘지 전원끔");
	}
}
