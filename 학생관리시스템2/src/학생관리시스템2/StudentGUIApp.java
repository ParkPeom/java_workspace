package 학생관리시스템2;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.print.attribute.standard.JobPriority;
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
	
	private static final long serialVersionUID = 1L;
	public static final int NONE = 0;   // 초기화
	public static final int ADD = 1;    // 추가
	public static final int DELETE = 2; // 추가
	public static final int UPDATE = 3; // 추가
	public static final int UPDATE_CHANGE = 4; // 추가
	public static final int SEARCH = 5; // 추가
	
	JTextField noTF ,nameTF, phoneTF, addressTF, birthdayTF; // 텍스트 필드 
	JButton addB , deleteB , updateB , searchB , cancelB; // 버튼
	
	JTable table; // 데이터를 보여주기 위한 테이블 
	
	int cmd; // 현재 상태 

	public StudentGUIApp() {
		setTitle("★★★ 학생 관리 프로그램 ★★★");
		setSize(800,400); // 가로 세로 ? 
		
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);
	
		JPanel left = new JPanel(); // 왼쪽
		
		left.setLayout(new GridLayout(5,1)); // 5행 1열 
		
		JPanel pno = new JPanel();
		pno.add(new JLabel("번  호"));
		pno.add(noTF = new JTextField(10));
		
		JPanel pname = new JPanel();
		pname.add(new JLabel("이 름"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("생 일"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("전  화"));
		pphone.add(phoneTF = new JTextField(10)); 
		
		JPanel paddress = new JPanel();
		paddress.add(new JLabel("주  소"));
		paddress.add(addressTF = new JTextField(10)); 
		
		// 각각 추가한 5개 패널을  행열 GridLayout(5,1) 틀에 추가
		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel(); // 아래 
		bottom.setLayout(new GridLayout(1,5)); // 1행 5열 
		
		bottom.add(addB = new JButton("추 가"));	
		addB.addActionListener(this); // 버튼 B를 눌렀을때 액션 이벤트 
		
		bottom.add(deleteB = new JButton("삭 제"));	
		deleteB.addActionListener(this); // 버튼 B를 눌렀을때 액션 이벤트 
	
		bottom.add(updateB = new JButton("변 경"));	
		updateB.addActionListener(this); // 버튼 B를 눌렀을때 액션 이벤트 
	
		bottom.add(searchB = new JButton("검 색"));	
		searchB.addActionListener(this); // 버튼 B를 눌렀을때 액션 이벤트 
		
		bottom.add(cancelB = new JButton("초기화"));
		cancelB.addActionListener(this);
		
		Object[] title = {"학번","이름","전화번호","주소","생년월일"}; // 컬럼명 
		table = new JTable(new DefaultTableModel(title,0)); // 컬럼명 , 0
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		JScrollPane sp = new JScrollPane(table);
			
		// JFrame에
		add(sp,	"Center"); // 테이블은 가운대 배치  
		add(left,"West"); // 서쪽 배치 
		add(bottom, "South"); // 남쪽 배치 
		cmd = NONE; // 초기화 
		initialize();
		
		// //JTable 컴퍼넌트에 모든 학생정보를 검색하여 출력하는 메소드 호출
		displayAllStudent();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() {
		// 초기화 누르면 텍스트필드 내용 안보이기 
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}
	
	// 텍스트 필드 활성화 , 비활성화  
	public void setEdiatable(int n) {
		switch(n) {
		case ADD: // 추가 버튼 누르면
			noTF.setEditable(true);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		
		case DELETE: // 삭제 버튼 한번 누르면 
			noTF.setEditable(true);
			break;
		
		case UPDATE: // 변경 버튼 한번 누르면 
			noTF.setEditable(true);
			break;
		
		case UPDATE_CHANGE: // 변경 버튼을 한번 더 누르면 
			noTF.setEditable(false);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break ;
		case SEARCH: // 찾기 버튼 
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
	
	// 버튼 비활성화 , 활성호 
	public void setEnable(int n) {
		
		addB.setEnabled(false);    // 추가 버튼 
		deleteB.setEnabled(false); // 삭제 버튼
		updateB.setEnabled(false); // 변경 버튼
		searchB.setEnabled(false); // 검색 버튼 
		
		switch(n) {
		
		case ADD: // 1일때  
			addB.setEnabled(true); // 추가버튼 활성화 
			setEdiatable(ADD); // 텍스트필드 
			cmd = ADD; // 현재 상태는 추가로
			break;
		case DELETE: //2일때
			deleteB.setEnabled(true);
			setEdiatable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			updateB.setEnabled(true);
			setEdiatable(UPDATE);
			cmd = UPDATE;
			break;
		case UPDATE_CHANGE:
			updateB.setEnabled(true);
			setEdiatable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;
		case SEARCH:
			searchB.setEnabled(true);
			setEdiatable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE:
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}
	
	// 초기화 되면 ? JTextField 컴퍼넌트의 입력값을 초기화 
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}
	
	// 모든 컴퍼넌트를 초기화 처리 하는 메소드
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();
	}
	
	// <-------- JButton 컴퍼넌트 누르면 이벤트 처리 --------->
	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component)e.getSource(); // Object 반환이므로 컴퍼넌트로 형변환 
		try {
			if(c == addB) { // 버튼이 addB일 경우 
				if(cmd != ADD) { // ADD 상태가 아니면 ? 활성화 시킴
					setEnable(ADD);
				} else {
					addStudent();
				}
			} else if(c == deleteB) {
				if(cmd != DELETE) {
					setEnable(DELETE);
				} else {
					removeStudent();
				}
			} else if(c == updateB) {
				if(cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if( cmd != UPDATE_CHANGE){
					searchNoStudent(); // 번호로 일단 있는지 검색 
				} else {
					modifyStudent(); // UPDATE_CHANGE 이면 변경 
					displayAllStudent();
					initDisplay();
				}
			} else if(c == cancelB) {
				// 메서드 실행
				displayAllStudent();
				initDisplay();
			} else if(c == searchB) {
				if(cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					searchNameStudent(); // 이름으로 검색한다.
				}
			}
		} catch(Exception ex) {
			System.out.println("예외 발생 : " + ex);
		}
	}
	
	//----------------버튼을 누르면 발생하는 메소드----------------
	// 데이터값들을 테이블에 넣어서 다시 보여준다.
	public void displayAllStudent() {
		
		//기존 JTable 컴퍼넌트에 존재하는 모든 행을 하나씩 반복적으로 제거 List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		if(studentList.isEmpty()) { // 비어있으면 true		
			JOptionPane.showMessageDialog(this, "저장된 학생정보가 없습니다.");
			return;
		}
		//JTable.getModel() : JTable 컴퍼넌트에 종속된 TableModel 인스턴스를 반환하는 메소드
		//DefaultTableModel : TableModel 인터페이스를 상속받아 작성된 클래스 
		// => JTable 컴퍼넌트의 행정보를 제어하는 인스턴스
		// => TableModel 인스턴스를 DefaultTableModel 클래스로 객체 형변환 하여 저장
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		//기존 JTable 컴퍼넌트에 존재하는 모든 행을 하나씩 반복적으로 제거 - JTable 컴퍼넌트의 초기화d	
		for(int i=model.getRowCount(); i>0; i--) {
			model.removeRow(0); // 첫번째 행 제거 
		}
		
		//JTable 컴퍼넌트에 검색된 학생정보를 저장하여 출력 
		// => DefaultTableModel 컴퍼넌트에 검색된 학생정보를 반복적으로 행으로 추가
		for(StudentDTO student : studentList) {
			Vector<Object> rowData = new Vector<Object>();
			// --- 중요  ---
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			// 열에 데이터들을 추가함 
			model.addRow(rowData);
		}
	}
	
	// ------------버튼 클릭시 메소드 실행 --------------
	// -----------텍스트 버튼값을 불러와서 유효성 검사를 함 ---------
	public void addStudent() {
		String noTemp = noTF.getText(); // 입력한 값 불러옴 
		// String으로 받아야지 equals() 호출 가능 
		if(noTemp.equals("")) { // 아무것도 입력을 하지 않으면 
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해 주세요");
			noTF.requestFocus(); // 입력 촛점으로 이동 
			return;
		}
		String noReg ="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "학번은 4자리로 입력해주세요");
			noTF.requestFocus();
			return;
		}
		
		
		// 입력받은 학번값을 정수값으로 변환하여 저장
		int no = Integer.parseInt(noTemp);
		
		// 그런데.. 이미 사용중인 학번이면 
		if(StudentDAO.getDAO().selectNoStudent(no) != null) {
			JOptionPane.showMessageDialog(this, "이미 사용중인 학번입니다");
			noTF.requestFocus();
			return;
		}
		String name = nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력해 주세요");
			nameTF.requestFocus();
			return;
		}
		
		// 정규식 표현식 검사
		String nameReg = "^([가-�R]{2,7})$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 한글 2~7자로 적어주세요");
			nameTF.requestFocus();
			return;		
		}
		String phone = phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "번호를 입력해주세요");
			phoneTF.requestFocus();
			return;
		}
		String phoneReg = "(01[016789])-\\d{3,4}-\\d{4}";

		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해주세요.");
			phoneTF.requestFocus();
			return;
		}
		String address = addressTF.getText();
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 반드시 입력해 주세요.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday = birthdayTF.getText();
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 반드시 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		/*
		String birthdayReg="(19|20)\\d{2}-(1-9|1[0-2])-(0[1-9]|[12][0-9]|3[0-1]";
		
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "생일을 형식에 맞게 입력해주세요.");
			birthdayTF.requestFocus();
			return;
		}
		*/
		
		// 입력값을 넣음 
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		int rows = StudentDAO.getDAO().insertStudent(student); // dao.insertStudent(추가);
		JOptionPane.showMessageDialog(this, rows+"명의 학생정보를 저장 하였습니다.");
	
		displayAllStudent();
		
		// 모든 컴포넌트 초기화 처리 메서드 호출 
		initDisplay();
	}
	
	public void removeStudent() {
		
		String noTemp = noTF.getText(); 
		if(noTemp.equals("")) { // 아무것도 입력을 하지 않으면 
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해 주세요");
			noTF.requestFocus(); // 입력 촛점으로 이동 
			return;
		}
		
		String noReg ="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "학번은 4자리로 입력해주세요");
			noTF.requestFocus();
			return;
		}
		int no = Integer.parseInt(noTemp);
		
		int rows = StudentDAO.getDAO().deleteStudent(no);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this, rows+"명의 학생 정보를 삭제 하였습니다. ");
			displayAllStudent();
		} else {
			JOptionPane.showMessageDialog(this, "삭제하고자 하는 학생 정보가 없습니다 ");
		}
		initDisplay(); // 초기화 
	}
	public void searchNoStudent() {
		String noTemp = noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "학번을 반드시 입력해 주세요");
			noTF.requestFocus();
			return;
		}
		
		String noReg = "\\d{4}"; 
	
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "학번은 4자리로 입력해주세요.");
			noTF.requestFocus();
			return;
		}
		int no = Integer.parseInt(noTemp);
		
		StudentDTO student = StudentDAO.getDAO().selectNoStudent(no);
		if(student == null) {
			JOptionPane.showMessageDialog(this, "변경하고자 하는 값이 없습니다.");
			noTF.requestFocus();
			noTF.setText("");
			return;
		}
		// 검색되어 불러온 정보를 텍스트필드에 입력 한다. 
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());

		// 현재 작성 상태를 UPDATE_CHANGE 상태로 변경 한다.
		setEnable(UPDATE_CHANGE);
	}
	public void modifyStudent() {
		
		int no=Integer.parseInt(noTF.getText());
		String name=nameTF.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		String nameReg = "^([가-�R]{2,7})$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 반드시 2~7자로 적어주세요");
			nameTF.requestFocus();
			return;
		}
		String phone = phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 입력해 주세요");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		
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
		
		/*
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		*/
		// UPDATE_CHANGE 에서 입력한 변경한 값들을 추가한다.
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		int rows = StudentDAO.getDAO().updateStudent(student);
	
		JOptionPane.showMessageDialog(this, rows+"명의 학생정보가 변경 하였습니다.");
	}
	
	public void searchNameStudent() {
		
		String name = nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 반드시 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg = "^[가-�R]{2,7}$";//2~7 범위의 한글을 표현한 정규 표현식
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 2~7 범위의 한글만 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		// 이름으로 검색 
		List<StudentDTO> studentList = StudentDAO.getDAO().selectNameStudent(name);
		
		// getModel() :  JTable이 갖고 있는 데이터를 담고 있는 객체인 TableModel객체가 리턴됩니다.
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		// 기존 테이블 값들을 삭제함 
		for(int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		// 검색되어진 테이블 
		for(StudentDTO student : studentList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			// 테이블에 추가함 
			model.addRow(rowData);
		}
		initDisplay();
	}
	
	public static void main(String[] args) {
		new StudentGUIApp();
	}
}
