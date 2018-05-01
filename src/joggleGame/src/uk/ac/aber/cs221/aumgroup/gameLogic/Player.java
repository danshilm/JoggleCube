/*
   * @(#) Player.java 2.2 2018/02/25
   *
   * Copyright (c) 2018 Aberystwyth University
   * All rights reserved.
   *
   */

package uk.ac.aber.cs221.aumgroup.gameLogic;


public class Player implements Comparable<Player> {
    private Integer score;
    private String name;

    public Player() {

    }
    public Player(String pName,Integer pScore){

        name = pName;
        score = pScore;

    }

    public Integer getScore() {
        return score;
    }

    public String getName(){
        return name;
    }
    @Override
    public int compareTo(Player player) {
        return score.compareTo(player.score);
    }


}
