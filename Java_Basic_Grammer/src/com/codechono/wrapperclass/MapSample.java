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
		
		hashmap.put(0, "��");
		hashmap.put(1, "��");
		hashmap.put(2, "��");
		hashmap.put(4, "��");
		hashmap.put(3, "��");
		
		// key �� , value �� 
		Iterator keys = hashmap.keySet().iterator();
		while(keys.hasNext()) {
			System.out.println("Ű �� = " + keys.next());
		}
		// key �� �� value ��
		Set set2 = hashmap.entrySet(); // Ű�� value ���� - entry
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
