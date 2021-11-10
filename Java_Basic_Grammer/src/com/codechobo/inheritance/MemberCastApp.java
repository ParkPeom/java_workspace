package com.codechobo.inheritance;

// 상속 관계의 클래스에 대한 참조변수와 인스턴스 
public class MemberCastApp {
	
	public static void main(String[] args) {
		// 부모클래스 참조변수 = new 부모클래스(); : 가능
		// => 부모 인스턴스를 생성하여 부모 참조변수에 부모 인스턴스 저장
		Member member1 = new Member();
		// 참조변수를 이용해서 부모 인스턴스의 메서드를 호출
		member1.display();
		member1.setId("aaa");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("==================================================");
		
		MemberEvent member2 = new MemberEvent(); // super() 부모 인스턴스가 만들어지고 나서 자식인스턴스가 만들어
		// 자식 참조변수에 자식 인스턴스가 저장됨
		// 참조변수를 이용하여 자식 인스턴스의 메서드 호출
		// => 상속으로 인해 자식 인스턴스를 부모 인스턴스를 참조할수 있으므로 참조변수는 
		// 부모 인스턴스의 메서드 호출 가능 
		member2.setId("bbb");
		member2.setName("김지훈");
		member2.setEmail("zkokopo@naver.com"); // 자식꺼
		member2.display(); 
		System.out.println("==================================================");

		// 자식클래스 참조변수 = new 부모클래스() 
		// MemberEvent member3 = new Member(); 못만듬 불가능(에러 발생)
		// => 자식 참조변수에는 자식 인스턴스를 저장할수있지만 자식 인스턴스가 생성되지 않아 
		// 참조변수에 인스턴스를 저장할 수 없으므로 에러가 발생 
		
		
		// 부모클래스로부터 참조변수 = new 자식클래스();
		// => 부모 인스턴스와 자식 인스턴스를 생성하여 부모 참조변수에 부모 인스턴스를 저장한다.
		// 참조변수를 이용하여 부모 인스턴스 메서드 호출 
		// => 자식 인스턴스의 메서드 호출 불가능 
		
		Member member3 = new MemberEvent();
		// member3은 부모만 참조
		member3.setId("ccc");
		member3.setName("김홍철");
		
		// 객체 형변환을 이용하면 부모클래스의 참조변수로 자식 인스턴스의 메서드 호출 가능
		// => 명시적 객체 형변환(강제 형변환) , 묵시적 객체 형변환(자동 형변환)
		
		
		MemberEvent member4 = (MemberEvent)member3;
		member4.setEmail("zkokopo@naver.com");
		
		
		// 명시적 객체 형변환 : 참조 변수의 자료형(클래스)을 자식 클래스로 변경하면 
		// 일시적으로 참조 변수에 자식 인스턴스가 자동으로 저장된다.
		// 형식) (자식클래스)참조변수 >> Cast 연산자 이용 
		// => 명시적 객체 형변환에 의해 변경된 자료형이 변경된 참조변수를 이용해서 부모 인스턴스와 자식 인스턴스의
		// 메서드를 호출 할수 있다.  
		
		// 자식 인스턴스의 메서드를 지속적으로 호출하여 사용하고자 할 경우 객체 형변환 후 명시적 객체 형변환 후
		// 저장된 자식 인스턴스를 새로운 자식 참조변수에 저장 하여 사용 
		
		/*
		MemberEvent event = (MemberEvent)member4;
		event.setEmail("gogogo");
		event.setId("id");
		event.setName("name");
		*/
		
		// 자식 인스턴스에 메서드를 한번만 호출 하고자 할 경우 
		// 객체 형변환 후 직접 메서드를 호출 할수 있다.
		((MemberEvent)member4).setEmail("ddd@naver.com");
		// 형변환이 먼저 될수 있도록 ()  연산자 우선순위 고려 
		// 왜? 형변환 보다 .이 먼저 되니까 
		
		// 묵시적 객체 형변환(자동으로 형변환 : 자식 클래스에서 오버라이드 선언된 메서드는 부모클래스의 숨겨진 
		// 메서드 대신 자식 클래스의 메서드를 호출하기 위해 묵시적 객체 형변환이 발생한다)
		// => 참조변수의 자료형이 자동으로 자식 클래스로 변경되어 참조변수에 자식 인스턴스가 저장된다.
		member4.display();
		
		System.out.println("======================");
		
		
		// 내일 자식을 구분하는 instanceof , object 클래스 를 볼것임
		// final , abstract 
		
		MemberEvent member5 = new MemberEvent();
		
		if(member5 instanceof Member) {
			((Member)member5).display();
		} else if(member5 instanceof MemberEvent) {
			 member5.display();
		}
	}
}