package com.codechobo.control;

public class IfApp {
	
	public static void main(String[] args) {
		
		int su = 90;
		// 변수값이 50이상인 경우에만 변수값 출력
		
		if(su >= 50) { // su 50보다 크거나 같으면 true 여야 출력됨 
			System.out.println("sum = " + su);			
		}
		
		System.out.println("===========================");
		
		int score = 50;
		
		// 변수값이 60이상인 경우 합격 메시지 출력 , 60 미만인 경우 불합격 메시지 출력
		
		
		/* if라는 구절이 2개나 있다 , 참일때만 실행됨 
		if(score >= 60) {
			System.out.println("결과가 60점 이상으로 합격입니다.");
		} 
		if(score < 60) {
			System.out.println("결과가 60점 미만으로 불합격 입니다");
		}
		*/

		// if 하나라서 효율적이다.
		
		if(score >= 60) { // 조건이 참일때 실행 
			System.out.println("결과가 60점 이상으로 합격입니다.");
		} else { // 조건이 거짓일때 실행
			System.out.println("결과가 60점 미만으로 불합격 입니다.");
		}
		System.out.println("========================================");
		
		int num = 9;
		
		// 변수값을 홀수와 짝수로 구분하여 출력 x % y == 0  [  x는 y의 배수이다. ] 
		
		if(num % 2 == 0) { // 산술 연산자만 만들어주면 안됨 
			System.out.println(num + "짝수 입니다.");
		} else {
			System.out.println(num + " 홀수 입니다.");
		} 
		
		// 삼항연산자로 표현하면
		String str = num % 2 == 0 ? num + " 짝수 입니다." : num + " 홀수 입니다";
		System.out.println(str);
		
		System.out.println("===============================");
		
		char mun = 'O';
		
		
		// 변수값을 영문자 또는 비영문자로 구분하여 출력하기
		
		if(mun == '0') {
			System.out.println("비영문자 0 입니다.");
		} else if('a' <= mun && mun <= 'z') {
			System.out.println("소문자 입니다.");
		} else if('A' <= mun && mun <= 'Z') {
			System.out.println("대문자 입니다.");
		} else {
			System.out.println("아무 문자도 아닙니다. ");
		}
		
		// 강사님이 풀어주신방법 
		// 어디부터 어디까지 && 
		if(mun > 'a' && mun <= 'z' || mun >= 'A' && mun <= 'Z') {
			System.out.println("영문자 입니다.");
		} else {
			System.out.println("비영문자 입니다.");
		}

		System.out.println("================================");
		
		// boolean 변수를 이용해서 true false 
		
		boolean sw = true;
		// 조건식 대신 boolean 변수값을 이용하여 명령 선택 실행 가능
		if(sw) { // sw값이 true인 경우 , 괄호 안에는 true 아니면 false 가 나오면 된다.
			System.out.println("현재 상태는 참입니다. ");
		} else {
			System.out.println("현재 상태는 거짓입니다.");
		}
		
		System.out.println("=================================");
		
		// 조건이 참일때보다 조건이 거짓일때 프로그램 만드는 경우가 많다
		// 잘못된 값이라면 명령을 실행해서 더이상 프로그램이 동작하지 않도록 하기 위해
		// not 연산자는 많이 쓴다. 
			
		// 사용자가 값이 입력하지 않으면 , 입력한값이 정답이랑 다르면 
		// 참이 아니라면 
		
		if(!sw) { // not를 붙임으로써 거짓일때 명령 실행하게 만듬 
			System.out.println("현재 상태는 참입니다. ");
		} else {
			System.out.println("현재 상태는 거짓입니다.");
		}	
		// while(!(input == answer))
		
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
		
		
	}
}
