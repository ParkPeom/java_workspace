package com.codechobo.collection.exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemberList {

	public MemberList() {
	}
	public static void main(String[] args) {
		List<MemberVO> list = new ArrayList<>();
		MemberVO student = MemberVO.getInstance();
		StringBuffer sb = new StringBuffer();
		student.setName("¹Ú¹ü");
		student.setNum(100);
		list.add(student);
		
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for(char ch ='a'; ch < 'z'; ch++) {
			sb.append(ch + " ");
			System.out.println(sb);
		}
	}
}
