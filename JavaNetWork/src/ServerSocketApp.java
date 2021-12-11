import java.io.IOException;
import java.net.ServerSocket;

// ����(Server) : �ٸ� ��ǻ�Ͱ� ������ �� �ִ� ȯ���� �����ϴ� ��ǻ��
// Ŭ���̾�Ʈ(Client) : ������ ������ �� �ִ� ��ǻ��

// ServerSocket : [TCP ���] �� ��Ʈ��ũ ���α׷����� ������ �����ϱ� ���� Ŭ����
//=>  Ŭ���̾�Ʈ �����ϱ� ���� Ư�� ��Ʈ(Port)�� Ȱ��ȭ �Ͽ� �ν��Ͻ� ���� 
//=>  Ŭ���̾�Ʈ�� ������ ���ӵ� �� ������ Ŭ���̾�Ʈ ���� ������ ������ ����

// ServerSocket Ŭ������ �������� ��� ������ ��Ʈ ��ȣ�� �˻��ϴ� ���α׷�
// C:\Users\fight> netstat -na  CMD ���� ��Ʈ �˻� 

public class ServerSocketApp {

	public static void main(String[] args) {
		for(int i = 2000; i <= 9000; i+=1000) {
			try {
				//ServerSocket(int port) : ��Ʈ ��ȣ�� ���޹޾� ServerSocket �ν��Ͻ��� �����ϴ� ������
				//=> ���޵� ��Ʈ ��ȣ�� �ٸ� ��Ʈ��ũ ���α׷����� ������� ��� IOException  
				ServerSocket serverSocket = new ServerSocket(i);
				System.out.println("[�޼���]" + i +"�� ��Ʈ�� ��� ���� ");
				// serverSocket.close(0 : ���� ����� ���� �ϴ� �޼ҵ�)
				serverSocket.close();
			} catch(IOException e) {
				System.out.println("[����]"+i+"�� ��Ʈ�� �̹� ��� �� �Դϴ�.");
			}
		}
	}
}
