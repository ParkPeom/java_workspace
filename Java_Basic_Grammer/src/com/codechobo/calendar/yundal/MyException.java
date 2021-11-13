package com.codechobo.calendar.yundal;
//사용자의 정의 예외클래스 생성
// Exception을 상속받아 만들어야 한다.
public class MyException extends Exception{

	public MyException() {
		// 예외 메시지 설정
		// 상위클래스의 Exception(String)으로 되어 있는 생성자메소드를
		// 호출하면 Exception 클래스 내에 예외 메시지를 저장한다.
		super("입력값은 1~100사이여야 합니다.");
	}
	public MyException(String msg) {
		super(msg);
	}
}
