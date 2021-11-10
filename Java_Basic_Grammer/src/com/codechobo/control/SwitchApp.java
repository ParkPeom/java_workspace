package com.codechobo.control;

/*
  정렬 단축키  Ctrl + shift + F : 명령을 정렬하는 단축키 
 
 */
public class SwitchApp {

	public static void main(String[] args) {

		int choice = 2; // break를 안쓰면 같은 값의 위치의 값부터 쭈루룩 실행됨

		switch (choice) { // 안에 조건식안씀!!! 변수를 씀 , (실수값이 오면 안된다.)

		case 1: // 콜론 case에는 상수 문자열 문자 올ㄹ수있고 (변수는 절대 못온다)
			System.out.println("수성으로 이동합니다.");
			break;
		case 2:
			System.out.println("금성으로 이동합니다.");
			break;
		case 3:
			System.out.println("화성으로 이동합니다.");
			break;
		default:
			System.out.println("아무대도 안감 ");
		}

		// switch 의 값 (변수값,연산 결과값) case 의 값(리터럴 , 상수) 와 비교하여 같은 값을 가진
		// case 위치로부터 하단에 존재하는 모든 명령 실행
		
		switch (choice) { // 안에 조건식안씀!!! 변수를 씀 , (실수값이 오면 안된다.)

		case 1: // 콜론 case에는 상수 문자열 문자 올수있고 (변수는 절대 못온다)
			System.out.println("수성으로 이동합니다.");
			break;
		case 2:
			System.out.println("금성으로 이동합니다.");
			break;
		case 3:
			System.out.println("화성으로 이동합니다.");
			break;
		default: // 모든 case의 값이 맞지 않을 경우 무조건 실행되는 명령을 작성하는 위치를 표현 
			System.out.println("집으로 이동합니다. ");
		}
		
		// switch 문 강제종료 
		switch (choice) { 
		case 1: 
			System.out.println("수성으로 이동합니다.");
			break; // 강제 종료 시킴 
		case 2:
			System.out.println("금성으로 이동합니다.");
			
		case 3:
			System.out.println("화성으로 이동합니다.");
			
		default: 
			System.out.println("집으로 이동합니다. ");
		}
		
		// 변수값이 0~100 범위의 유효값인지 아닌지를 구분하여 출력 - 입력값의 유효성 검사
		
		
		System.out.println("===============================");
		
		int jumsu = 98; // 입력값의 유효성 검사 ( ex ) 아이디 , 패스워드 등 
		// 변수값이 0부터 100 범위의 유효값인지 아닌지를 구분하여 출력하시오
		// 사용자가 입력한 값이 유효한값인지 반드시 확인을 해야한다.
			
		// 문자열의 초기값은 NullString을 많이 준다. 
		String grade = ""; // 등급을 저장하기 위한 변수 
		String oper = "";
		if(!(0 <= jumsu && jumsu <= 100)) { // && 범위를 표현하는 조건식 
			System.out.println("유효하지않습니다.");
		} else {
			// 유효한 값을 입력할 경우 변수값을 이용하여 등급을 구분하여 출력한다. 
			// 100~90 A , 89~80 B , 79~70 C , 69 ~ 60 D , 59 ~ 0 F
			// 95 이상  + , 85 이상 + , 75 이상 + , 69 이상 + 55 이상 + 

			// 밖에서 이미 유효성 검사해서 위에서 이미 걸려져 있기 때문에 
			// 크냐 라고만 물어보면 된다. (코드의 불필요함을 줄일수있다.)
			
			if(jumsu >= 90) {
				grade += "A";
				if(jumsu >= 95) {
					oper += "+";
				}
			}
			else if(jumsu >= 80) {
				grade += "B";
				if(jumsu >= 85) {
					oper += "+";
				}
			}
			else if(jumsu >= 70) {
				grade += "C";
				if(jumsu >= 75) {
					oper += "+";
				}
			} else if(jumsu >= 60) {
				grade += "D";
				if(jumsu >= 65) {
					oper += "+";
				}
			} else { // 모든 조건이 거짓이라면 (무조건적으로 실행됨 
				grade += "F";
			}
			System.out.println("결과 : " + jumsu +"점 등급은 " + grade+oper);	
		}	
		
		// 위 문장을 switch 문으로 쓰기
		
		// 100 ~ 90 , 90 ~ 80 , 80 ~ 70 , 70 ~ 60 , 그외 F
		// if가 활용가치가 더 높다 	
		
		jumsu = 88;
		switch(jumsu / 10) { // 연산식의 결과값 , 변수값을 비교하는게 더 많다 
			
		case 10: // 10 / 100 = 10 A
		case 9:  // 10 / 90 = 9 A
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
		
		System.out.println("점수는 " + jumsu +"등급은 " + grade + "입니다.");
		
		System.out.println("===============================================");
		
		String kor = "둘";
		String eng = "";

		// JDK 1.7 이상에서는 switch에서는 문자열을 비교해서 선택 실행 할 수 있다. 
		// 메뉴 선택 기능구현에 Switch문에 많이 쓰인다. 
		// 문제는 되도록 if문을 많이 푼다.
		switch(kor) {
		case "하나":
			eng = "One";
			break;
		
		case "둘":
			eng = "Two";
			break;
			
		case "셋":
			eng = "Three";
			break;
		}
		System.out.println("[결과]" + kor + " = " + eng);
	}
}
