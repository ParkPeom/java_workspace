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
		System.out.println("str�� 10��� ->"+(strInt*10));
	}
	
	public static void main(String[] args) {
	try {
		ExceptionMethod em = new ExceptionMethod();
		em.method1(); // ���������� ȣ���Ѱ����� catch���� ������� 
	}catch(ArithmeticException e) {
		System.out.println(e.getMessage());
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("�迭�� ÷�ڰ��� �߸��Ǿ����ϴ�.---->"+e.getMessage());
	}catch(NumberFormatException e) {
		System.out.println("���ڸ� ���ڷ� �ٲٷ��� �ϼ̽��ϴ�...");
	}
	
	} 
}