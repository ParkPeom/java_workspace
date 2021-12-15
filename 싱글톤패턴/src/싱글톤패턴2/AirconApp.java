package 싱글톤패턴2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AirconApp {
	
	BufferedReader br;
	int number;
	public AirconApp() {
		br = new BufferedReader(new InputStreamReader(System.in));
		start();
	}
	public void start() {
		Print.showmenu();
		int number = setMessage("선택");
		menu(number);
	}
	// 반복 입력 
	public int setMessage(String msg) {
		String answer = "";
		try { 
			System.out.print(msg + " >> ");
			number = Integer.parseInt(br.readLine());
			throw new ThrowException();
		} catch (ThrowException e) {
				System.out.println("값이 없습니다.");
		} catch (IOException e) {
				System.out.println("");
		} finally {
				
		}
		return number;	
	}
	// 메뉴 
	public void menu(int number) {		
		switch(number) {
		case 1:
			// 회원 가입
			break;
		case 2:
			// 상품 목록
			break;
		case 3:
			// 구입 목록
			break;
		case 4:
			// 
			break;
		case 5:
			break;
		
		case 6:
			break;
		
		case 7:
			break;
		}
	}
	// 사용자
	
	// 에어컨 물건    
	
	// 구입 품목
	
	// 계산 
	
	// 
	public static void main(String[] args) {
		new AirconApp().start();
		/*
		Aircon samsung = SamgSungAircon.getInstance();
		Aircon lg = LGAircon.getInstance();
		Aircon carrier = CarrierAircon.getInstance();
		Aircon bokuk = Bokuk.getInstance();
		*/
		// 기능 사용 메소드 
		UseAirCon use = new UseAirCon();
		// use.turnon(samsung); 	// 삼성 전원킴 
		// use.useAircon(samsung); // 삼성 
		use.template(samsung);
		use.template(lg);
		use.template(carrier);
		use.template(bokuk);
		// 사용자
		Customer user1 = new Customer();
		// 속성 출력 
		// 구입 목록
	}
}
