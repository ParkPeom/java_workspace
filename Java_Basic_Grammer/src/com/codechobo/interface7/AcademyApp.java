package com.codechobo.interface7;

/*
    Person <-  Instructor  ,  Student  ,  Staff   	
 	부모 하나 자식 여러명 
  	공통된 속성과 기능 - Person 클래스 
  	새로운 클래스를 빠르게 만들수있고 중복된 코드 최소화 - 유지보수 ↑
 */

public class AcademyApp {
	public static void main(String[] args) {
		
		// 학생 정보를 저장하기 위한 요소들이 존재하는 배열 선언 
		/*
		AcademyStudent[] student = new AcademyStudent[300];
		
		// 강사 정보를 저장하기 위한 요소들이 존재하는 배열 선언
		AcademyInstructor[] instructors = new AcademyInstructor[50]; 
	
		// 직원 정보를 저장하기 위한 요소들이 존재하는 배열 선언 
		AcademyStaff[] staffs = new AcademyStaff[100];
		*/
		
		// 학원 인적자원정보(학생,강사,직원)을 저장하기 위한 요소들이 존재하는 배열 선언 
		
		AcademyPerson[] persons = new AcademyPerson[5];
		
		// 부모로 참조변수로 저장하면 모든 자식을 저장시킬수있다.
		
		// 부모 클래스로 생성된 배열의 요소에 자식 클래스의 생성자로 인스턴스를 생성하여 저장
		// => 자식 클래스의 생성자를 이용하면 상속관계의 부모 인스턴스와 자식인스터가 생성된다.
		// => 배열의 요소에는 부모 인스턴스가 저장되어 참조
		// => 객체 형변환을 이용하면 자식 인스턴스 참조 가능 
		
		// ★ 부모의 참조변수를 만들면 자식의 인스턴스를 저장 가능 
		// 부모는 형변환을 하면 모든자식을 참조 할수있다. 
		persons[0] = new AcademyStudent("1000", "박범", "국어");
		persons[1] = new AcademyInstructor("2000","한미녀","웹 디자인 과정");
		persons[2] = new AcademyStaff("3000","김군","영업관리팀");
		persons[3] = new AcademyStudent("4000", "홍길동", "웹 개발자 과정");
		persons[4] = new AcademyStaff("5000","장길산","경영회계팀");
		
		for(AcademyPerson person : persons) {
			// 자식이 여러명 있으면 
			// 오버라이드 선언되지 않은 메서드는 명시적 객체 형변환 후 자식 인스턴스에 메서드 호출
			// => 상속 관계가 아닌 클래스로 명시적 객체 형변환을 할 경우 ClassCastException 발생
			// => 부모 참조변수에 저장된 부모 인스턴스로 상속관계의 자식 클래스를 확인하여 형변환
			// instanceof : 클래스의 상속관계를 구분하기 위한 연산자 
			// 형식 ) 부모참조변수 instanceof 자식클래스 
			// => 참조변수로 참조 가능한 자식 클래스인 경우 true를 제공한다. 
			// => 자식 클래스가 여러 개인 경우 명시적 객체 형변환을 하기 전에 사용 : ClassCastException 예방한다.
			if(person instanceof AcademyStudent) {
				// 명시적 객체 형변환을 통해 자식을 명확히 구분하고 명시적 형변환을 해줘야한다.
				System.out.println(((AcademyStudent) person).getCourse()+"학생 정보");
			} else if(person instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor) person).getSubject()+"강사 정보 ");
			} else if(person instanceof AcademyStaff) {
				System.out.println(((AcademyStaff) person).getDepart() +"직원 정보");
			}
			// 오버라이드 선언된 메서드는 묵시적 객체 형변환 되어 부모 인스턴스의 메서드 대신
			// 자식 인스턴스의 메서드 호출 
			// 자동형변환 되어 자식 인스턴스의 메서드 호출
			// => 메서드 오버라이드에 의한 다형성 - 참조변수가 참조 가능한 클래스로 자동
			// 형변환되어 자식 인스턴스의 메서드 선택 호출 
			person.display(); // 오버라이딩된 자식 인스턴스가 호출됨 
			System.out.println("=================================");
		}
	}
}
