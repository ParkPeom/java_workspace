package 채팅프로그램;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 채팅 클라이언트 프로그램 - Swing
// => 서버에서 보내온 메세지를 전달받아 컴퍼넌트 출력 - 반복 처리
// => 컴퍼넌트로 메세지를 입력받아 서버 전달 - 이벤트 핸드럴 메소드
public class ChatClientApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField field; // 입력 컴퍼넌트 
	private JTextArea area; // 출력 컴퍼넌트 
	
	//서버의 소켓과 연결될 Socket 인스턴스를 저장하기 위한 필드
	private Socket socket;
	
	//서버에서 보내온 메세지를 전달받기 위한 입력스트림을 저장하기 위한 필드 
	private BufferedReader in; 
	
	//서버에게 메세지를 전달할 출력스트림을 저장하기 위한 필드
	private PrintWriter out;
	
	//대화명을 저장하기 위한 필드 
	private String aliasName;
	
	public ChatClientApp(String title) {
		field = new JTextField();
		area = new JTextArea();
		
		JScrollPane pane = new JScrollPane(area);
		getContentPane().add(pane , BorderLayout.CENTER);
		getContentPane().add(field , BorderLayout.SOUTH);
		field.setFont(new Font("굴림체",Font.BOLD, 20));
		area.setFont(new Font("굴림체",Font.BOLD, 20));
		area.setFocusable(false); // 포커스가위치하지않도록 false
	
		// field.addActionListener( new EventHandler());
		
		// field.addActionListener( new ActionListener()); // 인터페이스로 인스턴스를 만들수없다.
		
		// 인터페이스로 인스턴스를 만들수없어서 객체를 만들수있는 방법
		// 익명의 내부 클래스로 인스턴스를 사용하여 이벤트 핸들러 등록
		// 익명의 내부 클래스(Anonymous Inner Class) : 추상클래스 또는 인터페이스를 상속받은 
		// 이름이 없는 클래스로 인스턴스를 생성 하기 위한 방법
		// 추상메소드를 직접 오버라이드 선언하여 인스턴스 생성할수있다 
		// => 하나의 인스턴스를 생성하여 프로그램을 작성할 경우 사용 
		field.addActionListener( new ActionListener() {
			// 이벤트 핸들러 메소드 
			// -> JTextField 컴퍼넌트 입력된 메세지를 얻어와 서버에 전달하는 명령어
			public void actionPerformed(ActionEvent e) {
				//  JTextField 컴퍼넌트에서 입력된 메세지를 반환받아 저장 
				String message = field.getText();
				
				if(!message.equals("")) { // 입력 메세지가 존재할 경우
					out.println(message); // 서버에 메세지를 전달
					field.setText(""); // JTextField 컴퍼넌트 입력 초기화 
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,400,500);
		setVisible(true);
		
		try {
			socket = new Socket("192.168.0.23",6000); // 서버 접속 
			
			//Socket 인스턴스의 입력스트림을 제공받아 문자열을 전달받을수 있는 입력 스트림으로 
			//확장하여 필드에 저장 
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
			
			// 모든 자료형의 값을 문자열로 변환하여 전달하되 boolean 매개변수에 true를 
			// 전달하면 출력 버퍼를 사용하지 않고 무조건 데이타를 전달하는 인스턴스를 
			// 생성하는 생성자 
			out = new PrintWriter(socket.getOutputStream() , true);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "서버에 접속할 수 없습니다.",
					"접속오류",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// 대화명을 입력받아 필드에 저장 - 정상적인 대화명이 입력되도록  반복처리 
		while(true) {
			// 입력 다이얼로그 사용하여 대화명을 입력받아 저장 
			aliasName = JOptionPane.showInputDialog(this,"대화명을 입력해 주세요"
					,"대화명 입력",JOptionPane.QUESTION_MESSAGE);
			//정상적인 대화명이 입력된 경우 반복문이 종료 
			if(aliasName != null && !aliasName.equals(""))break;
			
			aliasName = JOptionPane.showInputDialog(this,"대화명을반드시 입력해주세요"
					,"입력오류",JOptionPane.ERROR_MESSAGE);
		}
		// 입력받은 대화명을 서버에 전달
		out.println(aliasName);
		
		// 서버에서 보내온 메세지를 전달받아 JTextArea 컴퍼넌트에 추가하여 출력 - 반복 처리
		while(true) {
			try {
				area.append(in.readLine() + "\n");
				
				//JTextArea 컴퍼넌트의 스크롤을 맨 아래로 이동
				// JTextArea 컴퍼넌트의 스크롤 위치를 변경하는 메서드 
				area.setCaretPosition(area.getText().length()); // 쌓일수록 스크롤 위치를 내려줌 
				
			} catch(IOException e) {
				aliasName = JOptionPane.showInputDialog(this,"서버와의 연결이 끊어졌습니다."
						,"접속오류",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClientApp("채팅프로그램");
	}

	public class EventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
	}
}
