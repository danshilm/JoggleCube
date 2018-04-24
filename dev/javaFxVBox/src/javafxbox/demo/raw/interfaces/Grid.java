package javafxbox.demo.raw.interfaces;

import javafxbox.demo.raw.SomeTile;

public interface Grid {

	public void generateLetters();

	/**
	 * This method gets the grid number
	 * @return grid number
	 */
	public int getGridNumber();

	/**
	 * This method is used to set the grid number
	 * @param n New grid number
	 */
	public void setGridNumber(int n);

	/**
	 * This method is called when the grid have to be cleared of all tiles
	 * And the letters have to be generated again
	 */
	public void resetGrid();

    public void addSelectedTile(Tile newTile);
}
