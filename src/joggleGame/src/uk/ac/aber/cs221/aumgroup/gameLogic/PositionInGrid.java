/*
   * @(#) PositionInGrid.java 2.2 2018/02/25
   *
   * Copyright (c) 2018 Aberystwyth University
   * All rights reserved.
   *
   */

package uk.ac.aber.cs221.aumgroup.gameLogic;

/**
 * PositionInGrid - This is the class that represents the position of an element
 * <p>
 * It is used to provide a position to a tile in the grid that it is a child of
 * 
 * @author Danshil K Mungur (dkm4)
 * @version 1.0 initial development
 * @see Tile
 * @see Grid
 */
public class PositionInGrid {
    private int rowNumber;
    private int colNumber;

    /**
     * This is the constructor method for the position of a tile
     * @param rowNumber the row in which the tile is
     * @param colNumber the column in which the tile is
     */
    public PositionInGrid(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    /**
     * This is the getter method for the row number
     * @return row number in which the tile is
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * This is the setter method for the row
     * @param rowNumber new row in which the tile is
     */
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    /**
     * This is the getter method for the col number
     * @return col number in which the tile is
     */
    public int getColNumber() {
        return colNumber;
    }

    /**
     * This is the setter method for the col number
     * @param colNumber col number in which the tile is
     */
    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    /**
     * Overridden toString method to display position of element
     * @return string giving details about the row and column position of element
     */
    public String toString() {
        return "PositionInGrid{row:" + rowNumber + ", col:" + colNumber + "}";
    }
}
