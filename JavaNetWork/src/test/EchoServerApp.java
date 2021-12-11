package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer = null;
		
		try {
			echoServer = new ServerSocket(1000);
			System.out.println("[메세지] Echo Server Running");
			while(true) {
				Socket socket = echoServer.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("["+socket.getInetAddress().getHostAddress()
						+"] 님이 보내온 메세지 = " + br.readLine());
				socket.close();
			}
		} catch (IOException e) {
			System.out.println("[에러] 서버에 네트워크 문제가 발생 하였습니다.");
		}
	}
}
