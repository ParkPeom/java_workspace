package ä�����α׷����󸸵��;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ä�����α׷�.ChatServerApp.SocketThread;

public class ChatServerApp {
	
	private List<SocketThread> socketList;
	
	public ChatServerApp() {
		ServerSocket chatServer = null;
		
	try {
		chatServer = new ServerSocket(13000);
		System.out.println("[�޼���]ä�� ���� ���� ��...");
		socketList = new ArrayList<SocketThread>();
		
		while(true) {
			try {
				Socket socket = chatServer.accept();
				System.out.println("[���� �α�]" + socket.getInetAddress().getHostAddress());
				
				
				} catch (IOException e) {
					System.out.println("[�����α�]Ŭ���̾�Ʈ�� ���� ���� ������ �߻�");
				}
		}
	} catch (IOException e) {
		System.out.println("[�����α�]������ ���������� ���۵��� �ʽ��ϴ�.");
		}
	}
}
