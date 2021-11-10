package com.codechobo.control;
/*
	프로그램은 무조건 변수에 값을 담아서 사용한다. 

*/
public class VariableExample {
	
	public static void main(String[] args) {
		//가로의 길이가 7이고 세로의 길이가 10인 사각형의 넓이를 계산하여 출력하세요.
				int garo = 7; // 가로
				int saro = 10; // 세로
				int rectangle = 0; // 넓이 
				
				rectangle = garo * saro;
				System.out.println("삼각형 넓이 " + rectangle);
				System.out.println("======================================================");
				
				//높이가 9이고 밑변의 길이가 7인 삼각형의 넓이를 계산하여 출력하세요.
				
				int height = 9; // 높이
				int base = 7;	// 길이	
				double triangle = height * base / 2.0;
				System.out.println("삼각형 넓이 " + triangle);
				
				System.out.println("======================================================");
				
				//10명의 전체 몸무게가 759Kg인 경우 평균 몸무게를 계산하여 출력하세요.
				
				int num = 10;
				int totalweight = 759;
				double averageweight = 0.0;
				
				averageweight = (double)totalweight / num;
				System.out.println("평균 몸무게는 " + averageweight);

				System.out.println("======================================================");
				
				//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
				//총점과 평균을 계산하여 이름, 총점, 평균을 출력하세요.
				//단, 평균은 소숫점 한자리까지만 출력하고 나머지는 절삭 처리 하세요.

				String name = "홍길동";
				int kor = 89 , eng = 93 , math = 95;
				
				float average = 0.0f;
				
				int sum = kor + eng + math;
				average = (float)sum / 3;
				
				
				System.out.println((int)(average * 10) / 10.0);
				
				System.out.printf("이름 %s 총점 %d 평균 %.1f " , name , sum ,(int)(average * 10) / 10.0);
				System.out.println("======================================================");
	}

}


