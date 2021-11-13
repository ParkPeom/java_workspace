package com.codechobo.api;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatTest {

	public FormatTest() {
		//날짜데이터를 출력시 원하는 패턴으로 만들고자 할때 사용하는 클랙스
	
		Calendar now = Calendar.getInstance();
		// 2020-3-10(화) 17:30:41(오전)
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss(a)");
		
		String dataStr = fmt.format(now.getTime());
		System.out.println(dataStr);
		
		//////////////////////////////////////////////////////
		//    1236485 --> 1,236,485원
		//정수를 화폐단위로 format을 생성하여 문자열을 구한다.
		int money = 1236485;
		double moneyDbl = 51378656.45;
		DecimalFormat df = new DecimalFormat("#,###.#원");
		String won = df.format(moneyDbl);
		System.out.println("decimalFormat-->"+ won);
		
		try {
			// 패턴화된 문자를 -> 숫자형으로 변환하기
			NumberFormat nf = NumberFormat.getInstance();
			Number parseData = nf.parse(won);
			double wonDbl = parseData.doubleValue();
			System.out.println(wonDbl*0.1);
		}catch(ParseException pe) {
			System.out.println(pe.getMessage());
		}
	}

	public static void main(String[] args) {
		new FormatTest();
	}

}
