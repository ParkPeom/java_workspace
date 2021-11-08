package com.codechobo.calendar;

import java.util.Calendar;
/*
 * MONTH
 �� -  2 3 4 5 6 
 ���� - 1 2 3 4 5
 */
public class Ex10_1 {

	public Ex10_1() {
	}
	
	public void exam() {
		// �⺻������ ���� ��¥�� �ð����� �����ȴ�.
		Calendar today = Calendar.getInstance();
		today.set(2021, 10 , 6); // 11�� 
		System.out.println("�� ���� �⵵ :" + today.get(Calendar.YEAR));
		System.out.println("��(0~11), 0 : 1�� : " + (today.get(Calendar.MONTH)+1)); // 10 + 1 
		System.out.println("�� ���� �� ° �� : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("�� ���� �� ° �� : " + today.get(Calendar.WEEK_OF_MONTH));
		
		// DATE �� DAY_OF_MONTH ����
		System.out.println("�� ���� �� ��:" + today.get(Calendar.DATE));
		System.out.println("�� ���� �� ��:" + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("�� ���� �� ��:" + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("����(1 ~ 7 , 1 : �Ͽ���)  " +
		today.get(Calendar.DAY_OF_WEEK)); // 1:�Ͽ���,2:������,3:ȭ����,4:������,5:�����
										  // 6:�ݿ��� 7:�����
		System.out.println("�� ���� �� ��° ����: "
				+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("����_����(0:����, 1:����): "
				+ today.get(Calendar.AM_PM));
		System.out.println("�ð�(0~11) : " + today.get(Calendar.HOUR) + "��"); 
		System.out.println("��(0~23) : " + today.get(Calendar.MINUTE) + "��");
		System.out.println("��(0~59) : " + today.get(Calendar.SECOND) + "��");
		System.out.println("1000���� 1��(0~9999):"
				+ today.get(Calendar.MILLISECOND));
		// ������ 1�ʸ� �ð����� ǥ���ϱ� ���� 3600000���� ��������.(1�ð� = 60 * 60��)
		System.out.println("TimeZone(-12~+12) : "
				+ (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
		System.out.println("�� ���� ������ ��: "
				+ today.getActualMaximum(Calendar.DATE));
	}
	public static void main(String[] args) {
		new Ex10_1().exam();
		
	}

}
