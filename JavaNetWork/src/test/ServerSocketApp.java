package test;

import java.io.IOException;
import java.net.ServerSocket;
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i = 2000; i <= 9000; i+=1000) {
			try {
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("[메세지]" +  i + "번 포트는 사용이 가능");
			// serverSocket.close(0 : 서버 기능을 제거 하는 메소드)
		} catch(IOException e) {
			System.out.println("[에러]"+i+"번 포트는 이미 사용중 입니다.");
			}
		}
	}
}
