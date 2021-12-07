import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 클래스 -> JPanel 클래스 

class ImagePanel extends JPanel {
	private Image img; // 이미지 불러옴 private 하는 이유 이미지를 JPanel 에 있는 기능을 바꿀예정 
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // JPanel 사이즈 ,, 사진에 맞게 자동으로 조정  
		setPreferredSize(new Dimension(img.getWidth(null) , img.getHeight(null))); // 화면에 꽉차도록 함 
		setLayout(null); // 레이아웃이 원하는 곳에 
	}
	// 이미지를 넣어주는
	public void paintComponent(Graphics g) { // 패널열었을때 이미지가 자동으로 비쳐지도록
		g.drawImage(img , 0 , 0 , null); // 이미지, 시작 , 
	}
}
public class 패널에배경사진넣기 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 08");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null); // 가운대 띄우기
		frame.setVisible(true);

		ImagePanel panel = new ImagePanel(new ImageIcon("./image/flower.jpg").getImage()); // 경로와 이미지아이콘클래스였던걸 이미지클래스로 바뀜 
		frame.add(panel);
		frame.pack(); // pack : 패널의 이미지 싸이즈 맞게 패널이 자동으로 설정됨 
		
		// 경로에 파일이 있는지 확인 
		File f = new File("./image/flower.jpg");
		System.out.println(f.exists() ? "Exists " : "doesnt exists");
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
