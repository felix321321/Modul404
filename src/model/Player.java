package model;

public class Player {

	private String name;
	private int score;
	private Dice thrownDice[][];
	private boolean isTurn;

	public Player(String name, int rounds, boolean isTurn) {
		this.name = name;
		this.score = 0;
		this.thrownDice = new Dice[rounds][5];
		this.isTurn = isTurn;
	}

	public Player throwDice(int round, int dicePosition) {
		Dice dice = new Dice();
		this.thrownDice[round][dicePosition] = dice;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Dice[][] getThrownDice() {
		return thrownDice;
	}

	public void setThrownDice(Dice[][] thrownDice) {
		this.thrownDice = thrownDice;
	}

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

}
