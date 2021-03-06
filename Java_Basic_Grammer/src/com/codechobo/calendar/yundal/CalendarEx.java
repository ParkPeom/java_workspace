package com.codechobo.calendar.yundal;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {
	Scanner scan = new Scanner(System.in);
	public CalendarEx() {}
	public void dateStart() {
		while(true) {
			try {
				//년도와  월입력
				//년도를 문자입력시 NumberFormatException 발생한다.
				int yearInput = Integer.valueOf(getConsoleInput("년도"));
				int monthInput = Integer.parseInt(getConsoleInput("월"));
				
				//월이 1~12가 아니면 다시입력받아 한다.
				if(!(monthInput>=1 && monthInput<=12)) {
					throw new MyException("월은 1월~12월 사이의 값이여야 합니다.");
				}
				//head출력
				titleOutput(yearInput, monthInput);
				
				//입력받은 년월의 1일이 무슨요일인지 구한다.
				Calendar date = Calendar.getInstance();//오늘날짜
				//날짜 변경
				date.set(yearInput, monthInput-1, 1);
				//요일구하기 -> 공백의 수를 결정한다.
				int week1Day = date.get(Calendar.DAY_OF_WEEK);
				//공백출력하기
				spaceOutput(week1Day);
				
				//입력받은 년월의 마지막 날이 얼마인가?
				int lastDay = getLastDay(yearInput, monthInput);
							
				//날짜출력
				dayOutput(lastDay, week1Day-1);
				
			}catch(NumberFormatException e) {
				System.out.println("년도와 월은 숫자를 입력하여야 합니다.");
			}catch(MyException me) {
				System.out.println(me.getMessage());
			}
		}		
	}
	//날짜 출력하기
	public void dayOutput(int lastDay, int space) {
		for(int day=1; day<=lastDay; day++) {
			System.out.print(day+"\t");
			//현재출력된 날짜와 공백의 수를 더하여 7의 배수인지 확인하고 줄바꿈처리를 한다.
			if((day+space)%7==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	//마지막날 구하기
	public int getLastDay(int year, int month) {
 		//1월, 3월, 5월, 7월, 8월, 10월, 12월  -31
		//4월, 6월, 9월, 11월 -30
		//2월 - 28, 29
		
		int lastDay = 31;
		switch(month) {
		case 4:		case 6:		case 9:		case 11: lastDay = 30;break;
		case 2:
			// 년도가 4배수이지만 100으로 나누어지지 않는 해는 윤년  - 29
			// 년도가 400배수인 해는 무조건 윤년 - 29
			if( year%400==0 || year%4==0 && year%100!=0 ) {//윤년
				lastDay = 29;
			}else {//평년
				lastDay = 28;
			}
		}		
		return lastDay;
	}
	//공백출력
	public void spaceOutput(int week) {
		for(int i=1; i<week; i++) {
			System.out.print("\t");
		}
	}
	//달력의 타이틀 출력하는 메소드
	public void titleOutput(int year, int month) {
		System.out.printf("\t\t%d년 %d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
	}
	//콘솔에서 연도와 월을 입력받는 메소드
	public String getConsoleInput(String title) {
		System.out.print(title+"입력->");
		return scan.nextLine();
	}
	public static void main(String[] args) {		
		CalendarEx ex = new CalendarEx();
		ex.dateStart();
	}
}
