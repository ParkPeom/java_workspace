package �̱�������2;


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
		System.out.println("LG������ �ٶ��� �д�.");
	}

	@Override
	public void tunrOn() {
		System.out.println("���� ����Ŵ");
	}

	@Override
	public void turnOff() {
		System.out.println("���� ������");
	}
}
