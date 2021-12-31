package com.codechobo.calendar;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarPrint {
	int year, month;
	Calendar now =Calendar.getInstance();
	int maxday, startWeek;
	Scanner scan = new Scanner(System.in);
	public CalendarPrint() {
		// TODO Auto-generated constructor stub
	}
	
	public CalendarPrint(int year, int month) {
		this.year=year;
		this.month=month;
	}
	
	public int input(String msg) {
	//입력
	
	System.out.print(msg+=" = ");
	return scan.nextInt();
	}
	
	public void output() {
	
	year = input("년도");
	month = input("월");
	
	//사용자 지정요일 값을 입력함
	now.set(year, month-1,1);
	//입력받은 달의 마지막 일 수 계산(30일, 31일 등)
	this.maxday = now.getActualMaximum(now.DAY_OF_MONTH);
	//1이면 일요일, 2이면 월요일 ...순으로 입력 월의 시작 요일값 저장
	this.startWeek = now.get(Calendar.DAY_OF_WEEK);
	
	now.set(Calendar.MONTH , month);//
	now.set(Calendar.YEAR , year);//
	
	System.out.println("\t\t"+year+"년 "+month+"월");
	System.out.println("일\t월\t화\t수\t목\t금\t토");
	
	for(int i=1; i<startWeek; i++) {
		System.out.print("\t");
	}
	
	for(int i=1; i<=maxday ; i++) {
		System.out.printf("%2d\t",i);
		if (startWeek % 7 ==0) {
			System.out.println();
		}
		startWeek++;
	}
	
	if(startWeek>7) {
		System.out.printf("\t");
		System.out.println("");
	}
	

	}
	
	
	//main
	public static void main(String[] args) {
		CalendarPrint cp = new CalendarPrint();
		cp.output();
	
		
	}

}
