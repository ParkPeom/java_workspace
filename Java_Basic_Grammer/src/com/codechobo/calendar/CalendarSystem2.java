package com.codechobo.calendar;

import java.util.Calendar;

public class CalendarSystem2 {
	
	public CalendarSystem2() {}
	
	public CalendarSystem2(int year , int month) {
		start(year,month);
	}
	
	// DAY_OF_WEEK 1 ~ 7 요일을 가져온다. 일~토
	// DAY_OF_MONTH 월일을 가져온다. 
	// AM_PM 1 오전 0 오후
	// Calendar.WEEK_OF_MONTH  5일?
	// cal.getActualMinimum(이 일정관리의 시간 값이 주어진 지정된 일정관리 필드의 최소값을 반환합니다.
	// getActualMaximum 이 일정관리의 시간 값이 주어진 지정된 일정관리 필드의 최대값을 반환합니다.
	
	public void start(int year , int month) { // 내가 입력한게 들어옴
		Calendar now = Calendar.getInstance();
		now.set(now.YEAR, year);
		now.set(now.MONTH, month - 1); // 1월이 0부터 시작해서 -1 
		now.set(now.DAY_OF_MONTH , 1); // DAY_OF_MONTH를 1로 설정 (월의 첫날)
		int firstDay = now.getActualMinimum(now.DAY_OF_MONTH); //이번달 시작 날
		int lastDay = now.getActualMaximum(now.DAY_OF_MONTH); // 이번달의 마지막 날 
		int week = now.get(now.DAY_OF_WEEK); // 그 주의 반환 일요일=1 월요일=2
//		System.out.println(firstDay + " " + lastDay + " " + week );
		for(int i = 1; i < week; i++) { // 공백 
			System.out.printf("\t"," ");		
		}
		for(int i = 1; i <= lastDay; i++) { // 출력 
			System.out.printf("%d\t", i);
			if(week % 7 == 0) {
				System.out.println();
			}
			week++;
		}
	}
}
