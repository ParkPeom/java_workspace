package com.codechobo.exception;

public class Ex8_7 {
	
	public static void main(String[] args) {
//		throw new Exception(); // 고의로 Exception 발생 try-catch 필수
		try {
			// RuntimeException과 그 자손은 예외처리를 해주지 않아도 컴파일이 된다.(선택)
			throw new RuntimeException(); // try-catch 선택 
		} catch(Exception e) {
		}
	}
}
