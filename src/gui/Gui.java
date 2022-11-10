package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gui implements ActionListener {

	// Erstellt ein JFrame
	public JFrame f = new JFrame();

	public JLabel greetings = new JLabel();

	public JTextField rounds = new JTextField();

	public JLabel labelRounds = new JLabel();

	public JButton startButton = new JButton();

	public JTextField name1 = new JTextField();

	public JTextField name2 = new JTextField();

	public JLabel labelName1 = new JLabel();

	public JLabel labelName2 = new JLabel();

	public Gui() {
		// Gibt die Grösse des Fensters an
		f.setSize(600, 500);
		// Layout Manager wird ausgeschaltet
		f.setLayout(null);
		// Setzt die Titelzeile des Fensters
		f.setTitle("Würfelspiel");
		// Wenn das Programm beendet wird und keine offenen Fenster
		// vorhanden sind, wird der Prozess beendet
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f = addGreetings(f);
		f = addNames(f);
		f = addRounds(f);
		f = addStartGame(f);
		// Das Fenster wird sichtbar
		f.setVisible(true);
		f.add(name1);
	}

	public JFrame addGreetings(JFrame f) {
		greetings.setText("Bitte geben Sie die Namen der Spieler ein");
		greetings.setHorizontalAlignment(SwingConstants.CENTER);
		greetings.setBounds(50, 50, 500, 50);
		f.add(greetings);
		return f;
	}

	public JFrame addNames(JFrame f) {
		name1.setBounds(150, 100, 300, 30);
		f.add(name1);
		labelName1.setText("Spieler 1");
		labelName1.setBounds(50, 100, 100, 30);
		f.add(labelName1);
		name2.setBounds(150, 140, 300, 30);
		f.add(name2);
		labelName2.setText("Spieler 2");
		labelName2.setBounds(50, 140, 100, 30);
		f.add(labelName2);
		return f;
	}

	public JFrame addRounds(JFrame f) {
		rounds.setBounds(150, 180, 300, 30);
		f.add(rounds);
		labelRounds.setText("Anzahl Runden");
		labelRounds.setBounds(50, 180, 100, 30);
		f.add(labelRounds);
		return f;
	}

	public JFrame addStartGame(JFrame f) {
		startButton.setText("Spiel starten");
		startButton.setBounds(225, 220, 150, 30);
		startButton.addActionListener(this);
		f.add(startButton);
		return f;
	}

	public void actionPerformed(ActionEvent e) {
		startGame(name1.getText(), name2.getText(), Integer.parseInt(rounds.getText()));
	}

	public void startGame(String name1, String name2, int runden) {
		GameGui gameGui = new GameGui(name1, name2, runden);
	}

}
