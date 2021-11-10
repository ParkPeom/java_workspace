package com.codechobo.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam3 {
	
	public static void main(String[] args) throws IOException {
		
		boolean is = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		do {
			System.out.print("메뉴 1 ~ 2 선택 다시 , 종료 : 3  > ");
			int choice = br.read();
			
			switch(choice) {	
			case 1: 
				System.out.println("1번메뉴입니다.");
				continue; // 다시선택 
			case 2:
				System.out.println("2번메뉴입니다.");
				continue; // 다시 선택
			case 3:	
				System.out.println("종료");
				break;
			}

		}while(!true);
	}
}
