package com.codechono.wrapperclass;

public class WrapperClass {
	public WrapperClass() {
		// TODO Auto-generated constructor stub
		// 정수 = Byte , Short , Integer , Long
		// 실수 = Float , Double
		// 문자 = Character 
		int num  = 130;
		// 이 변수가 메모리에 얼마나 차지하는지 모르고 값이 250이란것만 알수있다.
		Integer numObj = new Integer(num);
		// 객체가 만들어지긴 하는데 권장하지않는다
		Integer numObj2 = Integer.valueOf(num);
		// valueOf 메서드 이용
		Integer numObj3 = num; 
		// num 그냥 넣어도 된다 = 오토 박싱 = 기본 데이터 타입이 객체형으로 자동으로 전환되는 것
		
		// num = 250 , numObj = 5400 주소에 값 250 , numobj2 = 6500 주소에 값 250 , numobj3 = 7200 주소에 값 250
		// 바이트 크기 
		System.out.println("바이트 수->"+numObj3.BYTES);
		// 비트수
		System.out.println("비트 수->"+numObj3.SIZE);
		// 범위 최대값
		System.out.println("큰값->"+ numObj3.MAX_VALUE);
		// 타입
		System.out.println("데이터형->"+numObj3.TYPE);
		// byte 최대값 
		System.out.println("바이트 최대 크기->"+Byte.MAX_VALUE);
		System.out.println("바이트 최소 크기->"+Byte.MIN_VALUE);
		byte numByte = (byte)num;
		System.out.println("numByte="+numByte); // - 128 , - 127 , - 126 오버플로우
		
		// Integer클래스는 byte타입으로 변경하는 메서드 찾기
		byte numByte2 = numObj3.byteValue();
		System.out.println("numByte2="+numByte2);
		// Integer클래스 16진수로 구하기
		System.out.println("100을 16진수로="+Integer.toHexString(100));
		// 매개변수에 int를 적어야되는데 Integer 를 대입해도 들어감 = 오토 언박싱 됨 
		System.out.println(num+"을 16진수로="+Integer.toHexString(num));
		
		// 객체형이 기본데이터형으로 변환하여 대입함 = 오토언박싱
		int num4 = numObj3;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WrapperClass();
	}

}
