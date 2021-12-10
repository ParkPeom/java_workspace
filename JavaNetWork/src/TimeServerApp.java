import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//���� Ŭ���̾�Ʈ���� ���� ��ǻ���� ��¥�� �ð��� �����ϴ� ���� ���α׷�
// => NTP(Network Time Protocol) Sever : ��¥�� �ð��� �����ϴ� ��ǻ��  
public class TimeServerApp {
	
	public static void main(String[] args) {
		ServerSocket ntpServer =  null;
		
		try {
			//ServerSocket �ν��Ͻ� ���� -  ���� ����
			ntpServer = new ServerSocket(3000);
			System.out.println("[�޼���] NTP Server Running...");
			// ������ �ټ��� Ŭ���̾�Ʈ ������ ����ϱ� ���� ���� ������ �̿��Ͽ� ó��
			// Ƚ���� �𸣴� ���� ���ѷ��� 
			while(true) {
				// accept() : Ŭ���̾�Ʈ ������ ��ٸ��� �޼ҵ� 
				// => Ŭ���̾�Ʈ ���� ������ ������ �Ͻ� ����
				// => Ŭ���̾�Ʈ�� ���ӵǸ� Ŭ���̾�Ʈ ���ϰ� ����� Socket �ν��Ͻ��� �����Ͽ� ��ȯ 
				// => ���� ���� ���� Ŭ���̾�Ʈ �� ��ŭ �������� Socket �ν��Ͻ� ����
				Socket socket = ntpServer.accept();
				
				/*
				// socket.getOutputStream() : Socket �ν��Ͻ��� ��½�Ʈ��(OutputStream �ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
				// => ���ӵ� ��ǻ�Ϳ��� ���� ������(1Byte)�� �����ϴ� ��� ��Ʈ�� 
				OutputStream out = socket.getOutputStream();
				
				// Socket �ν��Ͻ��� ��� ��Ʈ���� ���޹޾� ��ü�� ���� �� �� �ִ� ��� ��Ʈ������ Ȯ���Ͽ� ���� 
				ObjectOutputStream stream = new ObjectOutputStream(out);
				
				// Ŭ���� ��Ʈ���� ���޵� ������ ���� ��¥��  ��¥ �ð��� ����� Date �ν��Ͻ� ����
				Date date = new Date();
				
				// writeObject(Object obj) : ��½�Ʈ���� �̿��Ͽ�
				// ��ü(�ν��Ͻ�)�� �����ϴ� �޼ҵ�
				//=> Ŭ���̾�Ʈ���� ������ ���� ��¥�� �ð��� ���� 
				stream.writeObject(date); // Ŭ���̾�Ʈ���� date�� �ְڴ�.
				*/			
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				//�α�(Log) ��� : ������ ��� (������ ���ӵ� ����� ���)
				System.out.println("[�α�]Ŭ���̾�Ʈ[" + socket.getInetAddress().getHostAddress() +"]���� ��¥�� �ð��� ���� �Ͽ����ϴ�.");
				// getLocalAddress : ������ �ּ�
				// getInetAddress : Ŭ���̾�Ʈ�� �ּ� 
				
				// ���� ���� - Ŭ���̾�Ʈ���� ���� ���� 
				socket.close();
			}
		}catch(IOException e) {
			System.out.println("[����] ������ ��Ʈ��ũ ������ �߻��Ͽ����ϴ�. ");
		}
	}
}
