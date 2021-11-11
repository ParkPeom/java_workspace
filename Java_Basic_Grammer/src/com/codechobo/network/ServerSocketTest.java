package com.codechobo.network;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public ServerSocketTest() {
		//������ ����ϴ� ServerSocket��ü�� �����Ѵ�.
		try {
			ServerSocket ss = new ServerSocket(12000);
			System.out.println("���Ӵ����.....");
			
			Socket s = ss.accept();
			
			//�������� ip������
			InetAddress ia = s.getInetAddress();//������ ��ǻ���� ip
			System.out.println(ia.getHostAddress()+"-->Ŭ���̾�Ʈ �����߽��ϴ�.");
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("�ȳ� �� ������...");
			bw.flush();
			bw.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerSocketTest();
	}
}
