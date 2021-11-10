package com.codechobo.collection.exam;
//사용자 정의 예외 클래스 생성.
// Exception을 상속받아 만들어야 함.

public class MyException extends Exception{

	public MyException() {
			//예외 메세지 설정
			//상위 클래스의 Exceoption(String)으로 되어 있는 생성자메소드를
			//호출하면 Exception  클래스 내에 예외 메시지를 저장한다.
			super("월은 1~12월 사이여야 합니다.");
		
		    // 상위 클래스의 Exception(String)으로 되어 있는 생성자메소드를
	        // 호출하면 Exception 클래스내에 예외 메시지를 저장한다.
	
	}
	public MyException(String msg) {
		super(msg);
	}
}
