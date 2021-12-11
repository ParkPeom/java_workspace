package test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketApp {
	public static void main(String[] args) {
		
	try {	
		// ���� ��ǻ�� �̸� �Ǵ� ��Ʈ ��ȣ�� ���޹޾� ������ ���ӵ� socket �ν��Ͻ� ����
		Socket socket = new Socket("www.naver.com",80);
		
		// ���� ������ ���ڿ��� ��ȯ 
		System.out.println("socket = " + socket.toString());
		
		// ���� ��ǻ�� �̸��� ��Ʈ��ũ �ּҰ� ����� InetAddress �ν��Ͻ� ��ȯ 
		System.out.println("Remote IP Address = " + socket.getInetAddress().getHostName());
	
		// ������ ��Ʈ��ȣ 
		System.out.println("Remote Port Number = " + socket.getPort());
		
		// Ŭ���̾�Ʈ�� ��ǻ�� �̸� �� ��Ʈ��ũ �ּҰ� ����� InetAddress �ν��Ͻ� ��ȯ 
		System.out.println(socket.getLocalAddress().getHostAddress());

		// ���� ��ǻ�� (���� �����) ��Ʈ ��ȣ�� ��ȯ �ϴ� �޼ҵ� 
		System.out.println(socket.getLocalPort());
		
		// Socket.close() : ������ �����ϴ� �޼ҵ� - ���� ���� 
		socket.close();
		
		}catch(UnknownHostException e) {
			System.out.println("[����] ���� ��ǻ�͸� ã�� �� �����ϴ�.");
		}catch(IOException e) {
			System.out.println("[����] ���� ��ǻ�͸� ã���� �����ϴ�.");
		}
	}
}
