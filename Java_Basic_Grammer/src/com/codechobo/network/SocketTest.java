package com.codechobo.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

// 클라이언트 
public class SocketTest {

	public SocketTest() {
		try {
			// 4. 서버에 접속하기 172.30.34.113
			InetAddress ia = InetAddress.getByName("172.30.34.113");
			// 5. 서버 12000에 접속함
			Socket s = new Socket(ia, 12000);
			
			// 8.  서버로부터 받음 
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String receive = br.readLine();
			System.out.println(receive);
			
			// 9. 클라이언트가 서버로 데이터 보내기 - 문자 단위로 보냄 
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			// 서버로 문자쓰기
			pw.println("하이");
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
