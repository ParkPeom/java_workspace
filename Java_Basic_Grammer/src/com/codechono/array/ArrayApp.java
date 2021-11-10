package com.codechono.array;

public class ArrayApp {
	
	public static void main(String[] args) {
		
		// 1���� �迭�� �����Ͽ� �������� ���� - ���� ) �ڷ���[] ���������� = new �ڷ���[����]
		// => new �ڷ���[����] : �ڷ����� ���� ������ŭ ���� ������ �迭 ����
		// => �ڷ���[] ���������� : 1���� �迭�� �޸� �ּ� (HashCode)�� �����ϱ� ���� ���� ���� 
		// 1���� �迭�� ���(Element)�� �̿��Ͽ� �ټ��� �� ����
		// => �迭�� ��Ҵ� ÷��(index : 0 ���� 1�� �ڵ� �����Ǵ� ������)�� �̿��Ͽ� ���� 
		// => �迭 ������ �迭�� ��Ҵ� �ڵ������� �⺻���� �ڵ� ����ȴ�. (������ : 0 , ������ : flase , ������ : null )
		
		int[] num = new int[3]; // 0���� �ڵ� �ʱ�ȭ  ÷�ڴ� 0 , 1 , 2
		
		System.out.println(num); // [I@123a439b ���������� ����� �޸� �ּ�(�ؽ��ڵ� - 16����) ���
	
		System.out.println("==================");
		// �迭 ������ ����� ���������� ÷�ڸ� �̿��Ͽ� �迭�� ��� ǥ��
		// ����) ����������[÷��] 

		System.out.println("num[0] = " + num[0]);
		System.out.println("num[1] = " + num[1]);
		System.out.println("num[2] = " + num[2]);
	
		// �迭�� ��Ҹ� �����ϴ� ÷�ڸ� �߸� ����� ��� ���ܰ� �߻�
		// => ���ܰ� �߻��� ��� ������ ���α׷� ����(������ �Ҹ�)
		//		System.out.println("num[3] = " + num[3]);  java.lang.ArrayIndexOutOfBoundsException: �迭�� ���� ��� 
		
	// ��������.length : ���������� ����� �迭�� ����� ���� ǥ�� 
		System.out.println("�迭 ����� ���� = " + num.length); // 3
		System.out.println("=========");
		
		int index = 0;
		// �迭�� ��ҿ� ÷�ڴ� ���� ��������� ǥ���� ���� 
		num[index] = 10; // ��Ұ� ���� num[0]
		num[index+1] = 20; // num[1]
		num[index+2] = 30; // num[2]
		
		// for ������ �̿��Ͽ� �迭�� ��ҿ� ���� �ϰ� ó�� 
		
		// => �ʱ�� ���ǽ� �������� �̿��Ͽ� ÷�ڸ� ǥ���Ҽ��ִ�.
		// - �Է� , ���� , ���   
		for(int i = 0; i < num.length; i++) { // for�������ϰ�ó�� ��
			System.out.println("num[" + i +"] = " + num[i]);
		}
		System.out.println("===================");
		// �迭 ������ �迭 ��ҿ� �⺻�� ��� ���ϴ� �ʱⰪ ���� ���� 
		// ����) �ڷ���[] �������� = new �ڷ���[]{�ʱⰪ,�ʱⰪ,...}
		// => ������ �ʱⰪ�� ���� ��ŭ�� ��Ҹ� ���� ��Ҹ� �����ϴ� �迭 ����
		// => new �ڷ���[] ǥ������ ������ ����
		int[] su = new int[] {10,20,30};
		int[] su2 = {10,20,30};
		
		// for ������ �̿��Ͽ� �迭�� ��ҿ� ���� �ϰ�ó��
		// => ������ �ݺ�������(Iterator)�� �̿��Ͽ� ��Ұ��� ���ʴ�� �����޾� ������ �����Ͽ� �ϰ�ó���Ҽ��ִ�.
		
		// ����) for(�ڷ��� ������ : ��������) >> ������ for ���� 
		// => ���������� ����� �迭�� ��Ұ��� ���ʴ�� �����޾� ������ �����Ͽ� �ݺ�ó���Ѵ�.  -- ����� ���  �Է¾ȵ� ��ҿ� �����ϴ°����� �޸𸮿� ���ϴ°��� �ƴϤ��� iterator
		// => �迭�� ��� ��Ұ��� ������ ��� �ݺ��� ���� 
		
		
		// iterator ��� ����� ���� ���ʴ�� �ϳ��ϳ��� �ҷ��� 
		for(int temp : su) { // �迭�� ��Ұ����� temp �� ����� 
			System.out.println(temp + "\t");
		}
		System.out.println();
		System.out.println("====================");
		
		int[] array = {54,42,52,64,42,12,42,53,64,2,12,52,54,21};
		// �迭�� ��� ��Ұ��� ���� �հ� �� ����Ͽ� ����϶�
		int sum = 0;
		for (int number : array	) {
			sum += number;
		}
		System.out.println("��� �հ�� = " + sum);
		// "�迭�� ��Ұ��� 30 ~ 60 ������ ������ ������ ����Ͽ� ����Ͻÿ�

		int count = 0;
		for(int number : array) {
			if(number >= 30 && number <= 60) {
				count++;
			}
		}
		System.out.println(" 30 ~ 60 ������ ��� ���� = " + count);
	}
}
 