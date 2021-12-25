package choice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import print.Print;

// 선택 클래스들 모음
public class Choice { 
	public static void joinchoicemenu(int choice) {		
		
		switch(choice) {
			case 1:
				// 회원가입
				Print.join();
				break;
			case 2:
				// 로그인
				Print.login();
				break;
			} 
		}
	public static void showchoicemenu(String id) {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	try { 
		int choice = Integer.parseInt(br.readLine());
		switch(choice) {
			case 1:
				Print.myPage(id); //마이페이지
				break;
			case 2:	
				//구매하기
				break;
			case 3:
				//구입목록
				break;
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
