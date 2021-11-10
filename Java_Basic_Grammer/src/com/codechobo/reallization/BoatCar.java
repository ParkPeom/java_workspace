package com.codechobo.reallization;

// 인터페이스는 다른 인터페이스를 상속받아 작성 가능
// => extends 키워드를 사용하여 상속 처리
// => 인터페이스는 다중 상속이 가능 하다.

// 인터페이스 다중 상속 
public interface BoatCar extends Car , Boat {
	void floating();
}	
