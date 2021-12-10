import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//������ ���ӵ� Ŭ���̾�Ʈ�� ������ �޼����� ���޹޾� ����ϴ� ���� ���α׷� 

public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer = null;
		
	try {
		echoServer = new ServerSocket(9000);
		System.out.println("[�޼���] Echo Server Running...");
		
		while(true) { 
			Socket socket = echoServer.accept();
			// ������ �Է½�Ʈ���� �����޾� ���ڿ��� �Է¹��� �� �ֵ��� ��Ʈ�� Ȯ��
			// Ŭ���̾�Ʈ�� ������ ���ڸ� ���ڿ��� 
			// 1����Ʈ -> 2����Ʈ -> ���� ���� (Ȯ��)
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// Ŭ���̾�Ʈ�� ������ �޼����� �о� ȭ�鿡 ���
			// => Ŭ���̾�Ʈ�� �޼����� ������ ������ �����尡 �Ͻ� ���� 
			System.out.println("["+socket.getInetAddress().getHostAddress()
					+ " ] ���� ������ �޼��� = " + in.readLine());
			socket.close();
		}
	} catch(IOException e) {
		System.out.println("[����] ������ ��Ʈ��ũ ������ �߻��Ͽ����ϴ�.");
		}
	}
}
