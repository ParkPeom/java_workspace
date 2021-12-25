package 손님데이터저장프로그램;

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
		
		Customer customer = new Customer(); // sql 연결하고 데이터를 넣을수있음 
		frame = new JFrame();
		
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:\\Users\\fight\\git\\java_workspace\\JavaSwing\\image\\Welcome.jpg").getImage()); // 이미지 불러옴 
		welcomePanel.setBounds(0, 0, 915, 745);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight()); // 사이즈 이미지 가로 세로 설정해줌 
		
		frame.setResizable(true); 
		frame.getContentPane().setLayout(null);
		
		

		
		
		
		//String[][] data = new String[][] {{"1","2","3"},{"4","5","6"}}; // 데이터
		String[][] data = customer.getCustomers(); // 데이터 불러옴 
		
		String[] headers = new String[] {"Name","Phone","Gender","Age","Note"}; // 헤더 
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
		
		// 추가한 메인 패널을 처음엔 안보이게 설정함 
		mainPanel.setVisible(false);
	
		JLabel lblNewLabel_2 = new JLabel("Welcome to main Panel");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(248, 24, 375, 66);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(143, 153, 160, 76);
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gender");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_1.setBounds(143, 374, 160, 76);
		mainPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Age");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_1_1.setBounds(143, 255, 160, 76);
		mainPanel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Phone");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_1_2.setBounds(522, 153, 160, 76);
		mainPanel.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Birthday");
		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_1.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_1_2_1.setBounds(522, 255, 160, 76);
		mainPanel.add(lblNewLabel_3_1_2_1);
		
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Note");
		lblNewLabel_3_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2_2.setFont(new Font("굴림", Font.PLAIN, 21));
		lblNewLabel_3_1_2_2.setBounds(522, 374, 160, 76);
		mainPanel.add(lblNewLabel_3_1_2_2);
		
		name = new JTextField();
		name.setFont(new Font("굴림", Font.BOLD, 19));
		name.setBounds(316, 171, 194, 44);
		mainPanel.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("굴림", Font.BOLD, 19));
		phone.setColumns(10);
		phone.setBounds(669, 171, 194, 44);
		mainPanel.add(phone);
		
		age = new JTextField();
		age.setFont(new Font("굴림", Font.BOLD, 19));
		age.setColumns(10);
		age.setBounds(316, 271, 194, 44);
		mainPanel.add(age);
		
		birthday = new JTextField();
		birthday.setFont(new Font("굴림", Font.BOLD, 19));
		birthday.setColumns(10);
		birthday.setBounds(669, 271, 194, 44);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male","Female"}); // 콤보 박스 성별 
		gender.setFont(new Font("굴림", Font.PLAIN, 25));
		gender.setForeground(Color.GRAY);
		gender.setEditable(true);
		gender.setBackground(Color.WHITE);
		gender.setBounds(315, 385, 186, 47);
		mainPanel.add(gender);
		
		
		JTextArea note = new JTextArea();
		note.setBounds(669, 399, 194, 258);
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// 테두리 설정 현재 검정색으로 설정해 줌 내가 원하는대로 
		
		mainPanel.add(note);
		
		JButton btnNewButton = new JButton("Submit");
		
		// 버튼이 눌러저서 텍스트전부다 불러옴 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTxt = name.getText(); // name에서 얻은 텍스트를 얻어온다.
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String bTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				
				//Customer customer = new Customer(nameTxt,ageTxt,phoneTxt,bTxt,genderTxt,noteTxt);
			
				// 데이터 저장 완료 
				customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
				// 데이터 저장 확인 메세지 
				JOptionPane.showMessageDialog(null, "Your data has been successfully");
				mainPanel.setVisible(false);
				
			}
		});
		
		btnNewButton.setBounds(451, 611, 198, 76);
		mainPanel.add(btnNewButton);
		frame.getContentPane().add(welcomePanel); // 패널이 프레임에 들어가서 보이게 됨
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setBounds(464, 304, 285, 88);
		welcomePanel.add(lblNewLabel);
		
		id = new JTextField();
		id.setFont(new Font("굴림", Font.PLAIN, 25));
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
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel_1.setBounds(381, 415, 109, 58);
		welcomePanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD  : ");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel_1_1.setBounds(201, 507, 251, 58);
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778\uD558\uAE30");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\\uB85C\uADF8\uC778.png"));
		btnLogin.setBounds(482, 600, 236, 105);			
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(id.getText()); // 글자를 가져왔을떄 
//				System.out.println(password.getPassword()); // char Array
				/*
				if(id.getText().equals("Danny")) { // equals 는 string 끼리 비교 
					System.out.println("Hello Danny");
				}*/
				// JPasswordField 는 char 배열이므로 배열.equals 로 비교해야 된다. 
				if(id.getText().equals("bum4856") && Arrays.equals(password.getPassword(), "qkr159".toCharArray())) {
					System.out.println("Welcome Danny");		
					// 로그인이 완료되면 welcomePanel 안보이게
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
		tablePanel.setVisible(false); // 첫페이지에 테이블패널 안보이게함 
		tablePanel.setLayout(null);
		
		String[][] data = Customer.getCustomers();
		String[] headers = new String[] {"Name","Age","Note"};
		
		JTable table = new JTable(data,headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD , 15));
		table.setAlignmentX(0); // 0 으로 해주면 알아서 정렬됨
		table.setSize(800,600);
		table.setPreferredScrollableViewportSize(new Dimension(800,400)); // 크기 설정 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(56, 5, 802, 428);
		tablePanel.add(scrollPane);
		
		search = new JTextField();
		search.setFont(new Font("굴림", Font.PLAIN, 20));
		search.setBounds(12, 443, 846, 21);
		tablePanel.add(search);
		search.setColumns(10);
		
//		// 설치 - 필터  
		// 텍스트 필드 에서 들어갈 이벤트 키값 키의 변동사항에 있을경우 키리스너 적용
		search.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) { // 키를 누르고 나서 키 적용
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());// 이 줄이 데이터를 가지고 있지않으면 정리하는 클래스
						 						// 테이블 모델 값을 가져와서 이 테이블에 trs 에 집어넣음
				table.setRowSorter(trs); // 현재 테이블로 정리할수있는 기능	
				trs.setRowFilter(RowFilter.regexFilter(val)); // 행을 정리 필터
								// 현재 String값이 정리가 된다..
			}
		});
		
		
		
		// 컬럼간 크기설정 원하는 값의 설정 
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(100); // 그 테이블에서 열이 처음부터 0,1,2,3,4... 맨 첫번쨰 열을 선택
	      // 원하는 크기 설정 이 것보다 크면 테이블을 조정함 
		columnModels.getColumn(2).setPreferredWidth(50);
		columnModels.getColumn(3).setPreferredWidth(20);
		return bar;
	}
}
class ImagePanel extends JPanel {
	private Image img; // 이미지 불러옴 private 하는 이유 이미지를 JPanel 에 있는 기능을 바꿀예정 

	public ImagePanel(Image img) { // 이미지 패널에 이미지를 집어 넣을 경우 
		this.img = img;
		// 사이즈가 알아서 조절됨 
		setSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // JPanel 사이즈 ,, 사진에 맞게 자동으로 조정  
		setPreferredSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // 화면에 꽉차도록 함 
		setLayout(null); // 레이아웃이 원하는 곳에 
	}
	// 이미지를 넣어주는
	public void paintComponent(Graphics g) { // 패널열었을때 이미지가 자동으로 비쳐지도록
		g.drawImage(img , 0 , 0 , null); // 이미지, 시작 , 
	}
	// 가로길이 
	public int getWidth() {
		return img.getWidth(null); // 이미지의 가로 넓이 구할수있다.
	}
	public int getHeight() {
		return img.getHeight(null); // 높이를 받을수있다. 
	}
	
}

