package com.codechobo.calendar;
import java.util.Scanner;

public class EmailCheck2 {

	public EmailCheck2() {
		
	}
	
	public void start() {
		do {
			//�̸��� �Է¹ޱ�
			String email = inputEmail();
			
			if(emailCheck(email)) { // �����̸���
				emailOutput(email);
			}else {   //�߸��� �̸����ּ�
				System.out.println(email+"�� �߸��� �̸����ּ� �Դϴ�.");
			}
			break;
			
		}while(true);
		
	}
	//���̵�� �������� �и��Ͽ� ����ϴ� �޼ҵ�
	public void emailOutput(String email) {
		int atMark = email.indexOf("@");
		String id = email.substring(0 , atMark+1);
		String domain = email.substring(atMark+1);
		System.out.println("���̵� ="+ id);
		System.out.println("������ ="+ domain);
	}
	
	
	//�̸��� ��ȿ�� �˻� �ϴ� �޼ҵ� 
	public boolean emailCheck(String email) {
		boolean boo = true;
		//indexOf() Ư�������� ��ġ�� ���ϰ� , ������ -1 
		int atMark = email.indexOf("@");
		int point = email.indexOf(".",atMark+1);
		int len = email.length();
		
		if(atMark == -1 || atMark<8 || point == -1 || point -atMark<=2
				|| atMark!=email.lastIndexOf("@") || point<atMark || len==point+1){   ///(          ||@�ٷ� ������ . ���� ��� )
			boo =false;
		}
		return boo;
	}
	
	//�̸��� �Է¹޴� �޼ҵ� 
	public String inputEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�̸����Է� = ");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		EmailCheck2 ec = new EmailCheck2();
			ec.start();

	}

}
