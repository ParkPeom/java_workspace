package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServerTest2 {
	
	public SocketServerTest2() {
		
		try {
			ServerSocket socket = new ServerSocket(120000);
			
		while(true) {
			System.out.println("���� �����...");
			
			// ������ ����ڵ��� �������� �޴´�. 
			Socket s = socket.accept();
			InetAddress ia = s.getInetAddress(); // ���� ��ǻ�� ip�� ��� ������
			System.out.println( ia.getHostAddress() + "-->Ŭ���̾�Ʈ�� ���� �Ͽ����ϴ�.");
			
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SocketServerTest2();
	}
}
