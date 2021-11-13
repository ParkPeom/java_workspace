package com.codechobo.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 1. 서버
public class ServerSocketTest {

	public ServerSocketTest() {
		// 2 . 접속을 대기하는 ServerSocket객체를 생성한다.
		try {
			ServerSocket ss = new ServerSocket(12000);
		
		while(true) {
			// 3. 서버 접속 대기
			System.out.println("접속대기중.....");	
			Socket s = ss.accept(); 
			
			// 6. 접속자의 ip얻어오기
			InetAddress ia = s.getInetAddress();//접속자 컴퓨터의 ip
			System.out.println(ia.getHostAddress()+"-->클라이언트 접속했습니다.");
			
		
			// 7. 서버가 클라이언트에 메시지 보내기
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			pw.println("너 아이피 " + ia.getHostAddress() +"이지 ?? ");
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//			bw.write("안녕 나 서버야...\n");
//			pw.flush();
			pw.flush();
			// 10.
			// 클라이언트가 보낸 문자를 받기 위한 inputStream 객체가 있어야 한다.
			// 한줄로  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 InputStreamReader isr = new InputStreamReader(s.getInputStream());
			 BufferedReader br = new BufferedReader(isr);
			 String sendData = br.readLine(); // 클라이언트가 보낸 문자를 받음
			 System.out.println("서버가 받은 문자----->"+sendData);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerSocketTest();
	}
}
