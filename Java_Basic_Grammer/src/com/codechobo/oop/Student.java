package com.codechobo.oop;

//지정자(Modifier) : 클래스, 필드, 메소드 선언시 특별한 기능을 제공하기 위한 키워드
//=> 접근 지정자(Access Modifier) : private, package(default), protected, public
//=> static, final, abstract

//static : 인스턴스에 상관없이 클래스로 접근하기 위한 필드 또는 메소드를 선언할 때 사용하는 지정자
//=> 클래스는 내부 클래스인 경우에만 static 지정자 사용 가능

//학생정보(학번,이름,국어,영어,총점)를 저장하기 위한 클래스
public class Student {
	//인스턴스 필드(Instance Field) : 인스턴스 생성시 인스턴스에 만들어지는 필드
	// => 인스턴스로 접근하여 사용
	private int num;
	private String name;
	private int kor,eng,tot;
	
	//정적 필드(Static Field) : 클래스 사용시 클래스(Clazz)에 만들어지는 필드
	// => 인스턴스에 상관없이 메모리에 무조건 하나만 생성되는 필드
	// => 생성자에서 초기화하지 않고 필드 선언시 직접 초기화
	// => 모든 인스턴스에서 사용 가능 : 공유값 - 메모리 절약 및 필드값 변경 용이
	// => 클래스로 접근하여 사용
	private static int total; // 총학생들점수
	
	//생성자(Constructor) : 인스턴스를 생성하는 특별한 메소드 
	// => 인스턴스 필드에 기본값이 아닌 초기값을 저장하기 위해 선언
	public Student() {

	}

	public Student(int num, String name, int kor, int eng) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
		//총점을 계산하여 필드에 저장하는 명령 작성 - 메소드 호출
		// => 코드의 중복을 최소화 하여 유지보수의 효율성 증가
		//tot=kor+eng;
		calcTot(); // 은닉화 처리된 메서드 생성자로 호출시 메서드 호출시킴 , 추가할때마다 총점들이 더해짐
	}
	
	//인스턴스 메소드(Instance Method) : this 매개변수가 존재하는 메소드
	// => this를 이용하여 인스턴스 필드에 접근하여 사용 가능
	// => 정적 필드에 접근하여 사용 가능
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calcTot();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calcTot();
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	//총점을 계산하여 필드에 저장하는 메소드
	/*
	public void calcTot() {
		tot=kor+eng;
	}
	*/
	// 총합 - 은닉화처리된 메서드
	//은닉화 처리된 메소드 : 클래스 내부에서만 호출하여 사용하는 메소드 - 시스템 메소드
	private void calcTot() { // 총합 
		tot=kor+eng;
	}
	
	//필드값을 출력하는 메소드 - 필드값 확인
	public void display() {
		System.out.print(name+"["+num+"]의 성적 >> ");
		System.out.println("국어 = "+kor+", 영어 = "+eng+", 총점 = "+tot);
	}

	//정적 메소드(Static Method) : this 매개변수가 존재하지 않는 메소드
	// => this 매개변수가 없으므로 인스턴스 필드 접근 불가능
	// => 정적 필드는 접근하여 사용 가능
	// => 인스턴스와 상관없이 클래스를 이용하여 메소드 호출 가능
	
	public static int getTotal() {
		return total; // 총학생들 점수
	}

	public static void setTotal(int total) {
		Student.total = total; // 정적 
	}
}
