package model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	public JPanel jPanel = new JPanel();

	public JLabel lb1 = new JLabel();
	public JLabel lb2 = new JLabel();
	public JLabel lb3 = new JLabel();
	public JLabel lb4 = new JLabel();
	public JLabel lb5 = new JLabel();

	public GamePanel(String l1, String l2, String l3, String l4, String l5) {

		this.setLayout(null);

		lb1.setBounds(10, 10, 30, 30);
		lb2.setBounds(40, 10, 30, 30);
		lb3.setBounds(70, 10, 30, 30);
		lb4.setBounds(100, 10, 30, 30);
		lb5.setBounds(130, 10, 30, 30);

		lb1.setIcon(stringToImage(l1));
		lb2.setIcon(stringToImage(l2));
		lb3.setIcon(stringToImage(l3));
		lb4.setIcon(stringToImage(l4));
		lb5.setIcon(stringToImage(l5));

		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);

	}

	public ImageIcon stringToImage(String s) {
		ImageIcon icon = new ImageIcon("src/model/dice" + s + ".jpg");
		return icon;
	}

}
