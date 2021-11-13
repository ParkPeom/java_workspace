package com.codechobo.api;

public class StringBufferTest {

	public StringBufferTest() {
		
	}
	public void start() {
		//String ������������ ���ڿ��� ó���ϹǷ� ���ڿ��� ���� ����Ǹ�
		// ���ο� �ּ� �̵��Ѵ�.
		//StringBuffer�� StringBuilder ���ڿ��� �������� ������ �� �ִ� Ŭ������ 
		// ���ڿ��� ���� �Ǵ��� �ּҸ� �̵����� �ʰ� ������ ó���Ѵ�.
		
		StringBuffer sb = new StringBuffer();
		System.out.println("Ȯ���� �޸� ������->"+ sb.capacity());
		
		String name = "ȫ";
		name = name.concat("�浿");
		System.out.println("name->"+ name);
		
		sb.append("����");//���ڸ� ���� �������� �������� �߰��Ѵ�.
		System.out.println("sb->"+sb.toString());
		
		char[] txt = {'J','A','V','A','��', '��','��','��','��'};
		sb.append(txt);
		System.out.println("sb->"+ sb);
		//             ����index, ����
		sb.append(txt, 5,        4);
		System.out.println("sb->"+ sb);
		
		sb.insert(6, "(�ڹ�)");
		System.out.println("sb->"+ sb);
		
		System.out.println("���ڼ�->"+ sb.length());
		System.out.println("����ũ��->"+ sb.capacity());
		
		//Ư����ġ�� ���� �����
		sb.delete(2, 5);
		System.out.println("sb->del->"+ sb);
		//            01234567890123
		String tel = "010-1234-5678";
		String localTel = tel.substring(4, 8);
		String userTel = tel.substring(4);
		System.out.println(localTel+", "+ userTel);
		
		sb.reverse();
		System.out.println(sb);
		
		StringBuffer sb2 = new StringBuffer("�ڹ�");
		StringBuffer sb3 = new StringBuffer("�ڹ�");
		if(sb2==sb3) {
			System.out.println("����");
		}else {
			System.out.println("�����ʴ�.");////
		}
		
		StringBuffer sb4 = sb3;
		if(sb3==sb4) {
			System.out.println("����");/////
		}else {
			System.out.println("�����ʴ�.");
		}
		
		//sb4�� ���� �����ϸ� ���� �ּҸ� ������ �ִ� sb3�� ���� ���Ѵ�.
		//sb4.append("��¥�ٲ??");
		System.out.println("sb3->"+ sb3);
		
		
		//��ü �ּ��� �����͸� ������ ������ Ȯ���ϴ� �޼ҵ带 �̿��ؾ� �Ѵ�.
		//equals() : ObjectŬ������ �޼ҵ带 ��ӹ޾� ����ϰ� ������
		//           ��ü���� ���� �ƴ� ��ü��ü�� ������ �ٸ��� �Ǵ��Ѵ�.
		if(sb2.equals(sb3)) {
			System.out.println("equals=>����");
		}else {
			System.out.println("equals=>�ٸ���");
		}
		
		String s1 = new String("Java");
		String s2 = new String("JAVA");
		//������ �ٸ���
		if(s1.equals(s2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		//String s1 = new String("Java");
		//String s2 = new String("JAVA");
		//���ڿ��� ũ���
		// ����� ������ ���� ��ü�� ũ��
		// ������ ������ ���� ��ü�� �۴�
		// 0�̸� �� ��ü�� ���� ����.
		int result = s2.compareTo(s1);
		System.out.println("result->"+ result);
		//            01234567890123456789
		String str = "Java Programing Test..";
		//Ư����ġ�� ����1���� ���´�.
		System.out.println("charAt(index)->"+ str.charAt(5));
		
		//���ڿ��� byte�� �迭�� ���Ѵ�.
		byte[] strByte = str.getBytes();
		for(byte s : strByte) {
			System.out.println(s +"->"+(char)s);
		}
		System.out.println(str.indexOf("g")+", "+ str.lastIndexOf("g"));
		
		str = str.replaceAll("Test", "�׽�Ʈ");
		System.out.println("str->"+ str);
		
		String splitResult[] = str.split("g");
		for(String s:splitResult) {
			System.out.println(s);
		}
		System.out.println("�빮�ڷ�->" + str.toUpperCase());
		System.out.println("�ҹ��ڷ�->" +  str.toLowerCase());
		
		//���ڿ��� ���Ե� ���ʿ� �ִ� ���鹮�ڸ� �����ϴ� �� : trim()
		String userid = "       Gu    Gu    Ma      ";
		System.out.println("="+userid+"=");
		System.out.println("="+userid.trim().replaceAll(" ", "")+"=");
	}
	public static void main(String[] args) {
		new StringBufferTest().start();
	}
}
