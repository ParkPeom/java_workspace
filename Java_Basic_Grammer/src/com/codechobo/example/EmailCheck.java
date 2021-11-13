package com.codechobo.example;
import java.util.Scanner;

public class EmailCheck {

	public EmailCheck() {
		
	}
	public void start() {
		do {
			//이메일입력받기
			String email = inputEmail();
			
			if( emailCheck(email) ) {//정상이메일
				emailOutput(email);
			}else {//잘못된 이메일주소
				System.out.println(email+"은 잘못된 이메일주소입니다. 다시 입력하세요.");
			}			
		}while(true);
	}
	//아이디와 도메인을 분리하여 출력하는 메소드
	public void emailOutput(String email) {
		int atMark = email.indexOf("@");
		String id = email.substring(0, atMark);
		String domain = email.substring(atMark+1);
		System.out.println("아이디="+ id);
		System.out.println("도메인="+ domain);
	}
	//이메일 유효성검사하는 메소드
	public boolean emailCheck(String email) {
		boolean boo = true;
		//indexOf() 특정문자의 위치를 구하고, 없으면 -1
		int atMark = email.indexOf("@");
		int point = email.indexOf(".", atMark+1);
		int len = email.length();
		if(atMark==-1 || atMark<8 || point==-1 || point-atMark<=2
		   || atMark!=email.lastIndexOf("@") || point<atMark 
		   || len==point+1) {
			boo = false;
		}
		return boo;
	}
	//이메일 입력받는 메소드
	public String inputEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이메일입력=");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		EmailCheck ec = new EmailCheck();
		ec.start();
	}

}
/*
 실행
 이메일입력 = jkfdsk
 잘못된 이메일입니다. 다시입력하세요..
 
 이메일입력 = fjdkslf@fds
 잘못된 이메일입니다. 다시입력하세요..
 
 이메일입력 = fjdk.slf@fds
 잘못된 이메일입니다. 다시입력하세요..
 
 이메일입력 = abced@nate.com
 아이디:abced
 도메인:nate.com
 
 이메일입력 = _
 
 */
