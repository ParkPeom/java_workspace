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
	
	private static final long serialVersionUID = 1L; // ºÎ¸ğ JFrame serializable ÀÇ °íÀ¯°ª °´Ã¼ Á÷·ÄÈ­ (Á»´õ ºü¸£°Ô °´Ã¼ ´ÜÀ§·Î ÀÔÃâ·Â °¡´É ) 
													 // long Å¸ÀÔÀ¸·Î 1L ±âº» 

	// »ó¼ö : °ªÀ» ´ëÇ¥ÇØ¼­ ¾²´Â ÀÌ¸§  Á¤¼ö°ªÀ» ¸íÈ®ÇÏ°Ô ÀÌ¸§À¸·Î ±¸ºĞÇÒ¼öÀÖ´Ù. 
	public static final int NONE = 0; // ÃÖÃÊ »óÅÂ·Î ÃÊ±âÈ­
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
	 * »ı¼ºÀÚ Á¤ÀÇ - µğÀÚÀÎ : ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·Â 
	 *********************************************/
	public StudentGUIApp() throws Exception {
		setTitle("¡ß¡ß¡ß ÇĞ»ı °ü¸® ÇÁ·Î±×·¥ ¡ß¡ß¡ß");
		setSize(800, 400); // °¡·Î 800 ¼¼·Î 400

		
		// ¸ğ´ÏÅÍÀÇ È­¸éÅ©±â ¾Ë¾Æ³»±â 
		// Dimension : Æ¯Á¤¿µ¿ªÀÇ »ç°¢Çü°ú Æø°ú ³ôÀÌÀÇ °ªÀ» °ü¸®ÇÒ¼ö ÀÖµµ·Ï µµ¿ÍÁÖ´Â Å¬·¡½º
		// Dimension »ç°¢Çü¸ğ¾ç Æ¯Á¤Å©±â
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2); // setLocation Áß¾Ó¿¡ À§Ä¡ ÇÏ±â À§ÇØ¼­ 

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1)); // 5Çà 1¿­(row) ¹èÄ¡ 

		JPanel pno = new JPanel();
		pno.add(new JLabel("¹ø  È£")); // ¶óº§ ¹®ÀÚ¿­  
		pno.add(noTF = new JTextField(10)); // °ªÀ» ÀÔ·Â¹ŞÀ½ 

		JPanel pname = new JPanel();
		pname.add(new JLabel("ÀÌ  ¸§"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("»ı  ÀÏ"));
		pbirthday.add(birthdayTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("Àü  È­"));
		pphone.add(phoneTF = new JTextField(10));

		JPanel paddress = new JPanel();
		paddress.add(new JLabel("ÁÖ  ¼Ò"));
		paddress.add(addressTF = new JTextField(10));

		// ±×¸®µå ·¹ÀÌ¾Æ¿ô¿¡ Ãß°¡ 
		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5)); // 1Çà 5¿­ 

		// addActionListener ¹öÆ°À» ´­·¶À»¶§ Ã³¸®ÇÏ´Â ¸Ş¼­µå 
		// ¾×¼Ç ÀÌº¥Æ® °¡ ¹ß»ıÇÏ¸é ³»°¡ Ã³¸®ÇÒ¼öÀÖµµ·Ï 
		
		
		// ¹öÆ°µéÀ» ´©¸¦‹š¸¶´Ù ¾×¼Ç ÀÌº¥Æ®°¡ ¹ß»ı 
		bottom.add(addB = new JButton("Ãß  °¡"));
		addB.addActionListener(this); // ¾×¼Ç ÀÌº¥Æ®¸¦ È£ÃâÇÏ´Âµ¥ ³ª ÀÚ½ÅÀ» È£Ãâ(actionperformed) 

		bottom.add(deleteB = new JButton("»è  Á¦"));
		deleteB.addActionListener(this);
		
		bottom.add(updateB = new JButton("º¯  °æ"));
		updateB.addActionListener(this);

		bottom.add(searchB = new JButton("°Ë  »ö"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("ÃÊ±âÈ­"));
		cancelB.addActionListener(this);

		Object[] title={"ÇĞ¹ø","ÀÌ¸§","ÀüÈ­¹øÈ£","ÁÖ¼Ò","»ı³â¿ùÀÏ"}; // Å¸ÀÌÆ²
		table=new JTable(new DefaultTableModel(title, 0)); // (Å×ÀÌºí Çì´õ , ¾Æ¿¡ Çà 0°³) -> Å¸ÀÌÆ²¸¸ Ãâ·Â 
		
		// Å×ÀÌºíÀ» ¾²Áö¾Ê°í ±â·ÏÇã¿ë ¾ÈÇÏ°í Å©±â º¯°æÀ» Çã¿ëÇÏÁö ¾Ê°Ú´Ù.
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false); 
		table.getTableHeader().setResizingAllowed(false); // ±â·Ï , Å©±â º¯°æ ¸øÇÏ°Ô ÇÔ 

		// JTable ÄÄÆÛ³ÍÆ®¿¡ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼­µå È£Ãâ 
		displayAllStudent();
		JScrollPane sp=new JScrollPane(table); // Å×ÀÌºí Ãß°¡ 
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE; // ¸Õ°¡¸¦ ¼±ÅÃÇÑ°Ô ¾øÀ¸¸é NONE
		initialize(); // ¸ğµç ÀÔ·ÂÄÄÆÛ³ÍÆ® È£ÃâÇØ¼­ 

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() { 
		// ¸ğµç JTextField ÄÄÆÛ³ÍÆ® ºñÈ°¼ºÈ­ ½ÃÄÑÁÜ 
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}
	
	//¸Å°³º¯¼ö¿¡ Àü´ŞµÇ´Â Á¤¼ö°ª¿¡ µû¸¥ JTextField ÄÄÆÛ³ÍÆ®ÀÇ È°¼ºÈ­ ¶Ç´Â ºñÈ°¼º Ã³¸®
	
	// »óÅÂ¿¡ µû¶ó¼­ ÄÄÆÛ³ÍÆ® 
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
			noTF.setEditable(true); // ÇĞ¹øÀ¸·Î »èÁ¦ÇÏ´Ï±î ÇĞ¹ø¸¸ ÀÔ·Â °¡´ÉÇÏ°Ô ÇÔ
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
	
	
	//¸Å°³º¯¼ö¿¡ Àü´ŞµÇ´Â Á¤¼ö°ª¿¡ µû¸¥ JButton ÄÄÆÛ³ÍÆ®ÀÇ È°¼ºÈ­ ¶Ç´Â ºñÈ°¼º Ã³¸®ÇÏ´Â ¸Ş¼Òµå
	
	// ÇöÀç ÀúÀåµÈ cmd °ª¿¡ µû¶ó¼­ ¾î¶² ÄÄÆÛ³ÍÆ®´Â È°¼ºÈ­ Ã³¸® ºñÈ°¼ºÈ­ Ã³¸® ½ÃÅ´ 
	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD); // ADD¸¸ È°¼ºÈ­ Ã³¸® 
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
		case NONE: // Ãë¼ÒÇßÀ»¶§
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}
	// ¸ğµç JTextFied ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ª ÃÖÃÊ »óÅÂ·Î  ÃÊ±âÈ­ Ã³¸®ÇÏ´Â ¸Ş¼Òµå
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}
	
	//¸ğµç ÄÄÆÛ³ÍÆ® JText ¸¦ ÃÊ±âÈ­ Ã³¸®ÇÏ´Â ¸Ş¼Òµå
	public void initDisplay() {
		setEnable(NONE); // ¸ğµç ¹öÆ°ÀÌ È°¼ºÈ­ Ã³¸® 
		clear();
		cmd = NONE;
		initialize(); // JTextField ºñÈ°¼ºÈ­ Ã³¸® 	
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	
	
	//----------------------- ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå - JButton ÄÄÆÛ³ÍÆ®¸¦ ´©¸¥ °æ¿ì ÀÚµ¿ È£ÃâµÇ´Â ¸Ş¼Òµå-----------------------
	
	
	public void actionPerformed(ActionEvent ev) { // ¹öÆ°¿¡¼­ ÀÌº¥Æ® Ã³¸® ¸Ş¼­µå 
		Component c = (Component) ev.getSource(); // ÄÄÆÛ³ÍÆ®¸¦ ¹İÈ¯¹ŞÀ½
		try {
			
			// »óÅÂ¿¡ µû¶ó È°¼ºÈ­ ºñÈ°¼ºÈ­ Ã³¸® 
			
			
			if (c == addB) {//Ãß°¡ ¹öÆ°À» ´©¸¥ °æ¿ì
				if (cmd != ADD) { //ADD »óÅÂ°¡ ¾Æ´Ñ °æ¿ì - ÄÄÆÛ³ÍÆ®ÀÇ È°¼º ¶Ç´Â ºñÈ°¼º Ã³¸®
					setEnable(ADD); // ADD »óÅÂ·Î È°¼ºÈ­	- ÄÄÆÛ³ÍÆ®ÀÇ È°¼º ¶Ç´Â ºñÈ°¼ºÈ­ Ã³¸® , JText ´Ù È°¼ºÈ­			
				} else {//ADD »óÅÂÀÎ °æ¿ì
					//JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ÀÌ¿ëÇÏ¿© Ã³¸® >> ÃÊ±âÈ­ Ã³¸® 
					addStudent(); // Ãß°¡ 
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) { // DELETE »óÅÂ°¡ ¾Æ´Ñ °æ¿ì
					setEnable(DELETE); // DELETE »óÅÂ·Î È°¼ºÈ­ ÇÑ´Ù. 
				} else {
					removeStudent(); // »èÁ¦ 				
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if (cmd != UPDATE_CHANGE) { // ¾÷µ¥ÀÌÆ®»óÅÂÀÎµ¥ ¾÷µ¥ÀÌÆ®Ã¼ÀÎÁö°¡ ¾Æ´Ï¶ó¸é 
					searchNoStudent(); // ÇĞ¹øÀ» °¡Á®´Ù°¡ °Ë»ö ÇØ¼­ 
				} else {
					modifydStudent(); // Ã¼ÀÎÁö »óÅÂ¿¡¼­ È£Ãâ
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
			System.out.println("¿¹¿Ü ¹ß»ı : " + e);
		}		
	}
	
	// STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© JTableÄÄÆÛ³ÍÆ®¿¡ Ãâ·ÂÇÏ´Â ¸Ş¼­µå
	// => »ı¼ºÀÚ ¶Ç´Â ¸ğµç ÀÌº¥Æ®¿¡ ´ëÇÑ ÀÌº¥Æ® Ã³¸® ¸Ş¼­µå¿¡¼­ È£Ãâ  
	public void displayAllStudent() {
		// STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© ¹İÈ¯ÇÏ´Â DAOÅ¬·¡½ºÀÇ ¸Ş¼­µå È£Ãâ 
		// StudentDAO.getDAO() : ÀÌ¹Ì »ı¼ºµÈ StudentDAO ÀÎ½ºÅÏ½º¸¦ ¹İÈ¯ 
		// studentList ¸ğµç ÇĞ»ıÁ¤º¸¸¦ ¹İÈ¯¹Ş¾Æ °¡Á®¿È ( Áßº¹µÈ ÄÚµå¸¦ ÃÖ¼ÒÈ­ ÇØ¾ßÇÔ JDBC·Î ¤¤¤¤ °¡Á®´Ù°¡ ¾²¸éµÊ )
											// CRUD·Î ¼Õ½±°Ô ¸¸µé°í À¯Áöº¸¼ö°¡ ½±´Ù 
		List<StudentDTO> studentList = StudentDAO.getDAO().selectAllStudent();
		
		// List.isEmpty() : List ÀÎ½ºÅÏ½º¿¡ ÀúÀåµÈ ¿ä¼Ò°¡ ÀÖ´Â °æ¿ì false¹İÈ¯ ÇÏ°í ÀúÀåµÈ
		// ¿ä¼Ò°¡ ÇÏ³ªµµ ¾ø´Â °æ¿ì true ¹İÈ¯ ÇÏ´Â ¸Ş¼­µå 
		if(studentList.isEmpty()) { // ºñ¾îÀÖÀ¸¸é true
			// JOptionPane. : ±âº»ÀûÀÎ ´ÙÀÌ¾ó·Î±×¸¦ Á¦°øÇÏ´Â ÄÄÆÛ³ÍÆ® 
			// ºÎ¸ğ´Â this 
			// => ¸Ş¼¼Áö¸¦ Ãâ·Á°¡´Â ´ÙÀÌ¾ó·Î±×¸¦ Á¦°øÇÏ´Â ¸Ş¼­µå 
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ ÇĞ»ıÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			return; // Ãâ·ÂÇÒ°Ô ¾øÀ¸´Ï ¸Ş¼­µå Á¾·á 
		}
		
		// JTable.getModel() : JTable ÄÄÆÛ³ÍÆ®¿¡ Á¾¼ÓµÈ TableModel ÀÎ½ºÅÏ½º¸¦ ¹İÈ¯ÇÏ´Â ¸Ş¼­µå 
		
		// TableModel ÇàÀ» Á¦¾îÇÒ¼öÀÖ´Â 
		// DefaultTableModel : TableModel ÀÎÅÍÆäÀÌ½º »ó¼Ó¹Ş¾Æ¼­ ¸¸µç ÀÚ½ÄÅ×ÀÌºí
		// => - JTable ÄÄÆÛ³Ê´ÂÆ®ÀÇ ÇàÁ¤º¸¸¦ Á¦¾îÇÏ´Â ÀÎ½ºÅÏ½º 
		// => Table Model ÀÎ½ºÅÏ½º¸¦ DefaultTableModel Å¬·¡½º·Î °´Ã¼ Çüº¯È¯ ÇÏ¿© ÀúÀå 
		
		DefaultTableModel model = (DefaultTableModel)table.getModel(); // Å×ÀÌºí¿¡¼­ ÇàÀ» »èÁ¦ÇÏ°Å³ª Ãß°¡ÇÒ‹š DefaultTableModel	
				//  table.getModel() : TableModelºÎ¸ğ ¹İÈ¯ ÀÚ½Ä À¸·Î Çüº¯È¯ 
		
		
		// ±âÁ¸ ÇĞ»ıÀ» Á¦°ÅÇÏ°í 
		// ±âÁ¸ JTable ÄÄÆÛ³ÍÆ®¿¡ Á¸ÀçÇÏ´Â ¸ğµç ÇàÀ» ÇÏ³ª¾¿ ¹İº¹ÀûÀ¸·Î Á¦°ÅÇÑ´Ù - JTable ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­ 
		// model.getRowCount() : ÀúÀåµÈ ÇàÀÇ °¹¼ö¸¦ ¹İÈ¯ÇÏ´Â ¸Ş¼­µå 
		
		
		// ÇàÀÇ °¹¼ö±îÁö ¹İº¹ 
		for(int i = model.getRowCount(); i > 0 ; i--) {
			// DefaultTableModel.removeRow(int row ) :DefaultTableModel ÀÎ½ºÅÏ½º¿¡ ÀúÀåµÈ
			// ÇàÀ» Ã·ÀÚ(RowIndex)¸¦ Àü´Ş¹Ş¾ÆÃ·ÀÚ À§Ä¡ÀÇ ÇàÀ» Á¦°ÅÇÏ´Â ¸Ş¼­µå
			model.removeRow(0); // Ã¹¹ø¤Š Çà °è¼Ó Á¦°Å 
		}
		//JTable ÄÄÆÛ³ÍÆ®¿¡ °Ë»öµÈ ÇĞ»ıÁ¤º¸¸¦ ÀúÀåÇÏ¿© Ãâ·Â
		// => DefaultTableModel ÄÄÆÛ³ÍÆ®¿¡ °Ë»öµÈ ÇĞ»ıÁ¤º¸¸¦ ¹İº¹ÀûÀ¸·Î ÇàÀ¸·Î Ãß°¡ÇÏ¿© 
		for(StudentDTO student : studentList) {
			// Vector ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ¿© StudentDTO ÀÎ½ºÅÏ½º¸¦ ÇÊµå°ªÀ» ¿ä¼Ò·Î Ãß°¡ 
			Vector<Object> rowData = new Vector<Object>(); // ¿­ÀÇ °¹¼ö¸¦ ¸ô¶ó¼­ Vector 
			rowData.add(student.getNo()); // ¿­µéÀ» °¡Á®´Ù°¡ ¹éÅÍ·Î ÇÑÇàÀ» ¸¸µë 
			rowData.add(student.getName()); // ¿­µéÀ» °¡Á®´Ù°¡ ¹éÅÍ·Î ÇÑÇàÀ» ¸¸µë 
			rowData.add(student.getPhone()); // ¿­µéÀ» °¡Á®´Ù°¡ ¹éÅÍ·Î ÇÑÇàÀ» ¸¸µë 
			rowData.add(student.getAddress()); // ¿­µéÀ» °¡Á®´Ù°¡ ¹éÅÍ·Î ÇÑÇàÀ» ¸¸µë 
			rowData.add(student.getBirthday()); // ¿­µéÀ» °¡Á®´Ù°¡ ¹éÅÍ·Î ÇÑÇàÀ» ¸¸µë 
			
			// DefaultTableModel.addRow(Vector rowData)
			// DefaultTableModel ÀÎ½ºÅÏ½ºÀÇ ÇàÀ¸·Î Ãß°¡ÇÏ´Â ¸Ş¼­µå 
			model.addRow(rowData);
		}
	}
	
	//JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ»ıÁ¤º¸¸¦ Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [ADD]»óÅÂ¿¡¼­ [Ãß°¡] ¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	public void addStudent() {
		String noTemp=noTF.getText();//ÇĞ¹øÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå  
		// ¹®ÀÚ¿­·Î ¹Ş¾Æ¾ßÁö Á¤±Ô½ÄÀÌ¶û ºñ±³ÇÒ¼ö°¡ ÀÖ´Ù.
		
		//ÀÔ·Â°ª °ËÁõ
		if(noTemp.equals("")) { //ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return; // Á¾·á 
		}
		String noReg = "\\d{4}"; // ¼ıÀÚ 4¹ø ¹İº¹ ÇÏ´Â ±ÔÄ¢ 
		if(!Pattern.matches(noReg, noTemp)) { // ÀÔ·Â°ªÀÌ 4ÀÚ¸®¸¦ 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» 4ÀÚ¸®ÀÇ ¼ıÀÚ·Î¸¸ ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		//ÇĞ¹ø ÀÔ·Â°ªÀ» Á¤¼ö°ªÀ¸·Î º¯È¯ÇÏ¿© ÀúÀå 
		// ¹®ÀÚ¿­  (°ËÁõÀÌ ³¡³ª¸é) -> ¼ıÀÚ·Î ¹Ù²Ü¼öÀÖµµ·Ï 
		int no = Integer.parseInt(noTemp);
		
		// ÀÔ·ÂµÈ ÇĞ¹øÀÇ Áßº¹¼º °ËÁõ : ÇĞ¹øÀ» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ 
		// ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© ¹İÈ¯ÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ 
		// DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ - ÇĞ¹øÀÇ Áßº¹¼º °ËÁõ 
		// => NULL ¹İÈ¯ : ÇĞ»ıÁ¤º¸ ¹Ì°Ë»ö - ÀÔ·ÂµÈ  ÇĞ¹ø »ç¿ë °¡´É 
		// => StudentDTO ÀÎ½ºÅÏ½º ¹İÈ¯ - ÇĞ»ıÁ¤º¸ °Ë»ö - ÀÔ·ÂµÈ ÇĞ¹ø »ç¿ë ºÒ°¡´É(ÇĞ¹ø Áßº¹) 
		
		if(StudentDAO.getDAO().selectNoStudent(no)!=null) {//ÀÔ·ÂµÈ ÇĞ¹øÀÌ »ç¿ë ºÒ°¡´ÉÇÑ °æ¿ì 
			JOptionPane.showMessageDialog(this, "ÀÌ¹Ì »ç¿ëÁßÀÎ ÇĞ¹øÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		String name = nameTF.getText(); // //ÀÌ¸§ÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå  
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			nameTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		
		}
		
		// ¿µ¹®ÀÚµµ Æ÷ÇÔÀÌ¸é "^[°¡-ÆR]{2,7}|[a-zA-Z]{4,20}$"
		String nameReg = "^[°¡-ÆR]{2,7}$"; //ÇÑ±Û 2ÀÚ~7ÀÚ ¹İº¹ °¡ ºÎÅÍ ÆR(À¯´ÏÄÚµå ¸¶Áö¸·)±îÁö
										  //2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
		if(!Pattern.matches(nameReg, name)) { // ÀÔ·Â°ªÀÌ 4ÀÚ¸®¸¦ 
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			nameTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		// ÀÌ¸§Àº Áßº¹¼º¿¡ ´ëÇÑ °ËÁõÀ» ÇÒ ÇÊ¿ä°¡ ¾ø´Ù.
		
		String phone = phoneTF.getText(); // ÀüÈ­¹øÈ£ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå  
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			phoneTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}"; // 016789Áß ÇÏ³ª - 3ÀÚ¸®¿¡¼­4ÀÚ¸®¹İº¹ - 4ÀÚ¸®¹İº¹ 
	
		if(!Pattern.matches(phoneReg, phone)) { 
			JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			phoneTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		String address = addressTF.getText(); // ÁÖ¼Ò°¡ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå 
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			addressTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		// °Ç¹°¸í ÀÔ·ÂÇÏ°í ÇØ´ç °Ç¹°¿¡ ´ëÇÑ ¿ìÆí¹øÈ£ ±×·± Çü½ÄÀ¸·Î »ç¿ëÇÒ¼ö ÀÖ´Ù.
		// ½ÇÁ¦ ÁÖ¼Ò °°Àº °æ¿ì »ó¼¼ ÁÖ¼Ò¸¦ Á¦¿ÜÇÑ °Ë»öÀ» ÅëÇØ¼­ ÁÖ¼Ò°¡ °Ë»öµÇ¾îÁú¼öÀÖ´Ù.
		// ÁÖ¼Ò´Â Á¤±ÔÇ¥Çö½ÄÀ¸·Î Ç¥ÇöÇÒ¼ö°¡ ¾ø´Ù.. ¿ìÆí¹øÈ£°Ë»ö±â´ÉÀ» ÅëÇØ¼­ ÁÖ¼Ò¸¦ ..
		
		String birthday = birthdayTF.getText(); // »ı³â¿ùÀÏÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå 
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			birthdayTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(1-9|1[0-2])-(0[1-9]|[12][0-9]|3[0-1]";
										//  1900 2000 ³âµµ 1~9¿ù,10¿ù~12¿ù Áß ÇÏ³ª Æ÷ÇÔ  1 ~9 10~19 , 20 ~ 29 30~31
		if(!Pattern.matches(birthdayReg, birthday)) { 
			JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			birthdayTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		// DTO ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ°í JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ª(º¯¼ö°ª)À¸·Î ÇÊµå°ª º¯°æ
		
		StudentDTO student = new StudentDTO();
		// ÀÔ·ÂµÈ°ªÀ¸·Î °ªÀúÀå
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);

		//ÇĞ»ıÁ¤º¸¸¦ Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼­µå È£Ãâ
		int rows = StudentDAO.getDAO().insertStudent(student); 
	
		JOptionPane.showMessageDialog(this, rows + "¸íÀÇ ÇĞ»ı Á¤º¸¸¦ ÀúÀåÇÏ¿´½À´Ï´Ù.");
		
		// STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ¸ğµçÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
		displayAllStudent(); 
		
		// ¸ğµç ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­ Ã³¸®
		initDisplay();
	}
	// JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ¹øÀ» Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸¸¦ Á¦°ÅÇÏ´Â ¸Ş¼­µå
	// ÇĞ»ıÁ¤º¸¸¦ 
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [DELETE]»óÅÂ¿¡¼­ [»èÁ¦]¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	public void removeStudent() {
		
		String noTemp=noTF.getText();//ÇĞ¹øÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå  
		// ¹®ÀÚ¿­·Î ¹Ş¾Æ¾ßÁö Á¤±Ô½ÄÀÌ¶û ºñ±³ÇÒ¼ö°¡ ÀÖ´Ù.
		
		//ÀÔ·Â°ª °ËÁõ
		if(noTemp.equals("")) { //ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return; // Á¾·á 
		}
		
		String noReg = "\\d{4}"; // ¼ıÀÚ 4¹ø ¹İº¹ ÇÏ´Â ±ÔÄ¢ 
		if(!Pattern.matches(noReg, noTemp)) { // ÀÔ·Â°ªÀÌ 4ÀÚ¸®¸¦ 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» 4ÀÚ¸®ÀÇ ¼ıÀÚ·Î¸¸ ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		//ÇĞ¹ø ÀÔ·Â°ªÀ» Á¤¼ö°ªÀ¸·Î º¯È¯ÇÏ¿© ÀúÀå 
		// ¹®ÀÚ¿­  (°ËÁõÀÌ ³¡³ª¸é) -> ¼ıÀÚ·Î ¹Ù²Ü¼öÀÖµµ·Ï 
		int no = Integer.parseInt(noTemp);
		
		//ÇĞ¹øÀ» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºíÀÇ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ ÇĞ»ı Á¤º¸¸¦ »èÁ¦ÇÏ´Â DAOÅ¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ
		int rows = StudentDAO.getDAO().deleteStudent(no);
		
		if(rows > 0) { //»èÁ¦ÇàÀÌ Á¸ÀçÇÏ´Â °æ¿ì
			JOptionPane.showMessageDialog(this, rows + "¸íÀÇ ÇĞ»ı Á¤º¸¸¦ »èÁ¦ÇÏ¿´½À´Ï´Ù.");
			displayAllStudent();
		} else { //»èÁ¦ÇàÀÌ Á¸ÀçÇÏÁö ¾Ê´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "»èÁ¦ ÇÏ°íÀÚ ÇÏ´Â ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ ¾ø½À´Ï´Ù.");			
		}
		initDisplay();
	}
	
	// ÇÑ¹ø ´©¸£¸é ÇĞ¹ø¸¸ È°¼ºÈ­ »óÅÂ , ÇĞ¹øÀÔ·ÂÇØ¼­ º¯°æ ¶Ç ´©¸£¸é ÀÌ¸§,ÀüÈ­,ÁÖ¼Ò,»ıÀÏ ÀÔ·Â, º¯°æ ´©¸£¸é º¯°æÃ³¸®µÇ°ÔÇÔ
	
	// JTextField ÄÄÆÛ³ÍÆ®¿¡ ÀÔ·ÂµÈ ÇĞ¹øÀ» Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸¸¦ Á¦°ÅÇÏ´Â ¸Ş¼­µå
	// ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿©  JTextField ÄÄÆÛ³ÍÆ®¿¡ Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	// => ÀÌº¥Æ® Ã³¸® ¸Ş¼Òµå¿¡¼­ [UPDATE]»óÅÂ¿¡¼­ [º¯°æ]¹öÆ°À» ´©¸¥ °æ¿ì È£Ãâ
	
	public void searchNoStudent() {
		
		String noTemp=noTF.getText();//ÇĞ¹øÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå  
		// ¹®ÀÚ¿­·Î ¹Ş¾Æ¾ßÁö Á¤±Ô½ÄÀÌ¶û ºñ±³ÇÒ¼ö°¡ ÀÖ´Ù.
		
		//ÀÔ·Â°ª °ËÁõ
		if(noTemp.equals("")) { //ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» ¹İµå½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return; // Á¾·á 
		}
		
		String noReg = "\\d{4}"; // ¼ıÀÚ 4¹ø ¹İº¹ ÇÏ´Â ±ÔÄ¢ 
		if(!Pattern.matches(noReg, noTemp)) { // ÀÔ·Â°ªÀÌ 4ÀÚ¸®¸¦ 
			JOptionPane.showMessageDialog(this, "ÇĞ¹øÀ» 4ÀÚ¸®ÀÇ ¼ıÀÚ·Î¸¸ ÀÔ·ÂÇØÁÖ¼¼¿ä");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			return;
		}
		
		//ÇĞ¹ø ÀÔ·Â°ªÀ» Á¤¼ö°ªÀ¸·Î º¯È¯ÇÏ¿© ÀúÀå 
		// ¹®ÀÚ¿­  (°ËÁõÀÌ ³¡³ª¸é) -> ¼ıÀÚ·Î ¹Ù²Ü¼öÀÖµµ·Ï 
		int no = Integer.parseInt(noTemp);
		
		// ÇĞ¹øÀ» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© ¹İÈ¯ÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼­µå È£Ãâ
		StudentDTO student = StudentDAO.getDAO().selectNoStudent(no);
		if(student==null) {//ÀÔ·ÂµÈ ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ °Ë»öµÇÁö ¾ÊÀº °æ¿ì 
			JOptionPane.showMessageDialog(this, "º¯°æÇÏ°íÀÚ ÇÏ´Â ÇĞ¹øÀÇ ÇĞ»ıÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			noTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
			noTF.setText(""); // JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ª ÃÊ±âÈ­ Ã³¸® 
			return;
		}
		
		//°Ë»öµÇ¾î ¹İÈ¯µÈ ÇĞ»ıÁ¤º¸¸¦ ÀÌ¿ëÇÏ¿© JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ¸·Î º¯°æÇØÁØ´Ù.
		noTF.setText(student.getNo()+""); // StringÀ» ¹Ş¾Æ¾ßµÇ´Âµ¥. Integer ¿¡ + " "->¹®ÀÚ¿­·ÎµÊ
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
	
		// ÇöÀç ÀÛ¾÷ »óÅÂ¸¦ UPDATE_CHANGE »óÅÂ·Î º¯°æ ( º¯°æÃ³¸®°¡ °¡´ÉÇÏµµ·Ï )
		setEnable(UPDATE_CHANGE);
	}
	// => ÇĞ»ıÁ¤º¸¸¦ Á¦°ø¹Ş¾Æ STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ
	// => 
	public void modifydStudent() {
		
	
	// ÇĞ¹øÀº °ËÁõÇÒ ÇÊ¿ä°¡ ¾ø´Ù. ÇĞ¹øÀº ºñÈ°¼­¿ÀÇÏ Ã³¸®µÇ¾îÀÖÀ½ °ª¸¸ °¡Á®¿È 
	int no = Integer.parseInt(noTF.getText());
	
	
	String name = nameTF.getText(); // //ÀÌ¸§ÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå  
	
	if(name.equals("")) {
		JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		nameTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
		return;
	
	}
	
	// ¿µ¹®ÀÚµµ Æ÷ÇÔÀÌ¸é "^[°¡-ÆR]{2,7}|[a-zA-Z]{4,20}$"
	String nameReg = "^[°¡-ÆR]{2,7}$"; //ÇÑ±Û 2ÀÚ~7ÀÚ ¹İº¹ °¡ ºÎÅÍ ÆR(À¯´ÏÄÚµå ¸¶Áö¸·)±îÁö
									  //2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
	if(!Pattern.matches(nameReg, name)) { // ÀÔ·Â°ªÀÌ 4ÀÚ¸®¸¦ 
		JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		nameTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
		return;
	}
	
	// ÀÌ¸§Àº Áßº¹¼º¿¡ ´ëÇÑ °ËÁõÀ» ÇÒ ÇÊ¿ä°¡ ¾ø´Ù.
	
	String phone = phoneTF.getText(); // ÀüÈ­¹øÈ£ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå  
	
	if(name.equals("")) {
		JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		phoneTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
		return;
	
	}
	
	String phoneReg="(01[016789])-\\d{3,4}-\\d{4}"; // 016789Áß ÇÏ³ª - 3ÀÚ¸®¿¡¼­4ÀÚ¸®¹İº¹ - 4ÀÚ¸®¹İº¹ 

	if(!Pattern.matches(phoneReg, phone)) { 
		JOptionPane.showMessageDialog(this, "ÀüÈ­¹øÈ£¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		phoneTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
		return;
	}
	
	String address = addressTF.getText(); // ÁÖ¼Ò°¡ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå 
	
	if(address.equals("")) {
		JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		addressTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
		return;
	}
	
	// °Ç¹°¸í ÀÔ·ÂÇÏ°í ÇØ´ç °Ç¹°¿¡ ´ëÇÑ ¿ìÆí¹øÈ£ ±×·± Çü½ÄÀ¸·Î »ç¿ëÇÒ¼ö ÀÖ´Ù.
	// ½ÇÁ¦ ÁÖ¼Ò °°Àº °æ¿ì »ó¼¼ ÁÖ¼Ò¸¦ Á¦¿ÜÇÑ °Ë»öÀ» ÅëÇØ¼­ ÁÖ¼Ò°¡ °Ë»öµÇ¾îÁú¼öÀÖ´Ù.
	// ÁÖ¼Ò´Â Á¤±ÔÇ¥Çö½ÄÀ¸·Î Ç¥ÇöÇÒ¼ö°¡ ¾ø´Ù.. ¿ìÆí¹øÈ£°Ë»ö±â´ÉÀ» ÅëÇØ¼­ ÁÖ¼Ò¸¦ ..
	
	String birthday = birthdayTF.getText(); // »ı³â¿ùÀÏÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå 
	
	if(birthday.equals("")) {
		JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		birthdayTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
		return;
	}
	
	String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
									//  1900 2000 ³âµµ 1~9¿ù,10¿ù~12¿ù Áß ÇÏ³ª Æ÷ÇÔ  1 ~9 10~19 , 20 ~ 29 30~31
	if(!Pattern.matches(birthdayReg, birthday)) { 
		JOptionPane.showMessageDialog(this, "»ı³â¿ùÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
		birthdayTF.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃĞÁ¡(Focus)À» ÀÌµ¿ÇÏ´Â ¸Ş¼Òµå
		return;
	}
	
	// DTO ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ°í JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ª(º¯¼ö°ª)À¸·Î ÇÊµå°ª º¯°æ
	
	StudentDTO student = new StudentDTO();
	// ÀÔ·ÂµÈ°ªÀ¸·Î °ªÀúÀå
	student.setNo(no);
	student.setName(name);
	student.setPhone(phone);
	student.setAddress(address);
	student.setBirthday(birthday);

	//ÇĞ»ıÁ¤º¸¸¦ Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇĞ»ıÁ¤º¸¸¦ º¯°æÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼­µå È£Ãâ
	int rows = StudentDAO.getDAO().updateStudent(student); 
	
	JOptionPane.showMessageDialog(this, rows + "¸íÀÇ ÇĞ»ı Á¤º¸¸¦ ÀúÀåÇÏ¿´½À´Ï´Ù.");
	// STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ¸ğµçÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© Ãâ·ÂÇÏ´Â ¸Ş¼Òµå
	displayAllStudent(); 
	// ¸ğµç ÄÄÆÛ³ÍÆ® ÃÊ±âÈ­ Ã³¸®
	initDisplay();
	}
	
	public void searchNameStudent() {
		
		String name=nameTF.getText();//ÀÌ¸§ÀÌ ÀÔ·ÂµÈ JTextField ÄÄÆÛ³ÍÆ®ÀÇ ÀÔ·Â°ªÀ» ¹İÈ¯¹Ş¾Æ ÀúÀå
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹İµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^([°¡-?]{2,7})$";//2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			nameTF.requestFocus();
			return;
		}
		
		//ÀÌ¸§À» Àü´ŞÇÏ¿© STUDENT Å×ÀÌºí¿¡ ÀúÀåµÈ ÇØ´ç ÀÌ¸§ÀÇ ¸ğµç ÇĞ»ıÁ¤º¸¸¦ °Ë»öÇÏ¿© ¹İÈ¯
		//ÇÏ´Â DAO Å¬·¡½ºÀÇ ¸Ş¼Òµå È£Ãâ
		List<StudentDTO> studentList=StudentDAO.getDAO().selectNameStudent(name);
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "°Ë»öµÈ ÇĞ»ıÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
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
