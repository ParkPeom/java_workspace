package �л������ý���2;

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

	public static final int NONE = 0;   // �ʱ�ȭ
	public static final int ADD = 1;    // �߰�
	public static final int DELETE = 2; // �߰�
	public static final int UPDATE = 3; // �߰�
	public static final int UPDATE_CHANGE = 4; // �߰�
	public static final int SEARCH = 5; // �߰�
	
	JTextField noTF ,nameTF, phoneTF, addressTF, birthdayTF; // �ؽ�Ʈ �ʵ� 
	JButton addB , deleteB , updateB , searchB , cancelB; // ��ư
	
	JTable table; // �����͸� �����ֱ� ���� ���̺� 
	
	int cmd; // ���� ���� 

	public StudentGUIApp() {
		setTitle("�ڡڡ� �л� ���� ���α׷� �ڡڡ�");
		setSize(800,400); // ���� ���� ? 
		
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);
	
		JPanel left = new JPanel(); // ����
		
		left.setLayout(new GridLayout(5,1)); // 5�� 1�� 
		
		JPanel pno = new JPanel();
		pno.add(new JLabel("��  ȣ"));
		pno.add(noTF = new JTextField(10));
		
		JPanel pname = new JPanel();
		pname.add(new JLabel("�� ��"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("�� ��"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("��  ȭ"));
		pphone.add(phoneTF = new JTextField(10)); 
		
		JPanel paddress = new JPanel();
		paddress.add(new JLabel("��  ��"));
		paddress.add(addressTF = new JTextField(10)); 
		
		// ���� �߰��� 5�� �г���  �࿭ GridLayout(5,1) Ʋ�� �߰�
		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel(); // �Ʒ� 
		bottom.setLayout(new GridLayout(1,5)); // 1�� 5�� 
		
		bottom.add(addB = new JButton("�� ��"));	
		addB.addActionListener(this); // ��ư B�� �������� �׼� �̺�Ʈ 
		
		bottom.add(deleteB = new JButton("�� ��"));	
		deleteB.addActionListener(this); // ��ư B�� �������� �׼� �̺�Ʈ 
	
		bottom.add(updateB = new JButton("�� ��"));	
		updateB.addActionListener(this); // ��ư B�� �������� �׼� �̺�Ʈ 
	
		bottom.add(searchB = new JButton("�� ��"));	
		searchB.addActionListener(this); // ��ư B�� �������� �׼� �̺�Ʈ 
		
		bottom.add(cancelB = new JButton("�ʱ�ȭ"));
		cancelB.addActionListener(this);
		
		Object[] title = {"�й�","�̸�","��ȭ��ȣ","�ּ�","�������"}; // �÷��� 
		table = new JTable(new DefaultTableModel(title,0)); // �÷��� , 0
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		JScrollPane sp = new JScrollPane(table);
			
		// JFrame��
		add(sp,	"Center"); // ���̺��� ����� ��ġ  
		add(left,"West"); // ���� ��ġ 
		add(bottom, "South"); // ���� ��ġ 
		cmd = NONE; // �ʱ�ȭ 
		initialize();
		
		// //JTable ���۳�Ʈ�� ��� �л������� �˻��Ͽ� ����ϴ� �޼ҵ� ȣ��
	
		displayAllStudent();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() {
		// �ʱ�ȭ ������ �ؽ�Ʈ�ʵ� ���� �Ⱥ��̱� 
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}
	
	// �ؽ�Ʈ �ʵ� Ȱ��ȭ , ��Ȱ��ȭ  
	public void setEdiatable(int n) {
		switch(n) {
		case ADD: // �߰� ��ư ������
			noTF.setEditable(true);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		
		case DELETE: // ���� ��ư �ѹ� ������ 
			noTF.setEditable(true);
			break;
		
		case UPDATE: // ���� ��ư �ѹ� ������ 
			noTF.setEditable(true);
			break;
		
		case UPDATE_CHANGE: // ���� ��ư�� �ѹ� �� ������ 
			noTF.setEditable(false);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break ;
			
		case SEARCH: // ã�� ��ư 
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
	
	// ��ư ��Ȱ��ȭ , Ȱ��ȣ 
	public void setEnable(int n) {
		
		addB.setEnabled(false);    // �߰� ��ư 
		deleteB.setEnabled(false); // ���� ��ư
		updateB.setEnabled(false); // ���� ��ư
		searchB.setEnabled(false); // �˻� ��ư 
		
		switch(n) {
		
		case ADD: // 1�϶�  
			addB.setEnabled(true); // �߰���ư Ȱ��ȭ 
			setEdiatable(ADD); // �ؽ�Ʈ�ʵ� 
			cmd = ADD; // ���� ���´� �߰���
			break;
		case DELETE: //2�϶�
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
	
	// �ʱ�ȭ �Ǹ� ? JTextField ���۳�Ʈ�� �Է°��� �ʱ�ȭ 
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}
	
	// ��� ���۳�Ʈ�� �ʱ�ȭ ó�� �ϴ� �޼ҵ�
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();
	}
	
	// <-------- JButton ���۳�Ʈ ������ �̺�Ʈ ó�� --------->
	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component)e.getSource(); // Object ��ȯ�̹Ƿ� ���۳�Ʈ�� ����ȯ 
		
		try {
			if(c == addB) { // ��ư�� addB�� ��� 
				if(cmd != ADD) { // ADD ���°� �ƴϸ� ? Ȱ��ȭ ��Ŵ
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
					searchNoStudent(); // ��ȣ�� �ϴ� �ִ��� �˻� 
				} else {
					modifyStudent(); // UPDATE_CHANGE �̸� ���� 
					displayAllStudent();
					initDisplay();
				}
			} else if(c == cancelB) {
				// �޼��� ����
				displayAllStudent();
				initDisplay();
			} else if(c == searchB) {
				if(cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					searchNameStudent(); // �̸����� �˻��Ѵ�.
				}
			}
		} catch(Exception ex) {
			System.out.println("���� �߻� : " + ex);
		}
	}
	
	//----------------��ư�� ������ �߻��ϴ� �޼ҵ�----------------
	// �����Ͱ����� ���̺� �־ �ٽ� �����ش�.
	public void displayAllStudent() {
		
		//���� JTable ���۳�Ʈ�� �����ϴ� ��� ���� �ϳ��� �ݺ������� ���� List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		if(studentList.isEmpty()) { // ��������� true		
			JOptionPane.showMessageDialog(this, "����� �л������� �����ϴ�.");
			return;
		}
		//JTable.getModel() : JTable ���۳�Ʈ�� ���ӵ� TableModel �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//DefaultTableModel : TableModel �������̽��� ��ӹ޾� �ۼ��� Ŭ���� 
		// => JTable ���۳�Ʈ�� �������� �����ϴ� �ν��Ͻ�
		// => TableModel �ν��Ͻ��� DefaultTableModel Ŭ������ ��ü ����ȯ �Ͽ� ����
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		//���� JTable ���۳�Ʈ�� �����ϴ� ��� ���� �ϳ��� �ݺ������� ���� - JTable ���۳�Ʈ�� �ʱ�ȭd	
		for(int i=model.getRowCount(); i>0; i--) {
			model.removeRow(0); // ù��° �� ���� 
		}
		
		//JTable ���۳�Ʈ�� �˻��� �л������� �����Ͽ� ��� 
		// => DefaultTableModel ���۳�Ʈ�� �˻��� �л������� �ݺ������� ������ �߰�
		for(StudentDTO student : studentList) {
			Vector<Object> rowData = new Vector<Object>();
			// --- �߿�  ---
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			// ���� �����͵��� �߰��� 
			model.addRow(rowData);
		}
	}
	
	// ------------��ư Ŭ���� �޼ҵ� ���� --------------
	// -----------�ؽ�Ʈ ��ư���� �ҷ��ͼ� ��ȿ�� �˻縦 �� ---------
	public void addStudent() {
		String noTemp = noTF.getText(); // �Է��� �� �ҷ��� 
		
		// String���� �޾ƾ��� equals() ȣ�� ���� 
		if(noTemp.equals("")) { // �ƹ��͵� �Է��� ���� ������ 
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���");
			noTF.requestFocus(); // �Է� �������� �̵� 
			return;
		}
		
		String noReg ="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� �Է����ּ���");
			noTF.requestFocus();
			return;
		}
		
		
		// �Է¹��� �й����� ���������� ��ȯ�Ͽ� ����
		int no = Integer.parseInt(noTemp);
		
		// �׷���.. �̹� ������� �й��̸� 
		if(StudentDAO.getDAO().selectNoStudent(no) != null) {
			JOptionPane.showMessageDialog(this, "�̹� ������� �й��Դϴ�");
			noTF.requestFocus();
			return;
		}
		
		String name = nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �Է��� �ּ���");
			nameTF.requestFocus();
			return;
		}
		
		// ���Խ� ǥ���� �˻�
		String nameReg = "^([��-�R]{2,7})$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�̸��� �ѱ� 2~7�ڷ� �����ּ���");
			nameTF.requestFocus();
			return;		
		}
		
		String phone = phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "��ȣ�� �Է����ּ���");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg = "(01[016789])-\\d{3,4}-\\d{4}";

		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է����ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String address = addressTF.getText();
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "�ּҸ� �ݵ�� �Է��� �ּ���.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday = birthdayTF.getText();
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "��������� �ݵ�� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		
		/*
		String birthdayReg="(19|20)\\d{2}-(1-9|1[0-2])-(0[1-9]|[12][0-9]|3[0-1]";
		
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "������ ���Ŀ� �°� �Է����ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		*/
		
		// �Է°��� ���� 
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		int rows = StudentDAO.getDAO().insertStudent(student); // dao.insertStudent(�߰�);
	
		JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");
	
		displayAllStudent();
		
		// ��� ������Ʈ �ʱ�ȭ ó�� �޼��� ȣ�� 
		initDisplay();
	}
	
	public void removeStudent() {
		
		String noTemp = noTF.getText(); 
		
		if(noTemp.equals("")) { // �ƹ��͵� �Է��� ���� ������ 
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���");
			noTF.requestFocus(); // �Է� �������� �̵� 
			return;
		}
		
		String noReg ="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� �Է����ּ���");
			noTF.requestFocus();
			return;
		}
		
		int no = Integer.parseInt(noTemp);
		
		int rows = StudentDAO.getDAO().deleteStudent(no);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this, rows+"���� �л� ������ ���� �Ͽ����ϴ�. ");
			displayAllStudent();
		} else {
			JOptionPane.showMessageDialog(this, "�����ϰ��� �ϴ� �л� ������ �����ϴ� ");
		}
		initDisplay(); // �ʱ�ȭ 
	}
	
	public void searchNoStudent() {
		String noTemp = noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���");
			noTF.requestFocus();
			return;
		}
		
		String noReg = "\\d{4}"; 
	
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� �Է����ּ���.");
			noTF.requestFocus();
			return;
		}
		
		int no = Integer.parseInt(noTemp);
		
		StudentDTO student = StudentDAO.getDAO().selectNoStudent(no);
		if(student == null) {
			JOptionPane.showMessageDialog(this, "�����ϰ��� �ϴ� ���� �����ϴ�.");
			noTF.requestFocus();
			noTF.setText("");
			return;
		}
		
		// �˻��Ǿ� �ҷ��� ������ �ؽ�Ʈ�ʵ忡 �Է� �Ѵ�. 
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());

		// ���� �ۼ� ���¸� UPDATE_CHANGE ���·� ���� �Ѵ�.
		setEnable(UPDATE_CHANGE);
	}
	
	public void modifyStudent() {
		
		int no=Integer.parseInt(noTF.getText());
		String name=nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg = "^([��-�R]{2,7})$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� 2~7�ڷ� �����ּ���");
			nameTF.requestFocus();
			return;
		}
		
		String phone = phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �Է��� �ּ���");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "�ּҸ� �ݵ�� �Է��� �ּ���.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();//��������� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "��������� �ݵ�� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		
		/*
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "��������� ���Ŀ� �°� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		*/
		
		// UPDATE_CHANGE ���� �Է��� ������ ������ �߰��Ѵ�.
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		int rows = StudentDAO.getDAO().updateStudent(student);
	
		JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");
	}
	
	public void searchNameStudent() {
		
		String name = nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg = "^[��-�R]{2,7}$";//2~7 ������ �ѱ��� ǥ���� ���� ǥ����
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�̸��� 2~7 ������ �ѱ۸� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		// �̸����� �˻� 
		List<StudentDTO> studentList = StudentDAO.getDAO().selectNameStudent(name);
		
		// getModel() :  JTable�� ���� �ִ� �����͸� ��� �ִ� ��ü�� TableModel��ü�� ���ϵ˴ϴ�.
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		// ���� ���̺� ������ ������ 
		for(int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		
		// �˻��Ǿ��� ���̺� 
		for(StudentDTO student : studentList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			
			// ���̺� �߰��� 
			model.addRow(rowData);
		}
		initDisplay();
	}
	
	public static void main(String[] args) {
		new StudentGUIApp();
	}
}
