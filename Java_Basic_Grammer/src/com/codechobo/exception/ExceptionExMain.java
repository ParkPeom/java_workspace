package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExMain {
	
	Scanner sc = new Scanner(System.in);
	
	public ExceptionExMain() {

	}
	// ���� �Է¹޾� �������� ����ϴ� �޼���
	public void gugudan() {
		while(true) {
			try {
			System.out.print("���� �Է��ϼ��� > ");
			int dan = sc.nextInt();
			sc.nextLine();
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d \n" , dan, i , dan * i);
			}
		} catch(InputMismatchException ime) {
				System.out.println("���� ����(����)�� �Է��ϼ���.");
//				int dan = sc.nextInt();
				int dan = Integer.parseInt(sc.nextLine()); // ���ڿ��� ������ 
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d \n" , dan, i , dan * i);
				}
				ime.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
//		new ExceptionExMain().gugudan();
//		System.out.println("���̵� = " + args[0]);
//		System.out.println("��й�ȣ = " + args[1]);
		// ���̵�� ��й�ȣ ��ġ�� ��� ���񽺸� �����ϰڴ�.
		if(args[0].equals("djkk1234") && args[1].equals("1234")) {
				System.out.println("�α��� �Ǽ̽��ϴ�.");
				// �׷��� �������� ������
				new ExceptionExMain().gugudan();
			} else {
				System.out.println("���̵�� ��й�ȣ�� �߸��Է��Ͽ����ϴ�.");
			}
		}
	}
