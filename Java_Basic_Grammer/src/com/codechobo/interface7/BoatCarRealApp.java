package com.codechobo.interface7;

public class BoatCarRealApp {
	
	public static void main(String[] args) {
		
//	BoatCarReal boatCar = new BoatCarReal();
	BoatCar boatCar = new BoatCarReal();
		
	// 인터페이스로 생성된 참조변수로 메서드를 호출하면 묵시적 객체 형변환에 의해
	// 자식 인스턴스의 메서드가 호출된다.
	boatCar.run();
	boatCar.navigate();
	boatCar.floating();
	}
}
