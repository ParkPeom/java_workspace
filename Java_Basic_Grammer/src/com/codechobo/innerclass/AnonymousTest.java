package com.codechobo.innerclass;
public class AnonymousTest {
	AnonymousTest(){}
	void start() {
		//�͸��� ����Ŭ����
		new Sample() {
			//�͸�Ŭ����
			//�޼ҵ� �������̵�
			public void sum() {
				int s=0;
				for(int i=2; i<=100; i+=2) {
					s += i;
				}
				System.out.println("1~100������ ¦���� ���� "+ s);
			}
			//���ο� �޼ҵ� ����	
			//3�� ����� ���� ���ϴ� �޼ҵ带 ����
			public void threeSum(int max) {
				int total = 0;
				for(int n=0; n<=max ; n+=3) {
					total+= n;
				}
				System.out.println("1~"+max+"������ 3�ǹ���� ���� "+ total);
			}
		}.threeSum(100);
		//sam.sum();
		//sam.threeSum(10);
	}	
	public static void main(String[] args) {
		new AnonymousTest().start();
	}
}
