package interfaces;

public interface Grid {

	/**
	 * This method generates 9 random alphabets from a list of all alphabets
	 * and adds it to the list of generated letters for further consumption
	 */
	public void generateLetters();

	public int getGridNumber();

	public void setGridNumber(int n);

	public void resetGrid();

    public void addSelectedTile(Tile newTile);
}
