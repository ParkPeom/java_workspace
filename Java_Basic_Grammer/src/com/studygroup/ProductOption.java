package com.studygroup;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductOption {
	Scanner sc = new Scanner(System.in);
	public ProductOption() {
		
	}
	
	public void �����Ȳ(ArrayList<ProductVO> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getBrandName() + " " + arr.get(i).getMount() + "��"
					+ " ���� = " + arr.get(i).getPrice() +" ��ġ = " + arr.get(i).getPosition() 
					+ " ���� = " + arr.get(i).getManagement());
		}
	}
	public void ����(ArrayList<ProductVO> arr) {
		System.out.print("�����Ͻ� �귣�带 �Է����ּ��� > ");
		String brand = sc.nextLine();
		
		for(int i = 0; i < arr.size(); i++) {
			if(brand.equals(arr.get(i).getBrandName())) {
				System.out.print("�����մϴ�.");
				System.out.println("1. ���� ���� 2. ��ġ ���� 3. ���� ����");
				int num = sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					System.out.print("���� �Է� > ");
					int mount = sc.nextInt();
					arr.get(i).setMount(mount);
					break;
				case 2:
					System.out.print("��ġ �Է� > ");
					String position = sc.nextLine();
					arr.get(i).setPosition(position);
					break;
				case 3:
					System.out.print("���� �Է� > ");
					String manegement = sc.nextLine();
					arr.get(i).setManagement(manegement);
					break;
				}
			}
		}
	}	
	public void �׸��߰�(ArrayList<ProductVO> arr) {
			System.out.print("�߰��Ͻ� �귣�� �̸� > ");
			String brand = sc.nextLine();
			System.out.print("���� > ");
			int price = sc.nextInt();
			System.out.print("���� > ");
			int mount = sc.nextInt();
			sc.nextLine();
			System.out.print("��ġ > ");
			String position = sc.nextLine();
			System.out.print("���� > ");
			String management = sc.nextLine();
			ProductVO p = new ProductVO(brand,price,mount,position,management);
			arr.add(p);
		}
	public void �׸����(ArrayList<ProductVO> arr) {
		int count = 0;
			System.out.print("�����Ͻ� �귣�� �̸� > ");
			String brand = sc.nextLine();
			while(count < arr.size()) { // 0<=5
				if(brand.equals(arr.get(count).getBrandName())) {
					arr.remove(count);
				}
				count++;
			}
			return;
		}
	
	public void ����() {
		System.out.println("�ȳ��� ������");
		System.exit(0);
	}
}
