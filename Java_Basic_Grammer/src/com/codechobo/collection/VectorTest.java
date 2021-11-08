package com.codechobo.collection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VectorTest {
	public VectorTest() {

	}
	
	public Vector getData() {
		//Vector는 List인터페이스를 상속받고 있다
		// 			객체의 입력 순서를 유지하고 있으며 중복 데이터를 허용한다.
		Vector v = new Vector();
		//이름값이 재대로 들어갔는지 
		boolean booStr = v.add(new String("홍길동")); //이름 0
		System.out.println("booStr->"+booStr);
		
		v.addElement(Integer.valueOf(100));//정수형데이터 1  int -> Integer 래퍼클래스객체를반환
										  // Integer.parseInt 원시데이터타입 반환 
		//오늘날짜	
		Calendar date = Calendar.getInstance();
		date.set(2022, 10, 30);
		v.addElement(date); // 2
		//Random
		Random random = new Random();
		v.addElement(random); // 3
		//VO
		MemberVO mVo = new MemberVO(100,"홍길동","010-1234-5678");
		v.addElement(mVo); // 4 
		
		MemberVO mVo2 = new MemberVO();
		mVo2.setNum(300);
		mVo2.setUserid("이순신");
		v.addElement(mVo2); // 5
		
		System.out.println("객체의 수->"+v.size());
		//->Vector에 저장 후 return 
		return v;
	}
	public List<MemberVO> getArrayList() { // E, K, V
		//MemberVO객체 만 담을수 있는 컬렉션 생성하는 방법
//		ArrayList<MemberVO> lst = new ArrayList<MemberVO>();
		List<MemberVO> lst = new ArrayList<MemberVO>();
//		lst.add(new String("홍길동"));
		lst.add(new MemberVO(100,"홍길동","010-1234-5678"));
		lst.add(new MemberVO(200,"김길동","010-4444-5555"));
		lst.add(new MemberVO(300,"박길동","010-5555-9999"));
		lst.add(new MemberVO(400,"최길동","010-7777-9999"));
		
		return lst;
	}
}
