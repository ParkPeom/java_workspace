package com.codechobo.control;

import java.util.InputMismatchException;
import java.util.Scanner; // import : Scanner 클래스 가져와서 씀 

/*
 사용자에게 키보드로 이름과 나이를 입력받아 출력하는 프로그램 작성
 */
public class ScannerApp {
	
	public static void main(String[] args) {
		
		// Scanner 클래스 : 입력장치(키보드 , 파일 등)로부터 값을 제공받기 위한 메서드가 선언된 클래스
		// Scanner 클래스로 객체를 생성하여 변수에 저장 
		
		// => 변수에 저장된 객체를 사용하여 메서드를 호출 한다. 
		// => 키보드로부터 값을 입력받기 위한 Scanner 객체 생성
		// System.in : 표준 키보드 입력 스트림 - 키보드로 입력된 값을 전달하는 객체 
		// System.out : 모니터에 값을 출력 스트림 ( 
		
		Scanner scanner = new Scanner(System.in); // 입력 
		System.out.print("이름 입력 >> ");
		
		//	scanner.nextLine() : 입력값을 문자열로 변환하여 반환하는 메서드
		// => 키보드로 입력받은 값을 문자열로 제공받아 변수에 저장	
		// => 키보드 입력값이 없는 경우 프로그램 흐름(스레드- Thread) 이 일시 중지
		// => 키보드로 값을 입력한 후 엔터를 입력하면 스레드가 실행된다.
		String name= scanner.nextLine();
		
		System.out.print("나이 입력 >> ");
		// => scanner.nextInt(); : 입력값을 정수값으로 변환하여 반환하는 메서드
		// => 키보드로 입력받은 값을 정수값으로 제공받아 변수에 저장
		// => 키보드 입력값이 정수값이 아닌 경우 예외(Exception) 발생 
		int age = 0;
		age = scanner.nextInt(); 			
		System.out.println("[결과] 이름 " + name + "님의 나이는 " + age + " 입니다.");
		
		// Scanner.close() : Scanner 객체의 스트림을 제공하는 메서드
		scanner.close();
		
		scanner.next();
		scanner.nextLine();
		
		// 프로그램 입력하라고 해놓고 다른 프로그램 실행하면 컴퓨터 속도가 느려진다. 

	}
}
