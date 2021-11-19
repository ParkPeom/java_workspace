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
		ProductVO product = new ProductVO("컴퓨터",120000,2,"용산","삼성");
		arr.add(product);
		product = null;
		product = new ProductVO("마우스",50000,3,"강남","엘지");
		arr.add(product);
		product = null;
		product = new ProductVO("받침대",20000,1,"신림","엘지");
		arr.add(product);
		product = null;
		product = new ProductVO("모니터",15000,4,"분당","삼성");
		arr.add(product);
		product =null;
		product = new ProductVO("프린터",11000,3,"판교","엘지");
		arr.add(product);
		for(ProductVO p : arr) {
			System.out.println(p.toString());
		}
	}
	public void menu() {
		int num;
		do {
			System.out.print("[1] 재고현황");			
			System.out.print("[2] 수정(수량,위치,관리)");			
			System.out.print("[3] 항목 추가");			
			System.out.print("[4] 항목 삭제");			
			System.out.print("[5] 종료\n");			
			num = printsetMessage("선택");
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
			p.재고현황(arr);
			break;
		case 2:
			p.수정(arr);
			break;
		case 3:
			p.항목추가(arr);
			break;
		case 4:
			p.항목삭제(arr);
			break;
		case 5:
			p.종료();
			break;
		}
	menu();
	}
	
	
	public static void main(String[] args) {
		new InventoryMain().start();
	}

}
