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
		JTextField txtID=  new JTextField(10); // 10ĭ
		JPasswordField txtPass = new JPasswordField(10); // �Է��Ҷ� �н����尡 ��ȣȭ �Ǽ� ������ ����. 
		JButton logBtn = new JButton("Log In");
		
		panel.add(label); // �гο� ���۳�Ʈ���� �߰�����
		panel.add(txtID);
		panel.add(pswrd);
		panel.add(txtPass);
		panel.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			// ��ư�� �������� �ȿ��ִ� �۾� �޾ƿ���
				String id = "Dan";
				String pass = "1234";
				
				if(id.equals(txtID.getText()) && pass.equals(txtPass.getText())) { // ��ư�� �������� , �ؽ�Ʈ�ʵ����� ���� �����ͼ�  
					JOptionPane.showMessageDialog(null, "You have logged in successfully"); 
				} else {
					JOptionPane.showMessageDialog(null, "You faild to log in");
				}
			}
		});
		add(panel); // �г��� �����ӿ� �־��� 
		
		setVisible(true); // JFrame ��ӹ޾����Ƿ� �θ���� �����ִ�.
		setSize(600,400);
		setLocationRelativeTo(null);
		setResizable(false); // ������ ������ �ȵ� 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
