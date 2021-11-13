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
		//Map�������̽�
		// key�� value�� �����Ѵ�.
		// �Է¼����� �������� �ʰ� key�� �ߺ��� ������� �ʴ´�.
		// value�� �ߺ��� ����Ѵ�.
		// 100->ȫ�浿
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(100, "ȫ�浿");
		hm.put(200, "�̼���");
		hm.put(300, "�������");
		hm.put(400, "�念��");
		hm.put(500, "�������2");
		hm.put(600, "�念��2");
		
		//=== key�� �̿��Ͽ� ��ü ������
		String value= hm.get(300);
		System.out.println("300->"+ value);
		
		Set<Integer> keySet = hm.keySet();
		
		Iterator<Integer> keyIterator = keySet.iterator();
		TreeSet<Integer> keyList = new TreeSet<Integer>();//key�� ���� ��ü
		List<Integer> keyArrayList = new ArrayList<Integer>(); 
		
		while(keyIterator.hasNext()) {
			int k = keyIterator.next();
			String name = hm.get(k);
			System.out.println(k+"---->"+ name);
			
			keyList.add(k);
			keyArrayList.add(k);
		}
		//Map�� ������ ��ȣ������ ���////////////
		System.out.println("--------------------------");
		Iterator<Integer> ii = keyList.iterator();//Ű�� ������������ ���ĵǾ��ִ�
		while(ii.hasNext()) {
			int kk = ii.next();
			String v = hm.get(kk);
			System.out.println(kk+"===>"+ v);
		}
		
		//Collections�� sort�޼ҵ带 �̿��Ͽ� key �����ϱ�
		System.out.println("List�� key�� Collections.sort()�� �����ϱ�");
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
