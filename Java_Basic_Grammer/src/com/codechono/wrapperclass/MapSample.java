package com.codechono.wrapperclass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapSample {

	public MapSample() {
	}
	
	public static void main(String[] args) {
		
		Map<Integer,String> hashmap = new HashMap<Integer,String>();
		
		hashmap.put(0, "영");
		hashmap.put(1, "일");
		hashmap.put(2, "이");
		hashmap.put(4, "삼");
		hashmap.put(3, "사");
		
		// key 값 , value 값 
		Iterator keys = hashmap.keySet().iterator();
		while(keys.hasNext()) {
			System.out.println("키 값 = " + keys.next());
		}
		// key 값 과 value 값
		Set set2 = hashmap.entrySet(); // 키와 value 집합 - entry
		Iterator iterator2 = set2.iterator();
		while(iterator2.hasNext()) {
			Entry<Integer,String> entry = (Entry)iterator2.next();  
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("hashmap key : " + key);
			System.out.println("hashmap value : " + value);
		}
	}
}
