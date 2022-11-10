package model;

public class Game {

	private Player player1;
	private Player player2;
	private int rounds;
	private int currentRound;
	private int increment;
	private boolean finished;

	public Game() {

	}

	public Game(String name1, String name2, int runden) {
		player1 = new Player(name1, runden, true);
		player2 = new Player(name2, runden, false);
		this.rounds = runden;
		this.currentRound = 0;
		this.increment = 0;
		finished = false;
	}

	public void throwDice() {
		if (rounds > currentRound) {
			if (increment <= 4) {
				if (player1.isTurn()) {
					player1.throwDice(currentRound, increment);
//					if (isEven(player1.getThrownDice()[currentRound][increment].getValue())) {
//						whichPlayer = 1;
//					}
				} else {
					player2.throwDice(currentRound, increment);
//					if (isEven(player2.getThrownDice()[currentRound][increment].getValue())) {
//						whichPlayer = 2;
//					}
				}
				increment++;
			} else {
				changeTurn();
				throwDice();
//				if (whichPlayer == 1) {
//					whichPlayer = 2;
//				} else {
//					whichPlayer = 1;
//				}
			}
		} else {
			finished = true;
		}
	}

//	public boolean isEven(int i) {
//		if (i % 2 == 0) {
//			return true;
//		}
//		return false;
//	}

	public int getMaxPoints(Player p) {
		int points = 0;
		for (Dice[] entry : p.getThrownDice()) {
			for (Dice number : entry) {
				try {
					points += number.getValue();
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}
		return points;
	}

	public int getCurrentPoints(Player p, int round) {
		int points = 0;
		for (Dice dice : p.getThrownDice()[round]) {
			try {
				points += dice.getValue();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return points;
	}

	public void changeTurn() {
		if (player1.isTurn()) {
			player1.setTurn(false);
			player2.setTurn(true);
		} else {
			player1.setTurn(true);
			player2.setTurn(false);
			currentRound = currentRound + 1;
		}
		setIncrement(0);
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int runden) {
		this.rounds = runden;
	}

	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}

	public int getCurrentRound() {
		return this.currentRound;
	}

	public boolean getFinished() {
		return this.finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

//	public int getWhichPlayer() {
//		return this.whichPlayer;
//	}

}
