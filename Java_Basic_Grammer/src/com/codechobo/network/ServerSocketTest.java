package com.codechobo.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 1. ����
public class ServerSocketTest {

	public ServerSocketTest() {
		// 2 . ������ ����ϴ� ServerSocket��ü�� �����Ѵ�.
		try {
			ServerSocket ss = new ServerSocket(12000);
		
		while(true) {
			// 3. ���� ���� ���
			System.out.println("���Ӵ����.....");	
			Socket s = ss.accept(); 
			
			// 6. �������� ip������
			InetAddress ia = s.getInetAddress();//������ ��ǻ���� ip
			System.out.println(ia.getHostAddress()+"-->Ŭ���̾�Ʈ �����߽��ϴ�.");
			
		
			// 7. ������ Ŭ���̾�Ʈ�� �޽��� ������
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			pw.println("�� ������ " + ia.getHostAddress() +"���� ?? ");
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//			bw.write("�ȳ� �� ������...\n");
//			pw.flush();
			pw.flush();
			// 10.
			// Ŭ���̾�Ʈ�� ���� ���ڸ� �ޱ� ���� inputStream ��ü�� �־�� �Ѵ�.
			// ���ٷ�  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 InputStreamReader isr = new InputStreamReader(s.getInputStream());
			 BufferedReader br = new BufferedReader(isr);
			 String sendData = br.readLine(); // Ŭ���̾�Ʈ�� ���� ���ڸ� ����
			 System.out.println("������ ���� ����----->"+sendData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerSocketTest();
	}
}
