package ex1;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsole;

public class Program5 {

	public Program5() {
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeConsole console = new NoticeConsole();
		// int page; // page ���º���
		// NoticeConsole : �������� ���� ���°��� ������ �ִ�.
	EXIT : while(true) {
		console.printNoticeList();// ���
		int menu = console.inputNoticeMenu();// �Է�
		switch(menu) {
		case 1: // �� ��ȸ 
			break;
		case 2:	// ����
			console.movePrevList();
			//--page;
			break;
		case 3: // ���� 
			console.moveNextList();
			//++page;
			break;
		case 4: // �۾��� 
			break; 
		case 5: // �˻�
			console.inputSearchWord();
			break;
		case 6: // ����
			System.out.println("Bye ~ ");
			break EXIT; // ���ѷ��� �� ��� 
		default:
			System.out.println("<<�����>> �޴��� 1~4������ �Է� �Ҽ� �ֽ��ϴ�.");
				break;
			}
		}
	}
}
