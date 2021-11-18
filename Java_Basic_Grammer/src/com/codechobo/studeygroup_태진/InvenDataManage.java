package com.codechobo.studeygroup_����;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvenDataManage {
	
	List<InvenVO> lst = InvenDataSheet.DataSet();
	InvenLogin il = new InvenLogin();
	
	public InvenDataManage() {
		
	}
	//�Է�
	public String getInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.println(msg+"=");
		return scan.nextLine();
	}
	
	//üũ �� VO.StandOutput ���
	//�޴���� (1 : �����Ȳ, 2 : ����_����,��ġ,������, 3 : ��ǰ �߰�, 4 : ��ǰ ����, 5 : ����)
	//2-> arraylist index ��ȣ(��ǰ������ Ȯ��) -> ������ �׸� ���� ->
	//		1. ����, 2. ��ġ, 3. ������ -> ������ �Է� -> ������ ��Ȳ ��� �� �޴� ���
	//3-> arraylist�� index �߰� �� �� set������ �� �߰� �� �޴� ���
	//4-> arraylist���� index ��ȣ(��ǰ��)�Է½� ���� �� �޴����
	//5-> ����޼��� ���
	
	public void login() {
		String loginId = getInput("���̵� �Է����ּ���");
		String loginPw = getInput("�н����带 �Է����ּ���");
		
		String judge = Boolean.toString(il.InvenLogin(loginId, loginPw));
		
		while(true) {
			if(judge.equals("true")) {
				allDataSheet();
				menu();
				break;
			} else {
				start();
			}
		}
	}
	
	public void menu() {
		
		String menuNum = getInput("\n  [�޴�] 1: �����Ȳ, 2: ǰ������ ����, 3: ��ǰ �߰�, 4 : ��ǰ ����, 5 : ����");
		
		switch(menuNum) {
		case "1": 
			allDataSheet();
			//break;
			//InvenDataSheet.DataSet();
		case "2":
			modify();
			//break;
		case "3":
			addPrd();
			//break;
		case "4":
			delPrd();
			//break;
		case "5":
			System.out.println("���α׷��� �����մϴ�.");
			break;
		}
	}
	
	//1 - �����Ȳ ���
	public void allDataSheet() {
		
		InvenVO.standOutput();
		InvenDataSheet ids = new InvenDataSheet();
		
		List<InvenVO> lst = ids.DataSet();
		InvenVO arrVO[] = new InvenVO[lst.size()];
		lst.toArray(arrVO);
		
		for(InvenVO aVo : arrVO) {
			aVo.invenOutput();
		}
		menu();
	}
	//2 - ǰ������ ����
	public void modify() {
		//List<InvenVO> lst = InvenDataSheet.DataSet();
		
		String modProduct = getInput("��ǰ�� �Է�");
		//if(lst<.contains(modProduct)) {
		
		//if((Boolean.toString(lst.contains(modProduct))).equals("true")) {
		String modMenu = getInput("  1. ����, 2. ��ġ, 3. ������");
			switch(modMenu) {
				case "1":
					for(int i=0;i<lst.size();i++) { //0~lst ��������� �ݺ�
						if(modProduct.equals(lst.get(i).getProduct())) {//�Է°��� 
							int amount = Integer.parseInt(getInput("�����Է�"));
							lst.get(i).setAmount(amount);
							InvenVO arrVO[] = new InvenVO[lst.size()];
							lst.toArray(arrVO);
							for(InvenVO aVo : arrVO) {
								aVo.invenOutput();
							}
						} 
					}
						//else if(lst.contains(modProduct))){
						//	System.out.println("��ǰ�� ���� ���� �ʽ��ϴ�.");
						//	modify();
						//}
					 //else if((Boolean.toString(lst.contains(modProduct))).equals("false")) {
					//	System.out.println("��ǰ�� ���� ���� �ʽ��ϴ�.");
					//	modify();
					// }
					menu();
					break;
					/*
					int index = i;
					lst.set(i, lst.get(i).setAmount(amount));
							lst.setAmount(amount);
					InvenDataSheet ids = new InvenDataSheet();
					List<InvenVO> lsttwo = ids.DataSet();
					 */
					//allDataSheet();
				case "2": 
					String location = getInput("��ġ�Է�");
		
					for(int i=0;i<lst.size();i++) { //0~lst ��������� �ݺ�
						if(modProduct.equals(lst.get(i).getProduct())) {//�Է°��� 
							lst.get(i).setLocation(location);
						
							InvenVO arrVO[] = new InvenVO[lst.size()];
							lst.toArray(arrVO);
							
							for(InvenVO aVo : arrVO) {
								aVo.invenOutput();
							}
						}
					}
					menu();
					break;
				case "3": 
					String manager = getInput("�������Է�");
		
					for(int i=0;i<lst.size();i++) { //0~lst ��������� �ݺ�
						if(modProduct.equals(lst.get(i).getProduct())) {//�Է°��� 
							lst.get(i).setManager(manager);
						
							InvenVO arrVO[] = new InvenVO[lst.size()];
							lst.toArray(arrVO);
						
							for(InvenVO aVo : arrVO) {
								aVo.invenOutput();
							}
						}
					}
				menu();
				break;
			}
		//} else {
		//	System.out.println("�Է��Ͻ� ��ǰ���� �������� �ʽ��ϴ�.");
		//	modify();
	//	} else {
	//		System.out.println("�Է��Ͻ� ��ǰ���� �������� �ʽ��ϴ�.");
	//		modify();
	//	}
	}
		/*
	//2-1 ���� ����
	public void modAmount(String product) {
		int amount = Integer.parseInt(getInput("�����Է�"));

		List<InvenVO> lst = InvenDataSheet.DataSet();
		
		while(true) {
		
			if(modProduct=lst.get(i).getProduct())
			
		for(int i=0;product==lst.get(i).getProduct();i++) {
		lst.get(i).setAmount(amount);
		}
		}
	}
	//2-2 ��ġ����  
	public void modLocation() {
		String location = getInput("��ġ�Է�");

		List lst = InvenDataSheet.DataSet();
		lst.set(4, location);
	}
	//2-3 �����ڼ���
	public void modManager() {
		String manager = getInput("�������Է�");

		List lst = InvenDataSheet.DataSet();
		lst.set(5, manager);
	}
	*/
	//3 - ��ǰ�߰�
	public void addPrd() {
		String addProduct = getInput("��ǰ�� �Է�");
		String addBrand = getInput("�귣��� �Է�");
		int addPrice = Integer.parseInt(getInput("���� �Է�"));
		int addAmount = Integer.parseInt(getInput("���� �Է�"));
		String addLocation = getInput("��ġ �Է�");
		String addManager = getInput("������ �Է�");
		
		lst.add(new InvenVO(addProduct, addBrand, addPrice, addAmount, addLocation, addManager));
			
		InvenVO arrVO[] = new InvenVO[lst.size()];
		lst.toArray(arrVO);
		
		for(InvenVO aVo : arrVO) {
			aVo.invenOutput();
		}
		menu();
	}
	
	
	//4 - ��ǰ����
	public void delPrd() {
		String delProduct = getInput("��ǰ�� �Է�");
		
		for(int i=0;i<lst.size();i++) { //0~lst ��������� �ݺ�
			if(delProduct.equals(lst.get(i).getProduct())) {//�Է°��� ��
				lst.remove(lst.get(i));
			}
		}
		InvenVO arrVO[] = new InvenVO[lst.size()];
		lst.toArray(arrVO);
		
		for(InvenVO aVo : arrVO) {
			aVo.invenOutput();
		}
		menu();
	}
	
	//start �޼ҵ�
	public void start() {
		login();
	}
}




