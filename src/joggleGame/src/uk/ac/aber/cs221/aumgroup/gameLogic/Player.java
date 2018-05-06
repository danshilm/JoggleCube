/*
   * @(#) Player.java 1.0 2018/02/25
   *
   * Copyright (c) 2018 Aberystwyth University
   * All rights reserved.
   *
   */

package uk.ac.aber.cs221.aumgroup.gameLogic;

/**
 * Player class - stores and manipulates all the details of a player.
 * The details are: name and score.
 * It is used by the gameScoreBoard when reading all the best players details from the file.
 * used when we the game over and the players scores have to be sorted in descending order
 * it implements the comparable class as the players scores have to be sorted in descending order
 * 
 * @author Naailah Hajaree (nah37)
 * @version 1.0 initial development
 */
public class Player
        implements Comparable<Player> {
	
    private Integer score;
    private String name;

    /**
     * Default constructor of the Player class
     */
    public Player() {

    }

    /**
     * This constructor is used when the players details have been read from a file
     * @param pName The player's name
     * @param pScore The player's score
     */
    public Player(String pName,Integer pScore){
        name = pName;
        score = pScore;

    }

    /**
     * This method returns the player's score
     * @return score The player's score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method returns the player's name
     * @return name The player's name
     */
    public String getName(){
        return name;
    }

    /**
     * This method sets the player's score
     * @param pScore the player's score
     */
    public void setScore(int pScore){
        score = pScore;
    }
    
    /**
     * This method set the player's name
     * @param pName the player's name
     */
    public void setName(String pName){
        name = pName;
    }

    @Override
    public int compareTo(Player player) {
        return score.compareTo(player.score);
    }
}
