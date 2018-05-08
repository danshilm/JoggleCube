/*
   * @(#) LetterPopulation.java 1.0 2018/02/25
   *
   * Copyright (c) 2018 Aberystwyth University
   * All rights reserved.
   *
   */

package uk.ac.aber.cs221.aumgroup.gameLogic;

/**
 * LetterPopulation - This is an enumeration of all the letters that can be used
 * <p>
 * It is used a way of representing a letter while
 * still being able for each letter to have their own properties
 * 
 * @author Danshil K Mungur (dkm4)
 * @version 1.0 initial development
 * @see Letter
 */
public enum LetterPopulation {
    A(9, 1),
    B(2, 3),
    C(2, 3),
    D(4, 2),
    E(12, 1),
    F(2, 4),
    G(3, 2),
    H(2, 4),
    I(9, 1),
    J(1, 8),
    K(1, 5),
    L(4, 1),
    M(2, 3),
    N(6, 1),
    O(8, 1),
    P(2, 3),
    Qu(1, 8),
    R(6, 1),
    S(4, 1),
    T(6, 1),
    U(3, 1),
    V(2, 4),
    W(2, 4),
    X(1, 8),
    Y(2, 4),
    Z(1, 10);

    private int numAllowed;
    private int letterValue;

    /**
     * This is the constructor method for the letter enumeration
     * @param numAllowed the number of that letter allowed in one grid
     * @param letterValue the score of that letter
     */
    private LetterPopulation(int numAllowed, int letterValue) {
        this.numAllowed = numAllowed;
        this.letterValue = letterValue;
    }

    /**
     * This is the getter method for the number of one letter allowed in the grid
     * @return the number of letter allowed
     */
    public int getNumAllowed() {
        return numAllowed;
    }

    /**
     * This is the setter method for the number of one letter allowed in the grid
     * @param numAllowed new number of the letter allowed
     */
    public void setNumAllowed(int numAllowed) {
        this.numAllowed = numAllowed;
    }

    /**
     * This is the setter method for the score of letter letter
     * @return the score of the letter
     */
    public int getLetterValue() {
        return letterValue;
    }

    /**
     * This is the getter method for the score of the letter
     * @param letterValue new score of the letter
     */
    public void setLetterValue(int letterValue) {
        this.letterValue = letterValue;
    }
}
