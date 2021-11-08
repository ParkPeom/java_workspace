package com.codechobo.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {

	}

	public void start() {
		// Set : 입력순서를 유지하지 않는다.
		//		중복데이터를 허용하지 않는다
		// 빼낼때 순서가없다 
		HashSet<Integer> hs1 = new HashSet<Integer>();
		
		int[] data = {25,65,45,43,12,53,65,57,45,30};
		
		for(int d : data) {
			hs1.add(d);
		}
		// HashSet은 객체를 얻어오는 메소드가 없으므로 Iterator객체를 이용하여야 한다.
		Iterator<Integer> ii = hs1.iterator();	
		while(ii.hasNext()) {
			System.out.println(ii.next());
		}
		
		String[] names = {"홍길동","이순신","세종대왕","이순신","홍길동","홍길동"};
		HashSet<String> hs2 = new HashSet<String>();
		for(String s : names) {
			hs2.add(s);
		}
		Iterator iii = hs2.iterator();
		while(iii.hasNext()) {
			System.out.println(iii.next());
		}
	}
	
	public static void main(String[] args) {
		new HashSetTest().start();
	}

}
