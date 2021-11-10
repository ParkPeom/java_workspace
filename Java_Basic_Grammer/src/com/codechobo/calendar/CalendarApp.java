package com.codechobo.calendar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarApp {
	Scanner sc = new Scanner(System.in);
	int year , month;
	
	public CalendarApp() throws CalendarException {
		try {
			System.out.print("년도를 입력해주세요 > ");
			year = sc.nextInt();
			System.out.print("월 를 입력해주세요 > ");
			month = sc.nextInt();
			if(month < 1 || month > 12) {
				throw new CalendarException("1부터 12까지 숫자를 입력해주세요.");
			}
			System.out.printf("\t\t %d년%d월 \t\t\n",year,month);	
			System.out.print("일\t월\t화\t수\t목\t금\t토\n");
		} catch (InputMismatchException e) {
			System.out.println("종료 됨 숫자를 입력해주세요.");
		}
		new CalendarSystem2(year,month);
	}
	public static void main(String[] args) throws CalendarException {
		new CalendarApp();
	}
}
