package com.codechobo.io.exam;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {

	public CalendarTest() {
	
	}
	public void start() {
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		System.out.print("년 입력 > ");
		int year = sc.nextInt();
		
		System.out.print("달 입력 > ");
		int month = sc.nextInt();
		sc.nextLine();
		
	}
	public static void main(String[] args) {
		new CalendarTest().start();
	
	}
}
