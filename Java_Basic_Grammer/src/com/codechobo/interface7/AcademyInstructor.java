package com.codechobo.interface7;

// 강사 정보를 저장하기 위한 클래스
// => 강사번호 강사이름은 Person에서 상속받아 쓰고

public class AcademyInstructor extends AcademyPerson {
	
	private String subject;
	public AcademyInstructor() {}

	public AcademyInstructor(String num, String name, String subject) {
		super(num, name);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public void display() {
		System.out.println("강사 번호 = " + super.getNum());
		System.out.println("강사 이름 = " + super.getName());
		System.out.println("수강 과정 = " + this.getSubject());
	}
}
