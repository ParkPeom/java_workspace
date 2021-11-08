package com.codechobo.collection;

import java.util.ArrayList;
import java.util.Collections;

public class Ex11_1 {
	
	public static void main(String[] args) {
		
		// 기본 길이(용량, capacity) 가 10인 ArrayList를 생성한다. 
		ArrayList list1 = new ArrayList(10);
		// ArrayList에는 객체만 저장 가능 
		// autoboxing에 의해 기본형이 참조형으로 자동 변환
		
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		// subList = ArrayList 에 새로운 부분을 뽑아서 ArrayList를 만든다.
		// subList 읽기 전용 
		
		// 풀어쓰면 List sub = list1.subList(1,4);
		// 		  ArrayList list2 = new ArrayList(sub);
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // 1 ~ 3 
		print(list1,list2);
		
		// sort 오름차순 정렬 
		// Collection 은 인터페이스 , Collections 유틸 클래스
		// 유틸성 = Math처럼 컬렉션을 다루는 메서드들을 제공하는것 
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		// list1 이 list2를 모든 요소를 포함시키나 ? 
		System.out.println("list1.containsAll(list2) : "
				+ list1.containsAll(list2));
		list2.add("B");
		list2.add("C");
		list2.add(3,"A"); // 추가할 위치 지정 
		//  4 2 0 A B C ?
		print(list1,list2);
		
		list2.set(3,"AA"); // 값을 변경 한다. 
		print(list1,list2);
		
		list1.add(0,"1");
		System.out.println("index="+list1.indexOf(new Integer(1))); // indexOf()는 지정된 객체의 위치(인덱스)를 알려준다.
		list1.remove(new Integer(1)); // 여러타입 객체중 Integer 객체 1 지움
		list1.remove(5); // 인덱스 5에 있는 객체 삭제  
		list1.remove(new Integer(1)); // 인덱스가 아닌 숫자 1를 삭제하고싶으면 ?
		
		//  list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		
		print(list1,list2);
		
		//  list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i = list2.size()-1; i >=0; i--) {
			if(list1.contains(list2.get(i))) { // 1. get(i)으로 list2에서 하나씩 꺼낸다.
											   // 2. contains()로 꺼낸 객체가 list1에 있는지 확인
											   // 3. remove(i)로 해당 객체를 list2에서 삭제 
				list2.remove(i);
			}
			print(list1,list2);
		}
	}
	public static void print(ArrayList list1 , ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}
}
