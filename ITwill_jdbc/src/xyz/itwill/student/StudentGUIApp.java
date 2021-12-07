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
	 * ������ ����
	 *********************************************/
	public StudentGUIApp() throws Exception {
		setTitle("�ߡߡ� �л� ���� ���α׷� �ߡߡ�");
		setSize(800, 400);

		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel pno = new JPanel();
		pno.add(new JLabel("��  ȣ"));
		pno.add(noTF = new JTextField(10));

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

		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(addB = new JButton("��  ��"));
		addB.addActionListener(this);

		bottom.add(deleteB = new JButton("��  ��"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("��  ��"));
		updateB.addActionListener(this);

		bottom.add(searchB = new JButton("��  ��"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("�ʱ�ȭ"));
		cancelB.addActionListener(this);

		Object[] title={"�й�","�̸�","��ȭ��ȣ","�ּ�","�������"};
		table=new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false); 
		table.getTableHeader().setResizingAllowed(false); // ��� , ũ�� ���� ���ϰ� �� 

		// JTable ���۳�Ʈ�� ��� �л������� �˻��Ͽ� ����ϴ� �޼��� ȣ�� 
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
	
	public void actionPerformed(ActionEvent ev) { // ��ư���� �̺�Ʈ ó�� �޼��� 
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {//�߰� ��ư�� ���� ���
				if (cmd != ADD) {//ADD ���°� �ƴ� ���
					setEnable(ADD);//ADD ���·� Ȱ��ȭ					
				} else {//ADD ������ ���
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
			return; // �޼��� ���� 
		}
		
		// JTable.getModel() : JTable ���۳�Ʈ�� ���ӵ� TableModel �ν��Ͻ��� ��ȯ�ϴ� �޼��� 
		
		// TableModel ���� �����Ҽ��ִ� 
		// DefaultTableModel : TableModel �������̽� ��ӹ޾Ƽ� ���� �ڽ����̺�
		// => - JTable ���۳ʴ�Ʈ�� �������� �����ϴ� �ν��Ͻ� 
		// => Table Model �ν��Ͻ��� DefaultTableModel Ŭ������ ��ü ����ȯ �Ͽ� ���� 
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		
		// ���� �л��� �����ϰ� 
		// ���� JTable ���۳�Ʈ�� �����ϴ� ��� ���� �ϳ��� �ݺ������� �����Ѵ� - JTable ���۳�Ʈ �ʱ�ȭ 
		// model.getRowCount() : ����� ���� ������ ��ȯ�ϴ� �޼��� 
		
		for(int i = model.getRowCount(); i > 0 ; i--) {
			// DefaultTableModel.removeRow(int row ) :DefaultTableModel �ν��Ͻ��� �����
			// ���� ÷��(RowIndex)�� ���޹޾�÷�� ��ġ�� ���� �����ϴ� �޼���
			model.removeRow(0); // ù���� �� ���� 
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
}
