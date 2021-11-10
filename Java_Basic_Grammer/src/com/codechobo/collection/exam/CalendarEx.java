package com.codechobo.collection.exam;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {

	Scanner scan = new Scanner(System.in);

	public CalendarEx() {
	}

	public void dateStart() {
		while(true) {
		
		try{
		//�⵵�� ���Է�
			//������ ���� �Է½� NumberFormatException �߻��Ѵ�.
			int yearInput = Integer.valueOf(getConsoleInput("�⵵"));//���� �߻� ���� 			//���ڷ� ���� >> Int ������ ��ȯ�ؾ��� (EX :   parseInt(String s) // valueOf(String s)) 
			int monthInput = Integer.valueOf(getConsoleInput("��"));
		//���� 1~12�� �ƴϸ� �ٽ� �Է¹޾ƾ� �Ѵ�.
			if(!(monthInput>=1 && monthInput<=12)) {
				throw new MyException("���� 1~12�� ���̿��� �մϴ�.");
			
			}
		//head ���
			titleOutput(yearInput,monthInput);
		
		//�Է¹��� ����� 1���� ���� �����ΰ�
		Calendar date = Calendar.getInstance();
		//��¥ ����
		date.set(yearInput, monthInput-1 , 1);
	
		//���� ���ϱ� - > ������ ���� �����Ѵ�.
		int week1Day = date.get(Calendar.DAY_OF_WEEK);
		//���� ����ϱ�
		spaceOutput(week1Day);
		//�Է¹��� ����� ������ ���� ���ΰ�?
		int lastDay = getLastDay(yearInput , monthInput);
		
		//head ���
		
		
		//����
		
		
		//��¥���
		dayOutput(lastDay,week1Day-1);
		}catch(NumberFormatException e ) {
			System.out.println("�⵵�� ���� ���ڸ� �Է��Ͽ��� �մϴ�.");
		}catch(MyException me) {
			System.out.println(me.getMessage());
		}
		break;
	}
	}
	//��¥ ����ϱ�
	public void dayOutput(int lastday,int space) {
		for(int day=1; day<=lastday; day++) {
			System.out.print(day+"\t");
			if((day+space)%7==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	//�������� ���ϱ�
	public int getLastDay(int year , int month) {
		//1��,3��,5��,7��,8�� 10��...12�� -- 31�ϱ���
		//2�� , 4��, 6�� ,9��  - 30�ϱ��� 
		//2�� - 28,29
		
		int lastDay = 31;
		switch(month){
		case 4: case 6: case 9: case 11: lastDay = 30; break;
		case 2: 
			//�⵵�� 4��������� 100���� ���������� �ʴ� ���� ����
			//�⵵�� 400����� �ش� ������ ���� -29
			
			if(year%400==0 || year%4==0 && year%100!=0) {//����
				lastDay = 29;
			}else {
				lastDay  = 28;
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
	public void titleOutput(int year , int month) {
	System.out.printf("\t\t%d�� %d��\n",year,month);
	System.out.println("��\t��\tȭ\t��\t��\t��\t��");
	}
	
	
	
	// �ֿܼ��� ������ ���� �Է¹޴� �޼ҵ�
	public String getConsoleInput(String title) {
		System.out.println(title + " �Է�- >");
		return scan.nextLine();
	}

	public static void main(String[] args) {
		CalendarEx ex = new CalendarEx();
		ex.dateStart();
	}

}