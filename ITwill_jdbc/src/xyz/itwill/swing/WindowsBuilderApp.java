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

// 임포트 시켜줘야 함 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 컴퍼넌트(Component) 에서 발생된 이벤트(Event)에 대한 처리 방법
// 1. 컴퍼넌트에서는 다양한 이벤트 발생 - XXXEvent 인스턴스 생성 (XXX는 이벤트 이름)
// ex) JButton 컴퍼넌트을 누르거나 JTextField에서 Enter를 입력하면 ActionEvent 발생
// 2. 이벤트를 처리하기 위한 클래스 생성 - EventHandler 클래스 선언
// =>  XXXEvent 를 처리하기 위한 클래스는 Listener 인터페이스(Adapter 클래스)를 상속받아 작성
// => ex ) ActionEvent를 처리하기 위해서는 ActionListener 인터페이스를 상속받은 이벤트 처리 클래스
// => XXXListener 인터페이스의 추상메서드를 오버라이드 선언 >> 이벤트 처리 메서드 (이벤트 발생 시 ) 
// 3. 컴퍼넌트에서 이벤트가 발생될 경우 이벤트 처리 메서드가 호출되도록 이벤트 핸들러 클래스를 인스턴스로 등록
// => ex ) Component.AddXXXListener(Listener listener) 메서드를 이용하여 컴퍼넌트의 이벤트 핸들러 등록 
// => ex ) red.addActionListener(this);
public class WindowsBuilderApp extends JFrame implements ActionListener   {
	private static final long serialVersionUID = 1L;
	// 이벤트 처리 메서드에서 사용될 컴퍼넌트를 저장하는 참조변수는 필드로 선언한다.
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
		red.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		panel.add(red);
		
		green = new JButton("\uCD08\uB85D\uC0C9");
		green.setForeground(Color.GREEN);
		green.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		panel.add(green);
		
		blue = new JButton("\uD30C\uB780\uC0C9");
		blue.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		blue.setForeground(Color.BLUE);
		panel.add(blue);
		
		black = new JButton("\uAC80\uC815\uC0C9");
		black.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		panel.add(black);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		area = new JTextArea();
		area.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		area.setFocusable(false);
		scrollPane.setViewportView(area);
		
		field = new JTextField();
		field.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		contentPane.add(field, BorderLayout.SOUTH);
		field.setColumns(10);

		
		// 중요 .
		// 컴퍼넌트에서 ActionEvent가 발생될경우 현재 클래스로 생성된 인스턴스의 선언된 actionPerformed() 이벤트 처리 메서드 호출 
		// => actionPerformed() 메서드 자동 호출 - 이벤트 핸들러 등록 해줘야 한다.
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		black.addActionListener(this);
		field.addActionListener(this);
	
		// Component.setEnabled(boolean b) :  컴퍼넌트의 비활성화 처리 
		// => false : 비활성화 , true : 활성화 
		black.setEnabled(false);
	}
	// ActionListener 인터페이스에 선언된 추상메서드
	// => 컴퍼넌트에서 ActionEvent가 발생될 겨웅 자동 호출
	// ActionEvent 관련정보는 자동으로 매개변수에 저장 

	@Override
	public void actionPerformed(ActionEvent e) {
		// ActionEvent.getSource() : 이벤트가 발생된 Component 인스턴스를 반환하는 메서드 
		// => Object 타입의 자료형으로 반환 
		Object component = e.getSource();
		
		// 모두 버튼에 대한 활성화 처리 
		red.setEnabled(true);
		green.setEnabled(true);
		blue.setEnabled(true);
		black.setEnabled(true);
		
		// 이벤트가 발생된 버튼만 비활성화 처리 - 객체 형변환 후 메서드 호출 
		
		// 컴포넌트가 버튼이어야 한다. 
		if(component instanceof JButton) {
		((JButton)component).setEnabled(false);
		
		}
		// 컴퍼넌트와 이벤트가 발생된 컴퍼넌트를 비교하여 이벤트 처리 	
		if(component == red) {
			area.setForeground(Color.RED);
		} else if(component == green) {
			area.setForeground(Color.GREEN);
		} else if(component == blue) {

			area.setForeground(Color.RED);		
		} else if(component == black) {
	
			area.setForeground(Color.BLACK);
		} else if(component == field) {
			// JTextField.getText() : JTextField 컴퍼넌트의 입력값을 반환하는 메서드
			String text = field.getText();
			
			if(!text.equals("")) {
				//JTextArea.append(String text) : JTextArea 컴퍼넌트의 문자열을 추가하는 메서드
				area.append("[홍길동]" + text + "\n");
				// 컴퍼넌트의 입력값을 변경하는 메서드 
				field.setText("");
			}
		}
	}
}
