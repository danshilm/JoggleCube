/*
   * @(#) Grid.java 2.2 2018/02/25
   *
   * Copyright (c) 2018 Aberystwyth University
   * All rights reserved.
   *
   */

package uk.ac.aber.cs221.aumgroup.gameLogic;

import java.awt.Color;
import static java.lang.Math.max;
import static java.lang.Math.min;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import uk.ac.aber.cs221.aumgroup.gameFrames.GameMainClass;
import uk.ac.aber.cs221.aumgroup.gameFrames.PlayGame;

/**
 * Grid - The grid class, which is essentially a panel with custom attributes and methods
 * it will hold tiles that represent one letter each and one grid comprises of 9 tiles
 * <p>
 * Instances of the grid will be created using its constructor and
 * manipulated with the methods from each instance of the grid
 * 
 * @author Danshil K Mungur (dkm4)
 * @version 1.0 initial development (for JavaFX)
 * @version 2.0 initial development (for Swing)
 * @version 2.1 generation and deployment of letters work correctly
 * @version 2.2 now works when imported in the GUI builder
 * @see Tile
 * @see playGame
*/
public class Grid extends JPanel {

	// constants, one for the number of rows, columns and tiles in one grid
	public static final int NO_OF_TILES_IN_GRID = 9;
	public static final int NO_OF_ROWS_IN_GRID = 3;
	public static final int NO_OF_COLUMNS_IN_GRID = 3;
	// this is an array that holds all the tiles, and is also the way we reference to the tiles in the array
	private Tile[] allTiles;
	// this is an array of letters that will be generated randomly and later populated in the tiles
	private List<Letter> generatedLetters = new ArrayList<>(NO_OF_TILES_IN_GRID);
	// set this through the constructor or a setter method in the playGame class itself
	private int gridNo = 1;
	// an array to hold the neighbouring tiles that also need to have tiles highlighted
	private List<Grid> neighbourGrids = new ArrayList<>();
	// this list of tiles will make up the word to check for in the dictionary
	public List<Tile> selectedTiles = new ArrayList<>();
	private PlayGame game;

	/**
	 * This is the default constructor for a grid
	 * It is used when creating a grid in Swing
	 */
	public Grid() {
	}
	
	/**
	 * This is the setter method for the grid number
	 * @param gridNo new grid number
	 */
	public void setGridNo(int gridNo) {
		this.gridNo = gridNo;
	}

	/**
	 * This is the getter method for the number of the grid
	 * @return integer representing the grid number
	 */
	public int getGridNo() {
		return gridNo;
	}

	/**
	 * This is the getter method for all the tiles that the grid holds
	 * @return array of tiles which belong to this grid
	 */
	public Tile[] getAllTiles() {
		return allTiles;
	}
	
	/**
	 * This method sets the allTiles array that we use to reference to each tile in a grid
	 * @param allTiles what to set the allTiles array to
	 */
	public void setAllTiles(Tile[] allTiles) {
		this.allTiles = allTiles;
	}
	
	/**
	 * This method sets the list of letters that are to be populated in the grid
	 * so that they don't have to be generated
	 * It is used when a saved game is loaded
	 * @param letters the list of letters to use to populate the tiles
	 */
	public void setLetters(List<Letter> letters){
		   generatedLetters = letters;
	}

	public void setGame(PlayGame game) {
		this.game = game;
	}
	
	

	/**
	 * This method is to generate 9 random letters 
	 * while making sure there is not more than the number allowed of each letter present in the grid
	 */
	public void generateRandomLetters() {
		int letterPopulationSize = LetterPopulation.values().length;
		Random r = new Random();
		LetterPopulation randomLetterEnum;

		for (int indexVariable = 0; indexVariable < NO_OF_TILES_IN_GRID; indexVariable++) {
			randomLetterEnum = LetterPopulation.values()[r.nextInt(letterPopulationSize)];
			// check that there is not already the max amount of a letter in the grid
			while (!checkOverflow(randomLetterEnum)) {
				randomLetterEnum = LetterPopulation.values()[r.nextInt(letterPopulationSize)];
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
	private Boolean checkOverflow(LetterPopulation someLetterEnum) {
		Letter testLetter = new Letter(someLetterEnum);
		int occurrences = Collections.frequency(generatedLetters, testLetter);

		return occurrences < testLetter.getNumAllowed();
	}

	/**
	 * Set each tile of the grid to a letter that was randomly generated
	 */
	public void populateGrid(List<Letter> gridLetters) {
		for (int indexVariable = 0; indexVariable < NO_OF_TILES_IN_GRID; indexVariable++) {
			allTiles[indexVariable].assignLetter(gridLetters.get(indexVariable));
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

	/**
	 * This method is used to highlight the valid tiles that can be selected next
	 * in the other grids than the one where the tile which has been clicked is on
	 * @param tilePosition the position of the tile which has been clicked
	 */
	public void setSelectableInNeighbourGrids(PositionInGrid tilePosition) {
        for (Grid neighbourGrid: neighbourGrids) {
            // TODO:: set neighbours as well as tile in tilePosition selectable to true

        }
	}
	
	public void setSelectableTiles(Tile tileInFirstGrid, List<Tile> selectedTiles) {
		int row = tileInFirstGrid.getPos().getRowNumber();
		int col = tileInFirstGrid.getPos().getColNumber();
		
		int row_limit = Grid.NO_OF_ROWS_IN_GRID - 1;
		if (row_limit > 0) {
			int column_limit = Grid.NO_OF_COLUMNS_IN_GRID - 1;
			for (int x = max(0, row - 1); x <= min(row + 1, row_limit); x++) {
				for (int y = max(0, col - 1); y <= min(col + 1, column_limit); y++) {
					for (int indexVariable = 0; indexVariable < NO_OF_TILES_IN_GRID; indexVariable++) {
						if (allTiles[indexVariable].getPos().getRowNumber() == x) {
							if (allTiles[indexVariable].getPos().getColNumber() == y) {
								setSelectableIfNotSelected(new PositionInGrid(x, y), selectedTiles);
							}
						}
					}
				}
			}
		}
	}
	
	public void setSelectableIfNotSelected(PositionInGrid position, List<Tile> selectedTiles) {
		Boolean isAlreadyInSelected = false;
		for (Tile selectedTile: selectedTiles) {
			if (selectedTile.getOwnerGrid().getGridNo() == gridNo) {
				if (selectedTile.getPos().getRowNumber() == position.getRowNumber()) {
					if (selectedTile.getPos().getColNumber() == position.getColNumber()) {
						isAlreadyInSelected = true;
					}
				}
			}
		}
		if (!isAlreadyInSelected) {
			for (int indexVariable = 0; indexVariable < NO_OF_TILES_IN_GRID; indexVariable++) {
				if (allTiles[indexVariable].getPos().getRowNumber() == position.getRowNumber()) {
					if (allTiles[indexVariable].getPos().getColNumber() == position.getColNumber()) {
						allTiles[indexVariable].setIsTileSelectable(true);
						allTiles[indexVariable].highlightTile(game.getMain().selectableTilesColor);
					}
				}
			}
		}
	}
}