package com.codechobo.calendar;

import java.util.Calendar;

public class Ex10_2 {
	Calendar date1 = Calendar.getInstance(); // 현재 시간 객체 생성 인스턴스 반환
	Calendar date2 = Calendar.getInstance();
	final String[] DAY_OF_WEEK = {" ","일","월","화","수","목"
			,"금","토"};
	
	public Ex10_2() {
		input();
		differenceMethod();
	}
	
	public void input() {
		date1.set(2021, 10, 6);
		date2.set(2021, 10, 7);
		System.out.println("date1은" + toString(date1) +" "
		+ DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일 입니다.");
	}
	
	public String toString(Calendar date1) {
		return date1.get(Calendar.YEAR) + "년" + (date1.get(Calendar.MONTH) + 1)
				+ "월" + date1.get(Calendar.DAY_OF_MONTH);
	}
	
	public void differenceMethod() {
		// getTimeInMillis() 1000분의 1초단위로 변환해서 줌 
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000; // 1000단위 1000ms / 1000  s초
		System.out.println("그 날(date1 부터 지금(date2) 까지 "
				+ difference+"초가 지났습니다.");
		System.out.println("일(day)로 계산하면" + difference/(24*60*60)+"일 입니다."); // 1일 = 24 * 60 * 60 // 하루 24시간 x 60분 x 60초
								
	}
	
	public static void main(String[] args) {
		new Ex10_2();
	}
}
