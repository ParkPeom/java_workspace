import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table Prac.");
		JPanel panel = new JPanel();
		
		// JTable(a); // ������ , ����� �ص�
		// �÷�
		String[] headings = new String[] {"Id","Name","Country"}; // �÷�
		// ������
		Object[][] data = new Object[][] {
			{"1","Daniel","Korea"},
			{"2","Sunny","France"},
			{"3","John","Japan"}
		};
		
		JTable table = new JTable(data,headings); // ������ , �÷� 
		table.setPreferredScrollableViewportSize(new Dimension(700,600)); // ���ϴ� �������  ���� 700 ���� 600 
		table.setFillsViewportHeight(true); // ���̰� ��  
		
		panel.add(table);
		panel.add(new JScrollPane(table)); // ��ũ�� �Ҽ��ְ� �� 	
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800,640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
