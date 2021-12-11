package xyz.itwill.student; 

/********************************************************
��    ��   �� : StudentGUIApp.java
��         �� : �л� ���� ���α׷�
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
	 * ������ ���� - ������ : ��� �л������� �˻��Ͽ� ��� 
	 *********************************************/
	public StudentGUIApp2() throws Exception {
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
		table.getTableHeader().setResizingAllowed(false);

		JScrollPane sp=new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		//JTable ���۳�Ʈ�� ��� �л������� �˻��Ͽ� ����ϴ� �޼ҵ� ȣ��
		displayAllStudent();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//��� JTextField ���۳�Ʈ ��Ȱ��ȭ ó���ϴ� �޼ҵ�
	public void initialize() {
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}

	//�Ű������� ���޵Ǵ� �������� ���� JTextField ���۳�Ʈ�� Ȱ�� �Ǵ� ��Ȱ�� ó���ϴ� �޼ҵ�
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

	//�Ű������� ���޵Ǵ� �������� ���� JButton ���۳�Ʈ�� Ȱ�� �Ǵ� ��Ȱ�� ó���ϴ� �޼ҵ�
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

	//��� JTextField ���۳�Ʈ�� �Է°��� �ʱ�ȭ ó���ϴ� �޼ҵ�
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}

	//��� ���۳�Ʈ�� �ʱ�ȭ ó���ϴ� �޼ҵ�
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();		
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	//�̺�Ʈ ó�� �޼ҵ� - JButton ���۳�Ʈ�� ���� ��� �ڵ� ȣ��Ǵ� �޼ҵ�
	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {//�߰� ��ư�� ���� ���
				if (cmd != ADD) {//ADD ���°� �ƴ� ��� 
					setEnable(ADD);//ADD ���·� ���۳�Ʈ�� Ȱ�� �Ǵ� ��Ȱ�� ó��					
				} else {//ADD ������ ���
					//JTextField ���۳�Ʈ�� �Է°��� �̿��Ͽ� ó�� >> �ʱ�ȭ ó��
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
			System.out.println("���� �߻� : " + e);
		}		
	}

	//STUDENT ���̺��� ����� ��� �л������� �˻��Ͽ� JTable ���۳�Ʈ�� ����ϴ� �޼ҵ�
	// => ������ �Ǵ� ��� �̺�Ʈ�� ���� �̺�Ʈ ó�� �޼ҵ忡�� ȣ��
	public void displayAllStudent() {
		//STUDENT ���̺��� ����� ��� �л������� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		// => StudentDAO.getDAO() : �̹� ������ StudentDAO �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		List<StudentDTO> studentList=StudentDAO.getDAO().selectAllStudent();
		
		//List.isEmpty() : List �ν��Ͻ��� ����� ��Ұ� �ִ� ��� false ��ȯ�ϰ� �����
		//��Ұ� �ϳ��� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(studentList.isEmpty()) {
			//JOptionPane : �⺻���� ���̾�α׸� �����ϴ� ���۳�Ʈ
			//JOptionPane.showMessageDialog(Component parentComponent, Object message) 
			// => �޼����� ����ϴ� ���̾�α׸� �����ϴ� �޼ҵ�
			JOptionPane.showMessageDialog(this, "����� �л������� �����ϴ�.");
			return;
		}
		
		//JTable.getModel() : JTable ���۳�Ʈ�� ���ӵ� TableModel �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//DefaultTableModel : TableModel �������̽��� ��ӹ޾� �ۼ��� Ŭ���� 
		// => JTable ���۳�Ʈ�� �������� �����ϴ� �ν��Ͻ�
		// => TableModel �ν��Ͻ��� DefaultTableModel Ŭ������ ��ü ����ȯ �Ͽ� ����
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		//���� JTable ���۳�Ʈ�� �����ϴ� ��� ���� �ϳ��� �ݺ������� ���� - JTable ���۳�Ʈ�� �ʱ�ȭ
		//DefaultTableModel.getRowCount() : DefaultTableModel �ν��Ͻ��� ����� ���� ������ ��ȯ�ϴ� �޼ҵ�
		for(int i=model.getRowCount();i>0;i--) {
			//DefaultTableModel.removeRow(int row) : DefaultTableModel �ν��Ͻ��� ����� 
			//���Ͽ��� ÷��(RowIndex)�� ���޹޾� ÷�� ��ġ�� ���� �����ϴ� �޼ҵ�
			model.removeRow(0);//ù��° �� ����
		}
		
		//JTable ���۳�Ʈ�� �˻��� �л������� �����Ͽ� ���
		// => DefaultTableModel ���۳�Ʈ�� �˻��� �л������� �ݺ������� ������ �߰��Ͽ�
		for(StudentDTO student:studentList) {
			//Vector �ν��Ͻ��� �����Ͽ� StudentDTO �ν��Ͻ��� �ʵ尪�� ��ҷ� �߰�
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			//DefaultTableModel.addRow(Vector rowData) : Vector �ν��Ͻ��� ���޹޾�
			//DefaultTableModel �ν��Ͻ��� ������ �߰��ϴ� �޼ҵ�
			model.addRow(rowData);
		}
	}
	
	//JTextField ���۳�Ʈ�� �Էµ� �л������� �����޾� STUDENT ���̺��� �����ϴ� �޼ҵ�
	// => �̺�Ʈ ó�� �޼ҵ忡�� [ADD] ���¿��� [�߰�] ��ư�� ���� ��� ȣ��
	public void addStudent() {
		String noTemp=noTF.getText();//�й��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����
		
		//�Է°� ����
		if(noTemp.equals("")) {//�Է°��� ���� ���
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���.");
			noTF.requestFocus();//���۳�Ʈ�� �Է�����(Focus) �̵�
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {//�Է°��� ���Ŀ� ���� ���� ���
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� ���ڷθ� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		//�й� �Է°��� ���������� ��ȯ�Ͽ� ����
		int no=Integer.parseInt(noTemp);
		
		//�Էµ� �й��� �ߺ��� ���� - �й��� �����Ͽ� STUDENT ���̺��� ����� �ش� �й��� 
		//�л������� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ�� 
		// => NULL ��ȯ : �л����� �̰˻� - �Էµ� �й� ��� ����
		// => StudentDTO �ν��Ͻ� ��ȯ : �л����� �˻� - �Էµ� �й� ��� �Ұ���(�й� �ߺ�)
		if(StudentDAO.getDAO().selectNoStudent(no)!=null) {//�Էµ� �й��� ��� �Ұ����� ��� 
			JOptionPane.showMessageDialog(this, "�̹� ������� �й��Դϴ�. �ٽ� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
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
		
		String phone=phoneTF.getText();//��ȭ��ȭ�� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����

		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �ݵ�� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();//�ּҰ� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����
		
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
		
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "��������� ���Ŀ� �°� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		
		//DTO �ν��Ͻ��� �����ϰ� JTextField ���۳�Ʈ�� �Է°�(������)���� �ʵ尪 ����
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//�л������� �����Ͽ� STUDENT ���̺��� �����ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		int rows=StudentDAO.getDAO().insertStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");
		
		//STUDENT ���̺��� ����� ��� �л������� �˻��Ͽ� ����ϴ� �޼ҵ� ȣ��
		displayAllStudent();
		
		//��� ���۳�Ʈ �ʱ�ȭ ó�� �޼ҵ� ȣ��
		initDisplay();
	}
	
	//JTextField ���۳�Ʈ�� �Էµ� �й��� �����޾� STUDENT ���̺��� ����� �ش� �й��� 
	//�л������� �����ϴ� �޼ҵ�
	// => �̺�Ʈ ó�� �޼ҵ忡�� [DELETE] ���¿��� [����] ��ư�� ���� ��� ȣ��
	public void removeStudent() {
		String noTemp=noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� ���ڷθ� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		//�й��� �����Ͽ� STUDENT ���̺��� ����� �ش� �й��� �л������� �����ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		int rows=StudentDAO.getDAO().deleteStudent(no);
		
		if(rows>0) {//�������� �����ϴ� ���
			JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");
			displayAllStudent();
		} else {//�������� �������� �ʴ� ���
			JOptionPane.showMessageDialog(this, "�����ϰ��� �ϴ� �й��� �л������� �����ϴ�.");
		}
		
		initDisplay();
	}
	
	//JTextField ���۳�Ʈ�� �Էµ� �й��� �����޾� STUDENT ���̺��� ����� �ش� �й��� 
	//�л������� �˻��Ͽ� JTextField ���۳�Ʈ�� ����ϴ� �޼ҵ�
	// => �̺�Ʈ ó�� �޼ҵ忡�� [UPDATE] ���¿��� [����] ��ư�� ���� ��� ȣ��
	public void searchNoStudent() {
		String noTemp=noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "�й��� �ݵ�� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "�й��� 4�ڸ��� ���ڷθ� �Է��� �ּ���.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		//�й��� �����Ͽ� STUDENT ���̺��� ����� �ش� �й��� �л������� �˻��Ͽ� ��ȯ�ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		StudentDTO student=StudentDAO.getDAO().selectNoStudent(no);
		if(student==null) {//�Էµ� �й��� �л������� �˻����� ���� ���
			JOptionPane.showMessageDialog(this, "�����ϰ��� �ϴ� �й��� �л������� �����ϴ�.");
			noTF.requestFocus();
			noTF.setText("");//JTextField ���۳�Ʈ�� �Է°� �ʱ�ȭ ó��
			return;
		}
				
		//�˻��Ǿ� ��ȯ�� �л������� �̿��Ͽ� JTextField ���۳�Ʈ�� �Է°����� ����
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
		
		//���� �ۼ����¸� UPDATE_CHANGE ���·� ����
		setEnable(UPDATE_CHANGE);
	}
	
	//JTextField ���۳�Ʈ�� �Էµ� �л������� �����޾� STUDENT ���̺��� ����� �л������� �����ϴ� �޼ҵ�
	// => �̺�Ʈ ó�� �޼ҵ忡�� [UPDATE_CHANGE] ���¿��� [����] ��ư�� ���� ��� ȣ��
	public void modifydStudent() {
		//�й��� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����
		int no=Integer.parseInt(noTF.getText());
		
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
		
		String phone=phoneTF.getText();//��ȭ��ȭ�� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����

		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� �ݵ�� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ���Ŀ� �°� �Է��� �ּ���.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();//�ּҰ� �Էµ� JTextField ���۳�Ʈ�� �Է°��� ��ȯ�޾� ����
		
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
		
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "��������� ���Ŀ� �°� �Է��� �ּ���.");
			birthdayTF.requestFocus();
			return;
		}
		
		//DTO �ν��Ͻ��� �����ϰ� JTextField ���۳�Ʈ�� �Է°�(������)���� �ʵ尪 ����
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//�л������� �����Ͽ� STUDENT ���̺��� ����� �л������� �����ϴ� DAO Ŭ������ �޼ҵ� ȣ��
		int rows=StudentDAO.getDAO().updateStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"���� �л������� ���� �Ͽ����ϴ�.");
		
		displayAllStudent();
		initDisplay();
	}
	
	//JTextField ���۳�Ʈ�� �Էµ� �̸��� �����޾� STUDENT ���̺��� ����� �л������� �˻��Ͽ� ����ϴ� �޼ҵ�
	// => �̺�Ʈ ó�� �޼ҵ忡�� [SEARCH] ���¿��� [�˻�] ��ư�� ���� ��� ȣ��
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
		
		//�̸��� �����Ͽ� STUDENT ���̺��� ����� �ش� �̸��� ��� �л������� �˻��Ͽ� ��ȯ
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














