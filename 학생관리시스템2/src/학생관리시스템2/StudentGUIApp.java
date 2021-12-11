package ÇĞ»ı°ü¸®½Ã½ºÅÛ2;

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

	public static final int NONE = 0;   // ÃÊ±âÈ­
	public static final int ADD = 1;    // Ãß°¡
	public static final int DELETE = 2; // Ãß°¡
	public static final int UPDATE = 3; // Ãß°¡
	public static final int UPDATE_CHANGE = 4; // Ãß°¡
	public static final int SEARCH = 5; // Ãß°¡
	
	JTextField noTF ,nameTF, phoneTF, addressTF, birthdayTF; // ÅØ½ºÆ® ÇÊµå 
	JButton addB , deleteB , updateB , searchB , cancelB; // ¹öÆ°
	
	JTable table; // µ¥ÀÌÅÍ¸¦ º¸¿©ÁÖ±â À§ÇÑ Å×ÀÌºí 
	
	int cmd; // ÇöÀç »óÅÂ 

	public StudentGUIApp() {
		setTitle("¡Ú¡Ú¡Ú ÇĞ»ı °ü¸® ÇÁ·Î±×·¥ ¡Ú¡Ú¡Ú");
		setSize(800,400); // °¡·Î ¼¼·Î ? 
		
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);
	
		JPanel left = new JPanel(); // ¿ŞÂÊ
		
		left.setLayout(new GridLayout(5,1)); // 5Çà 1¿­ 
		
		JPanel pno = new JPanel();
		pno.add(new JLabel("¹ø  È£"));
		pno.add(noTF = new JTextField(10));
		
		JPanel pname = new JPanel();
		pname.add(new JLabel("ÀÌ ¸§"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("»ı ÀÏ"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("Àü  È­"));
		pphone.add(phoneTF = new JTextField(10)); 
		
		JPanel paddress = new JPanel();
		paddress.add(new JLabel("ÁÖ  ¼Ò"));
		paddress.add(addressTF = new JTextField(10)); 
		
		// °¢°¢ Ãß°¡ÇÑ 5°³ ÆĞ³ÎÀ»  Çà¿­ GridLayout(5,1) Æ²¿¡ Ãß°¡
		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel(); // ¾Æ·¡ 
		bottom.setLayout(new GridLayout(1,5)); // 1Çà 5¿­ 
		
		bottom.add(addB = new JButton("Ãß °¡"));	
		addB.addActionListener(this); // ¹öÆ° B¸¦ ´­·¶À»¶§ ¾×¼Ç ÀÌº¥Æ® 
		
		bottom.add(deleteB = new JButton("»è Á¦"));	
		deleteB.addActionListener(this); // ¹öÆ° B¸¦ ´­·¶À»¶§ ¾×¼Ç ÀÌº¥Æ® 
	
		bottom.add(updateB = new JButton("º¯ °æ"));	
		updateB.addActionListener(this); // ¹öÆ° B¸¦ ´­·¶À»¶§ ¾×¼Ç ÀÌº¥Æ® 
	
		bottom.add(searchB = new JButton("°Ë »ö"));	
		searchB.addActionListener(this); // ¹öÆ° B¸¦ ´­·¶À»¶§ ¾×¼Ç ÀÌº¥Æ® 
		
		bottom.add(cancelB = new JButton("ÃÊ±âÈ­"));
		cancelB.addActionListener(this);
		
		Object[] title = {"ÇĞ¹ø","ÀÌ¸§","ÀüÈ­¹øÈ£","ÁÖ¼Ò","»ı³â¿ùÀÏ"}; // ÄÃ·³¸í 
		table = new JTable(new DefaultTableModel(title,0)); // ÄÃ·³¸í , 0
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		JScrollPane sp = new JScrollPane(table);
			
		// JFrame¿¡
		add(sp,	"Center"); // Å×ÀÌºíÀº °¡¿î´ë ¹èÄ¡  
		add(left,"West"); // ¼­ÂÊ ¹èÄ¡ 
		add(bottom, "South"); // ³²ÂÊ ¹èÄ¡ 
		cmd = NONE; // ÃÊ±âÈ­ 
		initialize();
		
		// //JTable ÄÄÆÛ³ÍÆ®¿¡ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼Òµå È£Ãâ
	
		displayAllStudent();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() {
		// ÃÊ±âÈ­ ´©¸£¸é ÅØ½ºÆ®ÇÊµå ³»¿ë ¾Èº¸ÀÌ±â 
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}
	
	// ÅØ½ºÆ® ÇÊµå È°¼ºÈ­ , ºñÈ°¼ºÈ­  
	public void setEdiatable(int n) {
		switch(n) {
		case ADD: // Ãß°¡ ¹öÆ° ´©¸£¸é
			noTF.setEditable(true);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		
		case DELETE: // »èÁ¦ ¹öÆ° ÇÑ¹ø ´©¸£¸é 
			noTF.setEditable(true);
			break;
		
		case UPDATE: // º¯°æ ¹öÆ° ÇÑ¹ø ´©¸£¸é 
			noTF.setEditable(true);
			break;
		
		case UPDATE_CHANGE: // º¯°æ ¹öÆ°À» ÇÑ¹ø ´õ ´©¸£¸é 
			noTF.setEditable(false);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break ;
			
		case SEARCH: // Ã£±â ¹öÆ° 
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
	
	// ¹öÆ° ºñÈ°¼ºÈ­ , È°¼ºÈ£ 
	public void setEnable(int n) {
		
		addB.setEnabled(false);    // Ãß°¡ ¹öÆ° 
		deleteB.setEnabled(false); // »èÁ¦ ¹öÆ°
		updateB.setEnabled(false); // º¯°æ ¹öÆ°
		searchB.setEnabled(false); // °Ë»ö ¹öÆ° 
		
		switch(n) {
		
		case ADD: // 1ÀÏ¶§  
			addB.setEnabled(true); // Ãß°¡¹öÆ° È°¼ºÈ­ 
			setEdiatable(ADD); // ÅØ½ºÆ®ÇÊµå 
			cmd = ADD; // ÇöÀç »óÅÂ´Â Ãß°¡·Î
			break;
		case DELETE: //2ÀÏ¶§
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
	
	// ÃÊ±âÈ­ µÇ¸é ? JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ÃÊ±âÈ­ 
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}
	
	// ¸ğµç ÄÄÆÛ³ÍÆ®¸¦ ÃÊ±âÈ­ Ã³¸® ÇÏ´Â ¸Ş¼Òµå
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();
	}
	
	// <-------- JButton ÄÄÆÛ³ÍÆ® ´©¸£¸é ÀÌº¥Æ® Ã³¸® --------->
	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component)e.getSource(); // Object ¹İÈ¯ÀÌ¹Ç·Î ÄÄÆÛ³ÍÆ®·Î Çüº¯È¯ 
		
		try {
			if(c == addB) { // ¹öÆ°ÀÌ addBÀÏ °æ¿ì 
				if(cmd != ADD) { // ADD »óÅÂ°¡ ¾Æ´Ï¸é ? È°¼ºÈ­ ½ÃÅ´
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
					searchNoStudent(); // ¹øÈ£·Î ÀÏ´Ü ÀÖ´ÂÁö °Ë»ö 
				} else {
					modifyStudent(); // UPDATE_CHANGE ÀÌ¸é º¯°æ 
					displayAllStudent();
					initDisplay();
				}
			} else if(c == cancelB) {
				// ¸Ş¼­µå ½ÇÇà
				displayAllStudent();
				initDisplay();
			} else if(c == searchB) {
				if(cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					searchNameStudent(); // ÀÌ¸§À¸·Î °Ë»öÇÑ´Ù.
				}
			}
		} catch(Exception ex) {
			System.out.println("¿¹¿Ü ¹ß»ı : " + ex);
		}
	}
	
	//----------------¹öÆ°À» ´©¸£¸é ¹ß»ıÇÏ´Â ¸Ş¼Òµå----------------
	// µ¥ÀÌÅÍ°ªµéÀ» Å×ÀÌºí¿¡ ³Ö¾î¼­ ´Ù½Ã º¸¿©ÁØ´Ù.
	public void displayAllStudent() {
		
		//±âÁ¸ JTable ÄÄÆÛ³ÍÆ®¿¡ Á¸ÀçÇÏ´Â ¸ğµç ÇàÀ» ÇÏ³ª¾¿ ¹İº¹ÀûÀ¸·Î Á¦°Å List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		if(studentList.isEmpty()) { // ºñ¾îÀÖÀ¸¸é true		
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ ÇĞ»ıÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		//JTable.getModel() : JTable ÄÄÆÛ³ÍÆ®¿¡ Á¾¼ÓµÈ TableModel ÀÎ½ºÅÏ½º¸¦ ¹İÈ¯ÇÏ´Â ¸Ş¼Òµå
		//DefaultTableModel : TableModel ÀÎÅÍÆäÀÌ½º¸¦ »ó¼Ó¹Ş¾Æ ÀÛ¼ºµÈ Å¬·¡½º 
		// => JTable ÄÄÆÛ³ÍÆ®ÀÇ ÇàÁ¤º¸¸¦ Á¦¾îÇÏ´Â ÀÎ½ºÅÏ½º
		// => TableModel ÀÎ½ºÅÏ½º¸¦ DefaultTableModel Å¬·¡½º·Î °´Ã¼ Çüº¯È¯ ÇÏ¿© ÀúÀå
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		//±âÁ¸ JTable ÄÄÆÛ³ÍÆ®¿¡ Á¸ÀçÇÏ´Â ¸ğµç ÇàÀ» ÇÏ³ª¾¿ ¹İº¹ÀûÀ¸·Î Á¦°Å - JTable ÄÄÆÛ³ÍÆ®ÀÇ ÃÊ±âÈ­d	
		for(int i=model.getRowCount(); i>0; i--) {
			model.removeRow(0); // Ã¹¹øÂ° Çà Á¦°Å 
		}
		
		//JTable ÄÄÆÛ³ÍÆ®¿¡ °Ë»öµÈ ÇĞ»ıÁ¤º¸¸¦ ÀúÀåÇÏ¿© Ãâ·Â 
		// => DefaultTableModel ÄÄÆÛ³ÍÆ®¿¡ °Ë»öµÈ ÇĞ»ıÁ¤º¸¸¦ ¹İº¹ÀûÀ¸·Î ÇàÀ¸·Î Ãß°¡
		for(StudentDTO student : studentList) {
			Vector<Object> rowData = new Vector<Object>();
			// --- Áß¿ä  ---
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			// ¿­¿¡ µ¥ÀÌÅÍµéÀ» Ãß°¡ÇÔ 
			model.addRow(rowData);
		}
	}
	
	// ------------¹öÆ° Å¬¸¯½Ã ¸Ş¼Òµå ½ÇÇà --------------
	// -----------ÅØ½ºÆ® ¹öÆ°°ªÀ» ºÒ·¯¿Í¼­ À¯È¿¼º °Ë»ç¸¦ ÇÔ ---------
	public void addStudent() {
		String noTemp = noTF.getText(); // ÀÔ·ÂÇÑ °ª ºÒ·¯¿È 
		
		// StringÀ¸·Î ¹Ş¾Æ¾ßÁö equals() È£Ãâ °¡´É 
		if(noTemp.equals("")) { // ¾Æ¹«°Íµµ ÀÔ·ÂÀ» ÇÏÁö ¾ÊÀ¸¸é 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			noTF.requestFocus(); // ÀÔ·Â ÃĞÁ¡À¸·Î ÀÌµ¿ 
			return;
		}
		
		String noReg ="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀº 4ÀÚ¸®·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();
			return;
		}
		
		
		// ÀÔ·Â¹ŞÀº ÇĞ¹ø°ªÀ» Á¤¼ö°ªÀ¸·Î º¯È¯ÇÏ¿© ÀúÀå
		int no = Integer.parseInt(noTemp);
		
		// ±×·±µ¥.. ÀÌ¹Ì »ç¿ëÁßÀÎ ÇĞ¹øÀÌ¸é 
		if(StudentDAO.getDAO().selectNoStudent(no) != null) {
			JOptionPane.showMessageDialog(this, "ÀÌ¹Ì »ç¿ëÁßÀÎ ÇĞ¹øÀÔ´Ï´Ù");
			noTF.requestFocus();
			return;
		}
		
		String name = nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			nameTF.requestFocus();
			return;
		}
		
		// Á¤±Ô½Ä Ç¥Çö½Ä °Ë»ç
		String nameReg = "^([°¡-ÆR]{2,7})$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº ÇÑ±Û 2~7ÀÚ·Î Àû¾îÁÖ¼¼¿ä");
			nameTF.requestFocus();
			return;		
		}
		
		String phone = phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg = "(01[016789])-\\d{3,4}-\\d{4}";

		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String address = addressTF.getText();
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday = birthdayTF.getText();
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		
		/*
		String birthdayReg="(19|20)\\d{2}-(1-9|1[0-2])-(0[1-9]|[12][0-9]|3[0-1]";
		
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "»ıÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		*/
		
		// ÀÔ·Â°ªÀ» ³ÖÀ½ 
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		int rows = StudentDAO.getDAO().insertStudent(student); // dao.insertStudent(Ãß°¡);
	
		JOptionPane.showMessageDialog(this, rows+"¸íÀÇ ÇĞ»ıÁ¤º¸¸¦ ÀúÀå ÇÏ¿´½À´Ï´Ù.");
	
		displayAllStudent();
		
		// ¸ğµç ÄÄÆ÷³ÍÆ® ÃÊ±âÈ­ Ã³¸® ¸Ş¼­µå È£Ãâ 
		initDisplay();
	}
	
	public void removeStudent() {
		
		String noTemp = noTF.getText(); 
		
		if(noTemp.equals("")) { // ¾Æ¹«°Íµµ ÀÔ·ÂÀ» ÇÏÁö ¾ÊÀ¸¸é 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			noTF.requestFocus(); // ÀÔ·Â ÃĞÁ¡À¸·Î ÀÌµ¿ 
			return;
		}
		
		String noReg ="\\d{4}";
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀº 4ÀÚ¸®·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();
			return;
		}
		
		int no = Integer.parseInt(noTemp);
		
		int rows = StudentDAO.getDAO().deleteStudent(no);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this, rows+"¸íÀÇ ÇĞ»ı Á¤º¸¸¦ »èÁ¦ ÇÏ¿´½À´Ï´Ù. ");
			displayAllStudent();
		} else {
			JOptionPane.showMessageDialog(this, "»èÁ¦ÇÏ°íÀÚ ÇÏ´Â ÇĞ»ı Á¤º¸°¡ ¾ø½À´Ï´Ù ");
		}
		initDisplay(); // ÃÊ±âÈ­ 
	}
	
	public void searchNoStudent() {
		String noTemp = noTF.getText();
		
		if(noTemp.equals("")) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			noTF.requestFocus();
			return;
		}
		
		String noReg = "\\d{4}"; 
	
		if(!Pattern.matches(noReg, noTemp)) {
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀº 4ÀÚ¸®·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			noTF.requestFocus();
			return;
		}
		
		int no = Integer.parseInt(noTemp);
		
		StudentDTO student = StudentDAO.getDAO().selectNoStudent(no);
		if(student == null) {
			JOptionPane.showMessageDialog(this, "º¯°æÇÏ°íÀÚ ÇÏ´Â °ªÀÌ ¾ø½À´Ï´Ù.");
			noTF.requestFocus();
			noTF.setText("");
			return;
		}
		
		// °Ë»öµÇ¾î ºÒ·¯¿Â Á¤º¸¸¦ ÅØ½ºÆ®ÇÊµå¿¡ ÀÔ·Â ÇÑ´Ù. 
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());

		// ÇöÀç ÀÛ¼º »óÅÂ¸¦ UPDATE_CHANGE »óÅÂ·Î º¯°æ ÇÑ´Ù.
		setEnable(UPDATE_CHANGE);
	}
	
	public void modifyStudent() {
		
		int no=Integer.parseInt(noTF.getText());
		String name=nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg = "^([°¡-ÆR]{2,7})$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº ¹İµå½Ã 2~7ÀÚ·Î Àû¾îÁÖ¼¼¿ä");
			nameTF.requestFocus();
			return;
		}
		
		String phone = phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		
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
		
		/*
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			birthdayTF.requestFocus();
			return;
		}
		*/
		
		// UPDATE_CHANGE ¿¡¼­ ÀÔ·ÂÇÑ º¯°æÇÑ °ªµéÀ» Ãß°¡ÇÑ´Ù.
		StudentDTO student = new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		int rows = StudentDAO.getDAO().updateStudent(student);
	
		JOptionPane.showMessageDialog(this, rows+"¸íÀÇ ÇĞ»ıÁ¤º¸°¡ º¯°æ ÇÏ¿´½À´Ï´Ù.");
	}
	
	public void searchNameStudent() {
		
		String name = nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg = "^[°¡-ÆR]{2,7}$";//2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		// ÀÌ¸§À¸·Î °Ë»ö 
		List<StudentDTO> studentList = StudentDAO.getDAO().selectNameStudent(name);
		
		// getModel() :  JTableÀÌ °®°í ÀÖ´Â µ¥ÀÌÅÍ¸¦ ´ã°í ÀÖ´Â °´Ã¼ÀÎ TableModel°´Ã¼°¡ ¸®ÅÏµË´Ï´Ù.
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		// ±âÁ¸ Å×ÀÌºí °ªµéÀ» »èÁ¦ÇÔ 
		for(int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		
		// °Ë»öµÇ¾îÁø Å×ÀÌºí 
		for(StudentDTO student : studentList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			
			// Å×ÀÌºí¿¡ Ãß°¡ÇÔ 
			model.addRow(rowData);
		}
		initDisplay();
	}
	
	public static void main(String[] args) {
		new StudentGUIApp();
	}
}
