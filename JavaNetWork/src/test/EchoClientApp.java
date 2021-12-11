package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientApp {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���� �޼��� �Է� > ");
		String message = br.readLine();
		
	try {	
		Socket socket = new Socket("172.30.1.12",1000);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.print(false);
		out.flush();
		socket.close();
	} catch(Exception e) {
		System.out.println("[����]������ ���� �� �� �����ϴ�.");
		}
	}
}