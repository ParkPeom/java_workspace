import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table Prac.");
		JPanel panel = new JPanel();
		
		// JTable(a); // 데이터 , 제목들 해딩
		// 컬럼
		String[] headings = new String[] {"Id","Name","Country"}; // 컬럼
		// 데이터
		Object[][] data = new Object[][] {
			{"1","Daniel","Korea"},
			{"2","Sunny","France"},
			{"3","John","Japan"}
		};
		
		JTable table = new JTable(data,headings); // 데이터 , 컬럼 
		table.setPreferredScrollableViewportSize(new Dimension(700,600)); // 원하는 사이즈로  가로 700 세로 600 
		table.setFillsViewportHeight(true); // 보이게 함  
		
		panel.add(table);
		panel.add(new JScrollPane(table)); // 스크롤 할수있게 함 	
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800,640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
