package com.codechobo.composite;

// 자동차 정보(모델명,생산년도,엔진)를 저장하기 위한 클래스

public class Car {

	private String ModelName;
	private int productionYear;
	
	// 포함(직접연관)관계 - directAssociation
	private CarEngine carEngine; // 엔진 정보를 저장하기 위한 참조필드
							  // 엔진 인스턴스를 저장함 
	
	// => 포함관계가 성립되기 위해서는 생성자 또는 Setter 메서드를 이용하여 필드에 인스턴스 저장
	public Car() {
		carEngine = new CarEngine();
	
	}
	public Car(String modelName, int productionYear, CarEngine carEngine) {
		super();
		ModelName = modelName;
		this.productionYear = productionYear;
		this.carEngine = carEngine;
	}
	public String getModelName() {
		return ModelName;
	}
	public void setModelName(String modelName) {
		ModelName = modelName;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	
	//-------------------중 요----------------------
	public CarEngine getCarEngine() {
		return carEngine;
	}
	public void setCarEngine(CarEngine carEngine) {
		this.carEngine = carEngine;
	}

	// Car 클래스에서 Engine 클래스의 참조변수를 통해 getter/setter를 가져와서 쓸수있다.
	// => 참조필드에 인스턴스가 저장되어있지 않은 상태에서 메서드를 호출할 경우 NullPointerException 이 발생한다.
	// NullPointerException : 참조변수에 Null이 저장된 상태에서 메서드를 호출할 경우 발생되는 예외다.
	public void carDisplay() {
		System.out.println("모델명 = " + ModelName );
		System.out.println("생산년도 = " + productionYear );
		System.out.println("연료 타입 = " + 
						carEngine.getDisplacement() +"\n"
				+ "배기량 = " +  carEngine.getFualType());
	}
	
}
