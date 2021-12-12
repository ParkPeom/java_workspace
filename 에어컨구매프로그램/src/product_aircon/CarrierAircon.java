package product_aircon;

import product_aircon_attribute.AirconAttribute;

public class CarrierAircon extends AirconAttribute implements Aircon {

	private static CarrierAircon carrier = null;
	
	AirconAttribute attribute;
	
	private CarrierAircon() {
		attribute = new AirconAttribute();
		attribute.setColor("white");
		attribute.setPower(false);
		attribute.setTemperture(0);
	}
	
	public static CarrierAircon getInstance() {
		if(carrier == null) {
			carrier = new CarrierAircon();
		}
		return carrier;
	}
	@Override
	public void windcomingout() {
		System.out.println("캐리어 에어컨 바람이 분다~");
	}

	@Override
	public void tunrOn() {
		System.out.println("캐리어 전원킴");
	}

	@Override
	public void turnOff() {
		System.out.println("캐리어 전원끔");
	}
	
}
