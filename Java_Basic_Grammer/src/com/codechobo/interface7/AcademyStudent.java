package com.codechobo.interface7;

// 학생정보(학생번호,학생이름,수강과목)를 저장하기 위한 클래스 
// => 학생번호와 학생이름 관련 속성과 행위는 AcademyPerson 클래스를 상속받아 작성
public class AcademyStudent extends AcademyPerson {
	
	private String course;
	
	public AcademyStudent() {

	}

	// 부모의 공통된 속성도 super로 초기화 시켜줘야 한다.
	public AcademyStudent(String num, String name, String course) {
		super(num, name);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	// 부모의 것을 오버라이딩
	@Override
	public void display() {
		System.out.println("학생 번호 = " + super.getNum());
		System.out.println("학생 이름 = " + super.getName());
		System.out.println("수강 과정 = " + this.getCourse());
	
	}
}
