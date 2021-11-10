package com.codechobo.control;

public class OperatorExample {
		
	public static void main(String[] args) {
			
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		
		// 내가 풀기
		
		int cho = 245678;
		
		int day = cho / (60 * 60 * 24);
		cho %= (60 * 60 * 24);
		
		int hour = cho / (60 * 60);
		cho %= (60 * 60);
		
		int min = cho / 60;
		cho %= 60;
		
		int sec = cho;	
		System.out.println(day + "일" + hour + "시" + min +"분" + sec +"초");
		
//		int cho = 245678;
//		System.out.print(" 초 = " + cho);
//		
//	
//		int day = cho / (24 * 60 * 60); // 245678 / 86400 
//		System.out.println("\n" + day + "일");
//		
//		cho %= 86400; // 나눈 나머지값을 저장함 
//		System.out.println(" 초 = " + cho);
//		
//		int hour = cho / (60 * 60); // 60 * 60 = 3600
//		cho %= 3600;
//		
//		int min = cho / 60;
//		int sec = cho % 60;
		
//		System.out.println(day +"일" + hour + "시" + min + "분" + sec + "초");

		System.out.println("===============================================");
		
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 
		//출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		
		int AirplanPrice = 150_000_000;
		int AirplanOrder = 20;
		long price = 0; 
		
		System.out.println((long)(AirplanPrice * 0.25)); // 한대당 할인가격 
		
		price = AirplanOrder >= 15 ? AirplanPrice * 14 + ((AirplanOrder - 14) * (long)(AirplanPrice * 0.75)) : AirplanPrice * AirplanOrder;
		//                            14대까지는 정가에 + 15대부터 1대씩 25할인 
		
		System.out.println("구입한 비행기 수는 : " + AirplanOrder + " 총 가격은 : " + price);
		

		//	한대당- 37,500,000	
		//	15대 22억5천만원
		//	562,500,000원 5억6천   ,  	
		// 14대  2,100,000,000   15대 187,500,000 
		
		
		System.out.println("===============================================");
	}
}
