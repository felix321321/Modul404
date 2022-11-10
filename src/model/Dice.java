package model;

public class Dice {

	// Wert des Würfels
	private int value;

	// Konstruker welcher einen neuen Würfel erstellt
	// Der Würfel erhällt automatisch einen zufälligen Wert
	public Dice() {
		value = throwDice();
	}

	// Methode zur Erstellung eines ganzzahligen Wertes zwischen 6
	// und 1
	// Math.random erstellt eine Zahl zwischen 0 und 1 welche dann *6
	// genommen wird (0-6) und ein + 1 gerechnet (1-7), da 1 jedoch sehr
	// unwahrscheinlich erreicht wird, kann die Kommazahl einfach
	// weggelassen werden -> 6,938 -> 6
	// Dadurch kann eine Zahl zwischen 1 und 6 erzeugt werden
	public int throwDice() {
		value = (int) (Math.random() * (6) + 1);
		return value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
