package product_aircon;

import product_aircon_attribute.AirconAttribute;

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
		System.out.println("�Ｚ������ �ٶ��� �д�.");
	}
	@Override
	public void tunrOn() {
		System.out.println("�Ｚ ����Ŵ");
	}
	@Override
	public void turnOff() {
		System.out.println("�Ｚ ������");
	}
}
