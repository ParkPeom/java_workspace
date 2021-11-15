package com.gui.lottoprogram;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	/* Panel */
	JPanel panel = new JPanel(null);
	
	/* Label */
	JLabel label1 = new JLabel("뽑을 번호 개수");
	JLabel label2 = new JLabel("최솟값");
	JLabel label3 = new JLabel("최댓값");
	JLabel label4 = new JLabel("뽑힌 번호");
	
	/* Button */
	JButton btn1 = new JButton("추첨");
	JButton btn2 = new JButton("초기화");
	
	/* ComboBox */
	JComboBox combo1;
	JComboBox combo2;
	JComboBox combo3;
	
	/* List */
	JList<String> list = new JList<String>();
	
	String num[] = new String[6];
	String number[] = new String[45];
	String lotto[] = new String[6];
	
	int num1 = 0;
	int num2 = 0;
	int num3 = 0;
	
	Operator o = null;
	
	MainFrame(Operator _o) {
		o = _o;
		setTitle("로또");
		
		label1.setBounds(10, 5, 80, 25);
		label2.setBounds(10, 55, 80, 25);
		label3.setBounds(10, 105, 80, 25);
		label4.setBounds(100, 5, 100, 25);
		
		for(int i=0; i<6; i++) {
			num[i] = (i+1) + "";
		}
		
		for(int i=0; i<45; i++) {
			number[i] = (i+1) + "";
		}
		
		combo1 = new JComboBox(num);
		combo2 = new JComboBox(number);
		combo3 = new JComboBox(number);
		
		combo1.setBounds(10, 30, 80, 20);
		combo2.setBounds(10, 80, 80, 20);
		combo3.setBounds(10, 130, 80, 20);
		
		btn1.setBounds(10, 160, 80, 25);
		btn2.setBounds(100, 160, 95, 25);
		
		list.setBounds(100, 30, 95, 120);
		
		setContentPane(panel);
		
		panel.add(label1);
		panel.add(combo1);
		panel.add(label2);
		panel.add(combo2);
		panel.add(label3);
		panel.add(combo3);
		panel.add(btn1);
		panel.add(label4);
		panel.add(btn2);
		panel.add(list);
		
		ButtonListener bl = new ButtonListener();
		ComboBoxListener cl = new ComboBoxListener();
		
		combo1.addActionListener(cl);
		combo2.addActionListener(cl);
		combo3.addActionListener(cl);
		
		btn1.addActionListener(bl);
		btn2.addActionListener(bl);
		
		setSize(220, 230);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class ComboBoxListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			num1 = Integer.parseInt(combo1.getSelectedItem().toString());
			num2 = Integer.parseInt(combo2.getSelectedItem().toString());
			num3 = Integer.parseInt(combo3.getSelectedItem().toString());
		}
	}
	
	public class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			if(b.getText().equals("추첨")) {
				if(num1!=0 && num2!=0 && num3!=0 && num2<num3 && num3-num2>=num1) {
					Random rand = new Random();
					for(int i=0; i<num1; i++) {
						lotto[i] = (rand.nextInt(num3-num2+1) + num2) + "";
						
						for(int j=0; j<i; j++) {
							if(lotto[i].equals(lotto[j])) {
								i--;
							}
						}
						list.setListData(lotto);
					}
				} else {
					JOptionPane.showMessageDialog(null, "숫자 설정을 다시 해주세요", "추첨 불가", JOptionPane.ERROR_MESSAGE);
				}
			}
			if(b.getText().equals("초기화")) {
				num1 = 0;
				num2 = 0;
				num3 = 0;
				
				for(int i=0; i<6; i++) {
					lotto[i] = "";
				}
				
				list.setListData(lotto);
			}
		}
	}
}
