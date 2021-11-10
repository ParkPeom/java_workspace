package com.codechobo.oop;

import java.util.ArrayList;
import java.util.List;

// this : 메서드에 숨겨져 있는 매개변수(키워드) - 
// => this 매개변수의 자료형은 메서드가 선언된 클래스 
// => 메서드를 호출한 인스턴스의 정보(해쉬코드)를 저장하기 위한 참조변수
// => 인스턴스가 메서드를 호출한 경우 호출 인스턴스의 정보를 자동으로 전달받아 저장한다.
// => this가 있어야 하는 이유는 메서드에서 인스턴스필드 또는 메서드에 접근하기 위해 this를 사용한다.
// => this를 표현하지 않아도 자동으로 인스턴스 필드 또는 메서드에 접근 할수 있다.

// 메서드에 this 매개변수가 존재하는 이유
// => 필드는 인스턴스 마다 메모리(Heap)에 따로 생성되지만 메서드는 인스턴스와 상관없이 
// 메모리(Static)에 하나만 생성된다 - 프로토타입 클래스 
// => 메서드에서 필드에 접근할 경우 this를 이용하여 인스턴스를 구분하여 필드에 접근 가능하도록 this가 필요하다

// this 매개변수를 사용하는 경우
// 1. 필드의 이름과 메서드의 매개변수 이름과 같은 경우 this를 이용하여 필드를 표현할수있다.
// 매개변수에 전달되는 값이 명확하게 알려주기 위해서 필드의이름과 똑같이 한다.
// => this를 사용하지 않으면 매개변수로 처리
// => 매개변수에 전달되어 저장될 값을 명확하게 표현하기 위해 매개변수의 이름을 필드명과 같은 이름으로 설정

// 2. 생성자에서 다른 생성자를 호출하기 위해 this 사용 초기화작업
// => this를 이용하여 생성자를 호출하는 명령전에 다른 명령이 작성할 경우 에러 
// this()를 무조건 맨위에다가 넣어야함 (밑에는 실행이 안되므로)

// 3. 이벤트 처리 프로그램 또는 다중 스레드 프로그램의 메서드에서 인스턴스를 표현할경우
//  this 를 쓴다. 




// 회원정보(아이디,이름,이메일)를 저장하기 위한 클래스
// 값만 저장하는 클래스 = VO클래스(Value Object) 클래스

public class MemberVO {
	
	// 필드(Filed) 선언
	// => 인스턴스 생성시 필드에 기본값이 초기값으로 자동 저장된다.
	// 숫자형:0,논리형:false,참조형:null
	
	// => 인스턴스 생성시 필드에 저장될 기본값 변경도 가능하다. - 명시적 초기화 
	private String id = "NoId"; 
	private String name = "NoName"; 
	private String email = "NoEmail";
	List<MemberVO> arr;
	
	{ 
		// 인스턴스 초기화 블럭 (클래스를 읽어드릴떄 작업을 하는 영역) 
		id = "NOId";
	}
	
	// 생성자(Constructor) 선언
	// => 생성자를 선언하지 않으면 기본생성자가 자동 제공
	// => 생성자 작성 규칙 : 반환형이 없으며 메서드명은 (반드시 클래스명과 동일) 하게 작성
	// => 오버로딩 선언 가능 : 매개변수가 다른 생성자를 여러개 선언가능
	// => 초기화 작업 구현 : 생성자를 이용하여 인스턴스 생성시 필드에 원하는 초기값이 저장되게 한다.
	
	// 매개변수가 없는 기본 생성자 
	// => 일반적으로 초기화 작업 미구현 - 인스턴스 생성시 필드에 기본값을 초기값으로 저장
	// => 선언하지 않을 경우 상속 관련 문제가 발생할 수 있으므로 선언하는 것을 권장 한다.
	// 매개변수가 없는 생성자 자동 완성 : ctrl + space >> 생성자 선택
	
	public MemberVO(){
		// Member(String id,String name, String email) 생성자를 호출하여 초기화 작업
		this("NoId","NoName","NoEmail"); // 맨 첫줄 
		// this를 이용하여 다른 생성자를 호출하는 경우가 매우 적다 
		arr = new ArrayList<MemberVO>();
	}
	
	// => 생성자를 선언하면 기본생성자가 제공되지 않는다.
	
	// 매개변수가 있는 생성자 
	// => 매개변수에 전달된 값을 이용하여 필드의 초기값으로 설정해준다.
	// => 인스턴스 생성시 필드에 원하는 값이 초기값으로 저장되도록 생성자를 작성한다.
	// 매개변수가 있는 생성자 자동 완성 : Alt + Shift + S >> 팝업메뉴 >> [O] >> 필드 선택 >> Generate 완성 
	
	public MemberVO(String id) {
		this.id = id;
	}
	
	public MemberVO(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}

	public MemberVO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	// 메서드(Method) 선언 - setter , getter 만 만든다. 
	public String getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	// 필드값을 출력하는 메서드 >> 필드값을 확인
	// 코드의 중복성을 최소화 한다.
	public void display() {
		System.out.println(this.id);
		System.out.println(this.name);
		System.out.println(this.email);
	}
	
	public void display(List<MemberVO> arr) { // 참조변수 안써도 메서드에 직접 접근이 가능
		for(MemberVO s : arr) {
			System.out.println(s);
		}
	}
}
