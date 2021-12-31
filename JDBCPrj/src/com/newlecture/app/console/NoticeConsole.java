package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.service.Notice;
import com.newlecture.app.service.NoticeService;

public class NoticeConsole {
	Scanner scan = new Scanner(System.in);
	
	private NoticeService service;
	int page; // page 상태변수
	private String searchWord;
	private String searchField;
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
		searchWord = "";
		searchField = "TITLE";
	}
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page,searchField,searchWord); // page 상태변수에 따라서 서비스 검색 키워드 
		// 목록을 추가할때 레코드 개수
		int count = service.getCount(); // 지역내에서만 쓰는 변수
		int lastPage = count/10;// count를 지역적으로만 쓰는 변수로 쓰면 될것 같다. 
								// 100 -> 10 , 90->9, 93/10->9 넘어가니까...
		lastPage = count % 10 == 0 ? lastPage : lastPage + 1; // 마지막 페이지 							
		System.out.println("───────────────────────────────────────");
		System.out.printf("<공지사항> 총 %d 게시글\n" , count);
		System.out.println("───────────────────────────────────────");
		
		for(Notice n : list) {
			System.out.printf("%s  %s / %s / %s \n",
				n.getId(),
				n.getTitle(), 
				n.getWriterId(), 
				n.getRegDate());
		}
		System.out.println("─────────────────────────────");
		System.out.printf("			%d/%d pages \n" , page, lastPage); // 현재페이지 , 마지막페이지
 	}
	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("1.상세조회 / 2. 이전 / 3. 다음 / 4. 글쓰기 5. 검색 6. 종료 > ");
		String menu_ = scan.nextLine(); // 임시변수에 담음
		int menu = Integer.parseInt(menu_);
		return menu;
	}
	public void movePrevList() {
		if(page == 1) {
			System.out.println("==================");
			System.out.println("[ 이전 페이지가 없습니다. ] ");
			return; // 끝내기 
		}
		page--;
	}
	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount(); // 지역내에서만 쓰는 변수
		int lastPage = count/10;
		lastPage = count % 10 > 0 ? lastPage + 1 : lastPage;
		if(page == lastPage) {
			System.out.println("==================");
			System.out.println("[ 다음 페이지가 없습니다. ] ");
			return; // 끝내기 
		}
		page++;
	}
	public void inputSearchWord() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 범주(title/content/writerId)중에 하나를 입력하세요");
		System.out.print(">");
		searchField = scan.nextLine();
		System.out.print("검색어 > ");
		searchWord = scan.nextLine();
		
	}
}
