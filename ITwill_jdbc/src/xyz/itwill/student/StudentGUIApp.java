package xyz.itwill.student;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentGUIApp extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L; // 부모 JFrame serializable 의 고유값 객체 직렬화 (좀더 빠르게 객체 단위로 입출력 가능 ) 
													 // long 타입으로 1L 기본 

	// 상수 : 값을 대표해서 쓰는 이름  정수값을 명확하게 이름으로 구분할수있다. 
	public static final int NONE = 0; // 최초 상태로 초기화
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;

	JTextField noTF, nameTF, phoneTF, addressTF, birthdayTF;
	JButton addB, deleteB, updateB, searchB, cancelB;
	
	JTable table;
	
	int cmd;
	/********************************************
	 * 생성자 정의 - 디자인 : 모든 학생정보를 검색하여 출력 
	 *********************************************/
	public StudentGUIApp() throws Exception {
		setTitle("◆◆◆ 학생 관리 프로그램 ◆◆◆");
		setSize(800, 400); // 가로 800 세로 400

		
		// 모니터의 화면크기 알아내기 
		// Dimension : 특정영역의 사각형과 폭과 높이의 값을 관리할수 있도록 도와주는 클래스
		// Dimension 사각형모양 특정크기
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2); // setLocation 중앙에 위치 하기 위해서 

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1)); // 5행 1열(row) 배치 

		JPanel pno = new JPanel();
		pno.add(new JLabel("번  호")); // 라벨 문자열  
		pno.add(noTF = new JTextField(10)); // 값을 입력받음 

		JPanel pname = new JPanel();
		pname.add(new JLabel("이  름"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("생  일"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("전  화"));
		pphone.add(phoneTF = new JTextField(10));

		JPanel paddress = new JPanel();
		paddress.add(new JLabel("주  소"));
		paddress.add(addressTF = new JTextField(10));

		// 그리드 레이아웃에 추가 
		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5)); // 1행 5열 

		// addActionListener 버튼을 눌렀을때 처리하는 메서드 
		// 액션 이벤트 가 발생하면 내가 처리할수있도록 
		
		
		// 버튼들을 누를떄마다 액션 이벤트가 발생 
		bottom.add(addB = new JButton("추  가"));
		addB.addActionListener(this); // 액션 이벤트를 호출하는데 나 자신을 호출(actionperformed) 

		bottom.add(deleteB = new JButton("삭  제"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("변  경"));
		updateB.addActionListener(this);

		bottom.add(searchB = new JButton("검  색"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("초기화"));
		cancelB.addActionListener(this);

		Object[] title={"학번","이름","전화번호","주소","생년월일"}; // 타이틀
		table=new JTable(new DefaultTableModel(title, 0)); // (테이블 헤더 , 아에 행 0개) -> 타이틀만 출력 
		
		// 테이블을 쓰지않고 기록허용 안하고 크기 변경을 허용하지 않겠다.
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false); 
		table.getTableHeader().setResizingAllowed(false); // 기록 , 크기 변경 못하게 함 

		// JTable 컴퍼넌트에 모든 학생정보를 검색하여 출력하는 메서드 호출 
		displayAllStudent();
		JScrollPane sp=new JScrollPane(table); // 테이블 추가 
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE; // 먼가를 선택한게 없으면 NONE
		initialize(); // 모든 입력컴퍼넌트 호출해서 

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() { 
		// 모든 JTextField 컴퍼넌트 비활성화 시켜줌 
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}
	
	//매개변수에 전달되는 정수값에 따른 JTextField 컴퍼넌트의 활성화 또는 비활성 처리
	
	// 상태에 따라서 컴퍼넌트 
	public void setEditable(int n) {
		switch (n) {
		case ADD:
			noTF.setEditable(true);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		case DELETE:
			noTF.setEditable(true); // 학번으로 삭제하니까 학번만 입력 가능하게 함
			break;
		case UPDATE:
			noTF.setEditable(true);
			break;
		case UPDATE_CHANGE:
			noTF.setEditable(false);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		case SEARCH:
			nameTF.setEditable(true);
			break;
		case NONE:
			noTF.setEditable(false);
			nameTF.setEditable(false);
			phoneTF.setEditable(false);
			addressTF.setEditable(false);
			birthdayTF.setEditable(false);
		}
	}
	
	
	//매개변수에 전달되는 정수값에 따른 JButton 컴퍼넌트의 활성화 또는 비활성 처리하는 메소드
	
	// 현재 저장된 cmd 값에 따라서 어떤 컴퍼넌트는 활성화 처리 비활성화 처리 시킴 
	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD); // ADD만 활성화 처리 
			cmd = ADD;
			break;
		case DELETE:
			deleteB.setEnabled(true);
			setEditable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			updateB.setEnabled(true);
			setEditable(UPDATE);
			cmd = UPDATE;
			break;			
		case UPDATE_CHANGE:
			updateB.setEnabled(true);
			setEditable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;			
		case SEARCH:
			searchB.setEnabled(true);
			setEditable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE: // 취소했을때
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}
	// 모든 JTextFied 컴퍼넌트의 입력값 최초 상태로  초기화 처리하는 메소드
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}
	
	//모든 컴퍼넌트 JText 를 초기화 처리하는 메소드
	public void initDisplay() {
		setEnable(NONE); // 모든 버튼이 활성화 처리 
		clear();
		cmd = NONE;
		initialize(); // JTextField 비활성화 처리 	
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	
	
	//----------------------- 이벤트 처리 메소드 - JButton 컴퍼넌트를 누른 경우 자동 호출되는 메소드-----------------------
	
	
	public void actionPerformed(ActionEvent ev) { // 버튼에서 이벤트 처리 메서드 
		Component c = (Component) ev.getSource(); // 컴퍼넌트를 반환받음
		try {
			
			// 상태에 따라 활성화 비활성화 처리 
			
			
			if (c == addB) {//추가 버튼을 누른 경우
				if (cmd != ADD) { //ADD 상태가 아닌 경우 - 컴퍼넌트의 활성 또는 비활성 처리
					setEnable(ADD); // ADD 상태로 활성화	- 컴퍼넌트의 활성 또는 비활성화 처리 , JText 다 활성화			
				} else {//ADD 상태인 경우
					//JTextField 컴퍼넌트의 입력값을 이용하여 처리 >> 초기화 처리 
					addStudent(); // 추가 
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) { // DELETE 상태가 아닌 경우
					setEnable(DELETE); // DELETE 상태로 활성화 한다. 
				} else {
					removeStudent(); // 삭제 				
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if (cmd != UPDATE_CHANGE) { // 업데이트상태인데 업데이트체인지가 아니라면 
					searchNoStudent(); // 학번을 가져다가 검색 해서 
				} else {
					modifydStudent(); // 체인지 상태에서 호출
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					searchNameStudent();	
				}
			} else if (c == cancelB) {
			    displayAllStudent();
				initDisplay();
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}		
	}
	
	// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable컴퍼넌트에 출력하는 메서드
	// => 생성자 또는 모든 이벤트에 대한 이벤트 처리 메서드에서 호출  
	public void displayAllStudent() {
		// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 DAO클래스의 메서드 호출 
		// StudentDAO.getDAO() : 이미 생성된 StudentDAO 인스턴스를 반환 
		// studentList 모든 학생정보를 반환받아 가져옴 ( 중복된 코드를 최소화 해야함 JDBC로 ㄴㄴ 가져다가 쓰면됨 )
											// CRUD로 손쉽게 만들고 유지보수가 쉽다 
		List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		
		// List.isEmpty() : List 인스턴스에 저장된 요소가 있는 경우 false반환 하고 저장된
		// 요소가 하나도 없는 경우 true 반환 하는 메서드 
		if(studentList.isEmpty()) { // 비어있으면 true
			// JOptionPane. : 기본적인 다이얼로그를 제공하는 컴퍼넌트 
			// 부모는 this 
			// => 메세지를 출려가는 다이얼로그를 제공하는 메서드 
			JOptionPane.showMessageDialog(this, "저장된 학생정보가 없습니다.");
			return; // 출력할게 없으니 메서드 종료 
		}
		
		// JTable.getModel() : JTable 컴퍼넌트에 종속된 TableModel 인스턴스를 반환하는 메서드 
		
		// TableModel 행을 제어할수있는 
		// DefaultTableModel : TableModel 인터페이스 상속받아서 만든 자식테이블
		// => - JTable 컴퍼너는트의 행정보를 제어하는 인스턴스 
		// => Table Model 인스턴스를 DefaultTableModel 클래스로 객체 형변환 하여 저장 
		
		DefaultTableModel model = (DefaultTableModel)table.getModel(); // 테이블에서 행을 삭제하거나 추가할떄 DefaultTableModel	
				//  table.getModel() : TableModel부모 반환 자식 으로 형변환 
		
		
		// 기존 학생을 제거하고 
		// 기존 JTable 컴퍼넌트에 존재하는 모든 행을 하나씩 반복적으로 제거한다 - JTable 컴퍼넌트 초기화 
		// model.getRowCount() : 저장된 행의 갯수를 반환하는 메서드 
		
		
		// 행의 갯수까지 반복 
		for(int i = model.getRowCount(); i > 0 ; i--) {
			// DefaultTableModel.removeRow(int row ) :DefaultTableModel 인스턴스에 저장된
			// 행을 첨자(RowIndex)를 전달받아첨자 위치의 행을 제거하는 메서드
			model.removeRow(0); // 첫번쨰 행 계속 제거 
		}
		//JTable 컴퍼넌트에 검색된 학생정보를 저장하여 출력
		// => DefaultTableModel 컴퍼넌트에 검색된 학생정보를 반복적으로 행으로 추가하여 
		for(StudentDTO student : studentList) {
			// Vector 인스턴스를 생성하여 StudentDTO 인스턴스를 필드값을 요소로 추가 
			Vector<Object> rowData = new Vector<Object>(); // 열의 갯수를 몰라서 Vector 
			rowData.add(student.getNo()); // 열들을 가져다가 백터로 한행을 만듬 
			rowData.add(student.getName()); // 열들을 가져다가 백터로 한행을 만듬 
			rowData.add(student.getPhone()); // 열들을 가져다가 백터로 한행을 만듬 
			rowData.add(student.getAddress()); // 열들을 가져다가 백터로 한행을 만듬 
			rowData.add(student.getBirthday()); // 열들을 가져다가 백터로 한행을 만듬 
			
			// DefaultTableModel.addRow(Vector rowData)
			// DefaultTableModel 인스턴스의 행으로 추가하는 메서드 
			model.addRow(rowData);
		}
	}
	
	//JTextField 컴퍼넌트에 입력된 학생정보를 제공받아 STUDENT 테이블에 저장하는 메소드
	// => 이벤트 처리 메소드에서 [ADD]상태에서 [추가] 버튼을 누른 경우 호출
	public void addStudent() {
		String noTemp=noTF.getText();//학번이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장  
		// 문자열로 받아야지 정규식이랑 비교할수가 있다.
		
		//입력값 검증
		if(noTemp.equals("")) { //입력값이 없는 경우 
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해주세요");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return; // 종료 
		}
		String noReg = "\\d{4}"; // 숫자 4번 반복 하는 규칙 
		if(!Pattern.matches(noReg, noTemp)) { // 입력값이 4자리를 
			JOptionPane.showMessageDialog(this, "학번을 4자리의 숫자로만 입력해주세요");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		//학번 입력값을 정수값으로 변환하여 저장 
		// 문자열  (검증이 끝나면) -> 숫자로 바꿀수있도록 
		int no = Integer.parseInt(noTemp);
		
		// 입력된 학번의 중복성 검증 : 학번을 전달하여 STUDENT 테이블에 저장된 해당 학번의 
		// 학생정보를 검색하여 반환하는 DAO 클래스의 메소드 호출 
		// DAO 클래스의 메소드 호출 - 학번의 중복성 검증 
		// => NULL 반환 : 학생정보 미검색 - 입력된  학번 사용 가능 
		// => StudentDTO 인스턴스 반환 - 학생정보 검색 - 입력된 학번 사용 불가능(학번 중복) 
		
		if(StudentDAO.getDAO().selectNoStudent(no)!=null) {//입력된 학번이 사용 불가능한 경우 
			JOptionPane.showMessageDialog(this, "이미 사용중인 학번입니다. 다시 입력해 주세요");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		String name = nameTF.getText(); // //이름이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장  
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요");
			nameTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		
		}
		
		// 영문자도 포함이면 "^[가-힣]{2,7}|[a-zA-Z]{4,20}$"
		String nameReg = "^[가-힣]{2,7}$"; //한글 2자~7자 반복 가 부터 힣(유니코드 마지막)까지
										  //2~7 범위의 한글을 표현한 정규 표현식
		if(!Pattern.matches(nameReg, name)) { // 입력값이 4자리를 
			JOptionPane.showMessageDialog(this, "이름은 2~7 범위의 한글만 입력해 주세요");
			nameTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		// 이름은 중복성에 대한 검증을 할 필요가 없다.
		
		String phone = phoneTF.getText(); // 전화번호 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장  
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 반드시 입력해 주세요");
			phoneTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}"; // 016789중 하나 - 3자리에서4자리반복 - 4자리반복 
	
		if(!Pattern.matches(phoneReg, phone)) { 
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요");
			phoneTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		String address = addressTF.getText(); // 주소가 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장 
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 반드시 입력해 주세요");
			addressTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		// 건물명 입력하고 해당 건물에 대한 우편번호 그런 형식으로 사용할수 있다.
		// 실제 주소 같은 경우 상세 주소를 제외한 검색을 통해서 주소가 검색되어질수있다.
		// 주소는 정규표현식으로 표현할수가 없다.. 우편번호검색기능을 통해서 주소를 ..
		
		String birthday = birthdayTF.getText(); // 생년월일이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장 
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 반드시 입력해 주세요");
			birthdayTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(1-9|1[0-2])-(0[1-9]|[12][0-9]|3[0-1]";
										//  1900 2000 년도 1~9월,10월~12월 중 하나 포함  1 ~9 10~19 , 20 ~ 29 30~31
		if(!Pattern.matches(birthdayReg, birthday)) { 
			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요");
			birthdayTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		// DTO 인스턴스를 생성하고 JTextField 컴퍼넌트의 입력값(변수값)으로 필드값 변경
		
		StudentDTO student = new StudentDTO();
		// 입력된값으로 값저장
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);

		//학생정보를 전달하여 STUDENT 테이블에 저장하는 DAO 클래스의 메서드 호출
		int rows = StudentDAO.getDAO().insertStudent(student); 
	
		JOptionPane.showMessageDialog(this, rows + "명의 학생 정보를 저장하였습니다.");
		
		// STUDENT 테이블에 저장된 모든학생정보를 검색하여 출력하는 메소드
		displayAllStudent(); 
		
		// 모든 컴퍼넌트 초기화 처리
		initDisplay();
	}
	// JTextField 컴퍼넌트에 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 제거하는 메서드
	// 학생정보를 
	// => 이벤트 처리 메소드에서 [DELETE]상태에서 [삭제]버튼을 누른 경우 호출
	public void removeStudent() {
		
		String noTemp=noTF.getText();//학번이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장  
		// 문자열로 받아야지 정규식이랑 비교할수가 있다.
		
		//입력값 검증
		if(noTemp.equals("")) { //입력값이 없는 경우 
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해주세요");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return; // 종료 
		}
		
		String noReg = "\\d{4}"; // 숫자 4번 반복 하는 규칙 
		if(!Pattern.matches(noReg, noTemp)) { // 입력값이 4자리를 
			JOptionPane.showMessageDialog(this, "학번을 4자리의 숫자로만 입력해주세요");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		//학번 입력값을 정수값으로 변환하여 저장 
		// 문자열  (검증이 끝나면) -> 숫자로 바꿀수있도록 
		int no = Integer.parseInt(noTemp);
		
		//학번을 전달하여 STUDENT 테이블의 저장된 해당 학번의 학생 정보를 삭제하는 DAO클래스의 메소드 호출
		int rows = StudentDAO.getDAO().deleteStudent(no);
		
		if(rows > 0) { //삭제행이 존재하는 경우
			JOptionPane.showMessageDialog(this, rows + "명의 학생 정보를 삭제하였습니다.");
			displayAllStudent();
		} else { //삭제행이 존재하지 않는 경우
			JOptionPane.showMessageDialog(this, "삭제 하고자 하는 학번의 학생정보가 없습니다.");			
		}
		initDisplay();
	}
	
	// 한번 누르면 학번만 활성화 상태 , 학번입력해서 변경 또 누르면 이름,전화,주소,생일 입력, 변경 누르면 변경처리되게함
	
	// JTextField 컴퍼넌트에 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 제거하는 메서드
	// 학생정보를 검색하여  JTextField 컴퍼넌트에 출력하는 메소드
	// => 이벤트 처리 메소드에서 [UPDATE]상태에서 [변경]버튼을 누른 경우 호출
	
	public void searchNoStudent() {
		
		String noTemp=noTF.getText();//학번이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장  
		// 문자열로 받아야지 정규식이랑 비교할수가 있다.
		
		//입력값 검증
		if(noTemp.equals("")) { //입력값이 없는 경우 
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해주세요");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return; // 종료 
		}
		
		String noReg = "\\d{4}"; // 숫자 4번 반복 하는 규칙 
		if(!Pattern.matches(noReg, noTemp)) { // 입력값이 4자리를 
			JOptionPane.showMessageDialog(this, "학번을 4자리의 숫자로만 입력해주세요");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			return;
		}
		
		//학번 입력값을 정수값으로 변환하여 저장 
		// 문자열  (검증이 끝나면) -> 숫자로 바꿀수있도록 
		int no = Integer.parseInt(noTemp);
		
		// 학번을 전달하여 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 DAO 클래스의 메서드 호출
		StudentDTO student = StudentDAO.getDAO().selectNoStudent(no);
		if(student==null) {//입력된 학번의 학생정보가 검색되지 않은 경우 
			JOptionPane.showMessageDialog(this, "변경하고자 하는 학번의 학생정보가 없습니다.");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
			noTF.setText(""); // JTextField 컴퍼넌트의 입력값 초기화 처리 
			return;
		}
		
		//검색되어 반환된 학생정보를 이용하여 JTextField 컴퍼넌트의 입력값으로 변경해준다.
		noTF.setText(student.getNo()+""); // String을 받아야되는데. Integer 에 + " "->문자열로됨
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
	
		// 현재 작업 상태를 UPDATE_CHANGE 상태로 변경 ( 변경처리가 가능하도록 )
		setEnable(UPDATE_CHANGE);
	}
	// => 학생정보를 제공받아 STUDENT 테이블에 저장된
	// => 
	public void modifydStudent() {
		
	
	// 학번은 검증할 필요가 없다. 학번은 비활서오하 처리되어있음 값만 가져옴 
	int no = Integer.parseInt(noTF.getText());
	
	
	String name = nameTF.getText(); // //이름이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장  
	
	if(name.equals("")) {
		JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요");
		nameTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
		return;
	
	}
	
	// 영문자도 포함이면 "^[가-힣]{2,7}|[a-zA-Z]{4,20}$"
	String nameReg = "^[가-힣]{2,7}$"; //한글 2자~7자 반복 가 부터 힣(유니코드 마지막)까지
									  //2~7 범위의 한글을 표현한 정규 표현식
	if(!Pattern.matches(nameReg, name)) { // 입력값이 4자리를 
		JOptionPane.showMessageDialog(this, "이름은 2~7 범위의 한글만 입력해 주세요");
		nameTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
		return;
	}
	
	// 이름은 중복성에 대한 검증을 할 필요가 없다.
	
	String phone = phoneTF.getText(); // 전화번호 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장  
	
	if(name.equals("")) {
		JOptionPane.showMessageDialog(this, "전화번호를 반드시 입력해 주세요");
		phoneTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
		return;
	
	}
	
	String phoneReg="(01[016789])-\\d{3,4}-\\d{4}"; // 016789중 하나 - 3자리에서4자리반복 - 4자리반복 

	if(!Pattern.matches(phoneReg, phone)) { 
		JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요");
		phoneTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
		return;
	}
	
	String address = addressTF.getText(); // 주소가 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장 
	
	if(address.equals("")) {
		JOptionPane.showMessageDialog(this, "주소를 반드시 입력해 주세요");
		addressTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
		return;
	}
	
	// 건물명 입력하고 해당 건물에 대한 우편번호 그런 형식으로 사용할수 있다.
	// 실제 주소 같은 경우 상세 주소를 제외한 검색을 통해서 주소가 검색되어질수있다.
	// 주소는 정규표현식으로 표현할수가 없다.. 우편번호검색기능을 통해서 주소를 ..
	
	String birthday = birthdayTF.getText(); // 생년월일이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장 
	
	if(birthday.equals("")) {
		JOptionPane.showMessageDialog(this, "생년월일을 반드시 입력해 주세요");
		birthdayTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
		return;
	}
	
	String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
									//  1900 2000 년도 1~9월,10월~12월 중 하나 포함  1 ~9 10~19 , 20 ~ 29 30~31
	if(!Pattern.matches(birthdayReg, birthday)) { 
		JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요");
		birthdayTF.requestFocus();//컴퍼넌트로 입력촛점(Focus)을 이동하는 메소드
		return;
	}
	
	// DTO 인스턴스를 생성하고 JTextField 컴퍼넌트의 입력값(변수값)으로 필드값 변경
	
	StudentDTO student = new StudentDTO();
	// 입력된값으로 값저장
	student.setNo(no);
	student.setName(name);
	student.setPhone(phone);
	student.setAddress(address);
	student.setBirthday(birthday);

	//학생정보를 전달하여 STUDENT 테이블에 저장된 학생정보를 변경하는 DAO 클래스의 메서드 호출
	int rows = StudentDAO.getDAO().updateStudent(student); 
	
	JOptionPane.showMessageDialog(this, rows + "명의 학생 정보를 저장하였습니다.");
	// STUDENT 테이블에 저장된 모든학생정보를 검색하여 출력하는 메소드
	displayAllStudent(); 
	// 모든 컴퍼넌트 초기화 처리
	initDisplay();
	}
	
	public void searchNameStudent() {
		
		String name=nameTF.getText();//이름이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^([가-?]{2,7})$";//2~7 범위의 한글을 표현한 정규 표현식
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 2~7 범위의 한글만 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		//이름을 전달하여 STUDENT 테이블에 저장된 해당 이름의 모든 학생정보를 검색하여 반환
		//하는 DAO 클래스의 메소드 호출
		List<StudentDTO> studentList=StudentDAO.getDAO().selectNameStudent(name);
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "검색된 학생정보가 없습니다.");
			return;
		}
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		for(StudentDTO student:studentList) {
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			model.addRow(rowData);
		}
		
		initDisplay();
		
	}
}
