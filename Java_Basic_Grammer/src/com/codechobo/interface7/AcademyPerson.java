package com.codechobo.interface7;

// 공통된 기능 - 사람정보(번호,이름) 를 저장 하기 위한 클래스  
// => 학생 강사 직원 에 대한 공통적인 속성과 행위를 정의하기 위한 클래스
// => 중복된 코드를 최소화 할수있다.(유지보수)
// => 코드의 중복성을 최소화 하여 프로그램의 생산성 및 유지보수의 효율성 증가
public class AcademyPerson {
	
	// 코드의 중복되는것을 묶어준다. 
	private String num;
	private String name;

	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}

	public AcademyPerson(String num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void display() {
		System.out.println("번호" + num);
		System.out.println("이름" + name);
	}
}
