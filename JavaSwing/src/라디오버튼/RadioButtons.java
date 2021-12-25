package 라디오버튼;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 라디오버튼 - 그룹을 이용하여 그중에서 하나만 선택 가능
 * 체크박스 - 여러개 선택 가능 
 */

public class RadioButtons {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JRadioButton korBtn = new JRadioButton("Korean");
		JRadioButton engBtn = new JRadioButton("English");
		JRadioButton chiBtn = new JRadioButton("Chinese");
		
		ButtonGroup group = new ButtonGroup();
		
		korBtn.setActionCommand("kor"); // korean 선택하지만 실제 값은 kor임 
		engBtn.setActionCommand("eng");
		chiBtn.setActionCommand("chi");
		
		// 그룹에 버튼 하나씩 추가
		group.add(korBtn);
		group.add(engBtn);
		group.add(chiBtn);
		// 글자 크기 변경
		Font font = new Font("Arial",Font.BOLD , 24);
		korBtn.setFont(font);
		engBtn.setFont(font);
		chiBtn.setFont(font);
		
		// 영어버튼이 자동으로 추가되어있는 상태만들기
		engBtn.setSelected(true);
		
		// 한글 버튼을 눌렀을때 
		korBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand()); // 선택된 라디오 버튼에서 값을 가져옴
				
			}
		});
		
		engBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand()); // 선택된 라디오 버튼에서 값을 가져옴
				
			}
		});
		
		chiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand()); // 선택된 라디오 버튼에서 값을 가져옴
				
			}
		});
		
		// 패널에 일리리 추가해줘야함
		panel.add(korBtn);
		panel.add(engBtn);
		panel.add(chiBtn);
		
		
		// 프레임에 추가한패널을 추가해줘야 한다.
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
