package �α���GUI;

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
		JTextField txtID = new JTextField(10); // 10ĭ 
		JPasswordField txtPass = new JPasswordField(10);// �Է��Ҷ� �н�����ó�� ��ȣȭ �� 
		JButton logBtn = new JButton("Log In");
		
		panel.add(label);
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ư�� �������� ����
				// ���ϴ� ���̵�
				String id = "Dan";
				String pass = "1234";
				
				if(id.equals(txtID.getText()) && pass.equals(txtPass.getText())) {
					JOptionPane.showMessageDialog(null, "You have logged in successfully");
				} else {
					JOptionPane.showMessageDialog(null, "You have failed to log in");
				}
			}
			
		});
		add(panel); // â�� �г� �߰� 
		
		setVisible(true);
		setSize(600,400);
		setLocationRelativeTo(null); // ����� 
		setResizable(false); // ������ ���� ���� 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login(); // ���ο��� �α��� �ڵ� ���� 
	}
}
