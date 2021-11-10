package com.codechobo.interface7;

// 정규직 사원 정보 (사원번호,사원이름,연봉) 저장 하기 위한 클래스  
// => Employee 클래스를 상속받아 작성
public class EmployeeRegular extends Employee {

	// 연봉만 
	private int annualSalary;
	
	public EmployeeRegular() {}

	// 부모 생성자도 호출
	public EmployeeRegular(int empNo, String empName, int annualSalary) {
		super(empNo, empName);
		this.annualSalary = annualSalary;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	// 급여를 계산하여 반환하는 메서드 
	public int computeSalary() {
		return annualSalary/12;
	}

	@Override
	public int computePay() {
		return computeSalary() / 12;
	}
	
	// 인센티브 메서드를  오버라이드 할수없게 만들필요가 있다. 
	// final 지정자를 선언된 메서드를 오버라이드 선언할 경우 에러 발생
//	@Override
//	public int computeIncentive() {
//		return 1_000_000_000;
//	}
}
