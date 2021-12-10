import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressApp {
	
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress : ��Ʈ��ũ �ּ�(IP Address)�� ��ǻ�� �̸�(HostName)�� �����ϱ� ���� Ŭ����
				//InetAddress.getLocalHost() : ���� ��ǻ���� ��Ʈ��ũ �ּҿ� ��ǻ�� �̸��� ����� 
				//InetAddress �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
				// => UnknownHostException �߻� : ��Ʈ��ũ���� ��ǻ�� �̸��� ��ǻ�͸� �˻��� �� ���� ��� �߻��Ǵ� ����
				// => �̴���(Ethernet) ��ġ�� ��ϵ� ��Ʈ��ũ ���� ����
				//���� ��ǻ��(���� ������� ��ǻ��)�� �⺻������ [127.0.0.1]�� ��Ʈ��ũ �ּҿ� 
				//[localhost]�� ��ǻ�� �̸����� ���� 
				InetAddress myComputer=InetAddress.getLocalHost();
				
				//InetAddress.toString() : InetAddress �ν��Ͻ��� ����� ��Ʈ��ũ �ּҿ� ��ǻ�� �̸���
				//���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� - ���������� ����� ��� �ڵ� ȣ��Ǵ� �޼ҵ�
				System.out.println("myComputer = "+myComputer);
				
				//InetAddress.getHostName() : InetAddress �ν��Ͻ��� ����� ��ǻ�� �̸��� ��ȯ�ϴ� �޼ҵ�
				System.out.println("��ǻ�� �̸�(HostName) = "+myComputer.getHostName());

				//InetAddress.getHostAddress() : InetAddress �ν��Ͻ��� ����� ��Ʈ��ũ �ּҸ� ��ȯ�ϴ� �޼ҵ�
				System.out.println("��Ʈ��ũ �ּ�(IP Address) = "+myComputer.getHostAddress());
				System.out.println("==============================================================");
				//InetAddress.getByName(String host) : ���޹��� ��ǻ�� �̸��� ���� ��Ʈ��ũ �ּҿ� 
				//��ǻ�� �̸��� ����� InetAddress �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
				InetAddress itwill=InetAddress.getByName("www.itwill.xyz");
				
				System.out.println("[www.itwill.xyz]�� IP Address = "+itwill.getHostAddress());
				System.out.println("==============================================================");
				//InetAddress.getAllByName(String host) : ���޹��� ��ǻ�� �̸��� ���� ��� ��Ʈ��ũ  
				//�ּҿ� ��ǻ�� �̸��� ����� InetAddress �ν��Ͻ��� �����Ͽ� �迭�� ��ȯ�ϴ� �޼ҵ�
				InetAddress[] naver=InetAddress.getAllByName("www.naver.com");
				
				for(InetAddress address:naver) {
				System.out.println("[www.naver.com]�� IP Address = "+address.getHostAddress());
			}
			System.out.println("==============================================================");
		}
	}

