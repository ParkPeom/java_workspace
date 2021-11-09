package com.codechobo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ObjectCompareMain {

	public ObjectCompareMain() {
		
	}
	public void start() {
		//�÷��� ��ü���� ��ü�� ���Ե� �����͸� �̿��Ͽ� �����ϱ�
		//�⺻ ������ �����ϱ�
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		
		empList.add(new EmployeeVO(13, "����ȯ", "010-1234-2678", "���", "abc@nate.com"));	
		empList.add(new EmployeeVO(5, "�迬��", "010-8956-9587", "�븮", "zzz@naver.com"));
		empList.add(new EmployeeVO(50, "������", "010-4322-4353", "����", "xyz@hanmail.com"));
		empList.add(new EmployeeVO(120, "�����", "010-2525-1242", "�븮", "gggg@nate.com"));
		empList.add(new EmployeeVO(35, "�߽ż�", "010-2212-5243", "����", "cucucu@naver.com"));
		empList.add(new EmployeeVO(90, "����ȯ", "010-6598-9658", "������", "test@nate.com"));
		empList.add(new EmployeeVO(22, "�̵���", "010-5623-9564", "����", "dong@hanmail.com"));
	
		System.out.println("\t\t\t======������=======\t");
		for(EmployeeVO vo :empList) {
			System.out.println(vo.toString());
		}
		
		// �����Ͱ� ��ü�� ������ִ� ����Ʈ , ���� ������ �Ǵ� Ŭ���� 
		// ����  { �̸���(���ڸ� ��������) } ��Ŭ������ implements Comparator�� ��ӹ޾ƾ��Ѵ�.
		// �̸��� ������������ �����ϱ�
		Collections.sort(empList,new CompareNameAsc());
		System.out.println("=====�̸��� ������������ ����");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		
		System.out.println("====�������� ���� ����====");
		
		Collections.reverse(empList);
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		// �̸��� ������������ �����ϱ�
		Collections.sort(empList,new CompareNameDesc());
		System.out.println("=====�̸��� ������������ ����======");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		
		Collections.sort(empList, new CompareSabunAsc());
		System.out.println("====�����ȣ�� ������������ ����");
		for(EmployeeVO vo :empList) {
			System.out.println(vo.toString());
		}
		// �����ȣ�� ������������ ����
		Collections.sort(empList , new CompareSabunDesc());
		System.out.println("=====�����ȣ�� ������������ ����");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		
		// ������ ������������ ����
		Collections.sort(empList, new CompareSalDesc());
		System.out.println("====������ ������������ ����");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		
		// ������-����-����-�븮-����-���
		Collections.sort(empList , new CompareSalDesc());
		System.out.println("=====������ ������������ �����ϱ�");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		
		// �̸����� ������������ �����ϱ� 
		Collections.sort(empList , new CompareEmailAsc());
		System.out.println("====�̸����� �������� �����ϱ�");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
	}
	//==��������� �������� �������� �����ϴ� ����Ŭ����
	class CompareSalDesc implements Comparator<EmployeeVO> {

		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			// TODO Auto-generated method stub
			return o2.getPosition().compareTo(o1.getPosition());
		}		
	}
	
	//== �̸����� ������������ ���� �ϴ� ����Ŭ���� 
	class CompareEmailAsc implements Comparator<EmployeeVO> {
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			return o1.getEmail().compareTo(o2.getEmail());
		}
	}
	
	//==�����(�̸�)�� �������� �������� �����ϴ� ����Ŭ����
	class CompareNameDesc implements Comparator<EmployeeVO> {
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			// 		��							��
			// compareTo = ���ں� 
			return o2.getUsername().compareTo(o1.getUsername());
		}
	}
	//�����ȣ�� �������� �����ϴ� ����Ŭ����
		class CompareSabunDesc implements Comparator<EmployeeVO> {
			@Override
			public int compare(EmployeeVO o1, EmployeeVO o2) {
				//����϶� �ΰ��� ���� ��ȯ�Ѵ�.
				// ���׿����� = ���� ��
				// 1 ���� �ٲ�  -1 , 0 ��ȯ���� 
				return (o1.getSabun() < o2.getSabun()) ? 1 : (o1.getSabun() > o2.getSabun()) ? -1 : 0 ;
			}
		}
	
	//�����ȣ�� �������� �����ϴ� ����Ŭ����
	class CompareSabunAsc implements Comparator<EmployeeVO> {
		
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			//����϶� �ΰ��� ���� ��ȯ�Ѵ�.
			// ���׿����� = ���� ��
			// 1 ���� �ٲ�  -1 , 0 ��ȯ���� 
			return (o1.getSabun() > o2.getSabun()) ? 1 : (o1.getSabun() < o2.getSabun()) ? -1 : 0 ;
		}
	}
	// Comparator�������̽��� ��ӹ޾� Compare()�޼ҵ带 �������̵��Ѵ�.
	//==�����(�̸�)�� �������� �������� �����ϴ� ����Ŭ����
	class CompareNameAsc implements Comparator<EmployeeVO> {

		// ��ü �� 
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			// A - B 
			// ������ ��ü�� ������ -1 �ȹٲ� , ������ 0, ������ ��ü�� Ŭ�� 1 �ٲ� 
			return o1.getUsername().compareTo(o2.getUsername());
		}
	}
	
	public static void main(String[] args) {
		new ObjectCompareMain().start();
	}
}
