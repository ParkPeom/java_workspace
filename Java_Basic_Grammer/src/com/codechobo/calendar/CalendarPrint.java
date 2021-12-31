package com.codechobo.calendar;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarPrint {
	int year, month;
	Calendar now =Calendar.getInstance();
	int maxday, startWeek;
	Scanner scan = new Scanner(System.in);
	public CalendarPrint() {
		// TODO Auto-generated constructor stub
	}
	
	public CalendarPrint(int year, int month) {
		this.year=year;
		this.month=month;
	}
	
	public int input(String msg) {
	//�Է�
	
	System.out.print(msg+=" = ");
	return scan.nextInt();
	}
	
	public void output() {
	
	year = input("�⵵");
	month = input("��");
	
	//����� �������� ���� �Է���
	now.set(year, month-1,1);
	//�Է¹��� ���� ������ �� �� ���(30��, 31�� ��)
	this.maxday = now.getActualMaximum(now.DAY_OF_MONTH);
	//1�̸� �Ͽ���, 2�̸� ������ ...������ �Է� ���� ���� ���ϰ� ����
	this.startWeek = now.get(Calendar.DAY_OF_WEEK);
	
	now.set(Calendar.MONTH , month);//
	now.set(Calendar.YEAR , year);//
	
	System.out.println("\t\t"+year+"�� "+month+"��");
	System.out.println("��\t��\tȭ\t��\t��\t��\t��");
	
	for(int i=1; i<startWeek; i++) {
		System.out.print("\t");
	}
	
	for(int i=1; i<=maxday ; i++) {
		System.out.printf("%2d\t",i);
		if (startWeek % 7 ==0) {
			System.out.println();
		}
		startWeek++;
	}
	
	if(startWeek>7) {
		System.out.printf("\t");
		System.out.println("");
	}
	

	}
	
	
	//main
	public static void main(String[] args) {
		CalendarPrint cp = new CalendarPrint();
		cp.output();
	
		
	}

}
