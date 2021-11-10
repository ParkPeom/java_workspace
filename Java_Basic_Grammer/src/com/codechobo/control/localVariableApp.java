package com.codechobo.control;

// 지역변수 (Local Variable) : 메서드 또는 제어문 등의 블럭 내부에서 선언된 변수 
// => 지역변수가 선언된 블럭 내부에서만 사용 가능 
// => 지역변수가 선언된 블럭이 종료되면 지역변수는 자동 소멸 된다.(메모리상에 없는것)
// 
public class localVariableApp {
	
	
	
	public static void main(String[] args) {
		
		int num1 = 100; 
		
		// 임의 블럭 , 지역변수는 블록이 끝나면 소멸된다. 
		{ 
			int num2 = 200; // 블록이 끝나면 소멸됨 
			
			System.out.println("=======임의블럭 내부======");
			System.out.println("num2 = " + num1);
			System.out.println("num1 = " + num2);
		}
		int num2 = 200;
		System.out.println("=======임의블럭 외부=======");
		System.out.println("num1 = " + num1);
		
		// 임의블록 종료시 num2 변수가 소멸되므로 사용 불가능
		// System.out.println("num2 = " + num2);
	}
}



