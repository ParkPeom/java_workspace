package com.codechobo.control;

import java.util.InputMismatchException;
import java.util.Scanner; // import : Scanner Ŭ���� �����ͼ� �� 

/*
 ����ڿ��� Ű����� �̸��� ���̸� �Է¹޾� ����ϴ� ���α׷� �ۼ�
 */
public class ScannerApp {
	
	public static void main(String[] args) {
		
		// Scanner Ŭ���� : �Է���ġ(Ű���� , ���� ��)�κ��� ���� �����ޱ� ���� �޼��尡 ����� Ŭ����
		// Scanner Ŭ������ ��ü�� �����Ͽ� ������ ���� 
		
		// => ������ ����� ��ü�� ����Ͽ� �޼��带 ȣ�� �Ѵ�. 
		// => Ű����κ��� ���� �Է¹ޱ� ���� Scanner ��ü ����
		// System.in : ǥ�� Ű���� �Է� ��Ʈ�� - Ű����� �Էµ� ���� �����ϴ� ��ü 
		// System.out : ����Ϳ� ���� ��� ��Ʈ�� ( 
		
		Scanner scanner = new Scanner(System.in); // �Է� 
		System.out.print("�̸� �Է� >> ");
		
		//	scanner.nextLine() : �Է°��� ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼���
		// => Ű����� �Է¹��� ���� ���ڿ��� �����޾� ������ ����	
		// => Ű���� �Է°��� ���� ��� ���α׷� �帧(������- Thread) �� �Ͻ� ����
		// => Ű����� ���� �Է��� �� ���͸� �Է��ϸ� �����尡 ����ȴ�.
		String name= scanner.nextLine();
		
		System.out.print("���� �Է� >> ");
		// => scanner.nextInt(); : �Է°��� ���������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼���
		// => Ű����� �Է¹��� ���� ���������� �����޾� ������ ����
		// => Ű���� �Է°��� �������� �ƴ� ��� ����(Exception) �߻� 
		int age = 0;
		age = scanner.nextInt(); 			
		System.out.println("[���] �̸� " + name + "���� ���̴� " + age + " �Դϴ�.");
		
		// Scanner.close() : Scanner ��ü�� ��Ʈ���� �����ϴ� �޼���
		scanner.close();
		
		scanner.next();
		scanner.nextLine();
		
		// ���α׷� �Է��϶�� �س��� �ٸ� ���α׷� �����ϸ� ��ǻ�� �ӵ��� ��������. 

	}
}
