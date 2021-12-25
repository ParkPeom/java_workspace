package 체크박스;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class App {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox checkbox = new JCheckBox("Edit"); // 1. 생성
		checkbox.setBounds(86, 38, 45, 23);
		panel.add(checkbox); // 2. 패널에 추가
		
		textField = new JTextField();
		textField.setEnabled(false);// 타입을 사용할수 있는지 여부 false 사용할수없다
		textField.setBounds(86, 83, 260, 136);
		panel.add(textField);
		textField.setColumns(10);
		
		// 3. 액션리스너로 기능 추가 
		checkbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isChecked = checkbox.isSelected(); // 선택이 되어있으면 true 안되어있으면 false
				textField.setEnabled(isChecked); // 체크가 되어있으면 텍스트필드 사용 가능
				
				// textField.setEnabled(checkbox.isSelected());
			}
		}); 
		
	}
}
