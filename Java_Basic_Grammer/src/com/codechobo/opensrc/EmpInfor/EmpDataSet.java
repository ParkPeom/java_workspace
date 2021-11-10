package com.codechobo.opensrc.EmpInfor;

import java.util.HashMap;

public class EmpDataSet {
	public static HashMap<String, EmpVO> empList = new HashMap<String, EmpVO>();
	public EmpDataSet() {
		
	}
	//기본데이터 셋팅
	public static void basicEmpSet() {
		empList.put("홍길동", new EmpVO("11111", "홍길동", "010-1234-5678", 5000, "2020-05-05"));
		empList.put("이순신", new EmpVO("22222", "이순신", "010-8888-9999", 6000, "2021-01-01"));
		empList.put("강감찬", new EmpVO("66666", "강감찬", "010-7777-8888", 5500, "2020-10-10"));
		empList.put("장영실", new EmpVO("33333", "장영실", "010-5555-5555", 7000, "2009-03-01"));
		empList.put("유승룡", new EmpVO("44444", "유승룡", "010-1212-3434", 4500, "2012-08-09"));
	}
}
