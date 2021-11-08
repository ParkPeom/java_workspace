package com.codechobo.collection;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
/*
 * TreeSet 
 */
public class LottoObj {
	
	public LottoObj() {

	}
	public void start() {
		System.out.print("����");
		Scanner sc = new Scanner(System.in);
		int i = 0 ,temp = 0;
		int[] arr2 = new int[7];
	
   loop : while(true) {
	   System.out.print("����Ͻðڽ��ϱ�(y:��,�׿�:�ƴϿ�)?n > ");
	   String answer = sc.nextLine();
	   if(!answer.equalsIgnoreCase("y")) {
		   break loop;
	   	}
		System.out.print("���Ӽ�=");
		int gameCount = sc.nextInt();
		sc.nextLine();
		do {
			System.out.print(gameCount + "����=");
			int[] arr = new int[45];
			for(int j = 0; j < arr.length; j++) {
				arr[j] = j + 1;
//				System.out.print(arr[j]); // 1~45���� ���� 
			}
			for(int k = 0; k < 500; k++)	{
				int random = (int)(Math.random()*44) + 0;
				temp = arr[0];
				arr[0] = arr[random];
				arr[random] = temp;
			}
				for(i = 0 ; i < 7; i++) {
					arr2[i] = arr[i];
			}				
				TreeSet<Integer> ts = new TreeSet<Integer>();			
			for(int n : arr2) {
				ts.add(n);
			}
			Iterator<Integer> ii = ts.iterator();
			while(ii.hasNext()) {
				System.out.print(ii.next() + " ");
				}
				System.out.println();
				gameCount--;
				
			} while(gameCount > 0 );
		}
    System.out.println("���� �Ǿ����ϴ�.");
	}
	public static void main(String[] args) {
		new LottoObj().start();
	}
}
/*
	 * 1~45�����ǰ�
	 * ������������ ���� 
	 * �ߺ������� ����� ��
	 * �÷����� �̿��Ͽ� �����.
 ���� 
 ���Ӽ�=5
 1����=10,24,26,32,38,39, bonus=15
 2����=10,24,26,32,38,39, bonus=15
 3����=10,24,26,32,38,39, bonus=15
 4����=10,24,26,32,38,39, bonus=15
 5����=10,24,26,32,38,39, bonus=15
 
 ��� �Ͻðڽ��ϱ�(y:��, �׿�:�ƴϿ�)?y
 ���Ӽ�=2
  1����=10,24,26,32,38,39, bonus=15
  2����=10,24,26,32,38,39, bonus=15
 ����Ͻðڽ��ϱ�(y:��,�׿�:�ƴϿ�)?n 
*/
