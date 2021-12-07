package xyz.itwill.student;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

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
	 * 생성자 정의
	 *********************************************/
	public StudentGUIApp() throws Exception {
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
		table.getTableHeader().setResizingAllowed(false); // 기록 , 크기 변경 못하게 함 

		// JTable 컴퍼넌트에 모든 학생정보를 검색하여 출력하는 메서드 호출 
		displayAllStudent();
		JScrollPane sp=new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() {
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}

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
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}

	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();		
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	public void actionPerformed(ActionEvent ev) { // 버튼에서 이벤트 처리 메서드 
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {//추가 버튼을 누른 경우
				if (cmd != ADD) {//ADD 상태가 아닌 경우
					setEnable(ADD);//ADD 상태로 활성화					
				} else {//ADD 상태인 경우
					initDisplay();	
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {
					setEnable(DELETE);
				} else {
					initDisplay();				
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if (cmd != UPDATE_CHANGE) {
					setEnable(UPDATE_CHANGE);
				} else {
					initDisplay();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					initDisplay();	
				}
			} else if (c == cancelB) {
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
			return; // 메서드 종료 
		}
		
		// JTable.getModel() : JTable 컴퍼넌트에 종속된 TableModel 인스턴스를 반환하는 메서드 
		
		// TableModel 행을 제어할수있는 
		// DefaultTableModel : TableModel 인터페이스 상속받아서 만든 자식테이블
		// => - JTable 컴퍼너는트의 행정보를 제어하는 인스턴스 
		// => Table Model 인스턴스를 DefaultTableModel 클래스로 객체 형변환 하여 저장 
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		
		// 기존 학생을 제거하고 
		// 기존 JTable 컴퍼넌트에 존재하는 모든 행을 하나씩 반복적으로 제거한다 - JTable 컴퍼넌트 초기화 
		// model.getRowCount() : 저장된 행의 갯수를 반환하는 메서드 
		
		for(int i = model.getRowCount(); i > 0 ; i--) {
			// DefaultTableModel.removeRow(int row ) :DefaultTableModel 인스턴스에 저장된
			// 행을 첨자(RowIndex)를 전달받아첨자 위치의 행을 제거하는 메서드
			model.removeRow(0); // 첫번쨰 행 제거 
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
}
