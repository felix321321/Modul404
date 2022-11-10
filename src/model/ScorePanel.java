package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {

	public JLabel score = new JLabel();

	public ScorePanel(int currentPoints, int maxPoints) {
		this.setLayout(null);
		score.setBounds(0, 10, 50, 20);
		score.setText(currentPoints + "/" + maxPoints);
		add(score);
	}

}
