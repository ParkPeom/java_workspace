package com.codechobo.interface7;

// 직원정보(직원번호,직원이름,근무부서)를 저장하기 위한 클래스
public class AcademyStaff extends AcademyPerson {
	
	private String depart;
	
	public AcademyStaff() {	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public AcademyStaff(String num, String name, String depart) {
		super(num, name);
		this.depart = depart;
	}
	
	@Override
	public void display() {
		System.out.println("직원 번호 = " + super.getNum());
		System.out.println("직원 이름 = " + super.getName());
		System.out.println("근무 부서 = " + this.getDepart());
	}
}
