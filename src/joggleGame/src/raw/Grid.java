package raw;

import raw.Tile;
import raw.Letter;
import raw.LetterEnum;
import raw.PositionInGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * This is a grid, which is essentially a panel with custom attributes and methods
 * it will hold tiles that represent one letter each and one grid comprises of 9 tiles
 * @author Danshil K Mungur
 */
public class Grid extends JPanel {

	private static final int NO_OF_TILES_IN_GRID = 9;
	private static final int NO_OF_ROWS_IN_GRID = 3;
	private static final int NO_OF_COLUMNS_IN_GRID = 3;
	// this is an array that holds all the tiles, and is also the way we reference to the tiles in the array
	private Tile[] allTiles;
	// this is an array of letters that will be generated randomly
	private List<Letter> generatedLetters = new ArrayList<>(NO_OF_TILES_IN_GRID);
	// set this through the constructor or a setter method in the playGame class itself
	private int gridNo = 1;
	// 
	private List<Grid> neighbourGrids = new ArrayList<>();
	// this list of tiles will make up the word to check for in the dictionary
	private List<Tile> selectedTiles = new ArrayList<>();

	/**
	 * This is the default constructor for a grid
	 * It is used when creating a grid in Swing
	 */
	public void Grid() {
	}
	
	/**
	 * This is the setter method for the grid number
	 * @param gridNo new grid number
	 */
	public void setGridNo(int gridNo) {
		this.gridNo = gridNo;
	}

	/**
	 * This method sets the allTiles array that we use to reference to each tile in a grid
	 * @param allTiles what to set the allTiles array to
	 */
	public void setAllTiles(Tile[] allTiles) {
		this.allTiles = allTiles;
	}

	/**
	 * This method is to generate 9 random letters while making sure there is not more than the number allowed of each letter present in the grid
	 */
	public void generateRandomLetters() {
		int LetterPopulation = LetterEnum.values().length;
		Random r = new Random();
		LetterEnum randomLetterEnum;

		for (int i = 0; i < NO_OF_TILES_IN_GRID; i++) {
			randomLetterEnum = LetterEnum.values()[r.nextInt(LetterPopulation)];
			// check that there is not already the max amount of a letter in the grid
			while (!checkOverflow(randomLetterEnum)) {
				randomLetterEnum = LetterEnum.values()[r.nextInt(LetterPopulation)];
			}
			Letter tempLetter = new Letter(randomLetterEnum);
			generatedLetters.add(tempLetter);
		}
	}

	/**
	 * Micromethod for generateRandomLetters method
	 * @param someLetterEnum letter to check whether there are more than allowed or not in the grid
	 * @return whether there is already the amount of a letter in the list of generated letters
	 */
	private Boolean checkOverflow(LetterEnum someLetterEnum) {
		Letter testLetter = new Letter(someLetterEnum);
		int occurrences = Collections.frequency(generatedLetters, testLetter);

		return occurrences < testLetter.getNumAllowed();
	}

	/**
	 * Set each tile of the grid to a letter that was randomly generated
	 */
	public void populateGrid() {
		for (int i = 0; i < NO_OF_TILES_IN_GRID; i++) {
			allTiles[i].assignLetter(generatedLetters.get(i));
		}
	}

	/**
	 * This method will be used to get the neighboring grids from which to get the tiles
	 * that will be set to selectable when one tile on this grid is selected
	 * It has to be called after the other grids have been initialized
	 * OR
	 * whenever a tile is clicked
	 * @param neighbourGrids List of Grids
	 */
	public void setNeighbourGrids(List<Grid> neighbourGrids) {
		// TODO:: Use this method
		this.neighbourGrids = neighbourGrids;
	}

	public void setSelectableInNeighbourGrids(PositionInGrid tilePosition) {
        for (Grid neighbourGrid: neighbourGrids) {
            // TODO:: set neighbours as well as tile in tilePosition selectable to true

        }
	}

	/**
	 * This event is fired up when a Tile is clicked
	 * @param evt event being listened for
	 */
	public void handleTileAction(java.awt.event.ActionEvent evt, JLabel warningLabel) {
		Tile clickedTile = (Tile) evt.getSource();
		int row = clickedTile.getPos().getRowNumber();
		int col = clickedTile.getPos().getColNumber();

		/**
		 * When clicked,
		 *
		 * check if is selectable first
		 *		if yes
		 *			set all tiles selectable to false (we will set the neighbours selectable to true later)
		 *			highlight all tiles white (we will highlight the neighbours later)
		 *			set clickedTile selected to true
		 *			add tile to selectedTiles list in grid
		 *			set neighbour tiles selectable to true
		 *			highlight neighbour tiles red
		 * 		if no
		 *			empty selectedTiles list
		 *			set all tiles selected to false (default)
		 *			set all tiles selectable to true (default)
		 *			highlight all tiles white
		 *			display warning on label for 3 seconds 
		 */

		if (clickedTile.getSelectable()) {
			// set all tiles selectable to false
			for (Tile oneTile : allTiles) {
				oneTile.setSelectable(false);
				oneTile.highlightTile(Color.WHITE);
			}

			clickedTile.setSelected(true);
			selectedTiles.add(clickedTile);

			// this is to set all the neighbours selectable to true
			// so that the player can select another tile after

			// new and improved algo to set neighbours to selectable to true
			int row_limit = NO_OF_ROWS_IN_GRID - 1;
			if (row_limit > 0) {
				int column_limit = NO_OF_COLUMNS_IN_GRID - 1;
				for (int x = max(0, row - 1); x <= min(row + 1, row_limit); x++) {
					for (int y = max(0, col - 1); y <= min(col + 1, column_limit); y++) {
						if (x != row || y != col) {
							setSelectableIfNotAlreadySelected(new PositionInGrid(x, y));
						}
					}
				}
			}

			setSelectableInNeighbourGrids(new PositionInGrid(row, col));
		} else {
			// when user clicks on tile which is not selectable
			selectedTiles.clear();
			for (Tile oneTile : allTiles) {
				oneTile.setSelected(false);
				oneTile.setSelectable(true);
				oneTile.highlightTile(Color.WHITE);
			}
			
			warningLabel.setText("You clicked on an unselected tile!");
			Timer t = new Timer(3000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					warningLabel.setText(null);
				}
			});
			t.setRepeats(false);
			t.start();
		}
	}
	
	/**
	 * This method is used to make sure a tile that is already selected's selectable is set to true
	 * @param position position of neighbour tile to check if already selected
	 */
	private void setSelectableIfNotAlreadySelected(PositionInGrid position) {
		Boolean isAlreadyInSelected = false;
		for (Tile selectedTile: selectedTiles) {
			if (selectedTile.getPos() == position) {
				isAlreadyInSelected = true;
			}
		}

		if (isAlreadyInSelected) {
			System.out.println("Tile at position: " + position + "is already in selected tiles list");
		} else {
			for (Tile oneTile: allTiles) {
				if (oneTile.getPos().getRowNumber() == position.getRowNumber()) {
					if (oneTile.getPos().getColNumber() == position.getColNumber()) {
						oneTile.setSelectable(true);
						oneTile.highlightTile(Color.RED);
					}
				}
			}
		}
	}

}
