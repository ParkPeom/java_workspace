package com.codechobo.thread;

public class JoinExam {

	public JoinExam() {
	}
	public static void main(String[] args) {
		MyThread5 thread = new MyThread5();
		thread.start();
		// 메인스레드가 시작 종료가 벌써 끝나버림...
		// System.out.println("시작");
		// System.out.println("종료!");
		
		// join 메서드를 이용해서 해당 스레드가 끝나버리지 않고 MyThread5 가 모두 실행이 될떄까지 기다려주는 메서드
		 System.out.println("시작");
		 try {
			thread.join(); // 모두 끝날떄까지 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("종료!"); // 종료 출력 
	}
}
