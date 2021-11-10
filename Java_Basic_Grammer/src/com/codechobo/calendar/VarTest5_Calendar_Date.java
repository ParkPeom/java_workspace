package com.codechobo.calendar;

import java.util.Calendar;

public class VarTest5_Calendar_Date {

	public VarTest5_Calendar_Date() {
	
	}
	public void start() {
		// Calendar�� �߻�Ŭ����
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
		System.out.println(dayOfWeek); // �� 
		System.out.println(week); // ��
		System.out.println(lastDay); // ������ ��¥ 
		
		String korDayOfweek = "";
		
		switch(dayOfWeek) { case 1: korDayOfweek = "��"; break; case 2: korDayOfweek =
		"��"; break; case 3: korDayOfweek = "ȭ"; break; case 4: korDayOfweek = "��";
		break; case 5: korDayOfweek = "��"; break; case 6: korDayOfweek = "��"; break;
		case 7: korDayOfweek = "��"; }
		 
		System.out.println(korDayOfweek);
	}
	public static void main(String[] args) {
		new VarTest5_Calendar_Date().start();
	}
}
