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
		System.out.print("실행");
		Scanner sc = new Scanner(System.in);
		int i = 0 ,temp = 0;
		int[] arr2 = new int[7];
	
   loop : while(true) {
	   System.out.print("계속하시겠습니까(y:예,그외:아니오)?n > ");
	   String answer = sc.nextLine();
	   if(!answer.equalsIgnoreCase("y")) {
		   break loop;
	   	}
		System.out.print("게임수=");
		int gameCount = sc.nextInt();
		sc.nextLine();
		do {
			System.out.print(gameCount + "게임=");
			int[] arr = new int[45];
			for(int j = 0; j < arr.length; j++) {
				arr[j] = j + 1;
//				System.out.print(arr[j]); // 1~45까지 넣음 
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
    System.out.println("종료 되었습니다.");
	}
	public static void main(String[] args) {
		new LottoObj().start();
	}
}
/*
	 * 1~45사이의값
	 * 오름차순으로 정렬 
	 * 중복데이터 없어야 함
	 * 컬렉션을 이용하여 만든다.
 실행 
 게임수=5
 1게임=10,24,26,32,38,39, bonus=15
 2게임=10,24,26,32,38,39, bonus=15
 3게임=10,24,26,32,38,39, bonus=15
 4게임=10,24,26,32,38,39, bonus=15
 5게임=10,24,26,32,38,39, bonus=15
 
 계속 하시겠습니까(y:예, 그외:아니오)?y
 게임수=2
  1게임=10,24,26,32,38,39, bonus=15
  2게임=10,24,26,32,38,39, bonus=15
 계속하시겠습니까(y:예,그외:아니오)?n 
*/
