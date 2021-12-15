import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Lesson07 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table prac.");
		JPanel panel = new JPanel();

		//JTable(a,heading) // 테이블안에는 두가지 파라미터  첫번째 : 데이타 , 두번째 : 제목들
		String[] headings = new String[]{"Id","Name","Country"};
		Object[][] data = new Object[][] {
			{"1","Daniel","Korea"},
			{"2","Suuny","France"},
			{"3","John","Japan"}
		};
		JTable table = new JTable(data,headings); // 파라미터  첫번째 : 데이타 , 두번째 : 제목들
		table.setPreferredScrollableViewportSize(new Dimension(700,600)); // 우리가 원하는 사이즈로 만들수있다. 가로 700 세로 600
		table.setFillsViewportHeight(true); //테이블이 보이게 setVisible 이랑 비슷한 기능 
		
		panel.add(new JScrollPane(table)); // 이테이블을 스크롤를 사용할수있게 설정 
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800,640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
