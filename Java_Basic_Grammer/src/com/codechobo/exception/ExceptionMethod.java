package com.codechobo.exception;

public class ExceptionMethod  {
	
	public ExceptionMethod() {

	}
	public void method1() throws ArithmeticException , ArrayIndexOutOfBoundsException , NumberFormatException {
		int n1= 100 , n2 = 10;
		int result = n1 / n2;			
		System.out.println(n1+"/"+n2+"="+result);
		method2();
	}
	
	public void method2() throws ArrayIndexOutOfBoundsException , ArithmeticException{
		int[] data = {50,60,70};
		System.out.println("data-->"+data[data.length]);
						// data[3] -> ArrayIndexOutOfBoundsException
		method3();
	}
	public void method3() throws NumberFormatException {
		String str = "kor";
		int strInt = Integer.parseInt(str);
		System.out.println("str의 10배는 ->"+(strInt*10));
	}
	
	public static void main(String[] args) {
	try {
		ExceptionMethod em = new ExceptionMethod();
		em.method1(); // 마지막으로 호출한곳에서 catch문을 해줘야함 
	}catch(ArithmeticException e) {
		System.out.println(e.getMessage());
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("배열의 첨자값이 잘못되었습니다.---->"+e.getMessage());
	}catch(NumberFormatException e) {
		System.out.println("문자를 숫자로 바꾸려고 하셨습니다...");
	}
	
	} 
}