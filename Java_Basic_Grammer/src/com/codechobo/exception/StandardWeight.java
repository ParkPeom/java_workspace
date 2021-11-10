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
		System.out.println("표준체중 = " + standardweight);
		System.out.println("당신의 표준체중지수는 " + index +"으로"
				+ bodytype+"입니다.");
	}
	
	public void start() {
		age = confirm("나이 ");
		gender = confirm("성별(1:남성,2:여성) ");
		height = confirm("키 ");
		weight = confirm("현재 체중 ");
	}
	
	public int confirm(String msg) {
		System.out.print(msg + "=");
		int data = sc.nextInt();
		return data;
	}
	
	// 표준체중 기준 
	public void criteria() {
		if(35 >= age) {
			if(gender == 1) { // 남성
				standardweight = (int)((height - 100) * 0.90);
			} else if(gender == 2) { // 여성
				standardweight = (int)((height - 100) * 0.85);
			}
		} else if(age >= 36) {
			if(gender == 1) { // 남성
				standardweight = (int)((height - 100) * 0.95);
			} else if(gender == 2) { // 여성
				standardweight = (int)((height - 100) * 0.90);
			}
		}
	}
	
	// 표준체중지수 
	public void weightinx() {
		index = ((double)weight / standardweight) * 100;
	}
	// 표준체중 평가 기준
	public void weightindex(double index) {
		if(index >= 126) {
			bodytype = " 마른형";
		} else if(116 <= index && index <= 125) {
			bodytype = " 조금 비만형 ";
		} else if(96 <= index &&  index <= 115) {
			bodytype = " 표준형 ";
		}  else if(86 <= index && index <= 95) {
			bodytype = " 조금마른형";
		}  else {
			bodytype = " 비만형";
		}
	}
	public static void main(String[] args) {
		new StandardWeight();
	}
}
