package com.codechobo.thread;

public class JoinExam {

	public JoinExam() {
	}
	public static void main(String[] args) {
		MyThread5 thread = new MyThread5();
		thread.start();
		// ���ν����尡 ���� ���ᰡ ���� ��������...
		// System.out.println("����");
		// System.out.println("����!");
		
		// join �޼��带 �̿��ؼ� �ش� �����尡 ���������� �ʰ� MyThread5 �� ��� ������ �ɋ����� ��ٷ��ִ� �޼���
		 System.out.println("����");
		 try {
			thread.join(); // ��� ���������� 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("����!"); // ���� ��� 
	}
}
