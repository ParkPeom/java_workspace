package com.codechobo.oop;

// 시간제 사원정보(사원번호,사원이름,시급,근무시간)를 저장하기 위한 클래스
public class EmployeeTime extends Employee {
	
	// 시급 이랑 근무시간만 만들면됨
	private int moneyPerHour;
	private int workedHour;
	
	public EmployeeTime() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeTime(int empNo, String empName, int moneyPerHour, int workedHour) {
		super(empNo, empName);
		this.moneyPerHour = moneyPerHour;
		this.workedHour = workedHour;
	}

	public int getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}

	public int getWorkedHour() {
		return workedHour;
	}

	public void setWorkedHour(int workedHour) {
		this.workedHour = workedHour;
	}
	
	public int calcPay() {
		return moneyPerHour*workedHour;
	}

	@Override
	public int computePay() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
