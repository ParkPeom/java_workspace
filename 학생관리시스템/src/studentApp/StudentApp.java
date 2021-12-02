package studentApp;

import java.util.Scanner;

import studentdao.StudentDAO;

public class StudentApp {
	public StudentApp() {
	}
	public void start() {
		menu();
	}
	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("1. 추가 2. 조회 3. 수정 4. 삭제 5. 이름조회 6. 종료 > ");
			String str = sc.nextLine();
			int choice = Integer.parseInt(str);
			StudentDAO studentdao = new StudentDAO();
			
			switch(choice) {
				case 1:
					// 추가
					studentdao.addStudent();
					break;
				case 2:
					// 조회
					studentdao.selectStudent();
					break;
				case 3:
					// 수정
					studentdao.updateStudent();
					break;
				case 4:
					// 삭제
					studentdao.deleteStudent();
					break;
				case 5:
					studentdao.getSearchRecord();
					// 학생 조회
					break;
				case 6:
					System.out.println("종료됨");
					System.exit(0);
			}
		}
	}	
	public static void main(String[] args) {
		new StudentApp().start();
		
	}
}
