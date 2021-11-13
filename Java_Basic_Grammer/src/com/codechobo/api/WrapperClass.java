package com.codechobo.api;

public class WrapperClass {

	public WrapperClass() {
		// Wrapper 클래스는 기본데이터형을 객체형으로 변환하는 클래스들을 말한다.
		// 정수 : Byte, Short, Integer, Long
		// 실수 : Float, Double
		// 논리 : Boolean
		// 문자 : Character
		
		int num = 130;
		Integer numObj = new Integer(num);
		Integer numObj2 = Integer.valueOf(num);
		Integer numObj3 = num; // autoboxing: 기본데이터형이 객체형으로 자동으로 전환되는 것 
		System.out.println("바이트수->"+ numObj3.BYTES);//바이트크기
		System.out.println("비트수->"+ numObj3.SIZE);//비트수
		System.out.println("큰값->"+ numObj3.MAX_VALUE);
		System.out.println("데이터형->"+ numObj3.TYPE);
		
		System.out.println(Byte.MAX_VALUE);
		byte numByte =(byte)num; //  -128~127
		System.out.println("numByte="+numByte);
		
		//Integer클래스는 byte타입으로 변경하는 메소드 찾기
		byte numByte2 = numObj3.byteValue();
		System.out.println("numByte2="+numByte2);
		
		System.out.println("100을 16진수->"+ Integer.toHexString(100));
		System.out.println(num+"을 16진수->"+ Integer.toHexString(numObj3));
		
		int num4 = numObj3; // autounboxing:객체형이 기본데이터형으로 변환하여 대입된다.
	}

	public static void main(String[] args) {
		new WrapperClass();

	}

}
