package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
			br.write("�ȳ� �� ������...\n");
			br.flush();
			br.close();
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String sendData = br2.readLine();
			System.out.println("�����κ��� ���� ���� -----> " + sendData);
		}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SocketServerTest2();
	}
}
