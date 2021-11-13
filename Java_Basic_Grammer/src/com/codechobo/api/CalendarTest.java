package com.codechobo.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

	public CalendarTest() {
		
	}
	public void start() {
		//날짜, 시간에 관련된 현재 시스템의 모든 정보를 객체로 구해주는 클래스
		// 생성자메소드가 protected이기 때문에 new 키워드로 객체 생성할수 없다.
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		//////////////////////////////////////////
		// Calendar객체의 날짜 정보 변경하기
		//년/월/일
		now.set(2022, 4, 10);//  2022, 5, 10
		now.set(2020, 9, 10, 17, 30);//  2020,10, 10
		// 년월일시분초중 1개의 정보만 변경할때 사용
		now.set(Calendar.MONTH, 2);//월을 3월로 변경
		//////////////////////////////////////////
		// 2001-11-04(목) 11:02:33
		//  1:YEAR  , 2:MONTH
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;//0->1월, 1->2월,.....
		int day = now.get(Calendar.DAY_OF_MONTH);//일
		int week = now.get(Calendar.DAY_OF_WEEK);//요일 1->일, 2->월, 3->화,.... 7->토
		
		String weekName = "";
		switch(week) {
		case 1:weekName = "일"; break;
		case 2:weekName = "월"; break;
		case 3:weekName = "화"; break;
		case 4:weekName = "수"; break;
		case 5:weekName = "목"; break;
		case 6:weekName = "금"; break;
		case 7:weekName = "토"; 
		}
		
		//int hour = now.get(Calendar.HOUR);//12시간
		int hour = now.get(Calendar.HOUR_OF_DAY);//24시간
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.printf("%d-%d-%d(%s) %d:%d:%d", 
				year, month, day,weekName, hour, minute, second);
		
		// 2021/11/4(목) 0:38:50(오후)
		int amPm = now.get(Calendar.AM_PM);// 오전/오후  0:오전, 1:오후
		String amPmTxt = (amPm==0)? "오전":"오후";
		int hour12 = now.get(Calendar.HOUR);
		System.out.printf("\n%d/%d/%d(%s) %d:%d:%d(%s)\n",
				year, month, day, weekName, hour12, minute, second, amPmTxt);
	
		System.out.println("올해 몇주 ->"+ now.get(Calendar.WEEK_OF_YEAR));//올해 몇주째인지
		System.out.println("올해 몇일 ->"+ now.get(Calendar.DAY_OF_YEAR));//올해 몇일째인지
	
		//년월일 시분초의 +, -
		//2020/3/10(화) 5:30:41(오후)
		// 1000후는 언제인가?
		//now.add(Calendar.DATE , 1000);//1000후
		//now.add(Calendar.DATE , -1000);//1000전
		now.add(Calendar.HOUR, -120);// 120시간 전
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss(a)");
		String date = df.format(now.getTime());
		System.out.println(date);
	}
	public static void main(String[] args) {
		new CalendarTest().start();
	}

}
