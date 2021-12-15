import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;

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
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 1562, 586);
		frame.getContentPane().add(mainPanel);
		mainPanel.setVisible(false); // 처음 화면에 안보이기
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome This Main Panel");
		lblNewLabel_1.setBounds(484, 42, 380, 59);
		lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 20));
		mainPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 19));
		lblNewLabel_2.setBounds(284, 323, 204, 59);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(284, 118, 204, 59);
		mainPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Age");
		lblNewLabel_2_2.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(284, 231, 204, 59);
		mainPanel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Phone");
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2_1_1.setBounds(697, 118, 204, 59);
		mainPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Birthday");
		lblNewLabel_2_1_1_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2_1_1_1.setBounds(697, 216, 204, 59);
		mainPanel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Note");
		lblNewLabel_2_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_2_1_1_1_1.setBounds(697, 323, 204, 59);
		mainPanel.add(lblNewLabel_2_1_1_1_1);
		
		name = new JTextField();
		name.setFont(new Font("굴림", Font.PLAIN, 20));
		name.setBounds(381, 129, 220, 44);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("굴림", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(381, 238, 220, 44);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setFont(new Font("굴림", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(817, 129, 220, 44);
		mainPanel.add(phone);
		
		birthday = new JTextField();
		birthday.setFont(new Font("굴림", Font.PLAIN, 20));
		birthday.setColumns(10);
		birthday.setBounds(817, 231, 220, 44);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[] {"Male","Female"});
		gender.setBounds(394, 331, 207, 49);
		mainPanel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setBounds(817, 342, 226, 185);
		mainPanel.add(note);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String bTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString(); // 콤보박스 값 불러오기 
				String noteTxt = note.getText();// textArea 적은 값 불러오기 

				// 값을 넣어줌 데이터베이스 넣어주는 메서드 
				Customer customer = new Customer(nameTxt,ageTxt);
			}
		});
		btnNewButton.setBounds(531, 459, 204, 68);
		mainPanel.add(btnNewButton);
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/fight/Desktop/Tree/자바/eclipse-workspace/Lesson/image/theme.jpg").getImage()); // 시스템익스플로어 주소를 가져와야 디자인에서 보임
		welcomePanel.setBounds(0, 10, 1576, 623);
		frame.getContentPane().add(welcomePanel); // 프레임에 이미지패널을 추가함 
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 26));
		lblNewLabel.setBounds(1300, 240, 100, 53);
		welcomePanel.add(lblNewLabel);
		
		id = new JTextField();
		id.setToolTipText("ID\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		id.setBounds(1188, 303, 334, 53);
		welcomePanel.add(id);
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(1188, 383, 340, 53);
		welcomePanel.add(password);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("굴림", Font.PLAIN, 26));
		lblId.setBounds(1134, 299, 145, 53);
		welcomePanel.add(lblId);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 26));
		lblNewLabel_1_1.setBounds(1061, 383, 145, 53);
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\\uC790\uBC14\\eclipse-workspace\\Lesson\\image\\btnClicked.jpg"));
		
		// 로그인 버튼
		btnLogin.setPressedIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\\uC790\uBC14\\eclipse-workspace\\Lesson\\image\\button.jpg")); // 버튼을 눌렀을때 이미지 
		btnLogin.setBounds(1188, 466, 334, 43);

		welcomePanel.add(btnLogin);
		
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight()); // 이미지의 크기만큼 프레임크기를 설정함 
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 로그인 버튼을 눌렀을때
				if(id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					welcomePanel.setVisible(false); 
					// 메인패널 나오게 하기
					mainPanel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인에 실패");
				}
			}});
		
		frame.setJMenuBar(menuBar()); // 위에 메뉴바를 불러옴 
	}
	// 화면 맨위 메뉴바 
	public JMenuBar menuBar() { 
		JMenuBar bar = new JMenuBar(); // 메뉴바를 만들고
		
		JMenu fileMenu = new JMenu("File"); // 메뉴를 추가 
		JMenu aboutMenu = new JMenu("About");
		
		// 메뉴바에 메뉴들 추가 하고 
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		// 메뉴아이템 생성
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		
		// 파일메뉴에 메뉴아이템 추가해주면 된다.
		fileMenu.add(openFile);
		fileMenu.addSeparator(); // 구분선 
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener() { // exit 버튼 누르게되면	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 프로그램 종료 
			}
		});
		
		return bar;
	}
}
class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null))); //null 최대값
									// 사진이 패널의 사이즈 맞게 자동으로 조정됨
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		// setPreferredSize는 최소 사이즈와 최대사이즈를 설정하여서, layout과관계없이, 사이즈를 설정
		setLayout(null); // 레이아웃이 원하는곳에 할수있게된다.
	}
	// 이미지의 넓이와 높이를 받을수있다. 
	public int getWidth() { // 가로길이를 
		return img.getWidth(null); // 가로 넓이를 받을수있음
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g) { // 이미지를 자동으로 패널을 열었을때 자동으로 비춰짐
		g.drawImage(img,0,0,null); // img , 시작 , x 시작 ,y 시작  
						// 우리만의 JPanel 
	}
}