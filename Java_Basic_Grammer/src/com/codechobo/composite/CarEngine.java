package com.codechobo.composite;

// 엔진정보(연료타입,배기량)를 저장하기 위한 클래스 
public class CarEngine { // ALT + SHIFT + R 클래스의 이름을 한꺼번에 바꾼다. 
	
	private String fualType;
	private int displacement;
	
	public CarEngine() {

	}
	
	public CarEngine(String fualType, int displacement) {
		super();
		this.fualType = fualType;
		this.displacement = displacement;
	}
	
	public String getFualType() {
		return fualType;
	}
	
	public void setFualType(String fualType) {
		this.fualType = fualType;
	}
	
	public int getDisplacement() {
		return displacement;
	}
	
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	// 출력 
	public void engineDisplay() {
		System.out.println("연료타입 = " + fualType);
		System.out.println("배기량 = " + displacement);
	}
}
