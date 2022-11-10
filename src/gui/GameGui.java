package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Game;
import model.GamePanel;
import model.ScorePanel;

public class GameGui extends JFrame implements ActionListener {

	public JPanel panel = new JPanel();
	public JButton nextButton = new JButton();
	public Game game;
	public JPanel lastPanel = null;
	public JLabel name1 = new JLabel();
	public JLabel pointsPlayer1 = new JLabel();
	public JLabel name2 = new JLabel();
	public JLabel pointsPlayer2 = new JLabel();
	public JButton stopButton = new JButton();
	public JLabel winner = new JLabel();

	public GameGui(String name1, String name2, int runden) {
		game = new Game(name1, name2, runden);
		// Layout Manager wird ausgeschaltet
		this.setLayout(null);
		panel.setLayout(null);
		panel.setBounds(0, 0, 600, 5000);
		this.name1.setBounds(50, 10, 150, 20);
		this.name1.setText(name1);
		this.add(this.name1);
		this.name2.setBounds(300, 10, 150, 20);
		this.name2.setText(name2);
		this.add(this.name2);
		nextButton.setBounds(0, 300, 100, 20);
		nextButton.setText("Würfeln!");
		nextButton.addActionListener(this);
		stopButton.setBounds(150, 300, 100, 20);
		stopButton.setText("Fertig!");
		stopButton.addActionListener(this);
		this.add(panel);
		this.add(nextButton);
		this.add(stopButton);
		// Gibt die Grösse des Fensters an
		this.setSize(600, 600);

		// Setzt die Titelzeile des Fensters
		this.setTitle("Würfelspiel");
		// Wenn das Programm beendet wird und keine offenen Fenster
		// vorhanden sind, wird der Prozess beendet
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	int x = 0;

	// tbd stopround auswerten

	public void paintScreen() {
		String[] myArray = new String[5];
		for (int i = 0; i <= 4; i++) {
			myArray[i] = "";
		}
		int currentRound = game.getCurrentRound();
		if (game.getFinished() == false) {
			if (game.getPlayer1().isTurn() == true && game.getRounds() > currentRound) {
				for (int i = 0; i <= game.getIncrement() - 1; i++) {
					myArray[i] = game.getPlayer1().getThrownDice()[currentRound][i].getValue() + "";
				}
				;
			} else if (game.getPlayer1().isTurn() == false && game.getRounds() > currentRound - 1) {
				for (int i = 0; i <= game.getIncrement() - 1; i++) {
					myArray[i] = game.getPlayer2().getThrownDice()[currentRound][i].getValue() + "";
				}
				;
			}
			GamePanel gamePanel = new GamePanel(myArray[0], myArray[1], myArray[2], myArray[3], myArray[4]);
			if (game.getPlayer1().isTurn()) {
				x = 20;
			} else {
				x = 270;
			}
			gamePanel.setBounds(x, 60 * currentRound + 30, 150, 60);
			if (lastPanel != null && game.getIncrement() != 1) {
				panel.remove(lastPanel);
			}
			panel.add(gamePanel);
			lastPanel = gamePanel;
			this.repaint();
			if (game.getIncrement() == 5) {
				if (game.getPlayer1().isTurn() == true) {
					setPoints(2, game.getCurrentRound());
				} else {
					setPoints(1, game.getCurrentRound());
				}

			}
		}
	}

	public void setPoints(int player, int currentRound) {
		if (player == 1) {
			x = 460;
			ScorePanel score = new ScorePanel(game.getCurrentPoints(game.getPlayer2(), currentRound),
					game.getMaxPoints(game.getPlayer2()));
			score.setBounds(x, 60 * currentRound + 30, 50, 60);
			panel.add(score);
		} else {
			x = 210;
			ScorePanel score = new ScorePanel(game.getCurrentPoints(game.getPlayer1(), currentRound),
					game.getMaxPoints(game.getPlayer1()));
			score.setBounds(x, 60 * currentRound + 30, 50, 60);
			panel.add(score);
		}
		this.repaint();
	}

	public void turn() {
		game.throwDice();
	}

	public void gameIsOver() {
		this.winner.setBounds(200, 60 * (game.getCurrentRound() + 2) - 30, 150, 20);
		if (game.getMaxPoints(game.getPlayer1()) > game.getMaxPoints(game.getPlayer2())) {
			this.winner.setText(game.getPlayer1().getName() + " hat gewonnen!");
		} else if (game.getMaxPoints(game.getPlayer2()) > game.getMaxPoints(game.getPlayer1())) {
			this.winner.setText(game.getPlayer2().getName() + " hat gewonnen!");
		} else {
			this.winner.setText("Es ist ein Unentschieden!");
		}
		panel.add(this.winner);
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextButton) {
			turn();
			paintScreen();
			if (game.getRounds() == game.getCurrentRound() + 1 && game.getIncrement() == 5
					&& game.getPlayer2().isTurn() == true) {
				gameIsOver();
			}
		}

		if (e.getSource() == stopButton) {
			game.changeTurn();
			if (game.getPlayer1().isTurn() == true) {
				setPoints(1, game.getCurrentRound() - 1);
			} else {
				setPoints(2, game.getCurrentRound());
			}
			if (game.getRounds() == game.getCurrentRound() && game.getPlayer1().isTurn() == true) {
				gameIsOver();
			}

		}
	}

}
