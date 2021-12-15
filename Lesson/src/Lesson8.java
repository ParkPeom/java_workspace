import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null))); //null �ִ밪
									// ������ �г��� ������ �°� �ڵ����� ������
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		// setPreferredSize�� �ּ� ������� �ִ����� �����Ͽ���, layout���������, ����� ����
		setLayout(null); // ���̾ƿ��� ���ϴ°��� �Ҽ��ְԵȴ�.
		
	}
	public void paintComponent(Graphics g) { // �̹����� �ڵ����� �г��� �������� �ڵ����� ������
		g.drawImage(img,0,0,null); // img , ���� , x ���� ,y ����  
						// �츮���� JPanel 
	}
}
public class Lesson8 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 08");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/bird.jfif").getImage()); // new ImageIcon() �� ��θ� �����ش�.
											// getImage() : ���� �̹���Ŭ������ ���� 
		frame.add(panel);
		frame.pack(); // �г��� �̹�������� �°�  �����ӿ� �ڵ����� ������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
