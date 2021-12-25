package com.studygroup;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductOption {
	Scanner sc = new Scanner(System.in);
	public ProductOption() {
		
	}
	
	public void 재고현황(ArrayList<ProductVO> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getBrandName() + " " + arr.get(i).getMount() + "대"
					+ " 가격 = " + arr.get(i).getPrice() +" 위치 = " + arr.get(i).getPosition() 
					+ " 관리 = " + arr.get(i).getManagement());
		}
	}
	public void 수정(ArrayList<ProductVO> arr) {
		System.out.print("수정하실 브랜드를 입력해주세요 > ");
		String brand = sc.nextLine();
		
		for(int i = 0; i < arr.size(); i++) {
			if(brand.equals(arr.get(i).getBrandName())) {
				System.out.print("존재합니다.");
				System.out.println("1. 수량 변경 2. 위치 변경 3. 관리 변경");
				int num = sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					System.out.print("수량 입력 > ");
					int mount = sc.nextInt();
					arr.get(i).setMount(mount);
					break;
				case 2:
					System.out.print("위치 입력 > ");
					String position = sc.nextLine();
					arr.get(i).setPosition(position);
					break;
				case 3:
					System.out.print("관리 입력 > ");
					String manegement = sc.nextLine();
					arr.get(i).setManagement(manegement);
					break;
				}
			}
		}
	}	
	public void 항목추가(ArrayList<ProductVO> arr) {
			System.out.print("추가하실 브랜드 이름 > ");
			String brand = sc.nextLine();
			System.out.print("가격 > ");
			int price = sc.nextInt();
			System.out.print("수량 > ");
			int mount = sc.nextInt();
			sc.nextLine();
			System.out.print("위치 > ");
			String position = sc.nextLine();
			System.out.print("관리 > ");
			String management = sc.nextLine();
			ProductVO p = new ProductVO(brand,price,mount,position,management);
			arr.add(p);
		}
	public void 항목삭제(ArrayList<ProductVO> arr) {
		int count = 0;
			System.out.print("삭제하실 브랜드 이름 > ");
			String brand = sc.nextLine();
			while(count < arr.size()) { // 0<=5
				if(brand.equals(arr.get(count).getBrandName())) {
					arr.remove(count);
				}
				count++;
			}
			return;
		}
	
	public void 종료() {
		System.out.println("안녕히 가세요");
		System.exit(0);
	}
}
