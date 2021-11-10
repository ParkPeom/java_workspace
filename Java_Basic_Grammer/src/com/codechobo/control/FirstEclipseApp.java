package com.codechobo.control; // 패키지 명시해서 알려줘야함 

/*
설명을 잘해줌으로써 유지보수를 잘해줌
 -----범위주석----
프로그램 : 
버전:
개발자:

배포시 바이트코드 와 설명을 같이해주는 것이 좋다. 
 */

/**	API 주석 
 * 
 *  JVM에 의해 가장 먼저 호출되는 특별한 메서드 
 * 
 * @author 홍길동
 *어노테이션(Annotaion) : API 문서를 만들때 특별한 설명제공  
 *						ex) @Override 표시 
 * @since 17
 * @version 1.0
 * */
public class FirstEclipseApp { // public class 단하나 
	public static void main(String[] args)  {// 자동완성 기능
		//	public static void main(String[] args) { // main 빼고 키워드 main는 식별자
		//  ctrl + spacebar + enter 	
			
		System.out.println("이클립스를 이용해 만든 프로그램"); // 행주석 syso + ctrl + enter
		System.out.print("열심히 공부 합시다"); // 명령
		
		// 자동완성 기능
		// ctrl + s  저장하는 순간 -> 컴파일 
		// ctrl + F11 자동 저장 및 실행 
			
	}
}
