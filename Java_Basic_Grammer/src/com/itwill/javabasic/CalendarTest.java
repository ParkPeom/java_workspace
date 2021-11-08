package com.itwill.javabasic;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
	
	int year , month , week;
	public CalendarTest() {
	}
	public void start() {
		inputData();
		printCalendar();
	}
	public void inputData() {
		Scanner scan = new Scanner(System.in);
		System.out.print("년 입력 = ");
		year = scan.nextInt();
		System.out.print("달 입력 = ");
		month = scan.nextInt();
	}
	public void printCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//1 SundayStart (1 = Sunday, 2 = Monday, ..., 7 = Saturday)
		week = cal.get(cal.DAY_OF_WEEK);
		System.out.printf("\t\t %d년 %d월 \t\t\n" , year , month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		for(int i = 1; i < week; i++) {
			System.out.printf("\t");
		}
		for(int i = 1; i <= lastDay; i++) {
			System.out.print(i+"\t");
			if(week % 7 == 0) {
				System.out.println();
			}
			week++;
		}
	}
	public static void main(String[] args) {
		new CalendarTest().start();
	}
}
