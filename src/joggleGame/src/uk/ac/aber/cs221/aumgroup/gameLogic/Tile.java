/*
   * @(#) Tile.java 2.2 2018/02/25
   *
   * Copyright (c) 2018 Aberystwyth University
   * All rights reserved.
   *
   */

package uk.ac.aber.cs221.aumgroup.gameLogic;

import javax.swing.*;
import java.awt.*;

/**
 * Tile - This class is used to model a tile which extends the Button Swing component
 * by adding custom properties and attributes which make it a good fit for the game
 * <p>
 * It is used to make up the grids which all have 9 tiles and each tile represents a letter
 * 
 * @author Danshil K Mungur (dkm4)
 * @version 1.0 initial development
 * @version 1.1 added methods to highlight, getters and setters
 * @see Grid
 * @see Letter
 */
public class Tile extends JButton {

	// the letter being represented
    private Letter letter;
	// whether the tile is selected or not
    private Boolean isTileSelected = false;
	// whether the tile can be selected or not
    private Boolean isTileSelectable = true;
    // the grid the tile is on
	private Grid ownerGrid;
	// the position of the tile in the grid
    private PositionInGrid pos;
	
	/**
	 * This is the default constructor for a tile
	 * It is needed when using it as a custom swing component
	 */
	public Tile() {
	}

    /**
     * This is the constructor for a tile
     * @param ownerGrid the grid that the tile belongs to
     * @param pos the position of the tile
     */
    public Tile(Grid ownerGrid, PositionInGrid pos) {
        this.ownerGrid = ownerGrid;
        this.pos = pos;
    }

    /**
     * This method sets a letter for the tile as well as displays it on the JButton itself
     * @param letter the letter to be displayed
     */
    public void assignLetter(Letter letter) {
        super.setText(letter.printLetter());
        this.letter = letter;
    }

	/**
	 * This is the getter method for the letter that is represented by the tile
	 * @return letter being represented
	 */
	public Letter getLetter() {
		return letter;
	}

    /**
     * Getter method for PositionInGrid
     * @return position of tile
     */
    public PositionInGrid getPos() {
        return pos;
    }

    /**
     * Getter method for isTileSelectable
     * @return whether the tile is selectable or not
     */
    public Boolean getIsTileSelectable() {
        return isTileSelectable;
    }

    /**
     * Setter method for isTileSelectable
     * @param isTileSelectable set whether the tile can be selected or not
     */
    public void setIsTileSelectable(Boolean isTileSelectable) {
        this.isTileSelectable = isTileSelectable;
    }

    /**
     * Getter method for Tile
     * @return whether the tile is selected or not
     */
    public Boolean getIsTileSelected() {
        return isTileSelected;
    }

    /**
     * Setter method for isTileSelected
     * @param selected set whether the tile is selected or not
     */
	@Override
    public void setSelected(boolean selected) {
        this.isTileSelected = true;
    }

    /**
     * This is used to highlight a tile
     * @param colour the color to highlight the tile
     */
    public void highlightTile(Color colour) {
        this.setBackground(colour);
    }

	/**
	 * This is the getter method for the grid that the tile belongs to
	 * @return the owner grid of the tile
	 */
	public Grid getOwnerGrid() {
		return ownerGrid;
	}

    /**
     * toString method overridden to be cleaner and not show information that is not essential
     * @return details about the tile
     */
	@Override
    public String toString() {
        return "Tile{ letter=" + letter.printLetter() + " selected=" + isTileSelected + " selectable=" + isTileSelectable + " position=" + pos.toString() + " }";
    }
}
