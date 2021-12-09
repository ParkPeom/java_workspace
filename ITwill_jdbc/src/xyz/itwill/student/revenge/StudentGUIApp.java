package xyz.itwill.student.revenge;


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

import xyz.itwill.student.StudentDAO;
import xyz.itwill.student.StudentDTO;

public class StudentGUIApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;
	
	JTextField noTF , nameTF , phoneTF , addressTF , birthdayTF;
	JButton addB , deleteB , updateB , searchB , cancelB;
	
	JTable table;
	
	int cmd;
	
	public StudentGUIApp() throws Exception	 {
		setTitle("¡Ú ÇĞ»ı°ü¸® ÇÁ·Î±×·¥ ¡Ú");
		setSize(800,400); // °¡·Î,¼¼·Î
		
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);
		
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5,1));  // import java.awt.GridLayout;
		
		JPanel pno = new JPanel();
		pno.add(new JLabel("¹ø È£"));
		pno.add(noTF = new JTextField(10));
		
		JPanel pname = new JPanel();
		pname.add(new JLabel("ÀÌ ¸§"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("Àü È­"));
		pphone.add(phoneTF = new JTextField(10));
		
		JPanel paddress = new JPanel();
		paddress.add(new JLabel("ÁÖ ¼Ò"));
		paddress.add(addressTF = new JTextField(10));

		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("»ı ³â ¿ù ÀÏ"));
		pbirthday.add(birthdayTF = new JTextField(10));
	
		
		// ÆĞ³Î ±×¸®µå·¹ÀÌ¾Æ¿ô¿¡ Ãß°¡ÇÑ´Ù.
		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
	
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1,5)); // 1Çà 5¿­ 
		
		bottom.add(addB = new JButton("Ãß  °¡"));
		addB.addActionListener(this);

		bottom.add(deleteB = new JButton("»è  Á¦"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("º¯  °æ"));
		updateB.addActionListener(this);

		bottom.add(searchB = new JButton("°Ë  »ö"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("ÃÊ±âÈ­"));
		cancelB.addActionListener(this);
		
		Object[] title = {"ÇĞ¹ø","ÀÌ¸§","ÀüÈ­¹øÈ£","ÁÖ¼Ò","»ı³â¿ùÀÏ"}; // Çà 
		table = new JTable(new DefaultTableModel(title,0)); //  ( Çà,¿­)
		table.setEnabled(false);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		JScrollPane sp = new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		
		cmd = NONE; // cmd °¡ 0 ÀÌ¸é 
		initialize(); // ÃÊ±âÈ­
		
		displayAllStudent();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	// ¸ğµç JTextField ÄÄÆÛ³ÍÆ® ºñÈ°¼ºÈ­ Ã³¸® ÇÏ´Â ¸Ş¼Òµå
	public void initialize() {
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
		
	}
	
	
	// ¸Å°³º¯¼ö¿¡ Àü´ŞµÇ´Â Á¤¼ö°ª¿¡ µû¸¥ JTextField ÄÄÆÛ³ÍÆ®ÀÇ È°¼º ¶Ç´Â ºñÈ°¼º Ã³¸®ÇÏ´Â ¸Ş¼Òµå
	// JTextField¿¡ ÀÔ·ÂÀ» ºÒ°¡ÇÏ°Ô ¸¸µé¾î¾ß µÇ´Â°æ¿ì¿¡ Ç×»ó setEnabled(false)¸¦ ½è´Âµ¥ 
	// setEnabled(false)¸¦ÇÏ¸é ÅØ½ºÆ®ÀÇ »ö»óÀÌ ÇÏ¾á»öÀ¸·Î °íÁ¤µÇ¾î ¹ö¸°´Ù. 
	// ÀÔ·ÂÀº ºÒ°¡ÇÏ¸é¼­ ÅØ½ºÆ® »ö»óµµ ¹Ù²Ù°í ½Í´Ù¸é setEditable(false)¸¦ »ç¿ëÇÏ¸é µÈ´Ù.

	public void setEditable(int n) {
	
		switch(n) {
		
		case ADD: // Ãß°¡ 	
			noTF.setEditable(true); 
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;

		case DELETE: // »èÁ¦ 
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
		
		case SEARCH:
			nameTF.setEditable(true);
	
		case NONE: // ÃÊ±âÈ­
			noTF.setEditable(false);
			nameTF.setEditable(false);
			phoneTF.setEditable(false);
			addressTF.setEditable(false);
			birthdayTF.setEditable(false);
		}
	}
		//¸Å°³º¯¼ö¿¡ Àü´ŞµÇ´Â Á¤¼ö°ª¿¡ µû¸¥ JButton ÄÄÆÛ³ÍÆ®ÀÇ È°¼º ¶Ç´Â ºñÈ°¼º Ã³¸®ÇÏ´Â ¸Ş¼Òµå
		public void setEnable(int n) {
			addB.setEnabled(false);
			deleteB.setEnabled(false);
			updateB.setEnabled(false);
			searchB.setEnabled(false);
			
			switch (n) {
			case ADD: //0 
				addB.setEnabled(true);
				setEditable(ADD);
				cmd = ADD;
				break;
			case DELETE: //1
				deleteB.setEnabled(true);
				setEditable(DELETE);
				cmd = DELETE;
				break;
			case UPDATE: // 2
				updateB.setEnabled(true);
				setEditable(UPDATE);
				cmd = UPDATE;
				break;			
			case UPDATE_CHANGE: // 3
				updateB.setEnabled(true);
				setEditable(UPDATE_CHANGE);
				cmd = UPDATE_CHANGE;
				break;			
			case SEARCH: // 4 
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
			
	// ¸ğµç JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ÃÊ±âÈ­ Ã³¸®ÇÏ´Â ¸Ş¼Òµå
	public void clear() {
		noTF.setText(""); 
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}
	
	// ¸ğµç ÄÄÆÛ³ÍÆ®¸¦ ÃÊ±âÈ­ Ã³¸®ÇÏ´Â ¸Ş¼Òµå
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();
	}
	
	public static void main(String[] args) throws Exception {
		new StudentGUIApp();
	}
	
	
	//ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå - JButton ÄÄÆÛ³ÍÆ®¸¦ ´©¸¥ °æ¿ì ÀÚµ¿ È£ÃâµÇ´Â ¸Ş¼Òµå
	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		try {
			if (c == addB) {//Ãß°¡ ¹öÆ°À» ´©¸¥ °æ¿ì
				if (cmd != ADD) {//ADD »óÅÂ°¡ ¾Æ´Ñ °æ¿ì 
					setEnable(ADD);//ADD »óÅÂ·Î ÄÄÆÛ³ÍÆ®ÀÇ È°¼º ¶Ç´Â ºñÈ°¼º Ã³¸®					
				} else {//ADD »óÅÂÀÎ °æ¿ì
					//JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ÀÌ¿ëÇÏ¿© Ã³¸® >> ÃÊ±âÈ­ Ã³¸®
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
		} catch (Exception eb) {
			System.out.println("¿¹¿Ü ¹ß»ı : " + eb);
		}		
	}
	
	// STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© JTable ÄÄÆÛ³ÍÆ®¿¡ Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	// => »ı¼ºÀÚ ¶Ç´Â ¸ğµç ÀÌº¥Æ®¿¡ ´ëÇÑ ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ È£Ãâ
	
	public void displayAllStudent() {
		
		// List<StudentDTO> selectAllStudent() { } 
		List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		
		if(studentList.isEmpty()) { // ºñ¾îÀÖÀ¸¸é true
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ ÇĞ»ı Á¤º¸°¡ ¾ø½À´Ï´Ù");
			return;
		}
		
		// JTable.getModel() : JTable ÄÄÆÛ³ÍÆ®¿¡ Á¾¼ÓµÈ TableModel ÀÎ½ºÅÏ½º¸¦ ¹İÈ¯ÇÏ´Â ¸Ş¼Òµå
		// DefaultTableModel : TableModel ÀÎÅÍÆäÀÌ½º¸¦ »ó¼Ó¹Ş¾Æ ÀÛ¼ºµÈ Å¬·¡½º
		// => JTable ÄÄÆÛ³ÍÆ®ÀÇ ÇàÁ¤º¸¸¦ Á¦¾îÇÏ´Â ÀÎ½ºÅÏ½º
		// => TableModel ÀÎ½ºÅÏ½º¸¦ DefaultTableModel Å¬·¡½º·Î °´Ã¼ Çüº¯È¯ ÇÏ¿© ÀúÀå
	
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i=model.getRowCount(); i>0; i--) {
			model.removeRow(0); // Ã¹¹øÂ° Çà Á¦°Å 
		}
			
		// JTable ÄÄÆÛ³ÍÆ®¿¡ °Ë»öµÈ ÇĞ»ıÁ¤º¸¸¦ ÀúÀåÇÏ¿© Ãâ·Â
		// => DefaultTableModel ÄÄÆÛ³ÍÆ®¿¡ °Ë»öµÈ ÇĞ»ıÁ¤º¸¸¦ ¹İº¹ÀûÀ¸·Î ÇàÀ¸·Î Ãß°¡ÇÏ¿©
		
		for(StudentDTO student : studentList) {
			//Vector ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ¿© StudentDTO ÀÎ½ºÅÏ½º¸¦ ÇÊµå°ªÀ» ¿ä¼Ò·Î Ãß°¡
				Vector<Object> rowData = new Vector<Object>();
				rowData.add(student.getNo());
				rowData.add(student.getName());
				rowData.add(student.getPhone());
				rowData.add(student.getAddress());
				rowData.add(student.getBirthday());
				
				//DefaultTableModel.addRow(Vector rowData) : Vector ÀÎ½ºÅÏ½º¸¦ Àü´Ş¹Ş¾Æ
				//DefaultTableModel ÀÎ½ºÅÏ½ºÀÇ ÇàÀ¸·Î Ãß°¡ÇÏ´Â ¸Ş¼Òµå		
		}
	}
	// JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ»ıÁ¤º¸¸¦ Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [ADD] »óÅÂ¿¡¼­ [Ãß°¡] ¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	
	public void addStudent() {
		//ÇĞ¹øÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå
		String noTemp = noTF.getText();
		
		//ÀÔ·Â°ª °ËÁõ 
		if(noTemp.equals("")) { // ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì  ÇĞ¹ø StringÀ¸·Î ¹Ş´Â ÀÌÀ¯ - 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä."); // this ÀÚ±â ÀÚ½ÅÀÇ ÀÎ½ºÅÏ½º¸¦ °¡¸®Å²´Ù. 
			noTF.requestFocus(); // ÀÔ·ÂÇØ¾ßÇÒ°÷À¸·Î Æ÷Ä¿½º¸¦ ¿ä±¸ÇÔ
			return;
		}
		
		// ÇĞ¹ø ÀÔ·Â°ªÀ» Á¤¼ö°ªÀ¸·Î º¯È¯ÇÏ¿© ÀúÀå
		int no = Integer.parseInt(noTemp);
		
		// ÀÔ·ÂµÈ ÇĞ¹øÀÇ Áßº¹¼º °ËÁõ - ÇĞ¹øÀ» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ 
		// ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© ¹İÈ¯ÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ 
		
		// => NULL ¹İÈ¯ : ÇĞ»ıÁ¤º¸ ¹Ì°Ë»ö - ÀÔ·ÂµÈ ÇĞ¹ø »ç¿ë °¡´É
		// => StudentDTO ÀÎ½ºÅÏ½º ¹İÈ¯ : ÇĞ»ıÁ¤º¸ °Ë»ö - ÀÔ·ÂµÈ ÇĞ¹ø »ç¿ë ºÒ°¡´É(ÇĞ¹ø Áßº¹)
		
		if(StudentDAO.getDAO().selectNoStudent(no) != null) { 
			JOptionPane.showMessageDialog(this, "ÀÌ¹Ì »ç¿ëÁßÀÎ ÇĞ¹ø ÀÔ´Ï´Ù.");
			noTF.requestFocus();
			return;
		}
		
		String name = nameTF.getText();
		
		// ÀÔ·Â°ª °ËÁõ
		if(name.equals("")) { // ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì  ÇĞ¹ø StringÀ¸·Î ¹Ş´Â ÀÌÀ¯ - 
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä."); // this ÀÚ±â ÀÚ½ÅÀÇ ÀÎ½ºÅÏ½º¸¦ °¡¸®Å²´Ù. 
			noTF.requestFocus();
			return;
		}
		
		String nameReg = "^([°¡-?]{2,7})$"; // ÇÑ±Û 2~7¹ø ÀÌ»ó ¹İº¹
		
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2 ~ 7 ±ÛÀÚ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
		}
		
		String phone = phoneTF.getText();
		
		if(phone.equals("")) { // ÀÔ·Â ÇÏÁö¾ÊÀ¸¸é 
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg = "(01[016789])-\\d{3,4}-\\d{4}";
		
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·Â ÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String address = addressTF.getText();
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			addressTF.requestFocus();
			return; 
		}
		
		String birthday = birthdayTF.getText();
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		//DTO ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ°í JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ª(º¯¼ö°ª)À¸·Î ÇÊµå°ª º¯°æ
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		
		//ÇĞ»ıÁ¤º¸¸¦ Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ
		int rows = StudentDAO.getDAO().insertStudent(student);
		
		JOptionPane.showMessageDialog(this, rows + "¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ ÀúÀåÇÏ¿´½À´Ï´Ù");
		
		// STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼Òµå È£Ãâ
		displayAllStudent();
		
		//¸ğµç ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­ Ã³¸® ¸Ş¼Òµå È£Ãâ
		initDisplay();
	}
	
	// JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ¹øÀ» Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ 
	// ÇĞ»ıÁ¤º¸¸¦ Á¦°ÅÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [DELETE] »óÅÂ¿¡¼­ [»èÁ¦] ¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	
	
	// JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ¹øÀ» Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ
	// ÇĞ»ıÁ¤º¸¸¦ Á¦°ÅÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [DELETE] »óÅÂ¿¡¼­ [»èÁ¦] ¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	
	public void removeStudent() {
		
		String noTemp = noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» 4ÀÚ¸®·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}
		
		int no = Integer.parseInt(noTemp);
		
		int rows = StudentDAO.getDAO().deleteStudent(no); // ¹İÈ¯°ªÀÌ 1ÀÌ»óÀÌ¸é »èÁ¦µÈ°Å´Ù 
	
		// »èÁ¦ µÇ¸é 1 
		if(rows > 0 ) {
			JOptionPane.showMessageDialog(this, rows +" ¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ »èÁ¦ ÇÏ¿´½À´Ï´Ù.");
			displayAllStudent(); // ÇĞ»ıÀÇ ¸ğµçÁ¤º¸ Ãâ·Â 
		} else {
			JOptionPane.showMessageDialog(this, "»èÁ¦ÇÏ°íÀÚ ÇÏ´Â ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
		}
		initDisplay();
	}
	
	//JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ¹øÀ» Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ 
	//ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© JTextField ÄÄÆÛ³ÍÆ®¿¡ Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [UPDATE] »óÅÂ¿¡¼­ [º¯°æ] ¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	
	public void searchNoStudent() {
		String noTemp = noTF.getText(); // JText ³»¿ëÀ» °¡Á®¿È -> String À¸·Î 
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			noTF.requestFocus();
			return;
		}
		
		String noReg="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀº 4ÀÚ¸®ÀÇ ¼ıÀÚ·Î¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noTemp);
		
		//ÇĞ¹øÀ» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© ¹İÈ¯ÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ
		StudentDTO student=StudentDAO.getDAO().selectNoStudent(no);
		if(student==null) {//ÀÔ·ÂµÈ ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ °Ë»öµÇÁö ¾ÊÀº °æ¿ì
			JOptionPane.showMessageDialog(this, "º¯°æÇÏ°íÀÚ ÇÏ´Â ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			noTF.requestFocus();
			noTF.setText("");//JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ª ÃÊ±âÈ­ Ã³¸®
			return;
		}
				
		//°Ë»öµÇ¾î ¹İÈ¯µÈ ÇĞ»ıÁ¤º¸¸¦ ÀÌ¿ëÇÏ¿© JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ¸·Î º¯°æ
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
		
		//ÇöÀç ÀÛ¼º»óÅÂ¸¦ UPDATE_CHANGE »óÅÂ·Î º¯°æ
		setEnable(UPDATE_CHANGE); // public void setEnable(int n)
		
	}
	
	// JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ»ıÁ¤º¸¸¦ Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇĞ»ıÁ¤º¸¸¦ º¯°æÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [UPDATE_CHANGE] »óÅÂ¿¡¼­ [º¯°æ] ¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	
	public void modifydStudent() {
		// ÇĞ¹øÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå
		
		int no=Integer.parseInt(noTF.getText());
		
		String name=nameTF.getText();//ÀÌ¸§ÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^([°¡-?]{2,7})$"; //2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String phone=phoneTF.getText();//ÀüÈ­¹øÈ­°¡ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå

		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();//ÁÖ¼Ò°¡ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();//»ı³â¿ùÀÏÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		//DTO ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ°í JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ª(º¯¼ö°ª)À¸·Î ÇÊµå°ª º¯°æ
		
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//ÇĞ»ıÁ¤º¸¸¦ Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇĞ»ıÁ¤º¸¸¦ º¯°æÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ
		
		int rows = StudentDAO.getDAO().updateStudent(student);
		
		JOptionPane.showMessageDialog(this, rows +" ¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ º¯°æ ÇÏ¿´½À´Ï´Ù.");

		displayAllStudent();
		initDisplay();
	}
	
	//JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÀÌ¸§À» Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [SEARCH] »óÅÂ¿¡¼­ [°Ë»ö] ¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	
	public void searchNameStudent() {
		String name=nameTF.getText();//ÀÌ¸§ÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[°¡-ÆR]{2,7}$";//2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		//ÀÌ¸§À» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÀÌ¸§ÀÇ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© ¹İÈ¯
		//ÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ
		
		List<StudentDTO> studentList = StudentDAO.getDAO().selectNameStudent(name);
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "°Ë»öµÈ ÇĞ»ı Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i = model.getRowCount(); i>0; i--) {
			model.removeRow(0);
		}
		
		for(StudentDTO student:studentList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getNo());
			rowData.add(student.getNo());
			rowData.add(student.getNo());
			rowData.add(student.getNo());
		}
		
		initDisplay();
	}
}
