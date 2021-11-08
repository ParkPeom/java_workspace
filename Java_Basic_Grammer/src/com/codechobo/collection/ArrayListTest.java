package com.codechobo.collection;

import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		
	}
	public void start() {
		VectorTest vt = new VectorTest();
		List<MemberVO> lst = vt.getArrayList();
		
		for(MemberVO vo : lst) {
			//vo.memberOutput();
			int n = vo.getNum();
			String userid = vo.getUserid();
			String tel = vo.getTel();
			System.out.printf("[%d��\t %s��]\t %s\n",n,userid,tel);
		}
		System.out.println("=====================================");
		////////////////////////////////////////////
		//////// �÷����� ��ü�� ��� �迭�� �����ϱ�
		MemberVO[] arrVO = new MemberVO[lst.size()];
		// T[]  toArray(T[] a)
		lst.toArray(arrVO); // toArray �迭�� arrVO�� ��´�.
		
		for(MemberVO aVo: arrVO) {
			aVo.memberOutput();
		}
	}
	
	public static void main(String[] args) {
		new ArrayListTest().start();
	}
	
}
