package com.codechobo.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// 키보드로 점수를 입력받아 학점을 계산하여 출력하는 프로그램 작성 
// => 100 ~ 90 A , 89 ~ 80 : B , 79 ~70 : C , 69 ~ 60 : D , 59 ~ 0 : F 
// => 키보드 입력 점수가 0 ~ 100 범위의 정수값이 아닌 경우 오류 메시지 출력 후 재입력 

public class InputCheckApp {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = "";
			
		do {
			System.out.print("점수를 입력 하시오 > "); // 다시 입력받게 반복문 안에 적어줘야한다. 
			score = scanner.nextInt(); // 다시 입력받게 반복문 안에 적어줘야한다. 
		
			// 유효값 검사 
			if(!(0 <= score && score <= 100)) {
				System.out.println("잘못된 값 입력하셨어요"); // 잘못된 값을 출력하기 위해 조건문 
			}
			switch(score / 10) { 
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			default :
				grade = "F";
			}
		}while(! (0 <= score && score <= 100) ); // 비정상적인 값이 입력되면 반복 실행될수 있게 함 
	System.out.println("[결과]" + score + "점 >> " + grade + "학점");
	
	System.out.println();
	
	// 조건식 대신 true를 사용할 경우 무조건 참으로 처리되어
	// 조건식 대신 참(true)을 사용할 경우 무한루프 이다.
	
	while(true) { // while문은 무조건 true 로 하는게 좋음 break로 빠져가가게 
				   // 중간에서 나갈수있어서 좋다. 

		System.out.print("점수를 입력 하시오 > "); // 다시 입력받게 반복문 안에 적어줘야한다. 
		score = scanner.nextInt(); // 다시 입력받게 반복문 안에 적어줘야한다.
		
		// 무한반복을 벗어날수 있게 하려면 무조건 조건문을 줘서 break 로 빠져나가게 한다.
		
		if(score >= 0 && score <= 100) { // 정상적인 값이 입력된 경우
			break; // 반복문을 종료함
		}
		// 비정상적인 값이 입력된 경우 오류 메시지 출력 
		System.out.println("[에러] 점수는 0  ~ 100 사이의 숫자만 입력 가능합니다. ");
	}
		switch(score / 10) { 
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default :
			grade = "F";
		}
		System.out.println("[결과]" + score + "점 >> " + grade + "학점");
	}
}
