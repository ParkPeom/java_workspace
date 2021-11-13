package com.codechobo.api;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatTest {

	public FormatTest() {
		//��¥�����͸� ��½� ���ϴ� �������� ������� �Ҷ� ����ϴ� Ŭ����
	
		Calendar now = Calendar.getInstance();
		// 2020-3-10(ȭ) 17:30:41(����)
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss(a)");
		
		String dataStr = fmt.format(now.getTime());
		System.out.println(dataStr);
		
		//////////////////////////////////////////////////////
		//    1236485 --> 1,236,485��
		//������ ȭ������� format�� �����Ͽ� ���ڿ��� ���Ѵ�.
		int money = 1236485;
		double moneyDbl = 51378656.45;
		DecimalFormat df = new DecimalFormat("#,###.#��");
		String won = df.format(moneyDbl);
		System.out.println("decimalFormat-->"+ won);
		
		try {
			// ����ȭ�� ���ڸ� -> ���������� ��ȯ�ϱ�
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
