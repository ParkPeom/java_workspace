package com.codechobo.itwill.collection;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoObj {
	Random ran = new Random();
	public LottoObj() {
		
	}
	public void startLotto() {
		while(true) {
			int gameCnt = Integer.parseInt(conInput("게임수"));//게임수 입력
			
			//입력받은 게임수 만큼 반복실행
			for(int i=1; i<=gameCnt; i++) {
				//1게임
				createLotto(i);				
			}
			//종료
			String que = conInput("계속하시겠습니까?");
			if(!que.toUpperCase().equals("Y")) {
				break;//반복문 중단
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
	//1게임 만들기
	public void createLotto(int i) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int lastNum;
		while(true) {
			lastNum = ran.nextInt(45)+1;//마지막생성된 번호
			ts.add(lastNum);  // 0~44
			if(ts.size()==7) {
				break;
			}
		}
		
		ts.remove(lastNum);//보너스 번호와 같은 번호를 TreeSet에서 지운다.
		
		System.out.print(i+"게임=");
		// 컬렉션에 있는 값을 [],를 이용하여 문자열로 생성하여 리턴
		System.out.print(ts.toString());
		System.out.println(", bonus="+lastNum);
	}
	//게임수 입력받는 메소드
	public String conInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		String inData = scan.nextLine();
		return inData;
	}
	public static void main(String[] args) {
		new LottoObj().startLotto();
	}
}
/*
 - 1~45사이의 값
 - 오름차순으로 정렬
 - 중복데이터 없어야 함.
 - 컬렉션을 이용하여 만든다.
 
 실행
 게임수=5
 1게임= 10,24,26,32,38,39, bonus=15
 2게임= 10,24,26,32,38,39, bonus=15
 3게임= 10,24,26,32,38,39, bonus=15
 4게임= 10,24,26,32,38,39, bonus=15
 5게임= 10,24,26,32,38,39, bonus=15
 
 계속하시겠습니까(y:예, 그외:아니오)?y
 게임수=2
 1게임= 10,24,26,32,38,39, bonus=15
 2게임= 10,24,26,32,38,39, bonus=15
 
 계속하시겠습니까(y:예, 그외:아니오)?n
 
 */
