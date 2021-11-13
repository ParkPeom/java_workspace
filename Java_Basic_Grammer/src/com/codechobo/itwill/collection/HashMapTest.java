package com.codechobo.itwill.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashMapTest {

	public HashMapTest() {
		
	}
	public void start() {
		//Map인터페이스
		// key와 value가 존재한다.
		// 입력순서를 유지하지 않고 key는 중복을 허용하지 않는다.
		// value는 중복을 허용한다.
		// 100->홍길동
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(100, "홍길동");
		hm.put(200, "이순신");
		hm.put(300, "세종대왕");
		hm.put(400, "장영실");
		hm.put(500, "세종대왕2");
		hm.put(600, "장영실2");
		
		//=== key를 이용하여 객체 얻어오기
		String value= hm.get(300);
		System.out.println("300->"+ value);
		
		Set<Integer> keySet = hm.keySet();
		
		Iterator<Integer> keyIterator = keySet.iterator();
		TreeSet<Integer> keyList = new TreeSet<Integer>();//key를 담을 객체
		List<Integer> keyArrayList = new ArrayList<Integer>(); 
		
		while(keyIterator.hasNext()) {
			int k = keyIterator.next();
			String name = hm.get(k);
			System.out.println(k+"---->"+ name);
			
			keyList.add(k);
			keyArrayList.add(k);
		}
		//Map의 정보를 번호순으로 출력////////////
		System.out.println("--------------------------");
		Iterator<Integer> ii = keyList.iterator();//키가 오름차순으로 정렬되어있다
		while(ii.hasNext()) {
			int kk = ii.next();
			String v = hm.get(kk);
			System.out.println(kk+"===>"+ v);
		}
		
		//Collections의 sort메소드를 이용하여 key 정렬하기
		System.out.println("List의 key를 Collections.sort()로 정렬하기");
		Collections.sort(keyArrayList);
		for(int i=0; i<keyArrayList.size(); i++) {
			int kk = keyArrayList.get(i);
			String vv = hm.get(kk);
			System.out.println(kk+"==>"+vv);
		}
	}
	public static void main(String[] args) {
		new HashMapTest().start();
	}
}
