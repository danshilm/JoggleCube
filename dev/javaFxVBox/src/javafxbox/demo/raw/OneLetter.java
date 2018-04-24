package javafxbox.demo.raw;

import javafxbox.demo.raw.interfaces.Letter;

public class OneLetter implements Letter {

	private String character;
	private int score;
	private int numOnGrid;
	private int numAllowed;

	/**
	 * Constructor method for one letter
	 */
	public OneLetter(String character) {
		this.character = character;
	}

	@Override
	public int intGetNumAllowed() {
		return 0;
	}

	@Override
	public void setNumAllowed(char letter) {

	}

	@Override
	public int getNumOnGrid() {
		return 0;
	}

	@Override
	public void incNumOnGrid(int n) {

	}

	@Override
	public String printCharacter() {
		return character;
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public void setScore(char letter) {

	}
}
