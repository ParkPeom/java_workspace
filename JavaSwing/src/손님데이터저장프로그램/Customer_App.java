package 손님데이터저장프로그램;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;

	 /**
	 * Launch the application.
	 */
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

		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\자바\\eclipse-workspace\\JavaSwing/image/Welcome.jpg").getImage()); // 이미지 불러옴 
		
		//frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight()); // 사이즈 이미지 가로 세로 설정해줌 
		frame.setResizable(true); 
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
		lblNewLabel_1.setForeground(Color.BLACK);
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
				if(id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Welcome Danny");
					
					// 로그인이 완료되면 welcomePanel 안보이게
					welcomePanel.setVisible(false);
				}
			}			
		});
		
		welcomePanel.add(btnLogin);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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

