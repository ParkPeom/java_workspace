package �̱�������2;

public class UseAirCon {
	public void useAircon(Aircon aircon) {
		aircon.windcomingout();
	}
	public void turnon(Aircon aircon) {
		aircon.tunrOn();
	}
	public void turnoff(Aircon aircon) { 
		aircon.turnOff();
	}
	public void template(Aircon aircon) {
		UseAirCon use = new UseAirCon();
		use.turnon(aircon);
		use.useAircon(aircon);
		use.turnoff(aircon);
		line();
	}
	public void line() {
		System.out.println("----------------------------");
	}
	
	// �Ӽ� 
	public void getArrribute(Aircon aircon) {
		
	}
}
