package com.codechobo.network;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public ServerSocketTest() {
		//접속을 대기하는 ServerSocket객체를 생성한다.
		try {
			ServerSocket ss = new ServerSocket(12000);
			System.out.println("접속대기중.....");
			
			Socket s = ss.accept();
			
			//접속자의 ip얻어오기
			InetAddress ia = s.getInetAddress();//접속자 컴퓨터의 ip
			System.out.println(ia.getHostAddress()+"-->클라이언트 접속했습니다.");
			
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write("안녕 나 서버야...");
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
