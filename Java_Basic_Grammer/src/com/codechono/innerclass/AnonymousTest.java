package com.codechono.innerclass;

public class AnonymousTest {
	
	public AnonymousTest() {}
	
	void start() {	
		// �͸��� ����Ŭ����
		new Sample() {  // �͸�Ŭ���� 
			// Sample ���� �׹� ����Ŭ���� ��� ����
			// �޼��� �������̵�
			public void sum() {
				int s = 0;
				for(int i = 2; i <= 100; i+=2) {
					s += i;
				}
				System.out.println("1~100������ ¦���� ���� " + s);
			}
			// ���ο� �޼��� ���� (Sample �� ������������ �޼���)
			// 3�� ���� ���� ���ϴ� �޼��带 ����
			public void threeSum(int max) {
				int tot=0;
				for(int i = 0; i <= max; i+=3) {
					tot += i;
				}
				System.out.println("1~"+ max +" ������ 3�� ������� " + tot);
			}
			public void fourSum(int min) {
				sum();
			}
		}.fourSum(100);
//		sam.sum();
//		sam.threeSum(10); ���ο� �޼��� ȣ��������..
	}
	public static void main(String[] args) {
		new AnonymousTest().start();	
	}
}
