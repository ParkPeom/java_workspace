package com.codechobo.itwill.collection;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public TreeSetTest() {
		
	}
	public void start() {
		int num[] = {56,45,42,56,47,55,12,32,12,45};
		
		// TreeSet�÷��� : �ߺ������� ������� �ʴ´�.
		//               �Է¼����� �������� �ʴ´�.
		//               ũ������� (������������) ���ĵȴ�.
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int n: num) {
			ts.add(n);
		}
		
		// Tree���� ������������ ��ü�� �����´�.
		Iterator<Integer> ii = ts.descendingIterator();
		while(ii.hasNext()) {
			System.out.println(ii.next());
		}
		System.out.println("================");
		Iterator<Integer> iii =ts.iterator();
		while(iii.hasNext()) {
			System.out.println(iii.next());
		}
	}
	public static void main(String[] args) {
		new TreeSetTest().start();
	}
}
