package com.codechobo.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest2 {	
	
	public CalendarTest2() {
		input();
	}
	
	public void input() {
		int year = setMessage("년 입력 >");
		int month = setMessage("달 입력 > ");
		Calendar now= Start(year,month);
		print(now);
	}
	
	public int setMessage(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + "=");
		String num = sc.nextLine();
		int num2 = Integer.parseInt(num);
		return num2;
	}
	
	public Calendar Start(int year,int month) {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, month-1); // 0 , 1 , 2 , 3 , 4 , 5 , 6 
		now.set(now.DAY_OF_MONTH,1);  // 시작 달의 일을 1로 설정   
		return now;
	}	
	
	public void print(Calendar now) {
		System.out.printf("\t\t%d년%d월\t\t\n",now.get(now.YEAR),now.get(now.MONTH)+1);
		System.out.print("일\t월\t화\t수\t목\t금\t토\n");
		outOfCalendar(now);
	}
	
	public void outOfCalendar(Calendar now) {
		int week = now.get(now.DAY_OF_WEEK); // 1 일 요일 
		int lastday = now.getActualMaximum(now.DAY_OF_MONTH); // 그달의 마지막 일수 
			
		for(int i=1; i<week; i++) {
			System.out.printf("\t");
		}
		for(int i=1; i<=lastday; i++) {
			System.out.printf("%d\t",i);
			if(week % 7 == 0) {
				System.out.println();
			}
			week++;
		}
	}
	public static void main(String[] args) {
		new CalendarTest2();
	}
}
