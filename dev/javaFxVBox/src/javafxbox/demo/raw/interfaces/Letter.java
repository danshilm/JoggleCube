package javafxbox.demo.raw.interfaces;

public interface Letter {

	public int intGetNumAllowed();

	public void setNumAllowed(char letter);

	public int getNumOnGrid();

	public void incNumOnGrid(int n);

	public String printCharacter();

	public int getScore();

	// parameter is letter?
	public void setScore(char letter);
}
