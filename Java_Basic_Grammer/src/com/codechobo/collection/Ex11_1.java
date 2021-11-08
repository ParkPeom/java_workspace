package com.codechobo.collection;

import java.util.ArrayList;
import java.util.Collections;

public class Ex11_1 {
	
	public static void main(String[] args) {
		
		// �⺻ ����(�뷮, capacity) �� 10�� ArrayList�� �����Ѵ�. 
		ArrayList list1 = new ArrayList(10);
		// ArrayList���� ��ü�� ���� ���� 
		// autoboxing�� ���� �⺻���� ���������� �ڵ� ��ȯ
		
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		// subList = ArrayList �� ���ο� �κ��� �̾Ƽ� ArrayList�� �����.
		// subList �б� ���� 
		
		// Ǯ��� List sub = list1.subList(1,4);
		// 		  ArrayList list2 = new ArrayList(sub);
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4)); // 1 ~ 3 
		print(list1,list2);
		
		// sort �������� ���� 
		// Collection �� �������̽� , Collections ��ƿ Ŭ����
		// ��ƿ�� = Mathó�� �÷����� �ٷ�� �޼������ �����ϴ°� 
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		// list1 �� list2�� ��� ��Ҹ� ���Խ�Ű�� ? 
		System.out.println("list1.containsAll(list2) : "
				+ list1.containsAll(list2));
		list2.add("B");
		list2.add("C");
		list2.add(3,"A"); // �߰��� ��ġ ���� 
		//  4 2 0 A B C ?
		print(list1,list2);
		
		list2.set(3,"AA"); // ���� ���� �Ѵ�. 
		print(list1,list2);
		
		list1.add(0,"1");
		System.out.println("index="+list1.indexOf(new Integer(1))); // indexOf()�� ������ ��ü�� ��ġ(�ε���)�� �˷��ش�.
		list1.remove(new Integer(1)); // ����Ÿ�� ��ü�� Integer ��ü 1 ����
		list1.remove(5); // �ε��� 5�� �ִ� ��ü ����  
		list1.remove(new Integer(1)); // �ε����� �ƴ� ���� 1�� �����ϰ������ ?
		
		//  list1���� list2�� ��ġ�� �κи� ����� �������� �����Ѵ�.
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		
		print(list1,list2);
		
		//  list2���� list1�� ���Ե� ��ü���� �����Ѵ�.
		for(int i = list2.size()-1; i >=0; i--) {
			if(list1.contains(list2.get(i))) { // 1. get(i)���� list2���� �ϳ��� ������.
											   // 2. contains()�� ���� ��ü�� list1�� �ִ��� Ȯ��
											   // 3. remove(i)�� �ش� ��ü�� list2���� ���� 
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
