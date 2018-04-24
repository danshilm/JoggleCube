package javafxbox.demo.raw.interfaces;

import javafx.beans.property.BooleanProperty;

public interface Tile {

	/**
	 * This is the setter method for the letter that the tile represents
	 * @param letter new letter that is to be represented
	 */
	public void setLetter(Letter letter);

	/**
	 * This is the getter method for the letter that is represented on the tile
	 * @return letter that is represented on the tile
	 */
	public Letter getLetter();

	/**
	 * This method selects the tile as well as add it to the list of selected tiles for the grid
	 * and sets it as unselectable as a next tile
	 */
	public void select();

	/**
	 * This method is used to get whether the tile is selected or not
	 * @return whether the tile is selected or not
	 */
	public boolean isSelected();

	/**
	 * This is the getter method for the selected property
	 * @return selected property of the tile
	 */
	public BooleanProperty selectedProperty();

	/**
	 * This is the setter method for the selected property
	 * @param selected whether the tile is selected or not
	 */
	public void setSelected(boolean selected);

	/**
	 * This method is used to get whether the tile is seletable or not as a next tile
	 * @return whether the tile is selectable or not
	 */
	public boolean isSelectable();

	/**
	 * This is the getter method for the selectable property
	 * @return selectable property of the tile
	 */
	public BooleanProperty selectableProperty();

	/**
	 * This is the setter method for the selectable property
	 * @param selectable whether tile is selectable as a next tile or not
	 */
	public void setSelectable(boolean selectable);

	/**
	 * This is the setter method for the grid number to which the tile belongs
	 * @param n new grid number in which the tile is present
	 */
	public void setGridNo(int n);

	/**
	 * This is the getter method for the grid number to which the tile belongs
	 * @return grid number to which the tile belongs
	 */
	public int getGridNo();

	/**
	 * This is the getter method for the row position of the tile in the grid
	 * @return which row the tile is in
	 */
	public int getRowNoInGrid();

	/**
	 * This is the setter method for the row position for the tile in the grid
	 * @param r new row number for the tile
	 */
	public void setRowNoInGrid(int r);

	/**
	 * This is the getter method for the column position of the tile in the grid
	 * @return which column the tile is in
	 */
	public int getColNoInGrid();

	/**
	 * This is the setter method for the column position for the tile in the grid
	 * @param c
	 */
	public void setColNoInGrid(int c);
}
