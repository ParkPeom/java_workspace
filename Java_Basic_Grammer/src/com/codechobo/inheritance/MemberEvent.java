package com.codechobo.inheritance;
// 이벤트 관련 회원정보(아이디,이름,이메일)를 저장하기 위한 클래스
// => 회원정보를 저장하는 Member 클래스를 상속받아 작성하는 것을 권장
// 자식 클래스 선언시 extends 키워드로 기존 클래스(부모 클래스) - Super Class를 상속받아 새로운 클래스(자식클래스) 작성
// (자식 클래스 - Sub Class)를 작성
// => 자식 클래스에서 부모 클래스의 필드 또는 메서드에 접근하여 사용 가능 - 상속성(Inheritance)
// => 단일 상속만 가능 - 부모 클래스를 하나만 설정 
// 

public class MemberEvent extends Member {
	
	// 부모 클래스(Member)를 상속받아 사용 가능하므로 필드 미선언 
	/*
	private String id;
	private String name;
	*/
	private String email;
	
	// super : 자식 클래스의 메서드에서 부모 인스턴스를 저장하기 위한 매개변수(키워드)
	// => super 키워드로 부모 인스턴스의 필드 또는 메서드에 접근하여 사용이 가능하다.
	// => super 키워드를 사용하지 않아도 부모 인스턴스의 필드 또는 메서드 접근 가능
	// => this 키워드로 자식 인스턴스의 필드 또는 메서드를 참조 하여 없는 경우 super 키워드로 
	// 부모 인스턴스의 필드 또는 메서드를 참조할수있다. 
		
	// super 키워드를 사용해야 되는 경우 
	// 1. 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출하는 명령은 반드시 첫번째 명령  다른명령을 작성할 경우 에러 
	// => 부모 클래스의 매개변수가 선언된 생성자를 호출하여 부모 인스턴스 필드에 초기값을 설정
	
	
	// 2. 자식클래스의 오버라이드 메서드에서 부모클래스의 숨겨진 메서드를 호출하기 위해 super 키워드 사용
	
	public MemberEvent() {
		// 부모 클래스의 매개변수가 없는 생성자를 호출한다.
		// => 부모 클래스에 매개변수가 없는 생성자가 선언되어 있지 않은 경우 에러
		// 상속때문이다.
		super(); // 명령이 생략되어도 내부적으로 명령이 존재  
	}
	
	/*
	public MemberEvent(String id, String name, String email) {
		super();
		// 자식클래스에서 필드 또는 메서드 접근 순서 : 자식 클래스 참조 >> 부모 클래스 참조
		// => 부모 클래스의 은닉화 선언된 필드 또는 메서드는 접근이 불가능
		// this.id = id;
		super.setId(id); // 자식이 없으면 부모것을 참조한다.
						 // super를 굳이 안붙여도 됨 
//		this.name = name;
		super.setName(name);
//		this.email = email;
		this.email = email;
	}
	*/
	// [Alt] + [Shift] + [S] >> 팝업 메뉴 [0] >> 부모 클래스의 생성자를 선택 >> 필드 선택 >> Generate
	// 부모 클래스의 매개변수가 있는 생성자를 호출 - 부모 인스턴스 필드에 초기값 부여 
	public MemberEvent(String id, String name, String email) {
		super(id, name); // 부모의 id 와 name 를 초기화 할수있게 한다.
						 // 부모에 set메서드 안해도됨
		this.email = email; // 나의 email 를 초기화 시킴 
	}
	
	/*
	public MemberEvent() {
		
	}
	
	public String getId() {
		return super.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	*/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	// 메서드 오버라이딩 : 부모가 준걸 자식이 다르게 하고싶을때(Method Override) : 
	// 상속관계 에서  부모클래스의 메서드를 자식클래스에서 재선언하는 기능 
	// 부모 클래스의 메서드와 같은 형태로 작성한다.
	// => 접근지정자 , 반환형 , 메서드명 , 매개변수 자료형 개수 , 예외 전달 까지 모두 같도록 작성
	// 재선언 하는 기능 - 부모클래스의 메서드를 자식 클래스에서 사용하기 부적절한 경우 메서드를 재선언
	// => 부모 클래스의 메서드를 숨겨지고 자식 클래스의 메서드만 사용 가능
	
	/*
	public void display() {
		System.out.println("아이디 = " + getId());
		System.out.println("이름 = " + getName());
//		display(); 메서드가 자기 자기 호출하면 무한루프에 걸림 -> 재귀호출은 return를 같이써야됨
		super.display(); // 부모클래스에 있는 display 호출 
		System.out.println("이메일 = " + email);
	}
	*/
	// 이클립스에서 부모클래스의 메서드를 자식클래스에서 오버라이드 선언하는 방법 
	
	// 오버라이딩 선언된 부모클래스의 메서드명 입력 >> Crtl + space >> Override 선택
	
	// @Override : 어너테이션 api문서에서 특별한 기능을 설명하기 위해 제공 
	// 오버라이드 메서드를 표현하기 위한 어노테이션(Annotation) 
	// => 오버라이드 작성 규칙을 위반하면 에러가 위반
	// 어노테이션 : API 문서에 특별한 설명을 제공하기 위한 기능 제공
	// => Java Source 에서 특별한 기능을 제공하기 위해 사용 
	
	@Override 
	public void display() {
		// super 키워드로 부모 클래스의 숨겨진 메서드를 호출 할수있다. 
		super.display(); // 부모의 메서드 호출 
		System.out.println("이메일 = " + email);
	}	
}
