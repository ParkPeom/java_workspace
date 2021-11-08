package com.codechobo.collection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VectorTest {
	public VectorTest() {

	}
	
	public Vector getData() {
		//Vector�� List�������̽��� ��ӹް� �ִ�
		// 			��ü�� �Է� ������ �����ϰ� ������ �ߺ� �����͸� ����Ѵ�.
		Vector v = new Vector();
		//�̸����� ���� ������ 
		boolean booStr = v.add(new String("ȫ�浿")); //�̸� 0
		System.out.println("booStr->"+booStr);
		
		v.addElement(Integer.valueOf(100));//������������ 1  int -> Integer ����Ŭ������ü����ȯ
										  // Integer.parseInt ���õ�����Ÿ�� ��ȯ 
		//���ó�¥	
		Calendar date = Calendar.getInstance();
		date.set(2022, 10, 30);
		v.addElement(date); // 2
		//Random
		Random random = new Random();
		v.addElement(random); // 3
		//VO
		MemberVO mVo = new MemberVO(100,"ȫ�浿","010-1234-5678");
		v.addElement(mVo); // 4 
		
		MemberVO mVo2 = new MemberVO();
		mVo2.setNum(300);
		mVo2.setUserid("�̼���");
		v.addElement(mVo2); // 5
		
		System.out.println("��ü�� ��->"+v.size());
		//->Vector�� ���� �� return 
		return v;
	}
	public List<MemberVO> getArrayList() { // E, K, V
		//MemberVO��ü �� ������ �ִ� �÷��� �����ϴ� ���
//		ArrayList<MemberVO> lst = new ArrayList<MemberVO>();
		List<MemberVO> lst = new ArrayList<MemberVO>();
//		lst.add(new String("ȫ�浿"));
		lst.add(new MemberVO(100,"ȫ�浿","010-1234-5678"));
		lst.add(new MemberVO(200,"��浿","010-4444-5555"));
		lst.add(new MemberVO(300,"�ڱ浿","010-5555-9999"));
		lst.add(new MemberVO(400,"�ֱ浿","010-7777-9999"));
		
		return lst;
	}
}
