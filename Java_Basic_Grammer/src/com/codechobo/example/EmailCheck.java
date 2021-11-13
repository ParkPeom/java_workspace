package com.codechobo.example;
import java.util.Scanner;

public class EmailCheck {

	public EmailCheck() {
		
	}
	public void start() {
		do {
			//�̸����Է¹ޱ�
			String email = inputEmail();
			
			if( emailCheck(email) ) {//�����̸���
				emailOutput(email);
			}else {//�߸��� �̸����ּ�
				System.out.println(email+"�� �߸��� �̸����ּ��Դϴ�. �ٽ� �Է��ϼ���.");
			}			
		}while(true);
	}
	//���̵�� �������� �и��Ͽ� ����ϴ� �޼ҵ�
	public void emailOutput(String email) {
		int atMark = email.indexOf("@");
		String id = email.substring(0, atMark);
		String domain = email.substring(atMark+1);
		System.out.println("���̵�="+ id);
		System.out.println("������="+ domain);
	}
	//�̸��� ��ȿ���˻��ϴ� �޼ҵ�
	public boolean emailCheck(String email) {
		boolean boo = true;
		//indexOf() Ư�������� ��ġ�� ���ϰ�, ������ -1
		int atMark = email.indexOf("@");
		int point = email.indexOf(".", atMark+1);
		int len = email.length();
		if(atMark==-1 || atMark<8 || point==-1 || point-atMark<=2
		   || atMark!=email.lastIndexOf("@") || point<atMark 
		   || len==point+1) {
			boo = false;
		}
		return boo;
	}
	//�̸��� �Է¹޴� �޼ҵ�
	public String inputEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸����Է�=");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		EmailCheck ec = new EmailCheck();
		ec.start();
	}

}
/*
 ����
 �̸����Է� = jkfdsk
 �߸��� �̸����Դϴ�. �ٽ��Է��ϼ���..
 
 �̸����Է� = fjdkslf@fds
 �߸��� �̸����Դϴ�. �ٽ��Է��ϼ���..
 
 �̸����Է� = fjdk.slf@fds
 �߸��� �̸����Դϴ�. �ٽ��Է��ϼ���..
 
 �̸����Է� = abced@nate.com
 ���̵�:abced
 ������:nate.com
 
 �̸����Է� = _
 
 */
