package com.codechobo.control;

public class IfExample {

	public static void main(String[] args) {
				//변수에 저장된 문자값을 출력하세요.
				//단, 변수에 저장된 문자값이 소문자인 경우 대문자로 변환하여 출력하세요.
				char mun='d';
				if('a' <= mun && mun <= 'z') {
					mun -= 32;
					System.out.println("변환된 값은 : " + mun);
				} else if( 'A' <= mun && mun <= 'Z') {
					mun += 32;  // mun = mun + 32 는 int + int = int 이므로 (char)int + int 강제형변환 해줘야 한다.
					System.out.println("변환된 값은 : " + mun);
				}
			
				//변수에 저장된 정수값이 4의 배수인지를 구분하여 출력하세요.
				int num=345644;
				
				if(num % 4 == 0) {
					System.out.println("4의 배수 입니다.");
				} else {
					System.out.println("4의 배수가 아닙니다.");
				}

				//올해가 평년인지 윤년을 구분하여 출력하세요.
				// => 년도를 4로 나누어 나머지가 0인 경우 윤년
				// => 위 조건을 만족하는 년도 중 100으로 나누어 나머지가 0인 경우 평년
				// => 위 조건을 만족하는 년도 중 400으로 나누어 나머지가 0인 경우 윤년
				int year=2021;
				
				if(year % 4 == 0) {
					System.out.println("윤년");
						if(year % 100 == 0) {
							System.out.println("평년");
						} else if(year % 400 == 0) {
							System.out.println("윤년");
						} 
					} else {
						System.out.println("해당되는 년이 아닙니다.");
					}
				
				// 강사님이 푼거 
				if(year % 4 ==0 && year % 100 !=0 || year % 400 == 0) {
					System.out.println("[결과] " + year + "년은 윤년 입니다.");
				} else {
					System.out.println("[결과] " + year + "년은 평년 입니다.");
				}
				

				//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
				//총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
				// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료
				//    System.exit(0) : 프로그램을 강제로 종료하는 메소드
				// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
				// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.
				
				String name = "홍길동";
				int kor = 89 , eng = 93 , math = 95;
				int total = 0;
				double average;
				String grade = "";
				
				// 사용자 편의성을 위해서 하나씩 다 검증하는게 좋다 ( 로그인 패스워드 )
				if(0 <= kor && kor <= 100) {
					if(0 <= eng && eng <= 100) {
						if(0 <= math && math <=100) {
							total = kor + eng + math;
							average = total / 3.0;
							if( 90 <= average && average <= 100) {
								grade = "A";
							} else if(average >= 80) {
								grade = "B";
							} else if(average >= 70) {
								grade = "C";
							} else if(average >= 60) {
								grade = "D";
							} else {
								grade = "F";
							}
						System.out.printf("평균 %.2f 학점은  %s ", average , grade);	
						}
					}
				} else {
					System.out.println("종료");
					System.exit(0);
				}
				
				// switch문으로 풀경우
				int kor2 = 89 , eng2 = 93 , mat2 = 95;
				
				// 입력값 검증(Validation 유효값 검증) - 아이디 ,비밀번호 검증 할때 쓰인다. 
				
				
				
//				if(!(kor2 >= 0 && kor <= 100) || !(eng2 >= 0 && eng2 <= 100) || !(mat2 >= 0 && mat2 <= 100)) {
//					System.out.println("[에러] 0 ~ 100 범위를 벗어난 비정상적인 점수가 입력 되었습니다.");
//					System.exit(0);
//				} // 이것보단 
				
				
				// 단 조건값은 따로 주는게 -> 사용자에게 편의성을 무조건 잘 줘야 한다. ( 좋은프로그램을 주려면 )  - 조건 하나하나 다 검사함 
				
				boolean valid = false;
				
				if(!(kor2 >= 0 && kor2 <= 100)) {
					System.out.println("[에러] 0 ~ 100 범위를 벗어난 비정상적인 국어점수가 입력 되었습니다");
					valid = true; // 검증이 실패하면 true 
				}
				 if(!(eng2 >= 0 && eng2 <= 100)) {
					System.out.println("[에러] 0 ~ 100 범위를 벗어난 비정상적인 국어점수가 입력 되었습니다");
					valid = true;
				}
				 
				 if(!(mat2 >= 0 && mat2 <= 100)) {
					 System.out.println("[에러] 0 ~ 100 범위를 벗어난 비정상적인 국어점수가 입력 되었습니다");
					valid = true;
				} 
				 
				 // 입력값에 대한 검증이 실패한 경우 
				 if(valid) {
					 System.exit(0);
				 }
				
				// 검증이 실패되면  System.exit(0) 으로 인해 밑에는 실행이 되지 않는다. 
				
				int tot2 = kor2 + eng2 + mat2;
				grade = "";
				double ave2 = tot2 / 3.;
					
				switch((int)ave2/10) { // switch 는 실수를 못받으므로 int로 강제 형변환 
				case 10:
				case 9:
					grade = "A"; break;
				case 8:
					grade = "B"; break;
				case 7: 
					grade = "C"; break;
				case 6: 
					grade = "D"; break;
				default : 
					grade = "F"; break;
				}
				
			}
		}