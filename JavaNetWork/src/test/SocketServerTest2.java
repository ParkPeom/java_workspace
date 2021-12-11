package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServerTest2 {
	
	public SocketServerTest2() {
		
		try {
			ServerSocket socket = new ServerSocket(120000);
			
		while(true) {
			System.out.println("접속 대기중...");
			
			// 접속한 사용자들의 소켓으로 받는다. 
			Socket s = socket.accept();
			InetAddress ia = s.getInetAddress(); // 접속 컴퓨터 ip들 계속 가져옴
			System.out.println( ia.getHostAddress() + "-->클라이언트가 접속 하였습니다.");
			
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SocketServerTest2();
	}
}
