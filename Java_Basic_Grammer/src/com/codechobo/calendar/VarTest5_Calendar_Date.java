package com.codechobo.calendar;

import java.util.Calendar;

public class VarTest5_Calendar_Date {

	public VarTest5_Calendar_Date() {
	
	}
	public void start() {
		// Calendar는 추상클래스
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int week = cal.get(Calendar.WEEK_OF_MONTH);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		System.out.println(year);// 2021
		System.out.println(month + 1); // 11
		System.out.println(day); // 10
		System.out.println(dayOfWeek); // 수 
		System.out.println(week); // 월
		System.out.println(lastDay); // 마지막 날짜 
		
		String korDayOfweek = "";
		
		switch(dayOfWeek) { case 1: korDayOfweek = "일"; break; case 2: korDayOfweek =
		"월"; break; case 3: korDayOfweek = "화"; break; case 4: korDayOfweek = "수";
		break; case 5: korDayOfweek = "목"; break; case 6: korDayOfweek = "금"; break;
		case 7: korDayOfweek = "토"; }
		 
		System.out.println(korDayOfweek);
	}
	public static void main(String[] args) {
		new VarTest5_Calendar_Date().start();
	}
}
