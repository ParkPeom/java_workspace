package com.studygroup;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryMain {
	Scanner sc = new Scanner(System.in);
	static ArrayList<ProductVO> arr = new ArrayList<ProductVO>();
	public InventoryMain() {
		start();
		menu();
	}
	public void start() {
		ProductVO product = new ProductVO("��ǻ��",120000,2,"���","�Ｚ");
		arr.add(product);
		product = null;
		product = new ProductVO("���콺",50000,3,"����","����");
		arr.add(product);
		product = null;
		product = new ProductVO("��ħ��",20000,1,"�Ÿ�","����");
		arr.add(product);
		product = null;
		product = new ProductVO("�����",15000,4,"�д�","�Ｚ");
		arr.add(product);
		product =null;
		product = new ProductVO("������",11000,3,"�Ǳ�","����");
		arr.add(product);
		for(ProductVO p : arr) {
			System.out.println(p.toString());
		}
	}
	public void menu() {
		int num;
		do {
			System.out.print("[1] �����Ȳ");			
			System.out.print("[2] ����(����,��ġ,����)");			
			System.out.print("[3] �׸� �߰�");			
			System.out.print("[4] �׸� ����");			
			System.out.print("[5] ����\n");			
			num = printsetMessage("����");
			switchProduct(num);
		}while(!(1 > num && num > 5));
	}
	
	public int printsetMessage(String msg) {
		System.out.print(msg + "= ");
		int num = sc.nextInt();
		return num;
	}
	
	public void switchProduct(int num) {
		ProductOption p = new ProductOption();
		switch(num) {
		case 1:
			p.�����Ȳ(arr);
			break;
		case 2:
			p.����(arr);
			break;
		case 3:
			p.�׸��߰�(arr);
			break;
		case 4:
			p.�׸����(arr);
			break;
		case 5:
			p.����();
			break;
		}
	menu();
	}
	
	
	public static void main(String[] args) {
		new InventoryMain().start();
	}

}
