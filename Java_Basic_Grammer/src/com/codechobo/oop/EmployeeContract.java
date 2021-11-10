package com.codechobo.oop;

// 계약직 사원 정보(사원번호,사원이름,계약급여)를 저장하기 위한 클래스 
public class EmployeeContract extends Employee {
	
	// 계약급여만 추가하면 됨
	
	private int contractPay;
	
	public EmployeeContract() {	}

	public EmployeeContract(int empNo, String empName, int contractPay) {
		super(empNo, empName);
		this.contractPay = contractPay;
	}


	public int getContractPay() {
		return contractPay;
	}

	public void setContractPay(int contractPay) {
		this.contractPay = contractPay;
	}
	
	// 급여를 계산하여 반환하는 메서드
	public int returnPay() {
		return contractPay;
	}

	@Override
	public int computePay() {
		return returnPay();
	}
	
}
