package com.codechobo.calendar;

import java.util.Calendar;

public class Ex10_3 {
	
	public static void main(String[] args) {
		
		final int[] TIME_UNIT = {3600, 60, 1}; // 큰 단위를 앞에 놓는다.
		final String[] TIME_UNIT_NAME = {"시간","분","초"};
		
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		time1.set(Calendar.HOUR_OF_DAY, 10); // time1을 10시 20분 30초로 설정
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);

		time2.set(Calendar.HOUR_OF_DAY, 20); // time2을 20시 30분 10초로 설정
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "시"
				+time1.get(Calendar.MINUTE)+"분"+time1.get(Calendar.SECOND) + "초");
		
		System.out.println("time2 : " + time2.get(Calendar.HOUR_OF_DAY) + "시"
				+time2.get(Calendar.MINUTE)+"분"+time2.get(Calendar.SECOND) + "초");
		
		
		//  time2을 20시 30분 10초 -> ms 로 바꿔서 ms - ms = ms / 1000 = s 
		// 절대값 Math.abs  time1이 더크면 음수 
		long difference = 
			Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
			System.out.println("time1과 time2의 차이는 " + difference +"초 입니다.");
			String tmp = "";
			

			// 시간 , 분 , 초로 나눔 - 동전 개수 구하기랑 비슷  시간 구하고 남은거로 분 분 구하고 남은거로 초 
			for(int i = 0 ; i < TIME_UNIT.length; i++) {
				
				tmp += difference / TIME_UNIT[i] + TIME_UNIT_NAME[i]; // 36580 / 3600 + "시간"
				difference %= TIME_UNIT[i]; // difference = difference % TIME_UNIT[i] 36580 % 3600 
			}
			System.out.println("시분초로 변환하면 " + tmp + "입니다.");
	}
}
