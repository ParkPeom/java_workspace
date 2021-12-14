package 채팅프로그램따라만들기;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import 채팅프로그램.ChatServerApp.SocketThread;

public class ChatServerApp {
	
	private List<SocketThread> socketList;
	
	public ChatServerApp() {
		ServerSocket chatServer = null;
		
	try {
		chatServer = new ServerSocket(13000);
		System.out.println("[메세지]채팅 서버 동작 중...");
		socketList = new ArrayList<SocketThread>();
		
		while(true) {
			try {
				Socket socket = chatServer.accept();
				System.out.println("[접속 로그]" + socket.getInetAddress().getHostAddress());
				
				
				} catch (IOException e) {
					System.out.println("[에러로그]클라이언트의 접속 관련 문제가 발생");
				}
		}
	} catch (IOException e) {
		System.out.println("[에러로그]서버가 정상적으로 동작되지 않습니다.");
		}
	}
}
