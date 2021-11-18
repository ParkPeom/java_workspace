package com.codechobo.studeygroup_태진;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvenDataManage {
	
	List<InvenVO> lst = InvenDataSheet.DataSet();
	InvenLogin il = new InvenLogin();
	
	public InvenDataManage() {
		
	}
	//입력
	public String getInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.println(msg+"=");
		return scan.nextLine();
	}
	
	//체크 후 VO.StandOutput 출력
	//메뉴출력 (1 : 재고현황, 2 : 수정_수량,위치,관리자, 3 : 상품 추가, 4 : 상품 삭제, 5 : 종료)
	//2-> arraylist index 번호(제품명으로 확인) -> 수정할 항목 선택 ->
	//		1. 수량, 2. 위치, 3. 관리자 -> 수정값 입력 -> 수정된 현황 출력 후 메뉴 출력
	//3-> arraylist에 index 추가 후 각 set변수로 값 추가 후 메뉴 출력
	//4-> arraylist에서 index 번호(제품명)입력시 삭제 후 메뉴출력
	//5-> 종료메세지 출력
	
	public void login() {
		String loginId = getInput("아이디를 입력해주세요");
		String loginPw = getInput("패스워드를 입력해주세요");
		
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
		
		String menuNum = getInput("\n  [메뉴] 1: 재고현황, 2: 품목정보 수정, 3: 상품 추가, 4 : 상품 삭제, 5 : 종료");
		
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
			System.out.println("프로그램을 종료합니다.");
			break;
		}
	}
	
	//1 - 재고현황 출력
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
	//2 - 품목정보 수정
	public void modify() {
		//List<InvenVO> lst = InvenDataSheet.DataSet();
		
		String modProduct = getInput("상품명 입력");
		//if(lst<.contains(modProduct)) {
		
		//if((Boolean.toString(lst.contains(modProduct))).equals("true")) {
		String modMenu = getInput("  1. 수량, 2. 위치, 3. 관리자");
			switch(modMenu) {
				case "1":
					for(int i=0;i<lst.size();i++) { //0~lst 사이즈까지 반복
						if(modProduct.equals(lst.get(i).getProduct())) {//입력값과 
							int amount = Integer.parseInt(getInput("수량입력"));
							lst.get(i).setAmount(amount);
							InvenVO arrVO[] = new InvenVO[lst.size()];
							lst.toArray(arrVO);
							for(InvenVO aVo : arrVO) {
								aVo.invenOutput();
							}
						} 
					}
						//else if(lst.contains(modProduct))){
						//	System.out.println("상품이 존재 하지 않습니다.");
						//	modify();
						//}
					 //else if((Boolean.toString(lst.contains(modProduct))).equals("false")) {
					//	System.out.println("상품이 존재 하지 않습니다.");
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
					String location = getInput("위치입력");
		
					for(int i=0;i<lst.size();i++) { //0~lst 사이즈까지 반복
						if(modProduct.equals(lst.get(i).getProduct())) {//입력값과 
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
					String manager = getInput("관리자입력");
		
					for(int i=0;i<lst.size();i++) { //0~lst 사이즈까지 반복
						if(modProduct.equals(lst.get(i).getProduct())) {//입력값과 
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
		//	System.out.println("입력하신 상품명이 존재하지 않습니다.");
		//	modify();
	//	} else {
	//		System.out.println("입력하신 상품명이 존재하지 않습니다.");
	//		modify();
	//	}
	}
		/*
	//2-1 수량 수정
	public void modAmount(String product) {
		int amount = Integer.parseInt(getInput("수량입력"));

		List<InvenVO> lst = InvenDataSheet.DataSet();
		
		while(true) {
		
			if(modProduct=lst.get(i).getProduct())
			
		for(int i=0;product==lst.get(i).getProduct();i++) {
		lst.get(i).setAmount(amount);
		}
		}
	}
	//2-2 위치수정  
	public void modLocation() {
		String location = getInput("위치입력");

		List lst = InvenDataSheet.DataSet();
		lst.set(4, location);
	}
	//2-3 관리자수정
	public void modManager() {
		String manager = getInput("관리자입력");

		List lst = InvenDataSheet.DataSet();
		lst.set(5, manager);
	}
	*/
	//3 - 상품추가
	public void addPrd() {
		String addProduct = getInput("상품명 입력");
		String addBrand = getInput("브랜드명 입력");
		int addPrice = Integer.parseInt(getInput("가격 입력"));
		int addAmount = Integer.parseInt(getInput("수량 입력"));
		String addLocation = getInput("위치 입력");
		String addManager = getInput("관리자 입력");
		
		lst.add(new InvenVO(addProduct, addBrand, addPrice, addAmount, addLocation, addManager));
			
		InvenVO arrVO[] = new InvenVO[lst.size()];
		lst.toArray(arrVO);
		
		for(InvenVO aVo : arrVO) {
			aVo.invenOutput();
		}
		menu();
	}
	
	
	//4 - 상품삭제
	public void delPrd() {
		String delProduct = getInput("상품명 입력");
		
		for(int i=0;i<lst.size();i++) { //0~lst 사이즈까지 반복
			if(delProduct.equals(lst.get(i).getProduct())) {//입력값과 비교
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
	
	//start 메소드
	public void start() {
		login();
	}
}




