package xyz.itwill.thread;

import javax.swing.JOptionPane;

//Thread Ŭ������ ��ӹ��� �ڽ�Ŭ���� - �ݵ�� run() �޼ҵ� �������̵� ����
public class MultiThreadOne extends Thread {
	//�ڽ�Ŭ������ �ν��Ͻ��� ������ ���ο� �����尡 ������ ����� �ۼ��ϴ� �޼ҵ�
	
	// ���ν������ ������ ����� 
	@Override
	public void run() {
		// ���ν����尡 ����ǵ� ���Ӱ� ������ ������� ����� 
		for(char i='a'; i <= 'z'; i++) {
			System.out.print(i);
			
			// �������̵� ����� �޼ҵ�� ���� ���� �Ұ��� 
			try {
				Thread.sleep(500);
				// ����ϰ� 0.5�� ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
