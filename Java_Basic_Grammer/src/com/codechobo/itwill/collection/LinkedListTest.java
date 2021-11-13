package com.codechobo.itwill.collection;
import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		
	}
	public void start() {
		// LinkedList�÷��� : �Է¼����� �����Ѵ�.
		//          �Է��� �Ǵ� ����, ����� �Ǵ� ���� ���� �ִ�.
		//          ��ü�� ����� �Ǹ� �÷��ǿ����� ���ŵȴ�.
		LinkedList<String> ll = new LinkedList<String>();
		//��ü �߰�
		ll.offer("ȫ�浿");
		ll.offer("�̼���");
		ll.offer("�������");
		ll.offerFirst("�念��");
		
		//isEmpty() : ��ü�� ������ true, ������ false 
		while(!ll.isEmpty()) {
			String str = ll.pop();// poll()
			System.out.println(str);
		}
		System.out.println("size="+ ll.size());
	}
	public static void main(String[] args) {
		new LinkedListTest().start();
	}
}
