package print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import choice.Choice;
import dao.CustomerDAO;
import dao.JoinDAO;
import dto.CustomerDTO;
import dto.JoinDTO;

public class Print {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int number;
	String answer;
	public Print() {}
	
	public static void firstprintmenu() {
		System.out.println("\t\tㅣ-----환영합니다. -----ㅣ\t\t");		
		System.out.println("\t\tㅣ-----1.회 원 가 입 -----ㅣ\t\t");
		System.out.println("\t\tㅣ-----2.로 그 인 -----ㅣ\t\t");
	}
	public static void showprintmenu(String id) {
		System.out.println(id +"님 어서오세요.");
		System.out.println("\t\t-----1. 마이페이지-----\t\t");
		System.out.println("\t\t-----2. 구매 하기-----\t\t");
		System.out.println("\t\t-----3. 구입 목록-----\t\t");
		Choice.showchoicemenu(id);
	}
	// 숫자 
	public static int setIntMessage(String msg) {
		int number = 0;
	try {	
		System.out.print(msg + " >> ");
		number = Integer.parseInt(br.readLine());
		} catch(IOException e) {
			System.out.println("[에러] 숫자를 입력해 주세요.");
		}
		return number;
	}
	// 문자 
	public static String setStringMessage(String msg) {
			String answer = "";
		try {	
			System.out.print(msg + " >> ");
			answer = br.readLine();
			
			} catch(IOException e) {
				System.out.println("[에러] 문자를 입력해 주세요.");
			}
		return answer;
	}
	// 회원가입 페이지 
	public static void join() {
		JoinDTO joindto = new JoinDTO();	
		JoinDAO joindao = JoinDAO.getDAO();	
		// 가입 테이블---------------------------------
		joindto.setId(setStringMessage("아이디"));
		joindto.setPassword(setStringMessage("패스워드"));
		joindto.setJumin(setStringMessage("주민번호"));
		joindto.setName(setStringMessage("이름"));
		joindto.setAge(setIntMessage("나이"));
		joindto.setGender(setStringMessage("성별"));
		joindto.setPhone(setStringMessage("전화번호"));
		joindto.setEmail(setStringMessage("이메일"));
		// DB에 값 넣음
		joindao.insertJoin(joindto);			
	}
	// 로그인 
	public static void login() {
		JoinDAO joindao = JoinDAO.getDAO();
		System.out.println("로그인 페이지 입니다.");
		String id = setStringMessage("아이디");
		String password = setStringMessage("비밀번호");
		List<JoinDTO> joinList = joindao.selectAllJoin();
		
		for(int i = 0; i < joinList.size(); i++) {
			if(id.equals(joinList.get(i).getId())
					&& password.equals(joinList.get(i).getPassword())) {
				System.out.println("로그인이 되셨습니다.");
				Print.showprintmenu(id);
			} else {
				
			}
		}	
	}
	// 마이페이지
	public static void myPage(String id) { // 가입한 아이디 bum4856
		CustomerDAO dao = CustomerDAO.getDAO();
		CustomerDTO dto = new CustomerDTO();			
		List<CustomerDTO> customer = dao.selectIDCustomer(id);
		for(int i = 0; i < customer.size(); i++) {
			System.out.println("아이디 : " + customer.get(i).getId()
					+" 돈 : " + customer.get(i).getMoney()
					+" 포인트 : " + customer.get(i).getBonuspoint());
		}
	}
}
