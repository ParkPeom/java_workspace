package �մԵ������������α׷�;

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

		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:\\Users\\fight\\Desktop\\Tree\\�ڹ�\\eclipse-workspace\\JavaSwing/image/Welcome.jpg").getImage()); // �̹��� �ҷ��� 
		
		//frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight()); // ������ �̹��� ���� ���� �������� 
		frame.setResizable(true); 
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
		lblNewLabel_1.setForeground(Color.BLACK);
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
				if(id.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Welcome Danny");
					
					// �α����� �Ϸ�Ǹ� welcomePanel �Ⱥ��̰�
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

