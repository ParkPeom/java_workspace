import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Lesson07 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Table prac.");
		JPanel panel = new JPanel();

		//JTable(a,heading) // ���̺�ȿ��� �ΰ��� �Ķ����  ù��° : ����Ÿ , �ι�° : �����
		String[] headings = new String[]{"Id","Name","Country"};
		Object[][] data = new Object[][] {
			{"1","Daniel","Korea"},
			{"2","Suuny","France"},
			{"3","John","Japan"}
		};
		JTable table = new JTable(data,headings); // �Ķ����  ù��° : ����Ÿ , �ι�° : �����
		table.setPreferredScrollableViewportSize(new Dimension(700,600)); // �츮�� ���ϴ� ������� ������ִ�. ���� 700 ���� 600
		table.setFillsViewportHeight(true); //���̺��� ���̰� setVisible �̶� ����� ��� 
		
		panel.add(new JScrollPane(table)); // �����̺��� ��ũ�Ѹ� ����Ҽ��ְ� ���� 
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setSize(800,640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
