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
		System.out.println("ĳ���� ������ �ٶ��� �д�~");
	}

	@Override
	public void tunrOn() {
		System.out.println("ĳ���� ����Ŵ");
	}

	@Override
	public void turnOff() {
		System.out.println("ĳ���� ������");
	}
	
}
