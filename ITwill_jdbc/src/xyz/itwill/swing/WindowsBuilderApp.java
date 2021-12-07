package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

// ����Ʈ ������� �� 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// ���۳�Ʈ(Component) ���� �߻��� �̺�Ʈ(Event)�� ���� ó�� ���
// 1. ���۳�Ʈ������ �پ��� �̺�Ʈ �߻� - XXXEvent �ν��Ͻ� ���� (XXX�� �̺�Ʈ �̸�)
// ex) JButton ���۳�Ʈ�� �����ų� JTextField���� Enter�� �Է��ϸ� ActionEvent �߻�
// 2. �̺�Ʈ�� ó���ϱ� ���� Ŭ���� ���� - EventHandler Ŭ���� ����
// =>  XXXEvent �� ó���ϱ� ���� Ŭ������ Listener �������̽�(Adapter Ŭ����)�� ��ӹ޾� �ۼ�
// => ex ) ActionEvent�� ó���ϱ� ���ؼ��� ActionListener �������̽��� ��ӹ��� �̺�Ʈ ó�� Ŭ����
// => XXXListener �������̽��� �߻�޼��带 �������̵� ���� >> �̺�Ʈ ó�� �޼��� (�̺�Ʈ �߻� �� ) 
// 3. ���۳�Ʈ���� �̺�Ʈ�� �߻��� ��� �̺�Ʈ ó�� �޼��尡 ȣ��ǵ��� �̺�Ʈ �ڵ鷯 Ŭ������ �ν��Ͻ��� ���
// => ex ) Component.AddXXXListener(Listener listener) �޼��带 �̿��Ͽ� ���۳�Ʈ�� �̺�Ʈ �ڵ鷯 ��� 
// => ex ) red.addActionListener(this);
public class WindowsBuilderApp extends JFrame implements ActionListener   {
	private static final long serialVersionUID = 1L;
	// �̺�Ʈ ó�� �޼��忡�� ���� ���۳�Ʈ�� �����ϴ� ���������� �ʵ�� �����Ѵ�.
	private JPanel contentPane;
	private JButton red;
	private JButton green;
	private JTextArea area;
	private JButton blue;
	private JButton black;
	private JTextField field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsBuilderApp frame = new WindowsBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowsBuilderApp() {
		setTitle("WindowBuilder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.NORTH);
		
		red = new JButton("\uBE68\uAC04\uC0C9");
		red.setForeground(Color.RED);
		red.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		panel.add(red);
		
		green = new JButton("\uCD08\uB85D\uC0C9");
		green.setForeground(Color.GREEN);
		green.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		panel.add(green);
		
		blue = new JButton("\uD30C\uB780\uC0C9");
		blue.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		blue.setForeground(Color.BLUE);
		panel.add(blue);
		
		black = new JButton("\uAC80\uC815\uC0C9");
		black.setFont(new Font("��������ڵ�", Font.BOLD, 16));
		panel.add(black);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		area.setFont(new Font("��������ڵ�", Font.BOLD, 18));
		area.setFocusable(false);
		scrollPane.setViewportView(area);
		
		field = new JTextField();
		field.setFont(new Font("��������ڵ�", Font.BOLD, 18));
		contentPane.add(field, BorderLayout.SOUTH);
		field.setColumns(10);

		
		// �߿� .
		// ���۳�Ʈ���� ActionEvent�� �߻��ɰ�� ���� Ŭ������ ������ �ν��Ͻ��� ����� actionPerformed() �̺�Ʈ ó�� �޼��� ȣ�� 
		// => actionPerformed() �޼��� �ڵ� ȣ�� - �̺�Ʈ �ڵ鷯 ��� ����� �Ѵ�.
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		black.addActionListener(this);
		field.addActionListener(this);
	
		// Component.setEnabled(boolean b) :  ���۳�Ʈ�� ��Ȱ��ȭ ó�� 
		// => false : ��Ȱ��ȭ , true : Ȱ��ȭ 
		black.setEnabled(false);
	}
	// ActionListener �������̽��� ����� �߻�޼���
	// => ���۳�Ʈ���� ActionEvent�� �߻��� �ܿ� �ڵ� ȣ��
	// ActionEvent ���������� �ڵ����� �Ű������� ���� 

	@Override
	public void actionPerformed(ActionEvent e) {
		// ActionEvent.getSource() : �̺�Ʈ�� �߻��� Component �ν��Ͻ��� ��ȯ�ϴ� �޼��� 
		// => Object Ÿ���� �ڷ������� ��ȯ 
		Object component = e.getSource();
		
		// ��� ��ư�� ���� Ȱ��ȭ ó�� 
		red.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
		black.setEnabled(true);
		
		// �̺�Ʈ�� �߻��� ��ư�� ��Ȱ��ȭ ó�� - ��ü ����ȯ �� �޼��� ȣ�� 
		
		// ������Ʈ�� ��ư�̾�� �Ѵ�. 
		if(component instanceof JButton) {
		((JButton)component).setEnabled(false);
		
		}
		// ���۳�Ʈ�� �̺�Ʈ�� �߻��� ���۳�Ʈ�� ���Ͽ� �̺�Ʈ ó�� 	
		if(component == red) {
			area.setForeground(Color.RED);
		} else if(component == green) {
			area.setForeground(Color.GREEN);
		} else if(component == blue) {

			area.setForeground(Color.RED);		
		} else if(component == black) {
	
			area.setForeground(Color.BLACK);
		} else if(component == field) {
			// JTextField.getText() : JTextField ���۳�Ʈ�� �Է°��� ��ȯ�ϴ� �޼���
			String text = field.getText();
			
			if(!text.equals("")) {
				//JTextArea.append(String text) : JTextArea ���۳�Ʈ�� ���ڿ��� �߰��ϴ� �޼���
				area.append("[ȫ�浿]" + text + "\n");
				// ���۳�Ʈ�� �Է°��� �����ϴ� �޼��� 
				field.setText("");
			}
		}
	}
}
