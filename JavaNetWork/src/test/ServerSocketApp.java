package test;

import java.io.IOException;
import java.net.ServerSocket;
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i = 2000; i <= 9000; i+=1000) {
			try {
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("[�޼���]" +  i + "�� ��Ʈ�� ����� ����");
			// serverSocket.close(0 : ���� ����� ���� �ϴ� �޼ҵ�)
		} catch(IOException e) {
			System.out.println("[����]"+i+"�� ��Ʈ�� �̹� ����� �Դϴ�.");
			}
		}
	}
}
