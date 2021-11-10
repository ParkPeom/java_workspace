package com.codechobo.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class StringTest {

	public static void main(String[] args) {
		
		List<Integer> ar = new ArrayList();
		ar.add(1);
		ar.add(7);
		ar.add(6);
		ar.add(8);
		ar.add(2);
		Iterator iter = ar.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
		}
		TreeSet ts = new TreeSet(ar);
		
		System.out.println(ts);
		
		List<Integer> ar2 = new ArrayList();
		ar2.add(1);
		ar2.add(8);
		ar2.add(9);
		ar2.add(8);
		ar2.add(0);
		ar2.add(4);
		
		HashSet hs = new HashSet(ar2);
		System.out.println(hs);
	}
}
