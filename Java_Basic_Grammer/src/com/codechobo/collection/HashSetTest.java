package com.codechobo.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {

	}

	public void start() {
		// Set : �Է¼����� �������� �ʴ´�.
		//		�ߺ������͸� ������� �ʴ´�
		// ������ ���������� 
		HashSet<Integer> hs1 = new HashSet<Integer>();
		
		int[] data = {25,65,45,43,12,53,65,57,45,30};
		
		for(int d : data) {
			hs1.add(d);
		}
		// HashSet�� ��ü�� ������ �޼ҵ尡 �����Ƿ� Iterator��ü�� �̿��Ͽ��� �Ѵ�.
		Iterator<Integer> ii = hs1.iterator();	
		while(ii.hasNext()) {
			System.out.println(ii.next());
		}
		
		String[] names = {"ȫ�浿","�̼���","�������","�̼���","ȫ�浿","ȫ�浿"};
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
