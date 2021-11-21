package ex1;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsole;

public class Program5 {

	public Program5() {
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeConsole console = new NoticeConsole();
		// int page; // page 상태변수
		// NoticeConsole : 페이지에 대한 상태값을 가지고 있다.
	EXIT : while(true) {
		console.printNoticeList();// 출력
		int menu = console.inputNoticeMenu();// 입력
		switch(menu) {
		case 1: // 상세 조회 
			break;
		case 2:	// 이전
			console.movePrevList();
			//--page;
			break;
		case 3: // 다음 
			console.moveNextList();
			//++page;
			break;
		case 4: // 글쓰기 
			break; 
		case 5: // 검색
			console.inputSearchWord();
			break;
		case 6: // 종료
			System.out.println("Bye ~ ");
			break EXIT; // 무한루프 로 벗어남 
		default:
			System.out.println("<<사용방법>> 메뉴는 1~4까지만 입력 할수 있습니다.");
				break;
			}
		}
	}
}
