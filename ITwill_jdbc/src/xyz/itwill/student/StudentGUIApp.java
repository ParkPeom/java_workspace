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
	
	private static final long serialVersionUID = 1L; // �θ� JFrame serializable �� ������ ��ü ����ȭ (���� ������ ��ü ������ ����� ���� ) 
													 // long Ÿ������ 1L �⺻ 

	// ��� : ���� ��ǥ�ؼ� ���� �̸�  �������� ��Ȯ�ϰ� �̸����� �����Ҽ��ִ�. 
	public static final int NONE = 0; // ���� ���·� �ʱ�ȭ
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
	 * ������ ���� - ������ : ��� �л������� �˻��Ͽ� ��� 
	 *********************************************/
	public StudentGUIApp() throws Exception {
		setTitle("�ߡߡ� �л� ���� ���α׷� �ߡߡ�");
		setSize(800, 400); // ���� 800 ���� 400

		
		// ������� ȭ��ũ�� �˾Ƴ��� 
		// Dimension : Ư�������� �簢���� ���� ������ ���� �����Ҽ� �ֵ��� �����ִ� Ŭ����
		// Dimension �簢����� Ư��ũ��
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2); // setLocation �߾ӿ� ��ġ �ϱ� ���ؼ� 

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1)); // 5�� 1��(row) ��ġ 

		JPanel pno = new JPanel();
		pno.add(new JLabel("��  ȣ")); // �� ���ڿ�  
		pno.add(noTF = new JTextField(10)); // ���� �Է¹��� 

		JPanel pname = new JPanel();
		pname.add(new JLabel("��  ��"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("��  ��"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("��  ȭ"));
		pphone.add(phoneTF = new JTextField(10));

		JPanel paddress = new JPanel();
		paddress.add(new JLabel("��  ��"));
		paddress.add(addressTF = new JTextField(10));

		// �׸��� ���̾ƿ��� �߰� 
		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5)); // 1�� 5�� 

		// addActionListener ��ư�� �������� ó���ϴ� �޼��� 
		// �׼� �̺�Ʈ �� �߻��ϸ� ���� ó���Ҽ��ֵ��� 
		
		
		// ��ư���� ���������� �׼� �̺�Ʈ�� �߻� 
		bottom.add(addB = new JButton("��  ��"));
		addB.addActionListener(this); // �׼� �̺�Ʈ�� ȣ���ϴµ� �� �ڽ��� ȣ��(actionperformed) 

		bottom.add(deleteB = new JButton("��  ��"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("��  ��"));
		updateB.addActionListener(this);

		bottom.add(searchB = new JButton("��  ��"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("�ʱ�ȭ"));
		cancelB.addActionListener(this);

		Object[] title={"�й�","�̸�","��ȭ��ȣ","�ּ�","�������"}; // Ÿ��Ʋ
		table=new JTable(new DefaultTableModel(title, 0)); // (���̺� ��� , �ƿ� �� 0��) -> Ÿ��Ʋ�� ��� 
		
		// ���̺��� �����ʰ� ������ ���ϰ� ũ�� ������ ������� �ʰڴ�.
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false); 
		table.getTableHeader().setResizingAllowed(false); // ��� , ũ�� ���� ���ϰ� �� 

		// JTable ���۳�Ʈ�� ��� �л������� �˻��Ͽ� ����ϴ� �޼��� ȣ�� 
		displayAllStudent();
		JScrollPane sp=new JScrollPane(table); // ���̺� �߰� 
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE; // �հ��� �����Ѱ� ������ NONE
		initialize(); // ��� �Է����۳�Ʈ ȣ���ؼ� 

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() { 
		// ��� JTextField ���۳�Ʈ ��Ȱ��ȭ ������ 
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}
	
	//�Ű������� ���޵Ǵ� �������� ���� JTextField ���۳�Ʈ�� Ȱ��ȭ �Ǵ� ��Ȱ�� ó��
	
	// ���¿� ���� ���۳�Ʈ 
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
			noTF.setEditable(true); // �й����� �����ϴϱ� �й��� �Է� �����ϰ� ��
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
	
	
	//�Ű������� ���޵Ǵ� �������� ���� JButton ���۳�Ʈ�� Ȱ��ȭ �Ǵ� ��Ȱ�� ó���ϴ� �޼ҵ�
	
	// ���� ����� cmd ���� ���� � ���۳�Ʈ�� Ȱ��ȭ ó�� ��Ȱ��ȭ ó�� ��Ŵ 
	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD); // ADD�� Ȱ��ȭ ó�� 
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
		case NONE: // ���������
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}
	// ��� JTextFied ���۳�Ʈ�� �Է°� ���� ���·�  �ʱ�ȭ ó���ϴ� �޼ҵ�
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}
	
	//��� ���۳�Ʈ JText �� �ʱ�ȭ ó���ϴ� �޼ҵ�
	public void initDisplay() {
		setEnable(NONE); // ��� ��ư�� Ȱ��ȭ ó�� 
		clear();
		cmd = NONE;
		initialize(); // JTextField ��Ȱ��ȭ ó�� 	
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	
	
	//----------------------- �̺�Ʈ ó�� �޼ҵ� - JButton ���۳�Ʈ�� ���� ��� �ڵ� ȣ��Ǵ� �޼ҵ�-----------------------
	
	
	public void actionPerformed(ActionEvent ev) { // ��ư���� �̺�Ʈ ó�� �޼��� 
		Component c = (Component) ev.getSource(); // ���۳�Ʈ�� ��ȯ����
		try {
			
			// ���¿� ���� Ȱ��ȭ ��Ȱ��ȭ ó�� 
			
			
			if (c == addB) {//�߰� ��ư�� ���� ���
				if (cmd != ADD) { //ADD ���°� �ƴ� ��� - ���۳�Ʈ�� Ȱ�� �Ǵ� ��Ȱ�� ó��
					setEnable(ADD); // ADD ���·� Ȱ��ȭ	- ���۳�Ʈ�� Ȱ�� �Ǵ� ��Ȱ��ȭ ó�� , JText �� Ȱ��ȭ			
				} else {//ADD ������ ���
					//JTextField ���۳�Ʈ�� �Է°��� �̿��Ͽ� ó�� >> �ʱ�ȭ ó�� 
					addStudent(); // �߰� 
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) { // DELETE ���°� �ƴ� ���
					setEnable(DELETE); // DELETE ���·� Ȱ��ȭ �Ѵ�. 
				} else {
					removeStudent(); // ���� 				
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if (cmd != UPDATE_CHANGE) { // ������Ʈ�����ε� ������Ʈü������ �ƴ϶�� 
					searchNoStudent(); // �й��� �����ٰ� �˻� �ؼ� 
				} else {
					modifydStudent(); // ü���� ���¿��� ȣ��
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
			System.out.println("���� �߻� : " + e);
		}		
	}
	
	// STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� JTable���۳�Ʈ�� ����ϴ� �޼���
	// => ������ �Ǵ� ��� �̺�Ʈ�� ���� �̺�Ʈ ó�� �޼��忡�� ȣ��  
	public void displayAllStudent() {
		// STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ��ȯ�ϴ� DAOŬ������ �޼��� ȣ�� 
		// StudentDAO.getDAO() : �̹� ������ StudentDAO �ν��Ͻ��� ��ȯ 
		// studentList ��� �л������� ��ȯ�޾� ������ ( �ߺ��� �ڵ带 �ּ�ȭ �ؾ��� JDBC�� ���� �����ٰ� ����� )
											// CRUD�� �ս��� ����� ���������� ���� 
		List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		
		// List.isEmpty() : List �ν��Ͻ��� ����� ��Ұ� �ִ� ��� false��ȯ �ϰ� �����
		// ��Ұ� �ϳ��� ���� ��� true ��ȯ �ϴ� �޼��� 
		if(studentList.isEmpty()) { // ��������� true
			// JOptionPane. : �⺻���� ���̾�α׸� �����ϴ� ���۳�Ʈ 
			// �θ�� this 
			// => �޼����� ������� ���̾�α׸� �����ϴ� �޼��� 
			JOptionPane.showMessageDialog(this, "����� �л������� �����ϴ�.");
			return; // ����Ұ� ������ �޼��� ���� 
		}
		
		// JTable.getModel() : JTable ���۳�Ʈ�� ���ӵ� TableModel �ν��Ͻ��� ��ȯ�ϴ� �޼��� 
		
		// TableModel ���� �����Ҽ��ִ� 
		// DefaultTableModel : TableModel �������̽� ��ӹ޾Ƽ� ���� �ڽ����̺�
		// => - JTable ���۳ʴ�Ʈ�� �������� �����ϴ� �ν��Ͻ� 
		// => Table Model �ν��Ͻ��� DefaultTableModel Ŭ������ ��ü ����ȯ �Ͽ� ���� 
		
		DefaultTableModel model = (DefaultTableModel)table.getModel(); // ���̺��� ���� �����ϰų� �߰��ҋ� DefaultTableModel	
				//  table.getModel() : TableModel�θ� ��ȯ �ڽ� ���� ����ȯ 
		
		
		// ���� �л��� �����ϰ� 
		// ���� JTable ���۳�Ʈ�� �����ϴ� ��� ���� �ϳ��� �ݺ������� �����Ѵ� - JTable ���۳�Ʈ �ʱ�ȭ 
		// model.getRowCount() : ����� ���� ������ ��ȯ�ϴ� �޼��� 
		
		
		// ���� �������� �ݺ� 
		for(int i = model.getRowCount(); i > 0 ; i--) {
			// DefaultTableModel.removeRow(int row ) :DefaultTableModel �ν��Ͻ��� �����
			// ���� ÷��(RowIndex)�� ���޹޾�÷�� ��ġ�� ���� �����ϴ� �޼���
			model.removeRow(0); // ù���� �� ��� ���� 
		}
		//JTable ���۳�Ʈ�� �˻��� �л������� �����Ͽ� ���
		// => DefaultTableModel ���۳�Ʈ�� �˻��� �л������� �ݺ������� ������ �߰��Ͽ� 
		for(StudentDTO student : studentList) {
			// Vector �ν��Ͻ��� �����Ͽ� StudentDTO �ν��Ͻ��� �ʵ尪�� ��ҷ� �߰� 
			Vector<Object> rowData = new Vector<Object>(); // ���� ������ ���� Vector 
			rowData.add(student.getNo()); // ������ �����ٰ� ���ͷ� ������ ���� 
			rowData.add(student.getName()); // ������ �����ٰ� ���ͷ� ������ ���� 
			rowData.add(student.getPhone()); // ������ �����ٰ� ���ͷ� ������ ���� 
			rowData.add(student.getAddress()); // ������ �����ٰ� ���ͷ� ������ ���� 
			rowData.add(student.getBirthday()); // ������ �����ٰ� ���ͷ� ������ ���� 
			
			// DefaultTableModel.addRow(Vector rowData)
			// DefaultTableModel �ν��Ͻ��� ������ �߰��ϴ� �޼��� 
			model.addRow(rowData);
		}
	}
	
	//JTextField ���۳�Ʈ�� �Էµ� �л������� �����޾� STUDENT ���̺� �����ϴ� �޼ҵ�
	// => �̺�Ʈ ó�� �޼ҵ忡�� [ADD]���¿��� [�߰�] ��ư�� ���� ��� ȣ��
	public void addStudent() {
		String noTemp=noTF.getText();//�й��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����  
		// ���ڿ��� �޾ƾ��� ���Խ��̶� ���Ҽ��� �ִ�.
		
		//�Է°� ����
		if(noTemp.equals("")) { //�Է°��� ���� ��� 
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է����ּ���");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return; // ���� 
		}
		String noReg = "\\d{4}"; // ���� 4�� �ݺ� �ϴ� ��Ģ 
		if(!Pattern.matches(noReg, noTemp)) { // �Է°��� 4�ڸ��� 
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� ���ڷθ� �Է����ּ���");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		//�й� �Է°��� ���������� ��ȯ�Ͽ� ���� 
		// ���ڿ�  (������ ������) -> ���ڷ� �ٲܼ��ֵ��� 
		int no = Integer.parseInt(noTemp);
		
		// �Էµ� �й��� �ߺ��� ���� : �й��� �����Ͽ� STUDENT ���̺� ����� �ش� �й��� 
		// �л������� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ�� 
		// DAO Ŭ������ �޼ҵ� ȣ�� - �й��� �ߺ��� ���� 
		// => NULL ��ȯ : �л����� �̰˻� - �Էµ�  �й� ��� ���� 
		// => StudentDTO �ν��Ͻ� ��ȯ - �л����� �˻� - �Էµ� �й� ��� �Ұ���(�й� �ߺ�) 
		
		if(StudentDAO.getDAO().selectNoStudent(no)!=null) {//�Էµ� �й��� ��� �Ұ����� ��� 
			JOptionPane.showMessageDialog(this, "�̹� ������� �й��Դϴ�. �ٽ� �Է��� �ּ���");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		String name = nameTF.getText(); // //�̸��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����  
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���");
			nameTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		
		}
		
		// �����ڵ� �����̸� "^[��-�R]{2,7}|[a-zA-Z]{4,20}$"
		String nameReg = "^[��-�R]{2,7}$"; //�ѱ� 2��~7�� �ݺ� �� ���� �R(�����ڵ� ������)����
										  //2~7 ������ �ѱ��� ǥ���� ���� ǥ����
		if(!Pattern.matches(nameReg, name)) { // �Է°��� 4�ڸ��� 
			JOptionPane.showMessageDialog(this, "�̸��� 2~7 ������ �ѱ۸� �Է��� �ּ���");
			nameTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		// �̸��� �ߺ����� ���� ������ �� �ʿ䰡 ����.
		
		String phone = phoneTF.getText(); // ��ȭ��ȣ �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����  
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �ݵ�� �Է��� �ּ���");
			phoneTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}"; // 016789�� �ϳ� - 3�ڸ�����4�ڸ��ݺ� - 4�ڸ��ݺ� 
	
		if(!Pattern.matches(phoneReg, phone)) { 
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���");
			phoneTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		String address = addressTF.getText(); // �ּҰ� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ���� 
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "�ּҸ� �ݵ�� �Է��� �ּ���");
			addressTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		// �ǹ��� �Է��ϰ� �ش� �ǹ��� ���� �����ȣ �׷� �������� ����Ҽ� �ִ�.
		// ���� �ּ� ���� ��� �� �ּҸ� ������ �˻��� ���ؼ� �ּҰ� �˻��Ǿ������ִ�.
		// �ּҴ� ����ǥ�������� ǥ���Ҽ��� ����.. �����ȣ�˻������ ���ؼ� �ּҸ� ..
		
		String birthday = birthdayTF.getText(); // ��������� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ���� 
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "��������� �ݵ�� �Է��� �ּ���");
			birthdayTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(1-9|1[0-2])-(0[1-9]|[12][0-9]|3[0-1]";
										//  1900 2000 �⵵ 1~9��,10��~12�� �� �ϳ� ����  1 ~9 10~19 , 20 ~ 29 30~31
		if(!Pattern.matches(birthdayReg, birthday)) { 
			JOptionPane.showMessageDialog(this, "��������� ���Ŀ� �°� �Է��� �ּ���");
			birthdayTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		// DTO �ν��Ͻ��� �����ϰ� JTextField ���۳�Ʈ�� �Է°�(������)���� �ʵ尪 ����
		
		StudentDTO student = new StudentDTO();
		// �ԷµȰ����� ������
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);

		//�л������� �����Ͽ� STUDENT ���̺� �����ϴ� DAO Ŭ������ �޼��� ȣ��
		int rows = StudentDAO.getDAO().insertStudent(student); 
	
		JOptionPane.showMessageDialog(this, rows + "���� �л� ������ �����Ͽ����ϴ�.");
		
		// STUDENT ���̺� ����� ����л������� �˻��Ͽ� ����ϴ� �޼ҵ�
		displayAllStudent(); 
		
		// ��� ���۳�Ʈ �ʱ�ȭ ó��
		initDisplay();
	}
	// JTextField ���۳�Ʈ�� �Էµ� �й��� �����޾� STUDENT ���̺� ����� �ش� �й��� �л������� �����ϴ� �޼���
	// �л������� 
	// => �̺�Ʈ ó�� �޼ҵ忡�� [DELETE]���¿��� [����]��ư�� ���� ��� ȣ��
	public void removeStudent() {
		
		String noTemp=noTF.getText();//�й��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����  
		// ���ڿ��� �޾ƾ��� ���Խ��̶� ���Ҽ��� �ִ�.
		
		//�Է°� ����
		if(noTemp.equals("")) { //�Է°��� ���� ��� 
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է����ּ���");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return; // ���� 
		}
		
		String noReg = "\\d{4}"; // ���� 4�� �ݺ� �ϴ� ��Ģ 
		if(!Pattern.matches(noReg, noTemp)) { // �Է°��� 4�ڸ��� 
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� ���ڷθ� �Է����ּ���");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		//�й� �Է°��� ���������� ��ȯ�Ͽ� ���� 
		// ���ڿ�  (������ ������) -> ���ڷ� �ٲܼ��ֵ��� 
		int no = Integer.parseInt(noTemp);
		
		//�й��� �����Ͽ� STUDENT ���̺��� ����� �ش� �й��� �л� ������ �����ϴ� DAOŬ������ �޼ҵ� ȣ��
		int rows = StudentDAO.getDAO().deleteStudent(no);
		
		if(rows > 0) { //�������� �����ϴ� ���
			JOptionPane.showMessageDialog(this, rows + "���� �л� ������ �����Ͽ����ϴ�.");
			displayAllStudent();
		} else { //�������� �������� �ʴ� ���
			JOptionPane.showMessageDialog(this, "���� �ϰ��� �ϴ� �й��� �л������� �����ϴ�.");			
		}
		initDisplay();
	}
	
	// �ѹ� ������ �й��� Ȱ��ȭ ���� , �й��Է��ؼ� ���� �� ������ �̸�,��ȭ,�ּ�,���� �Է�, ���� ������ ����ó���ǰ���
	
	// JTextField ���۳�Ʈ�� �Էµ� �й��� �����޾� STUDENT ���̺� ����� �ش� �й��� �л������� �����ϴ� �޼���
	// �л������� �˻��Ͽ�  JTextField ���۳�Ʈ�� ����ϴ� �޼ҵ�
	// => �̺�Ʈ ó�� �޼ҵ忡�� [UPDATE]���¿��� [����]��ư�� ���� ��� ȣ��
	
	public void searchNoStudent() {
		
		String noTemp=noTF.getText();//�й��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����  
		// ���ڿ��� �޾ƾ��� ���Խ��̶� ���Ҽ��� �ִ�.
		
		//�Է°� ����
		if(noTemp.equals("")) { //�Է°��� ���� ��� 
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է����ּ���");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return; // ���� 
		}
		
		String noReg = "\\d{4}"; // ���� 4�� �ݺ� �ϴ� ��Ģ 
		if(!Pattern.matches(noReg, noTemp)) { // �Է°��� 4�ڸ��� 
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� ���ڷθ� �Է����ּ���");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			return;
		}
		
		//�й� �Է°��� ���������� ��ȯ�Ͽ� ���� 
		// ���ڿ�  (������ ������) -> ���ڷ� �ٲܼ��ֵ��� 
		int no = Integer.parseInt(noTemp);
		
		// �й��� �����Ͽ� STUDENT ���̺� ����� �ش� �й��� �л������� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼��� ȣ��
		StudentDTO student = StudentDAO.getDAO().selectNoStudent(no);
		if(student==null) {//�Էµ� �й��� �л������� �˻����� ���� ��� 
			JOptionPane.showMessageDialog(this, "�����ϰ��� �ϴ� �й��� �л������� �����ϴ�.");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
			noTF.setText(""); // JTextField ���۳�Ʈ�� �Է°� �ʱ�ȭ ó�� 
			return;
		}
		
		//�˻��Ǿ� ��ȯ�� �л������� �̿��Ͽ� JTextField ���۳�Ʈ�� �Է°����� �������ش�.
		noTF.setText(student.getNo()+""); // String�� �޾ƾߵǴµ�. Integer �� + " "->���ڿ��ε�
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
	
		// ���� �۾� ���¸� UPDATE_CHANGE ���·� ���� ( ����ó���� �����ϵ��� )
		setEnable(UPDATE_CHANGE);
	}
	// => �л������� �����޾� STUDENT ���̺� �����
	// => 
	public void modifydStudent() {
		
	
	// �й��� ������ �ʿ䰡 ����. �й��� ��Ȱ������ ó���Ǿ����� ���� ������ 
	int no = Integer.parseInt(noTF.getText());
	
	
	String name = nameTF.getText(); // //�̸��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����  
	
	if(name.equals("")) {
		JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���");
		nameTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
		return;
	
	}
	
	// �����ڵ� �����̸� "^[��-�R]{2,7}|[a-zA-Z]{4,20}$"
	String nameReg = "^[��-�R]{2,7}$"; //�ѱ� 2��~7�� �ݺ� �� ���� �R(�����ڵ� ������)����
									  //2~7 ������ �ѱ��� ǥ���� ���� ǥ����
	if(!Pattern.matches(nameReg, name)) { // �Է°��� 4�ڸ��� 
		JOptionPane.showMessageDialog(this, "�̸��� 2~7 ������ �ѱ۸� �Է��� �ּ���");
		nameTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
		return;
	}
	
	// �̸��� �ߺ����� ���� ������ �� �ʿ䰡 ����.
	
	String phone = phoneTF.getText(); // ��ȭ��ȣ �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����  
	
	if(name.equals("")) {
		JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �ݵ�� �Է��� �ּ���");
		phoneTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
		return;
	
	}
	
	String phoneReg="(01[016789])-\\d{3,4}-\\d{4}"; // 016789�� �ϳ� - 3�ڸ�����4�ڸ��ݺ� - 4�ڸ��ݺ� 

	if(!Pattern.matches(phoneReg, phone)) { 
		JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���");
		phoneTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
		return;
	}
	
	String address = addressTF.getText(); // �ּҰ� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ���� 
	
	if(address.equals("")) {
		JOptionPane.showMessageDialog(this, "�ּҸ� �ݵ�� �Է��� �ּ���");
		addressTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
		return;
	}
	
	// �ǹ��� �Է��ϰ� �ش� �ǹ��� ���� �����ȣ �׷� �������� ����Ҽ� �ִ�.
	// ���� �ּ� ���� ��� �� �ּҸ� ������ �˻��� ���ؼ� �ּҰ� �˻��Ǿ������ִ�.
	// �ּҴ� ����ǥ�������� ǥ���Ҽ��� ����.. �����ȣ�˻������ ���ؼ� �ּҸ� ..
	
	String birthday = birthdayTF.getText(); // ��������� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ���� 
	
	if(birthday.equals("")) {
		JOptionPane.showMessageDialog(this, "��������� �ݵ�� �Է��� �ּ���");
		birthdayTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
		return;
	}
	
	String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
									//  1900 2000 �⵵ 1~9��,10��~12�� �� �ϳ� ����  1 ~9 10~19 , 20 ~ 29 30~31
	if(!Pattern.matches(birthdayReg, birthday)) { 
		JOptionPane.showMessageDialog(this, "��������� ���Ŀ� �°� �Է��� �ּ���");
		birthdayTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus)�� �̵��ϴ� �޼ҵ�
		return;
	}
	
	// DTO �ν��Ͻ��� �����ϰ� JTextField ���۳�Ʈ�� �Է°�(������)���� �ʵ尪 ����
	
	StudentDTO student = new StudentDTO();
	// �ԷµȰ����� ������
	student.setNo(no);
	student.setName(name);
	student.setPhone(phone);
	student.setAddress(address);
	student.setBirthday(birthday);

	//�л������� �����Ͽ� STUDENT ���̺� ����� �л������� �����ϴ� DAO Ŭ������ �޼��� ȣ��
	int rows = StudentDAO.getDAO().updateStudent(student); 
	
	JOptionPane.showMessageDialog(this, rows + "���� �л� ������ �����Ͽ����ϴ�.");
	// STUDENT ���̺� ����� ����л������� �˻��Ͽ� ����ϴ� �޼ҵ�
	displayAllStudent(); 
	// ��� ���۳�Ʈ �ʱ�ȭ ó��
	initDisplay();
	}
	
	public void searchNameStudent() {
		
		String name=nameTF.getText();//�̸��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�̸��� �ݵ�� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^([��-?]{2,7})$";//2~7 ������ �ѱ��� ǥ���� ���� ǥ����
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�̸��� 2~7 ������ �ѱ۸� �Է��� �ּ���.");
			nameTF.requestFocus();
			return;
		}
		
		//�̸��� �����Ͽ� STUDENT ���̺� ����� �ش� �̸��� ��� �л������� �˻��Ͽ� ��ȯ
		//�ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		List<StudentDTO> studentList=StudentDAO.getDAO().selectNameStudent(name);
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "�˻��� �л������� �����ϴ�.");
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
