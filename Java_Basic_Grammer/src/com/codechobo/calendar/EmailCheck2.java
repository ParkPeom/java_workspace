package com.codechobo.calendar;
import java.util.Scanner;

public class EmailCheck2 {

	public EmailCheck2() {
		
	}
	
	public void start() {
		do {
			//이메일 입력받기
			String email = inputEmail();
			
			if(emailCheck(email)) { // 정상이메일
				emailOutput(email);
			}else {   //잘못된 이메일주소
				System.out.println(email+"은 잘못된 이메일주소 입니다.");
			}
			break;
			
		}while(true);
		
	}
	//아이디와 도메인을 분리하여 출력하는 메소드
	public void emailOutput(String email) {
		int atMark = email.indexOf("@");
		String id = email.substring(0 , atMark+1);
		String domain = email.substring(atMark+1);
		System.out.println("아이디 ="+ id);
		System.out.println("도매인 ="+ domain);
	}
	
	
	//이메일 유효성 검사 하는 메소드 
	public boolean emailCheck(String email) {
		boolean boo = true;
		//indexOf() 특정문자의 위치를 구하고 , 없으면 -1 
		int atMark = email.indexOf("@");
		int point = email.indexOf(".",atMark+1);
		int len = email.length();
		
		if(atMark == -1 || atMark<8 || point == -1 || point -atMark<=2
				|| atMark!=email.lastIndexOf("@") || point<atMark || len==point+1){   ///(          ||@바로 다음에 . 나올 경우 )
			boo =false;
		}
		return boo;
	}
	
	//이메일 입력받는 메소드 
	public String inputEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이메일입력 = ");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		EmailCheck2 ec = new EmailCheck2();
			ec.start();

	}

}
