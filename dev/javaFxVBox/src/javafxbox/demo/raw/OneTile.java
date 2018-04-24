package javafxbox.demo.raw;

import javafxbox.demo.raw.interfaces.Grid;
import javafxbox.demo.raw.interfaces.Tile;
import javafxbox.demo.raw.interfaces.Letter;

public class OneTile implements Tile {

	private Grid ownerGrid;
	private Letter letter;
	private boolean selected;
	private int rowNoInGrid;
	private int colNoInGrid;
	private int gridNo;
	// this holds the position of the tile in the grid that it is in
	private PositionInGrid pos;
	private boolean selectable;

	/**
	 * Constructor method for one tile that holds a letter
	 */
	private OneTile(Letter letter) {
		this.letter = letter;
		selectable = true;
	}

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
	}

	@Override
	public void select() {
		if (!selectable) {
			this.selected = true;
			ownerGrid.addSelectedTile(this);
			this.selectable = false;
		}
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	@Override
	public void setGridNo(int n) {

	}

	@Override
	public int getGridNo() {
		return gridNo;
	}

	@Override
	public int getRowNoInGrid() {
		return pos.getRowNumber();
	}

	@Override
	public void setRowNoInGrid(int r) {

	}

	@Override
	public int getColNoInGrid() {
		return pos.getRowNumber();
	}

	@Override
	public void setColNoInGrid(int c) {

	}
}
