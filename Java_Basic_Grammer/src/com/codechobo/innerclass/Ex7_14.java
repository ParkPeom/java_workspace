package com.codechobo.innerclass;

public class Ex7_14 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv; // 1. �ܺ�Ŭ������ private ����� ���� ����
		int iiv2 = outerCv;
	}
	
	static class StaticInner {
//		int siv = outerIv; // ����ƽ Ŭ������ �ܺ� Ŭ������ �ν��Ͻ������ ���� �Ұ�
		static int scv = outerCv;
	}
	
	void myMethod() {
		final int lv = 0; // lv�� �������� ���� �����ϴ� �ڵ尡 �����Ƿ� �����δ� ����� �ٸ� ����.
					// ���� �ٲ��� �ʴ� ������ ����� ���� 
		int LV = 0; // JDK 1.8 ���� final ���� ����
//		lv = 4;
		
		// ����� constant pool �� ���� ���� �޼��尡 ����ǵ� �����ִ�. 
		
		class LocalInner { // 2. ���� ���� Ŭ������ ���ΰ� �ִ� �޼����� ����� ��� ���� 
			int liv = outerIv;
			int liv2 = outerCv;
		// �ܺ� Ŭ������ ���������� final �� ���� ����(���)�� ���� ����
			int liv3  = lv; // ���� �ٲٸ� ����� ���������ʾƼ� ������ ���� 
			int liv4 =  LV;
		
			void method() {
				System.out.println(lv);
			}
		}
	}
}
