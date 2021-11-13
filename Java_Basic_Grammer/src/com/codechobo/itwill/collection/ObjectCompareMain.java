package com.codechobo.itwill.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareMain {

	public ObjectCompareMain() {
		
	}
	public void start() {
		//�÷��� ��ü���� ��ü�� ���Ե� �����͸� �̿��Ͽ� �����ϱ�
		//�⺻ ������ �����ϱ�
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		
		empList.add(new EmployeeVO(13, "����ȯ", "010-1234-2678", "���", "abc@nate.com"));
		empList.add(new EmployeeVO(5, "�迬��","010-8956-9587","�븮","zzz@naver.com"));
		empList.add(new EmployeeVO(50,"������","010-4322-4353","����","xyz@hanmail.com"));
		empList.add(new EmployeeVO(120,"�����","010-2525-1242","�븮","gggg@nate.com"));
		empList.add(new EmployeeVO(35,"�߽ż�","010-2212-5243","����","cucucu@naver.com"));
		empList.add(new EmployeeVO(90,"����ȯ","010-6598-9658","������","test@nate.com"));
		empList.add(new EmployeeVO(22,"�̵���","010-5623-9564","����","dong@hanmail.com"));
		
		System.out.println("=====������=======");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		
		//�̸��� ������������ �����ϱ�
		Collections.sort(empList, new CompareNameAsc());
		System.out.println("=====�̸��� ������������ ����");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		//�̸��� ������������ �����ϱ�
		Collections.sort(empList, new CompareNameDesc());
		System.out.println("=====�̸��� ������������ ����");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		Collections.sort(empList, new CompareSabunAsc());
		System.out.println("====�����ȣ�� ������������ ����");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
		//�����ȣ�� ������������ ����
		Collections.sort(empList, new CompareSabunDesc());
		System.out.println("=====�����ȣ�� ������������ ����");
		for(EmployeeVO vo :empList) {
			System.out.println(vo.toString());
		}
		//������ ������������ ����
		Collections.sort(empList, new ComparePositionDesc());
		System.out.println("====������ ������������ ����");
		for(EmployeeVO vo : empList) {
			System.out.println(vo.toString());
		}
		//�̸����� ������������ ����
		Collections.sort(empList, new CompareEmailAsc());
		System.out.println("====�̸����� ������������ ����");
		for(EmployeeVO vo:empList) {
			System.out.println(vo.toString());
		}
	}
	// Comparator�������̽��� ��ӹ޾� compare()�޼ҵ� �������̵��Ѵ�.
	//�̸����� ������������ �����ϴ� ���� Ŭ����
	class CompareEmailAsc implements Comparator<EmployeeVO>{
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			return o1.getEmail().compareTo(o2.getEmail());
		}		
	}
	
	//������ ������������ �����ϴ� ���� Ŭ����
	class ComparePositionDesc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {			
			return o2.getPosition().compareTo(o1.getPosition());
		}		
	}
	//�����ȣ�� �������� �����ϴ� ���� Ŭ����
	class CompareSabunDesc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			return (o1.getSabun()<o2.getSabun())?1:
				(o1.getSabun()>o2.getSabun())?-1:0;
		}		
	}
	//�����ȣ�� �������� �����ϴ� ����Ŭ����
	class CompareSabunAsc implements Comparator<EmployeeVO>{
		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			//����϶� �ΰ��� ���� ��ȯ�Ѵ�.
			return (o1.getSabun()>o2.getSabun())?1:
				(o1.getSabun()<o2.getSabun())?-1 :0 ;
		}		
	}
	
	//==�����(�̸�)�� �������� �������� �����ϴ� ����Ŭ����
	class CompareNameAsc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO o1, EmployeeVO o2) {
			// ������ ��ü�� �������� -1, ������ 0, ���� ��ü�� Ŭ���� 1
			return  o1.getUsername().compareTo(o2.getUsername());
		}		
	}
	//==�����(�̸�)�� �������� �������� �����ϴ� ����Ŭ����
	class CompareNameDesc implements Comparator<EmployeeVO>{

		@Override
		public int compare(EmployeeVO v1, EmployeeVO v2) {
			//     ��                           ��  +
			return v2.getUsername().compareTo(v1.getUsername());
		}		
	}
	public static void main(String[] args) {
		new ObjectCompareMain().start();
	}
}
