package com.codechobo.calendar.yundal;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {
	Scanner scan = new Scanner(System.in);
	public CalendarEx() {}
	public void dateStart() {
		while(true) {
			try {
				//�⵵��  ���Է�
				//�⵵�� �����Է½� NumberFormatException �߻��Ѵ�.
				int yearInput = Integer.valueOf(getConsoleInput("�⵵"));
				int monthInput = Integer.parseInt(getConsoleInput("��"));
				
				//���� 1~12�� �ƴϸ� �ٽ��Է¹޾� �Ѵ�.
				if(!(monthInput>=1 && monthInput<=12)) {
					throw new MyException("���� 1��~12�� ������ ���̿��� �մϴ�.");
				}
				//head���
				titleOutput(yearInput, monthInput);
				
				//�Է¹��� ����� 1���� ������������ ���Ѵ�.
				Calendar date = Calendar.getInstance();//���ó�¥
				//��¥ ����
				date.set(yearInput, monthInput-1, 1);
				//���ϱ��ϱ� -> ������ ���� �����Ѵ�.
				int week1Day = date.get(Calendar.DAY_OF_WEEK);
				//��������ϱ�
				spaceOutput(week1Day);
				
				//�Է¹��� ����� ������ ���� ���ΰ�?
				int lastDay = getLastDay(yearInput, monthInput);
							
				//��¥���
				dayOutput(lastDay, week1Day-1);
				
			}catch(NumberFormatException e) {
				System.out.println("�⵵�� ���� ���ڸ� �Է��Ͽ��� �մϴ�.");
			}catch(MyException me) {
				System.out.println(me.getMessage());
			}
		}		
	}
	//��¥ ����ϱ�
	public void dayOutput(int lastDay, int space) {
		for(int day=1; day<=lastDay; day++) {
			System.out.print(day+"\t");
			//������µ� ��¥�� ������ ���� ���Ͽ� 7�� ������� Ȯ���ϰ� �ٹٲ�ó���� �Ѵ�.
			if((day+space)%7==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	//�������� ���ϱ�
	public int getLastDay(int year, int month) {
 		//1��, 3��, 5��, 7��, 8��, 10��, 12��  -31
		//4��, 6��, 9��, 11�� -30
		//2�� - 28, 29
		
		int lastDay = 31;
		switch(month) {
		case 4:		case 6:		case 9:		case 11: lastDay = 30;break;
		case 2:
			// �⵵�� 4��������� 100���� ���������� �ʴ� �ش� ����  - 29
			// �⵵�� 400����� �ش� ������ ���� - 29
			if( year%400==0 || year%4==0 && year%100!=0 ) {//����
				lastDay = 29;
			}else {//���
				lastDay = 28;
			}
		}		
		return lastDay;
	}
	//�������
	public void spaceOutput(int week) {
		for(int i=1; i<week; i++) {
			System.out.print("\t");
		}
	}
	//�޷��� Ÿ��Ʋ ����ϴ� �޼ҵ�
	public void titleOutput(int year, int month) {
		System.out.printf("\t\t%d�� %d��\n", year, month);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
	}
	//�ֿܼ��� ������ ���� �Է¹޴� �޼ҵ�
	public String getConsoleInput(String title) {
		System.out.print(title+"�Է�->");
		return scan.nextLine();
	}
	public static void main(String[] args) {		
		CalendarEx ex = new CalendarEx();
		ex.dateStart();
	}
}
