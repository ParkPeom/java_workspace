package com.codechobo.interface7;

// 사원정보(사원번호,사원이름)를 저장하기 위한 클래스 (공통된 속성은 부모클래스로 준다 )
// => 인스턴스 생성이 목적이 아닌 상속이 목적인 클래스로 작성 - 이런클래스는 추상클래스로 선언하는게 좋다
// 추상클래스(Abstract Class) : abstract 지정자를 사용하여 선언된 클래스
// => 인스턴스를 생성할수 없는 클래스
public abstract class Employee {

	private int empNo;
	private String empName;
	// 상수필드(Constant Field) : 값 대신 의미 있는 단어를 사용하여 표현하기 위해 선언
	// => public static final 지정자를 이용하여 필드 선언 : 필드 선언시 초기값 설정 
	// 상수필드는 스네이크 표기법으로 선언하는 것을 권장한다.
	// => final 지정자에 의해 필드값 변경 불가
	private static final double INCETIVE_RATE = 1.5;
	
	public Employee() {}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	/*
	// 급여를 계산하여 반환하는 메서드
	public int computePay() {
		return 0;
	}
	*/
	/*
	// 급여를 반환하는 메서드
	// => 자식클래스에서 오버라이드 선언하도록 작성된 메서드 - 강제성이없다.
	// => 자식클래스에 반드시 오버라이드 선언 불필요 - 오버라이드 선언하지않으면 부모 클래스의 메서드가 호출된다.
	public int computePay(){
		return 0;
	}
	*/
	// 급여를 계산하여 반환하는 메서드
	// => 자식클래스에서 무조건 오버라이드 선언하도록 작성 - 추상메서드로 선언
	// 추상메서드(Abstract Method) : abstract 지정자를 사용하여 작성된 메서드 
	// => 명령을 작성하지 않는 불완전한 메서드 
	// => 추상메서드가 하나라도 선언된 클래스는 반드시 추상클래스로 선언 
	// => 자식클래스에서 반드시 부모클래스의 메서드를 반드시 오버라이드 선언하도록 강제성을 제공하는 메서드
	// 추상클래스를 상속받은 자식클래스는 모든 추상 메서드를 무조건 오버라이드 선언해줘야한다. 
	public abstract int computePay();
	
	// 인센티브를 계산하여 반환하는 메서드
	// => 모든 사원에게 급여의 150%를 인센티브로 지급
	
	// 자식클래스에서 메서드를 재정의할수없게 한다
	// => 자식 클래스에서 오버라이드 선언하지 못하도록 final 지정자로 메서드를 선언 
	public final int computeIncentive() {
		// 추상메서드를 호출할 경우 묵시적 객체 형변환에 의해 자식 인스턴스 메서드 호출된다. 
		// => 부모 클래스의 메서드에서 자식 클래스의 메서드 호출
		
		// => 상수필드를 넣을수 있다는 장점이 있다. 
		int incentive = (int)(computePay() * INCETIVE_RATE) ;
		return incentive;
		
	}
}
