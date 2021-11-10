package com.codechobo.opensrc.EmpInfor;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class EmpManager {
	Scanner scan = new Scanner(System.in);
	String menuTitle = "�޴�[1.�����ü���, 2.����߰�, 3.�������, 4.�������, 5.����]";
	public EmpManager() {
		
	}
	public void employeeStart() {
		boolean logResult=false;
		do {
		    //�α���
			String userid = inData("���̵�");
			String userpwd = inData("��й�ȣ");
			Login log = new Login();
			logResult = log.loginCheck(userid, userpwd);
		}while(!logResult);
		
		//�α��� �����ϸ� ���� ��
		//����� �⺻ ���� ����
		EmpDataSet.basicEmpSet();
		
		allEmpList();
		EmpProcessStart();
	}
	public void EmpProcessStart() {
		do {
			//�޴��Է�
			String menu = inData(menuTitle);
			if(menu.equals("1")) {//��ü������
				allEmpList();
			}else if(menu.equals("2")) {//����߰�
				empInsert();
				allEmpList();
			}else if(menu.equals("3")) {//�������
				empUpdate();
				allEmpList();
			}else if(menu.equals("4")) {//�������
				empDelete();
				allEmpList();
			}else if(menu.equals("5")) {//����
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				System.exit(0);
			}else {
				System.out.println("�޴��� �߸������Ͽ����ϴ�.  �ٽ� �Է��ϼ���.");
			}
			
		}while(true);
	}
	//�������
	public void empDelete() {
		String delName = inData("������ �����");
		EmpDataSet.empList.remove(delName);
	}
	//�������
	public void empUpdate() {
		//������ ������ Ȯ��
		String editName = inData("������ ������Է�");
		
		String editMenu = inData("������ �ʵ弱��[1.����ó, 2.�޿�]");
		if(editMenu.equals("1")) {
			telUpdate(editName);
		}else if(editMenu.equals("2")) {
			salUpate(editName);
		}else {
			System.out.println("�޴��� �߸������Ͽ����ϴ�.");
		}
		///
	}
	//����ó����
	public void telUpdate(String username) {
		String tel = inData("������ ����ó�Է�");
		EmpVO vo = EmpDataSet.empList.get(username);
		vo.setTel(tel);
	}
	//�޿�����
	public void salUpate(String username) {
		int sal = Integer.parseInt(inData("������ �޿� �Է�"));
		EmpVO vo = EmpDataSet.empList.get(username);
		vo.setSal(sal);
	}
	//����߰� 
	public void empInsert() {
		//1�� ��������� ������ VO��ü �����ϱ�
		EmpVO vo = new EmpVO();
		
		vo.setEmpNo(inData("�����ȣ"));//�����ȣ
		vo.setEmpName(inData("�����"));
		vo.setTel(inData("����ó"));
		
		do {
			boolean flag = true;
			try {
				vo.setSal(Integer.parseInt(inData("�޿�")));//-----
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("�޿��� ���ڷ� �Է��ϼ���...");
			}
			if(flag) break;
		}while(true);
		
		vo.setHiredate(inData("�Ի���"));
		
		EmpDataSet.empList.put(vo.getEmpName(), vo);
	}
	//�����ü��� ����ϱ�
	public void allEmpList() {
		//�������
		EmpVO.titlePrint();
		Collection<EmpVO> list= EmpDataSet.empList.values();
		Iterator<EmpVO> ii = list.iterator();
		while(ii.hasNext()) {
			EmpVO vo = ii.next();
			vo.empPrint();
		}	
	}
	
	//�ֿܼ��� ���ڿ��Է� �޴� �޼ҵ�
	public String inData(String msg) {
		System.out.print(msg+"->");
		return scan.nextLine();
	}
}
