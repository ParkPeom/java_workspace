package com.codechobo.oop;

// 사원 급여 관리 프로그램 

public class EmployeeApp {
	
	public static void main(String[] args) {
		// 추상클래스로 인스턴스를 생성할 경우 에러 발생
		// Employee employee = new Employee();
		
		// 추상클래스(부모클래스)로 참조변수를 생성하여 자식 인스턴스 저장 가능
		Employee employee1 = new EmployeeRegular();
		Employee employee2 = new EmployeeTime();
		Employee employee3 = new EmployeeContract();
		
		Employee[] employArr = new Employee[5];
		
		employArr[0] = new EmployeeRegular(1000,"홍길동",96000000);
		employArr[1] = new EmployeeTime(2000,"임꺽정",50000,150);
		employArr[2] = new EmployeeContract(3000,"전우치",70000000);
		employArr[3] = new EmployeeTime(4000,"일지매",20000,100);
		employArr[4] = new EmployeeRegular(5000,"장길산",60000000);
		
		for (Employee employee : employArr) {
			System.out.println("사원 번호 = " + employee.getEmpNo());
			System.out.println("사원 이름 = " + employee.getEmpName());
			
			// 급여를 반환받아 출력 
			// => 명시적 객체 형변환을 이용하여 자식 인스턴스의 메서드 호출
			// => instanceof 연산자를 이용하여 자식 클래스를 구분하여 객체 형변환 해줘야 한다.
			/*
			if (employee instanceof EmployeeRegular ) {
				System.out.println(((EmployeeRegular)employee).computeSalary());
			} else if(employee instanceof EmployeeContract) {
				System.out.println(((EmployeeContract)employee).returnPay());
			} else if(employee instanceof EmployeeTime) {
				System.out.println(((EmployeeTime)employee).calcPay());
			}
			*/
			
			// 자식 클래스에서 부모클래스의 메서드를 오버라이드 선언하여 묵시적 객체 형변환을 통해
			// 이용하여 자식 인스턴스의 메서드를 호출 
			System.out.println("사원 급여 = " + employee.computePay());
			System.out.println("인센 티브 = " + employee.computeIncentive());
			
			System.out.println("==============================================");
		}
	}
}
