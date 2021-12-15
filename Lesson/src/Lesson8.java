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
		setSize(new Dimension(img.getWidth(null),img.getHeight(null))); //null 최대값
									// 사진이 패널의 사이즈 맞게 자동으로 조정됨
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		// setPreferredSize는 최소 사이즈와 최대사이즈를 설정하여서, layout과관계없이, 사이즈를 설정
		setLayout(null); // 레이아웃이 원하는곳에 할수있게된다.
		
	}
	public void paintComponent(Graphics g) { // 이미지를 자동으로 패널을 열었을때 자동으로 비춰짐
		g.drawImage(img,0,0,null); // img , 시작 , x 시작 ,y 시작  
						// 우리만의 JPanel 
	}
}
public class Lesson8 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 08");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/bird.jfif").getImage()); // new ImageIcon() 에 경로를 적어준다.
											// getImage() : 지금 이미지클래스로 만듬 
		frame.add(panel);
		frame.pack(); // 패널을 이미지싸이즈에 맞게  프레임에 자동으로 조정됨
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
