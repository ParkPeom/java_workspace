package xyz.itwill.thread;

//���α׷� ����� JVM�� main() �޼��带 ȣ���Ͽ� �����ϱ� ���� �ڵ����� main ������ ���� 
// => main �����尡 main() �޼����� ����� �о� ���� 
// => main �����常 �̿��Ͽ� ���α׷� �ۼ� : ���� ������ ���α׷� 
// => ���� ������ ���α׷��� main() �޼ҵ尡 ����Ǹ� main ������ �Ҹ� -  ���α׷� ����
// => ���������� ��� : �����尡 ��� �ϳ��� �о��� cpu�� �� ����� ó�� �� ����ϳ��� �о��� cpu�� ����� ó��


// �츮�� ����� Swing ���α׷��� �⺻������ ���߽����� ���α׷��̴�. 

public class SingleThreadApp {	
	public static void main(String[] args) {
		/*
		System.out.println("SingleThread Ŭ������ main() �޼��忡 ��� ����");
		
		//Thread : ������ ���� ������ ����� �����ϱ� ���� Ŭ����
		//Thread.currentThread() : ���� ����� �����ϴ� Thread�ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//Thread.getName() : �����忡 �ο��� �̸�(�ĺ���)�� ��ȯ�ϴ� �޼ҵ�
		
		System.out.println("["+Thread.currentThread().getName()+"]�����忡 ���� main() �޼ҵ��� ��� ����ǰ� �־��");
		
		//�ν��Ͻ��� �����Ͽ� �޼ҵ� ȣ���ϸ� �ν��Ͻ� �޼ҵ��  �����尡 �̵��Ǿ� �޼ҵ���
		//��� ���� - �ν��Ͻ� �޼ҵ尡 ����Ǹ� ������ �ڵ����� �����Ͽ� �ϴܿ� �ۼ��� ��� ����  
		new SingleThread().display(); // �ν��Ͻ��� �����ϰ� �޼ҵ� ȣ�� (�޼ҵ��ѹ��� ȣ��)
		
		System.out.println("SingleThread Ŭ������ main() �޼��忡 ��� ����");
		*/
		
		// �ݺ����� �̿��Ͽ� A~Z(���ĺ� �빮��)�� ��� 
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		new SingleThread().display(); // ȣ�� �����尡 �̵� 
		
		// ������ ���� 
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}
}
