import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Ŭ���� -> JPanel Ŭ���� 

class ImagePanel extends JPanel {
	private Image img; // �̹��� �ҷ��� private �ϴ� ���� �̹����� JPanel �� �ִ� ����� �ٲܿ��� 
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // JPanel ������ ,, ������ �°� �ڵ����� ����  
		setPreferredSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // ȭ�鿡 �������� �� 
		setLayout(null); // ���̾ƿ��� ���ϴ� ���� 
	}
	// �̹����� �־��ִ�
	public void paintComponent(Graphics g) { // �гο������� �̹����� �ڵ����� ����������
		g.drawImage(img , 0 , 0 , null); // �̹���, ���� , 
	}
}
public class �гο��������ֱ� {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 08");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null); // ����� ����
		frame.setVisible(true);

		ImagePanel panel = new ImagePanel(new ImageIcon("./image/flower.jpg").getImage()); // ��ο� �̹���������Ŭ���������� �̹���Ŭ������ �ٲ� 
		frame.add(panel);
		frame.pack(); // pack : �г��� �̹��� ������ �°� �г��� �ڵ����� ������ 
		
		// ��ο� ������ �ִ��� Ȯ�� 
		File f = new File("./image/flower.jpg");
		System.out.println(f.exists() ? "Exists " : "doesnt exists");
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
