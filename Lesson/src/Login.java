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
		JTextField txtID=  new JTextField(10); // 10칸
		JPasswordField txtPass = new JPasswordField(10); // 입력할때 패스워드가 암호화 되서 볼수가 없다. 
		JButton logBtn = new JButton("Log In");
		
		panel.add(label); // 패널에 컴퍼넌트들을 추가해줌
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			// 버튼을 눌렀을때 안에있는 글씨 받아오기
				String id = "Dan";
				String pass = "1234";
				
				if(id.equals(txtID.getText()) && pass.equals(txtPass.getText())) { // 버튼을 눌렀을때 , 텍스트필드적은 값을 가져와서  
					JOptionPane.showMessageDialog(null, "You have logged in successfully"); 
				} else {
					JOptionPane.showMessageDialog(null, "You faild to log in");
				}
			}
		});
		add(panel); // 패널을 프레임에 넣어줌 
		
		setVisible(true); // JFrame 상속받았으므로 부모것을 쓸수있다.
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false); // 사이즈 조절이 안됨 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
