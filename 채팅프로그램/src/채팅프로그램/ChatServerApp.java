package ä�����α׷�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//ä�� ���� ���α׷� - ���� ������ 
//=> Ŭ���̾�Ʈ�� ������ �޼����� ���޹޾� ���ӵ� ��� Ŭ���̾�Ʈ���� �����ϴ� ��� 
//=> Ŭ���̾�Ʈ�� ����� ������ ������ ���ο� �����带 �����Ͽ� ���������� ���۵ǵ��� ����
public class ChatServerApp {
	
	// ���ӵ� Ŭ���̾�Ʈ�� ����� ������ Socket �ν��Ͻ��� ����� ��Ʈ���� ����� 
	// SocketThread �ν��Ͻ��� ��ҷ� �����ϱ� ���� List �ν��Ͻ� �ݷ��� �ʵ� ���� 
	private List<SocketThread> socketList;
	
	public ChatServerApp()  {
		ServerSocket chatServer = null;
	try { 	
		chatServer = new ServerSocket(13000);
		System.out.println("[�޼���]ä�� ���� ���� ��...");
		// �ݷ��� �ʵ忡 ArrayList �ν��Ͻ��� �����Ͽ� ���� 
		socketList = new ArrayList<ChatServerApp.SocketThread>(); // ����Ŭ������ �ҷ����� ����

		while(true) {				
			try {
				Socket socket = chatServer.accept(); // �����̵Ǹ� ������ ������� 
				System.out.println("[���� �α�]" + socket.getInetAddress().getHostAddress()
					+"�� ��ǻ�Ϳ��� �����Ͽ����ϴ�.");	
					// Ŭ���̾�Ʈ�� ����� ������ Socket �ν��Ͻ��� ������ SocketThread �ν��Ͻ� ����
					// => Thread �ν��Ͻ� ���� 
					SocketThread socketThread = new SocketThread(socket); //�޾ƿ��� ������ ���ϻ����� 
					//List �ν��Ͻ��� ���(SocketThread �ν��Ͻ� ) �߰� 
					//=> List �ν��Ͻ����� Ŭ���̾�Ʈ�� ����� ��� ���������� ���� 
					socketList.add(socketThread);						
					// ���ο� �����带 �����Ͽ� �������� Socket�ν��Ͻ��� �̿��� ����� ��Ʈ������
					// �������� ����� ����� �����ϴ� run() �޼ҵ� ��� ���� 
					socketThread.start(); // �����带 ���������� ���� 
				} catch (IOException e) {
						System.out.println("[�����α�]Ŭ���̾�Ʈ�� ���� ���� ������ �߻�");
					}
			}
		} catch (IOException e) {
			System.out.println("[�����α�]������ ���������� ���۵��� �ʽ��ϴ�.");
		}
	}
	public static void main(String[] args)  {
		new ChatServerApp();
	}
	
	// �޼����� ���޹޾� ���� �������� ��� Ŭ���̾�Ʈ���� �����ϴ� �޼ҵ�

	public void sendMessage(String message) {
		//List �ν��Ͻ��� ���(SocketThread �ν��Ͻ�)�� �ϳ��� �����޾� ��� - �ϰ�ó��  
		for(SocketThread socketThread : socketList) {
			//Ŭ���̾�Ʈ�� ����� ������ Socket �ν��Ͻ��� ��½�Ʈ���� �̿��Ͽ� �޼��� ����  
			socketThread.out.println(message); // ��� ���Ͽ��� �ϰ������� �޼����� ��� �ؼ� ������ 
		}
	}
	
	// Ŭ���̾�Ʈ�� ����� ���ϰ� ����� ��Ʈ���� �����Ͽ� ����� ����� �����ϱ� ���� ���� Ŭ����(Inner class)
	// => �������� ����� ����� �����ϱ� ���� ���ο� �����带 �����Ͽ� ���۵ǵ��� ����
	
	// innerclass -> outer Ŭ������ �ʵ� �޼ҵ带 ��밡���ϴϱ� �ܺο��� �������� ���ϱ� ���ؼ� 
	public class SocketThread extends Thread {
		// Ŭ���̾�Ʈ�� ����� ������ Socket �ν��Ͻ��� �����ϱ� ���� �ʵ� 
		private Socket socket;
		
		// Ŭ���̾�Ʈ�� ������ �޼����� ���޹��� �Է½�Ʈ���� �����ϱ� ���� �ʵ�
		private BufferedReader in;
		
		// Ŭ���̾�Ʈ ���� �޼����� �����ϴ� ��½�Ʈ���� �����ϱ� ���� �ʵ�
		private PrintWriter out;
		
		// SocketThread Ŭ������ �ν��Ͻ��� �����ϱ� ���� ������ �ۼ� 
		//=> Socket �ν��Ͻ��� ���޹޾� �ʵ� �ʱ�ȭ
		public SocketThread(Socket socket) {
			this.socket = socket;
		}
		//���Ӱ� ������ �����尡 �����ϱ� ���� ����� �ۼ�
		//=> Ŭ���̾�Ʈ���� ������ �޼����� ���޹޾� ��� ���� Ŭ���̾�Ʈ���� �����ϴ� �޼ҵ�
		@Override
		public void run() {
			String aliasName = ""; // Ŭ���̾�Ʈ�� ��ȭ���� �����ϱ� ���� ����  	
			
			try {
				//Socket �ν��Ͻ��� �Է½�Ʈ���� �����޾� ���ڿ��� ���޹����� �ִ� �Է� ��Ʈ������ 
				//Ȯ���Ͽ� �ʵ忡 ����  
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//Socket �ν��Ͻ��� ��½�Ʈ���� ��ȯ�޾� ���ڿ��� �����Ҽ� �ִ� ��� ��Ʈ������
				// Ȯ���Ͽ� �ʵ忡 ���� 
				
				// out = new PrintWriter(socket.getOutputStream()); Writer ���� ��� ��Ʈ���� ��뷮�� ���� �����ϴ� ��½�Ʈ������
							// ���� ũ�Ⱑ �̸��� ��� ��¹��ۿ� ���� �����ϰ� �����͸� ������ - flush() �޼ҵ� ��� 
				
				// PrintWriter(OutputStream out ,boolean autoFlush) : ��½�Ʈ���� Ȯ���Ͽ�
				// ��� �ڷ����� ���� ���ڿ��� ��ȯ�Ͽ� �����ϵ� boolean �Ű������� true�� 
				// �����ϸ� ��� ���۸� ������� �ʰ� ������ ����Ÿ�� �����ϴ� �ν��Ͻ��� 
				// �����ϴ� ������ 
				out = new PrintWriter(socket.getOutputStream() , true);
				
				// Ŭ���̾�Ʈ���� ������ ��ȭ���� ��ȯ�޾� ���� - �Է½�Ʈ�� ��� 
				aliasName = in.readLine();
				
				// ���� ���ӵ� ��� Ŭ���̾�Ʈ ���� ���� �޼����� ���� - ��½�Ʈ�� ��� 
				sendMessage("["+aliasName+"]���� ���� �Ͽ����ϴ�.");
				
				// Ŭ���̾�Ʈ���� ������ �޼����� ���޹޾� ���� �������� ��� Ŭ���̾�Ʈ���� ����
				// => Ŭ���̾�Ʈ�� ������ �����ϱ� ������ �ݺ� ó�� 
				// => Ŭ���̾�Ʈ�� ������ �����ϸ� ����� ��Ʈ���� ���ŵǹǷ� IOException �߻� 
				while(true) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}
			} catch(IOException e) {
				// Ŭ���̾�Ʈ�� ������ �����ϸ� ����� ��� �ۼ� 
				// => List �ν��Ͻ��� ����� SocketThread �ν��Ͻ� ��� ���� 
				// => ���� �������� ��� Ŭ���̾�Ʈ���� ���� �޼����� ����
				socketList.remove(this); // this - �������ν��Ͻ��� �����ϰڴ�.
				sendMessage("["+aliasName+"]" + "���� �����Ͽ����ϴ�.");
				
				System.out.println("[���� �α�]" + socket.getInetAddress().getHostAddress()
						+"�� ��ǻ�Ϳ��� ������ ���� �Ͽ����ϴ�..");
			}
		}
	}
}
