package com.codechobo.calendar;

import java.util.Calendar;

public class Ex10_2 {
	Calendar date1 = Calendar.getInstance(); // ���� �ð� ��ü ���� �ν��Ͻ� ��ȯ
	Calendar date2 = Calendar.getInstance();
	final String[] DAY_OF_WEEK = {" ","��","��","ȭ","��","��"
			,"��","��"};
	
	public Ex10_2() {
		input();
		differenceMethod();
	}
	
	public void input() {
		date1.set(2021, 10, 6);
		date2.set(2021, 10, 7);
		System.out.println("date1��" + toString(date1) +" "
		+ DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "���� �Դϴ�.");
	}
	
	public String toString(Calendar date1) {
		return date1.get(Calendar.YEAR) + "��" + (date1.get(Calendar.MONTH) + 1)
				+ "��" + date1.get(Calendar.DAY_OF_MONTH);
	}
	
	public void differenceMethod() {
		// getTimeInMillis() 1000���� 1�ʴ����� ��ȯ�ؼ� �� 
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000; // 1000���� 1000ms / 1000  s��
		System.out.println("�� ��(date1 ���� ����(date2) ���� "
				+ difference+"�ʰ� �������ϴ�.");
		System.out.println("��(day)�� ����ϸ�" + difference/(24*60*60)+"�� �Դϴ�."); // 1�� = 24 * 60 * 60 // �Ϸ� 24�ð� x 60�� x 60��
								
	}
	
	public static void main(String[] args) {
		new Ex10_2();
	}
}
