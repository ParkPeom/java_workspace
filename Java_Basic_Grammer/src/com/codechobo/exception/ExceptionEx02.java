package com.codechobo.exception;

import java.util.Scanner;

public class ExceptionEx02 {
	Scanner s = new Scanner(System.in);
	public ExceptionEx02() {

	}
	public void testStart() {
		try {
		int n1 = Integer.parseInt(s.nextLine()); // ���� �Է¹޾Ƽ� ������ ��ȯ
		int n2 = Integer.parseInt(s.nextLine()); // number Exception
		
		System.out.println(n1 + "+" + n2 +"="+n1+n2);
		System.out.println(n1 + "/" + n2 +"="+n1/n2); // Arth
		
		String[] names = {"ȫ�浿","��浿","�ڱ浿"};
		for(int i=0; i < names.length; i++) { // 0, 1, 2, 3
			System.out.println("names[" + i + "]=" + names[i]); // Array
		}
	} catch(NumberFormatException e) {
		System.out.println("���ڸ� �Է��ϼ���.");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		// ���ܰ� �߻��ϵ� ���ϵ� ������ ���� 
		System.out.println("finally ������ �����.");
	}
}
	public static void main(String[] args) {
		ExceptionEx02 ee = new ExceptionEx02();
		ee.testStart();
		
	}
}
