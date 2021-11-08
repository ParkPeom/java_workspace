package com.codechobo.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		
	}

	public void start() {
		int[] num = {56,45,42,56,47,55,12,32,12,45};
	
		// TreeSet컬렉션 : 중복데이터 허용하지 않는다.
		//		입력순서를 유지하지 않는다.
		//		크기순으로 (기본 오름차순) 정렬된다.
		//  root 뿌리 56에서 크면 오른쪽 내리면 왼쪽
		//  가지치기 
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		for(int n : num) {
			ts.add(n); // 오토박싱
		}

		// TreeSet 에서 내림차순으로 객체를 가져옴 
		Iterator<Integer> ii = ts.descendingIterator();
		while(ii.hasNext()) {
			System.out.println(ii.next());
		}
		System.out.println("================");
		Iterator<Integer> iii = ts.iterator();
		
		while(iii.hasNext()) {
			System.out.println(iii.next());
		}
	}
	
	public static void main(String[] args) {
		new TreeSetTest().start();
	}
}
