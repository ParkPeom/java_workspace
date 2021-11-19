package com.codechobo.thread;

public class DaemonThread implements Runnable {
	
	public DaemonThread() {}
	@Override
	public void run() {
		// ���ѷ��� 0.5�ʾ� ���󽺷��尡 �������Դϴ�. �ۼ��غ�
		while(true) {
			System.out.println("���� �����尡 �������Դϴ�. ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonThread());
		thread.setDaemon(true); // ���󽺷���� ����
		thread.start(); // ���󽺷��尡 ���ᰡ�Ǹ� ��� �����尡 �����
		
		// ���ν����� ��ü�� sleep 1������ �ִٰ� ����
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// ���ν����尡 ����Ǵϱ� ���󽺷��嵵 ����ȴ�.
	System.out.println("���� �����尡 ���� �˴ϴ�.");	
	}
}
