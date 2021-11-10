package com.codechono.array;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
//=> 1~100 범위의 정수 난수값을 제공받도록 작성
//=> 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
//=> 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
//=> 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
//=> 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
//=> 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int chance = 10;
		int nansu = (int)(Math.random()*100)+1;
		System.out.println("nansu 미리 공개 " + nansu);
	while(true) {
			System.out.println("값을 입력하세요 > ");
			int num = sc.nextInt();
			if(!(1 <= num && num <= 100)) {
				System.out.println("1~100 범위가 아닙니다.");
				continue;
			}
			if(nansu == num) {
				System.out.println("맞췄습니다.");
				System.out.println("답 : " + nansu);
				break;
			} else if(num < nansu) {
				System.out.println("큰값 입력");
				chance--;
			} else {
				System.out.println("작은값 입력");
				chance--;
			}
			if(chance <= 0) {
				System.out.println("모든기회날임");
				System.out.println("답 : " + nansu);
				break;
			}
		}
	}
}

