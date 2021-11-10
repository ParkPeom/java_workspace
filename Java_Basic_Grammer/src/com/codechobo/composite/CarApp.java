package com.codechobo.composite;

public class CarApp {
	
	public static void main(String[] args) {
		CarEngine engine = new CarEngine();
		Car carOne = new Car();
	
		carOne.carDisplay(); // 기본값이 출력됨
		carOne.setModelName("쏘렌토");
		carOne.setProductionYear(2018);

		engine.setFualType("경유");
		engine.setDisplacement(2000);
		
		// 자동차에 엔진 포함 - Setter 메서드를 호출하여 포함 관계 성립
		// 포함 관계를 성립되게 해줘야 한다.
		carOne.setCarEngine(engine);
		carOne.carDisplay();
		
		System.out.println("====================================");
		// 생성자를 이용한
		// 자동차 생성 - 엔진을 포함 - 생성자를 호출하여 포함 관계 성립 
		Car carTwo = new Car("싼타페",2021,new CarEngine("휘발유",3000));
		carTwo.carDisplay();
		
		System.out.println("====================================");
	
		System.out.println(carOne.getModelName() +"의 엔진 정보 >> ");
		engine.engineDisplay();
		
		System.out.println("====================================");
		System.out.println(carTwo.getModelName() +"의 엔진 정보 >> ");
		carTwo.getCarEngine().engineDisplay();
		// 싼타페는.. 참조변수로 저장하지 않아서.. 
		// return carEngine;  + carEngine.engineDisplay(); 를 호출시킴
	}
}
