package xyz.itwill.thread;

//���� ������ ���α׷� - �����ڰ� �����带 �����Ͽ� main ������ʹ� �޸� �ٸ� ����� �����ϴ� ���α׷�
// => ��� �����尡 �Ҹ�Ǿ�߸� ���α׷��� ���� 
public class MultiThreadApp {
	//main �޼ҵ�� ���޵Ǵ� ��� ���ܴ� JVM���� �ڵ����� ���� ó�� 
	public static void main(String[] args) throws InterruptedException {
		//JVM�� ���� main������ �ڵ� ����
		// => main ������� main() �޼ҵ带 �ڵ� ȣ���Ͽ� ��� ���� 
		
		/*
		Thread thread = new Thread(); //Thread �ν��Ͻ� ����
		//Thread.start() : Thread �ν��Ͻ��� �̿��Ͽ� ���ο� �����带 �����ϴ� �޼ҵ�
		// => ���Ӱ� ������ ������� Thread �ν��Ͻ��� run() �޼ҵ带 �ڵ� ȣ���Ͽ� ��� ���� 
		// Thread �ν��Ͻ��� ����� run() �޼ҵ忡�� ����� ��� ������ 
		// => Thread Ŭ������ ��ӹ��� �ڽ�Ŭ������ �ۼ��Ͽ� run() �޼ҵ� �������̵� ����
		thread.start();
		*/
		
		// Thread Ŭ������ ��ӹ��� �ڽ�Ŭ������ �ν��Ͻ� ���� - Thread �ν��Ͻ� ���� 
		// => �ڽ� Ŭ������ �ν��Ͻ��� �����Ǳ� ���� �θ� Ŭ����(Thread �ν��Ͻ�)��  ���� �����ȴ�. 
		//�θ�Ŭ������ �ν��Ͻ��� start() �޼ҵ带 ȣ���Ͽ� ���ο� �����尡 �����ȴ�.
		// => ���Ӱ� ������ ������� �ڽ� Ŭ������ �ν��Ͻ��� run() �޼ҵ带 ȣ���Ͽ� ��� ����
		// => main ������� ���Ӱ� ������ ������� ���� �ٸ� ������� ����� ���� 
		//= > ���Ӱ� ������ ������� �ڽ� �ν��Ͻ��� �����ϰ�
		//   run() �޼ҵ��� ����� ���ÿ� ���� ����(���ÿ� �������� ���ð� �ƴ� �����¾ְ� ��������)
		/*
		MultiThreadOne thread = new MultiThreadOne();
		thread.start();
		*/
		
		//�ϳ��� Thread �ν��Ͻ��� �ϳ��� �����常 ���� - �ν��Ͻ��� ������ �������� �̻��
		new MultiThreadOne().start(); // �޼ҵ带 �ѹ��� ȣ�� �ϴ� ��� 
		new MultiThreadOne().start();
		
		/*
		//Runnable �������̽��� ��ӹ��� �ڽ�Ŭ������ �ν��Ͻ� ����
		MultiThreadTwo two = new MultiThreadTwo();
		//Thread(Runnable target) : Runnable �������̽��� ��ӹ��� �ڽ� �ν��Ͻ��� �Ű������� 
		//���޹޾� Thread �ν��Ͻ� ���� 
		// => ���������� �ڽ��ν��Ͻ��� run() �޼ҵ带 �������̵� ������ �Ͱ� �����ϰ� ó��
		Thread thread = new Thread(two);
		//Thread �ν��Ͻ��� ���ο� �����带 �����Ͽ�  Runnable �������̽��� ��ӹ��� �ڽ� 
		// �ν��Ͻ��� run() �޼ҵ尡 �ڵ� ȣ��Ǿ� ��� ����
		// ex) ��� �Ѿ� ����� ���ε��� �����ϰ� �ȴ�.
		thread.start();
		*/
		
		// Runnable �������̽��� ����ϴ� ���� 
		// => �ڽ�Ŭ������ Thread Ŭ������ ��ӹ��� ���� ��� Runnable �������̽� ��� 
		new Thread(new MultiThreadTwo()).start();
		
		for(int i = 0; i <= 9; i++) {
			System.out.print(i);
			// 01abcdefghijklmnopqrstuvwxyz23456789 ������ ������������ä �����
			
			//Thread.sleep(long ms) : ���� ����� �����ϴ� �����带 �Ű������� 
			// ���޵� �ð�(ms)��ŭ �Ͻ� �����ϴ� �޼ҵ� 
			// �ʹ� ũ�� ������ ����� �ɸ� (�׾����)
			// => InterruptedException �߻� - ����ó�� ���� ���� ��� ���� �߻� (���� ���� ����)
			Thread.sleep(500);
			
		}
	}
}
