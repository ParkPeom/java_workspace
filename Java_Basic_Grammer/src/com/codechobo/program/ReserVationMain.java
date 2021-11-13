package com.codechobo.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	영화 예매 
	좌석 [0-0] [0-1] [0-2] [0-3]
	    [1-0] [1-1] [1-2] [1-3]
	    [2-0] [2-1] [2-2] [2-3]
	    [3-0] [3-1] [3-2] [3-3]
	<< ITWill CIneMa >>    
	1. 좌석보기    
	2. 좌석예약
	3. 예매내역조회
	4. 예매취소하기
	
*/

// 메인 실행 클래스 
public class ReserVationMain { 
	static ReserVationMain reser = new ReserVationMain(); // 메인
	static String[][] seat;	// 좌석
	static int[][] reservedNumber; // 예매번호
	Scanner sc; // 입력
	List<UserVO> user; // 유저정보 
	
	static Join j; 
	
	
	// 생성자 초기화 싱글톤 
	ReserVationMain() {
		seat = new String[4][4];
		reservedNumber = new int[4][4];
		sc = new Scanner(System.in);
		user = new ArrayList<UserVO>();
	}
	
	// 프로그램 시작 시 좌석 초기화
	
	public void setInfo() {
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j] = i + "-" + j;
			}
		}
	}
	
	// 라인 
		public void line() {
			System.out.println("=================");
		}
	
	// 1. 좌석 보기
	public String[][] showSeat(String[][] seat) {
		line();
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				System.out.print(seat[i][j]+" ");
			}
			System.out.println();
		}
		line();
		return seat;
	}
	
	// 2. 좌석 예약하기
	public String[][] seatReserVation(String[][] seat) {
		System.out.print("좌석 번호를 선택해주세요. 예) 1-1> ");
		String seatNo = sc.nextLine();
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				if(seatNo.equals(seat[i][j])) {
					seat[i][j] = "예매";
					reservedNumber[i][j] = (int)(Math.random()*100000);
					System.out.println("예매가 완료 되었습니다.");
					reser.showSeat(seat);
					System.out.println(String.format("예매 좌석은 [%s-%s]부여된 예매번호는 %d 입니다.",i,j,reservedNumber[i][j] ));
					break;
				} else if(seatNo.equals("예매")) {
					System.out.println("예매됨");
				}
				if(seatNo.equals("예매") && reservedNumber[i][j] == 0) {
					System.out.println("예매됨");
				}
			}
		}
		if(seatNo == null) {
			System.out.println("존재하지않습니다.");
		}
		return seat;
	}
	
	// 3. 예매 내역 조회하기
	public void reservedConfirm(String[][] seat) {
		line();
		System.out.print(" ▼ 예매권 번호를 입력해주세요 ▼ ");
		line();
		int number = sc.nextInt();
		for(int i = 0; i < reservedNumber.length; i++) {
			for(int j = 0; j < reservedNumber[i].length; j++) {
				if(number == reservedNumber[i][j]) {
					line();
					System.out.println(String.format("조회된 예매의 좌석은 [%s-%s] 입니다", i , j));
					line();
				} 
			}
		}
	}
	
	// 4. 예매 취소하기
	public void cancelSeat(String[][] seat) {
		System.out.println("▼ 예매권 번호를 입력해주세요 ▼ ");
		int number = sc.nextInt();
		for(int i = 0; i < reservedNumber.length; i++) {
			for(int j = 0; j < reservedNumber[i].length; j++) {
				if(number == reservedNumber[i][j]) {
					seat[i][j] = i+"-"+j;
					reservedNumber[i][j] = 0;
					line();
					System.out.println("예매가 취소되었습니다.");
					line();
					break;
				}
			}
		}
	}	
	
	// 프로그램 종료하기
	public static void exit() {
		System.exit(0);
	}
	
	// 메뉴 
	public static void showMenu() {
		int menu = 0;
		do {
			System.out.println("<< ITWill CineMa >>");
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1. 영화관 좌석 보기");
			System.out.println("2. 영화 좌석 예약");
			System.out.println("3. 예매 내역 조회");
			System.out.println("4. 예매 취소 ");
			System.out.println("5. 회원 가입 페이지로 이동하기 ");
			System.out.println("6. 종료 하기");
			
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			menu = Integer.parseInt(choice);
			
			switch(menu) {		
			case 1:
				reser.showSeat(seat);		 // 좌석보기 
				break;
			case 2:
				reser.seatReserVation(seat); // 좌석예약하기
				break;
			case 3:
				reser.reservedConfirm(seat); // 예매내역 조회하기
				break;
			case 4:
				reser.cancelSeat(seat);		 // 예매내역 취소하기 
				break;
			case 5:
				Join j = new Join();
				j.showMenu(); 			     // 회원 가입 페이지로 이동 
				break;
			case 6:
				System.out.println("종료되었습니다.");
				exit();
			default :
				System.out.println("다시 입력 하세요.");
			}
		} while(!(1 > menu || menu >= 5));
	}
	
	public static void main(String[] args) {		
		reser.setInfo(); // 좌석초기화
		reser.showMenu(); // 메뉴보여주기 	
	}
}
