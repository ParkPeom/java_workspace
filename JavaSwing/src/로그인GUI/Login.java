package 로그인GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	public Login() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("ID : ");
		JLabel pswrd = new JLabel("Password : ");
		JTextField txtID = new JTextField(10); // 10칸 
		JPasswordField txtPass = new JPasswordField(10);// 입력할때 패스워드처럼 암호화 됨 
		JButton logBtn = new JButton("Log In");
		
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 눌렀을떄 반응
				// 원하는 아이디
				String id = "Dan";
				String pass = "1234";
				
				if(id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "You have logged in successfully");
				} else {
					JOptionPane.showMessageDialog(null, "You have failed to log in");
				}
			}
			
		});
		add(panel); // 창에 패널 추가 
		
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null); // 가운대 
		setResizable(false); // 사이즈 조절 못함 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login(); // 메인에서 로그인 자동 실행 
	}
}
