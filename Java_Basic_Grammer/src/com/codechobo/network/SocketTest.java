package com.codechobo.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

// Ŭ���̾�Ʈ 
public class SocketTest {

	public SocketTest() {
		try {
			// 4. ������ �����ϱ� 172.30.34.113
			InetAddress ia = InetAddress.getByName("172.30.34.113");
			// 5. ���� 12000�� ������
			Socket s = new Socket(ia, 12000);
			
			// 8.  �����κ��� ���� 
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String receive = br.readLine();
			System.out.println(receive);
			
			// 9. Ŭ���̾�Ʈ�� ������ ������ ������ - ���� ������ ���� 
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			// ������ ���ھ���
			pw.println("����");
			pw.flush();
			pw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SocketTest();
	}
}
