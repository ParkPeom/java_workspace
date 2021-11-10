package com.codechobo.exception;

import java.util.Scanner;

public class StandardWeight {
	
	int weight,height,age,gender,standardweight;
	double index;
	String bodytype;
	Scanner sc = new Scanner(System.in);
	
	public StandardWeight() {
		start();
		criteria();
		weightinx();
		weightindex(index);
		showInfo();
	}
	
	public void showInfo() {
		System.out.println("ǥ��ü�� = " + standardweight);
		System.out.println("����� ǥ��ü�������� " + index +"����"
				+ bodytype+"�Դϴ�.");
	}
	
	public void start() {
		age = confirm("���� ");
		gender = confirm("����(1:����,2:����) ");
		height = confirm("Ű ");
		weight = confirm("���� ü�� ");
	}
	
	public int confirm(String msg) {
		System.out.print(msg + "=");
		int data = sc.nextInt();
		return data;
	}
	
	// ǥ��ü�� ���� 
	public void criteria() {
		if(35 >= age) {
			if(gender == 1) { // ����
				standardweight = (int)((height - 100) * 0.90);
			} else if(gender == 2) { // ����
				standardweight = (int)((height - 100) * 0.85);
			}
		} else if(age >= 36) {
			if(gender == 1) { // ����
				standardweight = (int)((height - 100) * 0.95);
			} else if(gender == 2) { // ����
				standardweight = (int)((height - 100) * 0.90);
			}
		}
	}
	
	// ǥ��ü������ 
	public void weightinx() {
		index = ((double)weight / standardweight) * 100;
	}
	// ǥ��ü�� �� ����
	public void weightindex(double index) {
		if(index >= 126) {
			bodytype = " ������";
		} else if(116 <= index && index <= 125) {
			bodytype = " ���� ���� ";
		} else if(96 <= index &&  index <= 115) {
			bodytype = " ǥ���� ";
		}  else if(86 <= index && index <= 95) {
			bodytype = " ���ݸ�����";
		}  else {
			bodytype = " ����";
		}
	}
	public static void main(String[] args) {
		new StandardWeight();
	}
}
