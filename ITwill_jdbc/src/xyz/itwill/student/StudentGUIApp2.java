package xyz.itwill.student; 

/********************************************************
파    일   명 : StudentGUIApp.java
기         능 : 학생 관리 프로그램
*********************************************************/
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

public class StudentGUIApp2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static final int NONE = 0;
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
	public StudentGUIApp2() throws Exception {
		setTitle("◆◆◆ 학생 관리 프로그램 ◆◆◆");
		setSize(800, 400);

		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel pno = new JPanel();
		pno.add(new JLabel("번  호"));
		pno.add(noTF = new JTextField(10));

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

		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(addB = new JButton("추  가"));
		addB.addActionListener(this);

		bottom.add(deleteB = new JButton("삭  제"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("변  경"));
		updateB.addActionListener(this);

		bottom.add(searchB = new JButton("검  색"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("초기화"));
		cancelB.addActionListener(this);

		Object[] title={"학번","이름","전화번호","주소","생년월일"};
		table=new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		JScrollPane sp=new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		//JTable 컴퍼넌트에 모든 학생정보를 검색하여 출력하는 메소드 호출
		displayAllStudent();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//모든 JTextField 컴퍼넌트 비활성화 처리하는 메소드
	public void initialize() {
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}

	//매개변수에 전달되는 정수값에 따른 JTextField 컴퍼넌트의 활성 또는 비활성 처리하는 메소드
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
			noTF.setEditable(true);
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

	//매개변수에 전달되는 정수값에 따른 JButton 컴퍼넌트의 활성 또는 비활성 처리하는 메소드
	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD);
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
		case NONE:
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}

	//모든 JTextField 컴퍼넌트의 입력값을 초기화 처리하는 메소드
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}

	//모든 컴퍼넌트를 초기화 처리하는 메소드
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();		
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	//이벤트 처리 메소드 - JButton 컴퍼넌트를 누른 경우 자동 호출되는 메소드
	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {//추가 버튼을 누른 경우
				if (cmd != ADD) {//ADD 상태가 아닌 경우 
					setEnable(ADD);//ADD 상태로 컴퍼넌트의 활성 또는 비활성 처리					
				} else {//ADD 상태인 경우
					//JTextField 컴퍼넌트의 입력값을 이용하여 처리 >> 초기화 처리
					addStudent();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {
					setEnable(DELETE);
				} else {
					removeStudent();				
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if (cmd != UPDATE_CHANGE) {
					searchNoStudent();
				} else {
					modifydStudent();
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

	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	// => 생성자 또는 모든 이벤트에 대한 이벤트 처리 메소드에서 호출
	public void displayAllStudent() {
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
		// => StudentDAO.getDAO() : 이미 생성된 StudentDAO 인스턴스를 반환하는 메소드
		List<StudentDTO> studentList=StudentDAO.getDAO().selectAllStudent();
		
		//List.isEmpty() : List 인스턴스에 저장된 요소가 있는 경우 false 반환하고 저장된
		//요소가 하나도 없는 경우 true를 반환하는 메소드
		if(studentList.isEmpty()) {
			//JOptionPane : 기본적인 다이얼로그를 제공하는 컴퍼넌트
			//JOptionPane.showMessageDialog(Component parentComponent, Object message) 
			// => 메세지를 출력하는 다이얼로그를 제공하는 메소드
			JOptionPane.showMessageDialog(this, "저장된 학생정보가 없습니다.");
			return;
		}
		
		//JTable.getModel() : JTable 컴퍼넌트에 종속된 TableModel 인스턴스를 반환하는 메소드
		//DefaultTableModel : TableModel 인터페이스를 상속받아 작성된 클래스 
		// => JTable 컴퍼넌트의 행정보를 제어하는 인스턴스
		// => TableModel 인스턴스를 DefaultTableModel 클래스로 객체 형변환 하여 저장
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//기존 JTable 컴퍼넌트에 존재하는 모든 행을 하나씩 반복적으로 제거 - JTable 컴퍼넌트의 초기화
		//DefaultTableModel.getRowCount() : DefaultTableModel 인스턴스에 저장된 행의 갯수를 반환하는 메소드
		for(int i=model.getRowCount();i>0;i--) {
			//DefaultTableModel.removeRow(int row) : DefaultTableModel 인스턴스에 저장된 
			//행목록에서 첨자(RowIndex)를 전달받아 첨자 위치의 행을 제거하는 메소드
			model.removeRow(0);//첫번째 행 제거
		}
		
		//JTable 컴퍼넌트에 검색된 학생정보를 저장하여 출력
		// => DefaultTableModel 컴퍼넌트에 검색된 학생정보를 반복적으로 행으로 추가하여
		for(StudentDTO student:studentList) {
			//Vector 인스턴스를 생성하여 StudentDTO 인스턴스를 필드값을 요소로 추가
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			//DefaultTableModel.addRow(Vector rowData) : Vector 인스턴스를 전달받아
			//DefaultTableModel 인스턴스의 행으로 추가하는 메소드
			model.addRow(rowData);
		}
	}
	
	//JTextField 컴퍼넌트에 입력된 학생정보를 제공받아 STUDENT 테이블에 저장하는 메소드
	// => 이벤트 처리 메소드에서 [ADD] 상태에서 [추가] 버튼을 누른 경우 호출
	public void addStudent() {
		String noTemp=noTF.getText();//학번이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장
		
		//입력값 검증
		if(noTemp.equals("")) {//입력값이 없는 경우
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해 주세요.");
			noTF.requestFocus();//컴퍼넌트로 입력촛점(Focus) 이동
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {//입력값이 형식에 맞지 않은 경우
			JOptionPane.showMessageDialog(this, "학번은 4자리의 숫자로만 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		//학번 입력값을 정수값으로 변환하여 저장
		int no=Integer.parseInt(noTemp);
		
		//입력된 학번의 중복성 검증 - 학번을 전달하여 STUDENT 테이블에 저장된 해당 학번의 
		//학생정보를 검색하여 반환하는 DAO 클래스의 메소드 호출 
		// => NULL 반환 : 학생정보 미검색 - 입력된 학번 사용 가능
		// => StudentDTO 인스턴스 반환 : 학생정보 검색 - 입력된 학번 사용 불가능(학번 중복)
		if(StudentDAO.getDAO().selectNoStudent(no)!=null) {//입력된 학번이 사용 불가능한 경우 
			JOptionPane.showMessageDialog(this, "이미 사용중인 학번입니다. 다시 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
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
		
		String phone=phoneTF.getText();//전화번화가 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장

		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 반드시 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();//주소가 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 반드시 입력해 주세요.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();//생년월일이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 반드시 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		//DTO 인스턴스를 생성하고 JTextField 컴퍼넌트의 입력값(변수값)으로 필드값 변경
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//학생정보를 전달하여 STUDENT 테이블에 저장하는 DAO 클래스의 메소드 호출
		int rows=StudentDAO.getDAO().insertStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"명의 학생정보를 저장 하였습니다.");
		
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력하는 메소드 호출
		displayAllStudent();
		
		//모든 컴퍼넌트 초기화 처리 메소드 호출
		initDisplay();
	}
	
	//JTextField 컴퍼넌트에 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 
	//학생정보를 제거하는 메소드
	// => 이벤트 처리 메소드에서 [DELETE] 상태에서 [삭제] 버튼을 누른 경우 호출
	public void removeStudent() {
		String noTemp=noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "학번은 4자리의 숫자로만 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		//학번을 전달하여 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하는 DAO 클래스의 메소드 호출
		int rows=StudentDAO.getDAO().deleteStudent(no);
		
		if(rows>0) {//삭제행이 존재하는 경우
			JOptionPane.showMessageDialog(this, rows+"명의 학생정보를 삭제 하였습니다.");
			displayAllStudent();
		} else {//삭제행이 존재하지 않는 경우
			JOptionPane.showMessageDialog(this, "삭제하고자 하는 학번의 학생정보가 없습니다.");
		}
		
		initDisplay();
	}
	
	//JTextField 컴퍼넌트에 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 
	//학생정보를 검색하여 JTextField 컴퍼넌트에 출력하는 메소드
	// => 이벤트 처리 메소드에서 [UPDATE] 상태에서 [변경] 버튼을 누른 경우 호출
	public void searchNoStudent() {
		String noTemp=noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "학번은 4자리의 숫자로만 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		//학번을 전달하여 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
		StudentDTO student=StudentDAO.getDAO().selectNoStudent(no);
		if(student==null) {//입력된 학번의 학생정보가 검색되지 않은 경우
			JOptionPane.showMessageDialog(this, "변경하고자 하는 학번의 학생정보가 없습니다.");
			noTF.requestFocus();
			noTF.setText("");//JTextField 컴퍼넌트의 입력값 초기화 처리
			return;
		}
				
		//검색되어 반환된 학생정보를 이용하여 JTextField 컴퍼넌트의 입력값으로 변경
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
		
		//현재 작성상태를 UPDATE_CHANGE 상태로 변경
		setEnable(UPDATE_CHANGE);
	}
	
	//JTextField 컴퍼넌트에 입력된 학생정보를 제공받아 STUDENT 테이블에 저장된 학생정보를 변경하는 메소드
	// => 이벤트 처리 메소드에서 [UPDATE_CHANGE] 상태에서 [변경] 버튼을 누른 경우 호출
	public void modifydStudent() {
		//학번이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장
		int no=Integer.parseInt(noTF.getText());
		
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
		
		String phone=phoneTF.getText();//전화번화가 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장

		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 반드시 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();//주소가 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 반드시 입력해 주세요.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();//생년월일이 입력된 JTextField 컴퍼넌트의 입력값을 반환받아 저장
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 반드시 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		//DTO 인스턴스를 생성하고 JTextField 컴퍼넌트의 입력값(변수값)으로 필드값 변경
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//학생정보를 전달하여 STUDENT 테이블에 저장된 학생정보를 변경하는 DAO 클래스의 메소드 호출
		int rows=StudentDAO.getDAO().updateStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"명의 학생정보를 변경 하였습니다.");
		
		displayAllStudent();
		initDisplay();
	}
	
	//JTextField 컴퍼넌트에 입력된 이름을 제공받아 STUDENT 테이블에 저장된 학생정보를 검색하여 출력하는 메소드
	// => 이벤트 처리 메소드에서 [SEARCH] 상태에서 [검색] 버튼을 누른 경우 호출
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















