import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(); // 프레임안에 또다른 프레임을 집어넣을수있게함
		JPanel btnPanel = new JPanel();
		JLabel label = new JLabel("some text"); // 글자 표시
		JButton btn1 = new JButton("Click me"); // 버튼에 들어갈 글씨
		JButton btn2 = new JButton("Exit"); // 프로그램 종료 버튼
		JTextArea txtArea = new JTextArea(); // 한줄이상 많은글씨 넣을때
		JTextField txtField = new JTextField(200); // 한줄 글씨 넣을때 (글자크기를 넣어줘야함)
		panel.setLayout(new BorderLayout());//패널 자체에서 자기가 원하는 방식으로 패널들을 레이블 원하는 위치에
											// BorderLayout() : 동서남북중앙 자기가 원하는 방향에
		frame.add(panel); // 프레임안에 패널을 직접 넣어줘야한다.	
		
		panel.add(new JLabel("Welcome this lecture"));
		panel.add(label, BorderLayout.NORTH); // new BorderLayout()으로 패널을 설정했으니
		panel.add(btnPanel, BorderLayout.WEST); // 서쪽에 추가 
		btnPanel.add(btn1); // 버튼패널에 버튼컴퍼넌트 추가
		btnPanel.add(btn2);
		
		btn1.addActionListener(new ActionListener(){ // 버튼을 눌렀을때 기능을 추가하겠다.

			@Override
			public void actionPerformed(ActionEvent e) { // 이 기능은 클릭을 할때 무언가 해라 지시 버튼 기능 추가 가능
				// txtArea.append("You are amazing!"); // 버튼클릭시 txtArea에 글씨 추가 
				label.setText(txtArea.getText()); // 글자를 내가 입력한것으로 라벨의내용이 설정됨
			}		
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 버튼클릭시 프로그램 종료 
			
			}
		});
		
		panel.add(txtArea, BorderLayout.CENTER); 
		
		
		frame.setResizable(false); // 프레임을 했을때 함부로 크기를 조절할수있나. true : 쉽게움직임
		frame.setVisible(true); // 화면에 보이게 한다.
		frame.setPreferredSize(new Dimension(840, 840/12*9)); // 원하는 사이즈로 Dimension(가로,세로) , 작은화면이면 작은화면에 맞게 
		frame.setSize(840, 840/12*9); 
		frame.setLocationRelativeTo(null); // 컴퓨터 가운대에서 나타나게 한다.
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); // 껐을때 우리가 원하는 값
															 // frame.EXIT_ON_CLOSE 프로그램 껐을때 모든게 종료
		// JFrame 하나의 틀  패널 : 보이게, 끄게 안보이게 여러가지를 넣을수있다.
		
	}
}
