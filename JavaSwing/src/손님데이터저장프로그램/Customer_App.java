package �մԵ������������α׷�;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {
	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField phone;
	private JTextField age;
	private JTextField birthday;
	private JTextField search;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Customer_App() {
		initialize();	
	}
	private void initialize() {
		
		Customer customer = new Customer(); // sql �����ϰ� �����͸� ���������� 
		frame = new JFrame();
		
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:\\Users\\fight\\git\\java_workspace\\JavaSwing\\image\\Welcome.jpg").getImage()); // �̹��� �ҷ��� 
		welcomePanel.setBounds(0, 0, 915, 745);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight()); // ������ �̹��� ���� ���� �������� 
		
		frame.setResizable(true); 
		frame.getContentPane().setLayout(null);
		
		

		
		
		
		//String[][] data = new String[][] {{"1","2","3"},{"4","5","6"}}; // ������
		String[][] data = customer.getCustomers(); // ������ �ҷ��� 
		
		String[] headers = new String[] {"Name","Phone","Gender","Age","Note"}; // ��� 
		JTable table = new JTable(data,headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif",Font.BOLD,15));
		table.setAlignmentX(0);
		table.setSize(800,600);
		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 928, 745);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		// �߰��� ���� �г��� ó���� �Ⱥ��̰� ������ 
		mainPanel.setVisible(false);
	
		JLabel lblNewLabel_2 = new JLabel("Welcome to main Panel");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(248, 24, 375, 66);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(143, 153, 160, 76);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gender");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_3_1.setBounds(143, 374, 160, 76);
		mainPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Age");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_3_1_1.setBounds(143, 255, 160, 76);
		mainPanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Phone");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_3_1_2.setBounds(522, 153, 160, 76);
		mainPanel.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Birthday");
		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_3_1_2_1.setBounds(522, 255, 160, 76);
		mainPanel.add(lblNewLabel_3_1_2_1);
		
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Note");
		lblNewLabel_3_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_2.setFont(new Font("����", Font.PLAIN, 21));
		lblNewLabel_3_1_2_2.setBounds(522, 374, 160, 76);
		mainPanel.add(lblNewLabel_3_1_2_2);
		
		name = new JTextField();
		name.setFont(new Font("����", Font.BOLD, 19));
		name.setBounds(316, 171, 194, 44);
		mainPanel.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("����", Font.BOLD, 19));
		phone.setColumns(10);
		phone.setBounds(669, 171, 194, 44);
		mainPanel.add(phone);
		
		age = new JTextField();
		age.setFont(new Font("����", Font.BOLD, 19));
		age.setColumns(10);
		age.setBounds(316, 271, 194, 44);
		mainPanel.add(age);
		
		birthday = new JTextField();
		birthday.setFont(new Font("����", Font.BOLD, 19));
		birthday.setColumns(10);
		birthday.setBounds(669, 271, 194, 44);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male","Female"}); // �޺� �ڽ� ���� 
		gender.setFont(new Font("����", Font.PLAIN, 25));
		gender.setForeground(Color.GRAY);
		gender.setEditable(true);
		gender.setBackground(Color.WHITE);
		gender.setBounds(315, 385, 186, 47);
		mainPanel.add(gender);
		
		
		JTextArea note = new JTextArea();
		note.setBounds(669, 399, 194, 258);
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// �׵θ� ���� ���� ���������� ������ �� ���� ���ϴ´�� 
		
		mainPanel.add(note);
		
		JButton btnNewButton = new JButton("Submit");
		
		// ��ư�� �������� �ؽ�Ʈ���δ� �ҷ��� 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTxt = name.getText(); // name���� ���� �ؽ�Ʈ�� ���´�.
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String bTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				
				//Customer customer = new Customer(nameTxt,ageTxt,phoneTxt,bTxt,genderTxt,noteTxt);
			
				// ������ ���� �Ϸ� 
				customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				// ������ ���� Ȯ�� �޼��� 
				JOptionPane.showMessageDialog(null, "Your data has been successfully");
				mainPanel.setVisible(false);
				
			}
		});
		
		btnNewButton.setBounds(451, 611, 198, 76);
		mainPanel.add(btnNewButton);
		frame.getContentPane().add(welcomePanel); // �г��� �����ӿ� ���� ���̰� ��
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setBounds(464, 304, 285, 88);
		welcomePanel.add(lblNewLabel);
		
		id = new JTextField();
		id.setFont(new Font("����", Font.PLAIN, 25));
		id.setText("Enter ID");
		id.setToolTipText("Enter ID");
		id.setBounds(464, 388, 383, 88);
		welcomePanel.add(id);
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(464, 496, 383, 94);
		welcomePanel.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("ID : ");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 35));
		lblNewLabel_1.setBounds(381, 415, 109, 58);
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD  : ");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("����", Font.BOLD, 35));
		lblNewLabel_1_1.setBounds(201, 507, 251, 58);
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778\uD558\uAE30");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\\uB85C\uADF8\uC778.png"));
		btnLogin.setBounds(482, 600, 236, 105);			
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(id.getText()); // ���ڸ� ���������� 
//				System.out.println(password.getPassword()); // char Array
				/*
				if(id.getText().equals("Danny")) { // equals �� string ���� �� 
					System.out.println("Hello Danny");
				}*/
				// JPasswordField �� char �迭�̹Ƿ� �迭.equals �� ���ؾ� �ȴ�. 
				if(id.getText().equals("bum4856") && Arrays.equals(password.getPassword(), "qkr159".toCharArray())) {
					System.out.println("Welcome Danny");		
					// �α����� �Ϸ�Ǹ� welcomePanel �Ⱥ��̰�
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "You Failed to log in");
				}
			}			
		});
		welcomePanel.add(btnLogin);
		frame.setJMenuBar(menuBar());
	//	frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		
		ImagePanel tablePanel = new ImagePanel(new ImageIcon("C:\\Users\\fight\\git\\java_workspace\\JavaSwing\\image\\2400-photo-of-black-and-white-rabbit.jpeg").getImage());
		bar.add(tablePanel);
		tablePanel.setVisible(false); // ù�������� ���̺��г� �Ⱥ��̰��� 
		tablePanel.setLayout(null);
		
		String[][] data = Customer.getCustomers();
		String[] headers = new String[] {"Name","Age","Note"};
		
		JTable table = new JTable(data,headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD , 15));
		table.setAlignmentX(0); // 0 ���� ���ָ� �˾Ƽ� ���ĵ�
		table.setSize(800,600);
		table.setPreferredScrollableViewportSize(new Dimension(800,400)); // ũ�� ���� 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(56, 5, 802, 428);
		tablePanel.add(scrollPane);
		
		search = new JTextField();
		search.setFont(new Font("����", Font.PLAIN, 20));
		search.setBounds(12, 443, 846, 21);
		tablePanel.add(search);
		search.setColumns(10);
		
//		// ��ġ - ����  
		// �ؽ�Ʈ �ʵ� ���� �� �̺�Ʈ Ű�� Ű�� �������׿� ������� Ű������ ����
		search.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) { // Ű�� ������ ���� Ű ����
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());// �� ���� �����͸� ������ ���������� �����ϴ� Ŭ����
						 						// ���̺� �� ���� �����ͼ� �� ���̺� trs �� �������
				table.setRowSorter(trs); // ���� ���̺�� �����Ҽ��ִ� ���	
				trs.setRowFilter(RowFilter.regexFilter(val)); // ���� ���� ����
								// ���� String���� ������ �ȴ�..
			}
		});
		
		
		
		// �÷��� ũ�⼳�� ���ϴ� ���� ���� 
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(100); // �� ���̺��� ���� ó������ 0,1,2,3,4... �� ù���� ���� ����
	      // ���ϴ� ũ�� ���� �� �ͺ��� ũ�� ���̺��� ������ 
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(20);
		return bar;
	}
}
class ImagePanel extends JPanel {
	private Image img; // �̹��� �ҷ��� private �ϴ� ���� �̹����� JPanel �� �ִ� ����� �ٲܿ��� 

	public ImagePanel(Image img) { // �̹��� �гο� �̹����� ���� ���� ��� 
		this.img = img;
		// ����� �˾Ƽ� ������ 
		setSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // JPanel ������ ,, ������ �°� �ڵ����� ����  
		setPreferredSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // ȭ�鿡 �������� �� 
		setLayout(null); // ���̾ƿ��� ���ϴ� ���� 
	}
	// �̹����� �־��ִ�
	public void paintComponent(Graphics g) { // �гο������� �̹����� �ڵ����� ����������
		g.drawImage(img , 0 , 0 , null); // �̹���, ���� , 
	}
	// ���α��� 
	public int getWidth() {
		return img.getWidth(null); // �̹����� ���� ���� ���Ҽ��ִ�.
	}
	public int getHeight() {
		return img.getHeight(null); // ���̸� �������ִ�. 
	}
	
}

