/*
   * @(#) Letter.java 2.2 2018/02/25
   *
   * Copyright (c) 2018 Aberystwyth University
   * All rights reserved.
   *
   */

package uk.ac.aber.cs221.aumgroup.gameLogic;

/**
 * Letter - A class which is used to represent one letter
 * <p>
 * A word is made up of letters and is each letter is going to be represented on a tile each
 * 
 * @author Danshil K Mungur (dkm4)
 * @version 1.0 initial development with list of letters
 * @version 2.0 now works with letter population enumeration
 * @see LetterPopulation
 * @see Tile
 */
public class Letter {
	
	// the letter being represented
    private LetterPopulation character;
	// the number of the letter allowed in one grid
    private int numAllowed;
	// the scrabble value of the letter
    private int letterValue;
	// the number of the letter already on the grid
    private int numOnGrid;

	/**
	 * This is the default constructor for a letter
	 * It is needed when using it as a custom swing component
	 */
    public Letter() {
    }

	/**
	 * This is the constructor for a letter
	 * @param character the character that the tile will represent
	 */
    public Letter(LetterPopulation character) {
        this.character = character;
        this.numAllowed = character.getNumAllowed();
        this.letterValue = character.getLetterValue();
    }

	/**
	 * This is the getter method for the number of the letter allowed in one grid
	 * @return maximum number of the letter allowed
	 */
    public int getNumAllowed() {
        return numAllowed;
    }

	/**
	 * This is the getter method for the scrabble score of the letter
	 * @return score of the letter
	 */
	public int getLetterValue() {
		return letterValue;
	}
	
	/**
	 * This method prints out the character being represented
	 * It is used when loading a saved game and when creating a tile
	 * @return character string that is represented
	 */
    public String printLetter() {
        return character.toString();
    }
	
	/**
	 * This is the setter method for the character that the letter represents
	 * @param tLetter new letter to be represented
	 */
	public void setCharacter(String tLetter){
        character = LetterPopulation.valueOf(tLetter);
    }
}
