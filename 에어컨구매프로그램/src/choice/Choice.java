package choice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import print.Print;

// ���� Ŭ������ ����
public class Choice { 
	public static void joinchoicemenu(int choice) {		
		
		switch(choice) {
			case 1:
				// ȸ������
				Print.join();
				break;
			case 2:
				// �α���
				Print.login();
				break;
			} 
		}
	public static void showchoicemenu(String id) {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	try { 
		int choice = Integer.parseInt(br.readLine());
		switch(choice) {
			case 1:
				Print.myPage(id); //����������
				break;
			case 2:	
				//�����ϱ�
				break;
			case 3:
				//���Ը��
				break;
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
