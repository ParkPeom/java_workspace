package com.codechobo.opensrc.EmpInfor;

import java.util.HashMap;

public class EmpDataSet {
	public static HashMap<String, EmpVO> empList = new HashMap<String, EmpVO>();
	public EmpDataSet() {
		
	}
	//�⺻������ ����
	public static void basicEmpSet() {
		empList.put("ȫ�浿", new EmpVO("11111", "ȫ�浿", "010-1234-5678", 5000, "2020-05-05"));
		empList.put("�̼���", new EmpVO("22222", "�̼���", "010-8888-9999", 6000, "2021-01-01"));
		empList.put("������", new EmpVO("66666", "������", "010-7777-8888", 5500, "2020-10-10"));
		empList.put("�念��", new EmpVO("33333", "�念��", "010-5555-5555", 7000, "2009-03-01"));
		empList.put("���·�", new EmpVO("44444", "���·�", "010-1212-3434", 4500, "2012-08-09"));
	}
}
