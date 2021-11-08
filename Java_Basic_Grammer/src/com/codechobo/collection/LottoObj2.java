package com.codechobo.collection;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoObj2 {
	Random ran = new Random();
	public LottoObj2() {
	
	}
	public void startLotto() {
		while(true) {
			int gameCnt = Integer.parseInt(conInput("���Ӽ�"));//���� �� �Է�		
			
			//�Է¹��� ���Ӽ� ��ŭ �ݺ�����
			for(int i=1; i <= gameCnt; i++) {
				//1����
				createLotto(i);
			}
			//����
			String que = conInput("��� �Ͻðڽ��ϱ�?");
			if(!que.toUpperCase().equals("Y")) {
				break;//�ݺ��� �ߴ�
			}
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
	//1���� �����
	public void createLotto(int i) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int lastNum;
		while(true) {
			lastNum = ran.nextInt(45)+1;//�������������� ��ȣ
			ts.add(lastNum); // 1~45
			if(ts.size()==7) {
				break;
			}
		}
		
		ts.remove(lastNum);//���ʽ� ��ȣ�� ���� ��ȣ�� TreeSet���� �����.
		
		System.out.print(i+"����=");
		// �÷��ǿ� �ִ� ���� [],�� �̿��Ͽ� ���ڿ��� �����Ͽ� ���� 
		System.out.print(ts.toString());
		System.out.println(", bonus="+lastNum);
	}
	//���Ӽ� �Է¹��� �޼ҵ� 
	public String conInput(String msg) {
		// Random, Math.random()
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		String inData = scan.nextLine();
		return inData;
	}
	public static void main(String[] args) {
		new LottoObj2().startLotto();
	}
}