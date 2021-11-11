package com.codechobo.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTest {

	public SocketTest() {
		try {
			//������ �����ϱ� 10.10.4.103
			InetAddress ia = InetAddress.getByName("10.10.4.103");
			//������ ������
			Socket s = new Socket(ia, 12000);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String receive = br.readLine();
			System.out.println(receive);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SocketTest();
	}
}
