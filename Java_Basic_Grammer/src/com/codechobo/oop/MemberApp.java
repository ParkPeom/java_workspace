package com.codechobo.oop;

import java.util.ArrayList;
import java.util.List;

public class MemberApp {
	
	public static void main(String[] args) {
		// new 연산자로 매개변수가 없는 기본 생성자를 호출하여 인스턴스를 생성
		// => 인스턴스의 필드에는 기본값으로 자동 초기화
		// => new연산자로 호출한 생성자가 없는 경우 에러 발생 - 인스턴스 생성 불가 
		
		// new연산자는 특별한 메서드이며 . 연산자로 호출할 수 없다.
		MemberVO member1 = new MemberVO();
		List<MemberVO> arr = new ArrayList<MemberVO>();
		
		// Getter 메서드를 호출하여 인스턴스의 필드값을 반환받아 출력
		System.out.println("아이디 = " + member1.getId());
		System.out.println("이름 = " + member1.getName());
		System.out.println("이메일 = " + member1.getEmail());
		System.out.println("===============================================================");
		
		// Setter 메서드를 호출하여 매개변수에 전달값을 이용하여 필드값 변경
		member1.setId("aaa");
		member1.setName("홍길동");
		member1.setEmail("aaa@daum.net");
		
		System.out.println("아이디 = " + member1.getId());
		System.out.println("이름 = " + member1.getName());
		System.out.println("이메일 = " + member1.getEmail());
		System.out.println("===============================================================");
		member1.display(arr);
		System.out.println("===============================================================");
		
		
		member1 = null;
		member1 = new MemberVO("bbb","김경순","bbb@daum.net");
		arr.add(member1);
		
		member1 = null;
		member1 = new MemberVO("ccc","이지훈","ccc@daum.net");
		arr.add(member1);
		member1.display(arr);
	
		System.out.println("==========================================");

		MemberVO member2 = new MemberVO("BBB");
		// 값을 하나만 넣으면 나머지 값이 null 값이 나온다.
		member2.display();
		
		MemberVO member3 = new MemberVO("CCC","임꺽정");
		member3.display();
		System.out.println("==========================================");
		
	}	
}
