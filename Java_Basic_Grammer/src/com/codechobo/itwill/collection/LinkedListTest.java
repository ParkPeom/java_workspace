package com.codechobo.itwill.collection;
import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		
	}
	public void start() {
		// LinkedList컬렉션 : 입력순서를 유지한다.
		//          입력이 되는 곳과, 출력이 되는 곳이 따로 있다.
		//          객체가 출력이 되면 컬렉션에서는 제거된다.
		LinkedList<String> ll = new LinkedList<String>();
		//객체 추가
		ll.offer("홍길동");
		ll.offer("이순신");
		ll.offer("세종대왕");
		ll.offerFirst("장영실");
		
		//isEmpty() : 객체가 없으면 true, 있으면 false 
		while(!ll.isEmpty()) {
			String str = ll.pop();// poll()
			System.out.println(str);
		}
		System.out.println("size="+ ll.size());
	}
	public static void main(String[] args) {
		new LinkedListTest().start();
	}
}
