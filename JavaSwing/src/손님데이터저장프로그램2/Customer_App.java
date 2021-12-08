package 손님데이터저장프로그램2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Customer_App {

	private JFrame frame;
	private JPasswordField password;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField id;
	private JTextField name;
	private JTextField age;
	private JTextField phone;
	private JTextField birthday;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer customer = new Customer();
		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 794, 571);
		tablePanel.setVisible(false);
		String[][] data = customer.getCustomers();
		String[] headers =new String[] {"Name","Phone","Gender","Age","Note"};
		tablePanel.setLayout(null);
		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(600,400);
		table.setPreferredScrollableViewportSize(new Dimension(600,400));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(93, 58, 602, 428);
		tablePanel.add(scrollPane);
		frame.getContentPane().add(tablePanel);

		search = new JTextField();
		search.setFont(new Font("굴림", Font.PLAIN, 17));
		search.setBounds(93, 21, 602, 27);
		tablePanel.add(search);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(100);
		columnModels.getColumn(1).setPreferredWidth(50);
		columnModels.getColumn(2).setPreferredWidth(20);


		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 794, 571);
		mainPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);


				JLabel lblNewLabel = new JLabel("Welcome This is Main Panel");
				lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 35));
				lblNewLabel.setBounds(243, 26, 374, 72);
				mainPanel.add(lblNewLabel);

				JLabel lblName = new JLabel("Name");
				lblName.setBounds(199, 135, 57, 15);
				mainPanel.add(lblName);

				JLabel lblAge = new JLabel("Age");
				lblAge.setBounds(199, 222, 57, 15);
				mainPanel.add(lblAge);

				JLabel lblGender = new JLabel("Gender");
				lblGender.setBounds(199, 302, 57, 15);
				mainPanel.add(lblGender);

				JLabel lblPhone = new JLabel("Phone");
				lblPhone.setBounds(451, 135, 57, 15);
				mainPanel.add(lblPhone);

				JLabel lblBirthday = new JLabel("Birthday");
				lblBirthday.setBounds(451, 222, 57, 15);
				mainPanel.add(lblBirthday);

				JLabel lblNote = new JLabel("Note");
				lblNote.setBounds(451, 302, 57, 15);
				mainPanel.add(lblNote);

				name = new JTextField();
				name.setBounds(268, 132, 116, 21);
				mainPanel.add(name);
				name.setColumns(10);

				age = new JTextField();
				age.setColumns(10);
				age.setBounds(268, 219, 116, 21);
				mainPanel.add(age);

				phone = new JTextField();
				phone.setColumns(10);
				phone.setBounds(498, 132, 116, 21);
				mainPanel.add(phone);

				birthday = new JTextField();
				birthday.setColumns(10);
				birthday.setBounds(501, 219, 116, 21);
				mainPanel.add(birthday);

				JComboBox gender = new JComboBox(new String[] {"Male","Female"});
				gender.setEditable(true);
				gender.setBackground(Color.WHITE);
				gender.setBounds(268, 299, 122, 21);
				mainPanel.add(gender);

				JTextArea note = new JTextArea();
				note.setBounds(498, 298, 129, 164);
				note.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				mainPanel.add(note);

				JButton btnNewButton = new JButton("submit");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nameTxt= name.getText();
						String ageTxt = age.getText();
						String phoneTxt = phone.getText();
						String genderTxt = gender.getSelectedItem().toString();
						String noteTxt = note.getText();
						//Customer customer = new Customer(nameTxt, ageTxt)

						//customer.createCustomer(nameTxt, phoneTxt, genderTxt, ageTxt, noteTxt);
						JOptionPane.showMessageDialog(null, "Your data has been saved successfully");
						mainPanel.setVisible(false);

					}
				});
				btnNewButton.setBounds(377, 493, 97, 23);
				mainPanel.add(btnNewButton);

		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:/Users/Mirim/OneDrive/문서/java_swing_basic/Lesson/image/welcome.jpg").getImage());
		welcomePanel.setBounds(0, 0, 794, 570);
		frame.getContentPane().add(welcomePanel);

		password = new JPasswordField();
		password.setBounds(533, 399, 232, 50);
		password.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		welcomePanel.add(password);




		JTextField id_1 = new JTextField();
		id_1.setBounds(533, 328, 232, 50);
		welcomePanel.add(id_1);
		id_1.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		id_1.setToolTipText("ID");
		id_1.setColumns(10);

		JButton btnLogin = new JButton("Log In");
		btnLogin.setBounds(533, 467, 232, 56);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(id_1.getText().equals("Danny") && Arrays.equals(password.getPassword(), "hello".toCharArray())) {
					System.out.println("Hello Danny");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);

				}else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
			}

		});
		welcomePanel.add(btnLogin);


		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");

		bar.add(fileMenu);
		bar.add(aboutMenu);

		JMenuItem openFile = new JMenuItem("open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		return bar;
	}
}

class ImagePanel extends JPanel{
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);

	}
	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
