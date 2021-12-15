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
		mainPanel.setVisible(false); // ó�� ȭ�鿡 �Ⱥ��̱�
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome This Main Panel");
		lblNewLabel_1.setBounds(484, 42, 380, 59);
		lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 20));
		mainPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 19));
		lblNewLabel_2.setBounds(284, 323, 204, 59);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(284, 118, 204, 59);
		mainPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Age");
		lblNewLabel_2_2.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(284, 231, 204, 59);
		mainPanel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Phone");
		lblNewLabel_2_1_1.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_2_1_1.setBounds(697, 118, 204, 59);
		mainPanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Birthday");
		lblNewLabel_2_1_1_1.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_2_1_1_1.setBounds(697, 216, 204, 59);
		mainPanel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Note");
		lblNewLabel_2_1_1_1_1.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_2_1_1_1_1.setBounds(697, 323, 204, 59);
		mainPanel.add(lblNewLabel_2_1_1_1_1);
		
		name = new JTextField();
		name.setFont(new Font("����", Font.PLAIN, 20));
		name.setBounds(381, 129, 220, 44);
		mainPanel.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setFont(new Font("����", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(381, 238, 220, 44);
		mainPanel.add(age);
		
		phone = new JTextField();
		phone.setFont(new Font("����", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(817, 129, 220, 44);
		mainPanel.add(phone);
		
		birthday = new JTextField();
		birthday.setFont(new Font("����", Font.PLAIN, 20));
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
				String genderTxt = gender.getSelectedItem().toString(); // �޺��ڽ� �� �ҷ����� 
				String noteTxt = note.getText();// textArea ���� �� �ҷ����� 

				// ���� �־��� �����ͺ��̽� �־��ִ� �޼��� 
				Customer customer = new Customer(nameTxt,ageTxt);
			}
		});
		btnNewButton.setBounds(531, 459, 204, 68);
		mainPanel.add(btnNewButton);
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/fight/Desktop/Tree/�ڹ�/eclipse-workspace/Lesson/image/theme.jpg").getImage()); // �ý����ͽ��÷ξ� �ּҸ� �����;� �����ο��� ����
		welcomePanel.setBounds(0, 10, 1576, 623);
		frame.getContentPane().add(welcomePanel); // �����ӿ� �̹����г��� �߰��� 
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 26));
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
		lblId.setFont(new Font("����", Font.PLAIN, 26));
		lblId.setBounds(1134, 299, 145, 53);
		welcomePanel.add(lblId);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblNewLabel_1_1.setFont(new Font("����", Font.PLAIN, 26));
		lblNewLabel_1_1.setBounds(1061, 383, 145, 53);
		welcomePanel.add(lblNewLabel_1_1);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\\uC790\uBC14\\eclipse-workspace\\Lesson\\image\\btnClicked.jpg"));
		
		// �α��� ��ư
		btnLogin.setPressedIcon(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\\uC790\uBC14\\eclipse-workspace\\Lesson\\image\\button.jpg")); // ��ư�� �������� �̹��� 
		btnLogin.setBounds(1188, 466, 334, 43);

		welcomePanel.add(btnLogin);
		
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight()); // �̹����� ũ�⸸ŭ ������ũ�⸦ ������ 
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // �α��� ��ư�� ��������
				if(id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					welcomePanel.setVisible(false); 
					// �����г� ������ �ϱ�
					mainPanel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "�α��ο� ����");
				}
			}});
		
		frame.setJMenuBar(menuBar()); // ���� �޴��ٸ� �ҷ��� 
	}
	// ȭ�� ���� �޴��� 
	public JMenuBar menuBar() { 
		JMenuBar bar = new JMenuBar(); // �޴��ٸ� �����
		
		JMenu fileMenu = new JMenu("File"); // �޴��� �߰� 
		JMenu aboutMenu = new JMenu("About");
		
		// �޴��ٿ� �޴��� �߰� �ϰ� 
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		// �޴������� ����
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		
		// ���ϸ޴��� �޴������� �߰����ָ� �ȴ�.
		fileMenu.add(openFile);
		fileMenu.addSeparator(); // ���м� 
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener() { // exit ��ư �����ԵǸ�	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // ���α׷� ���� 
			}
		});
		
		return bar;
	}
}
class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null))); //null �ִ밪
									// ������ �г��� ������ �°� �ڵ����� ������
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		// setPreferredSize�� �ּ� ������� �ִ����� �����Ͽ���, layout���������, ����� ����
		setLayout(null); // ���̾ƿ��� ���ϴ°��� �Ҽ��ְԵȴ�.
	}
	// �̹����� ���̿� ���̸� �������ִ�. 
	public int getWidth() { // ���α��̸� 
		return img.getWidth(null); // ���� ���̸� ����������
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g) { // �̹����� �ڵ����� �г��� �������� �ڵ����� ������
		g.drawImage(img,0,0,null); // img , ���� , x ���� ,y ����  
						// �츮���� JPanel 
	}
}