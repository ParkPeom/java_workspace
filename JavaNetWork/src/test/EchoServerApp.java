package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer = null;
		
		try {
			echoServer = new ServerSocket(1000);
			System.out.println("[�޼���] Echo Server Running");
			while(true) {
				Socket socket = echoServer.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("["+socket.getInetAddress().getHostAddress()
						+"] ���� ������ �޼��� = " + br.readLine());
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[����] ������ ��Ʈ��ũ ������ �߻� �Ͽ����ϴ�.");
		}
	}
}
