package com.codechobo.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

	public CalendarTest() {
		
	}
	public void start() {
		//��¥, �ð��� ���õ� ���� �ý����� ��� ������ ��ü�� �����ִ� Ŭ����
		// �����ڸ޼ҵ尡 protected�̱� ������ new Ű����� ��ü �����Ҽ� ����.
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		//////////////////////////////////////////
		// Calendar��ü�� ��¥ ���� �����ϱ�
		//��/��/��
		now.set(2022, 4, 10);//  2022, 5, 10
		now.set(2020, 9, 10, 17, 30);//  2020,10, 10
		// ����Ͻú����� 1���� ������ �����Ҷ� ���
		now.set(Calendar.MONTH, 2);//���� 3���� ����
		//////////////////////////////////////////
		// 2001-11-04(��) 11:02:33
		//  1:YEAR  , 2:MONTH
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;//0->1��, 1->2��,.....
		int day = now.get(Calendar.DAY_OF_MONTH);//��
		int week = now.get(Calendar.DAY_OF_WEEK);//���� 1->��, 2->��, 3->ȭ,.... 7->��
		
		String weekName = "";
		switch(week) {
		case 1:weekName = "��"; break;
		case 2:weekName = "��"; break;
		case 3:weekName = "ȭ"; break;
		case 4:weekName = "��"; break;
		case 5:weekName = "��"; break;
		case 6:weekName = "��"; break;
		case 7:weekName = "��"; 
		}
		
		//int hour = now.get(Calendar.HOUR);//12�ð�
		int hour = now.get(Calendar.HOUR_OF_DAY);//24�ð�
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.printf("%d-%d-%d(%s) %d:%d:%d", 
				year, month, day,weekName, hour, minute, second);
		
		// 2021/11/4(��) 0:38:50(����)
		int amPm = now.get(Calendar.AM_PM);// ����/����  0:����, 1:����
		String amPmTxt = (amPm==0)? "����":"����";
		int hour12 = now.get(Calendar.HOUR);
		System.out.printf("\n%d/%d/%d(%s) %d:%d:%d(%s)\n",
				year, month, day, weekName, hour12, minute, second, amPmTxt);
	
		System.out.println("���� ���� ->"+ now.get(Calendar.WEEK_OF_YEAR));//���� ����°����
		System.out.println("���� ���� ->"+ now.get(Calendar.DAY_OF_YEAR));//���� ����°����
	
		//����� �ú����� +, -
		//2020/3/10(ȭ) 5:30:41(����)
		// 1000�Ĵ� �����ΰ�?
		//now.add(Calendar.DATE , 1000);//1000��
		//now.add(Calendar.DATE , -1000);//1000��
		now.add(Calendar.HOUR, -120);// 120�ð� ��
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss(a)");
		String date = df.format(now.getTime());
		System.out.println(date);
	}
	public static void main(String[] args) {
		new CalendarTest().start();
	}

}
