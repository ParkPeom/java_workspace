package com.codechobo.api;

public class WrapperClass {

	public WrapperClass() {
		// Wrapper Ŭ������ �⺻���������� ��ü������ ��ȯ�ϴ� Ŭ�������� ���Ѵ�.
		// ���� : Byte, Short, Integer, Long
		// �Ǽ� : Float, Double
		// �� : Boolean
		// ���� : Character
		
		int num = 130;
		Integer numObj = new Integer(num);
		Integer numObj2 = Integer.valueOf(num);
		Integer numObj3 = num; // autoboxing: �⺻���������� ��ü������ �ڵ����� ��ȯ�Ǵ� �� 
		System.out.println("����Ʈ��->"+ numObj3.BYTES);//����Ʈũ��
		System.out.println("��Ʈ��->"+ numObj3.SIZE);//��Ʈ��
		System.out.println("ū��->"+ numObj3.MAX_VALUE);
		System.out.println("��������->"+ numObj3.TYPE);
		
		System.out.println(Byte.MAX_VALUE);
		byte numByte =(byte)num; //  -128~127
		System.out.println("numByte="+numByte);
		
		//IntegerŬ������ byteŸ������ �����ϴ� �޼ҵ� ã��
		byte numByte2 = numObj3.byteValue();
		System.out.println("numByte2="+numByte2);
		
		System.out.println("100�� 16����->"+ Integer.toHexString(100));
		System.out.println(num+"�� 16����->"+ Integer.toHexString(numObj3));
		
		int num4 = numObj3; // autounboxing:��ü���� �⺻������������ ��ȯ�Ͽ� ���Եȴ�.
	}

	public static void main(String[] args) {
		new WrapperClass();

	}

}
