package com.codechobo.oop;

public class StudentApp {
	public static void main(String[] args) {
		/*
		Student student1=new Student(1000, "홍길동", 90, 90);
		Student student2=new Student(2000, "임꺽정", 94, 88);
		Student student3=new Student(3000, "전우치", 92, 80);
		Student student4=new Student(4000, "일지매", 76, 82);
		Student student5=new Student(5000, "장길산", 84, 86);
		
		//student1.calcTot();
		//student2.calcTot();
		//student3.calcTot();
		//student4.calcTot();
		//student5.calcTot();
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
		System.out.println("=============================================================");
		student1.setKor(100);
		//student1.calcTot();
		student1.display();
		System.out.println("=============================================================");
		*/
		
		/*
		//인스턴스를 저장할 수 있는 참조요소가 5개인 배열 생성
		// => 배열의 요소에는 기본값으로 null 저장
		Student[] students=new Student[5];
		
		//배열 요소에 인스턴스를 생성하여 저장 - 인스턴스 배열 
		students[0]=new Student(1000, "홍길동", 90, 90);
		students[1]=new Student(2000, "임꺽정", 94, 88);
		students[2]=new Student(3000, "전우치", 92, 80);
		students[3]=new Student(4000, "일지매", 76, 82);
		students[4]=new Student(5000, "장길산", 84, 86);
		*/
		
		Student[] students=new Student[] {new Student(1000, "홍길동", 90, 90)
				,new Student(2000, "임꺽정", 94, 88),new Student(3000, "전우치", 92, 80)
				,new Student(4000, "일지매", 76, 82),new Student(5000, "장길산", 84, 86)};
		
		//일괄처리를 이용하여 메소드 호출
		//for(int i=0;i<students.length;i++) {
		//	students[i].display();
		//}
		
		//int total=0;//모든 학생들의 총점 합계를 저장하기 위한 변수
		
		for(Student student:students) {
			student.display();
			//total+=student.getTot();//학생의 총점을 반환받아 총점 합계 변수에 누적
			
			//정적 필드는 클래스를 이용하여 접근 가능 
			// => 정적 필드의 접근 지정자가 private인 경우 접근 불가능
			//Student.total+=student.getTot();
			
			//정적 메소드는 클래스를 이용하여 호출 가능
			Student.setTotal(Student.getTotal()+student.getTot());
		}
		System.out.println("==============================================================");
		//System.out.println("총합계 = "+total);//모든 학생들의 총점 합계 출력
		//System.out.println("총합계 = "+Student.total);
		System.out.println("총합계 = "+Student.getTotal());
		System.out.println("==============================================================");
	}
}












