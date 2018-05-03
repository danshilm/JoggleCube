/*
 * @gameMainClass.java 1.1 2018/05/04
 *
 * Copyright (c) 2018 Aberystwyth University.
 * All rights reserved.
 *
 */

package uk.ac.aber.cs221.aumgroup.gameFrames;

/**
 * The gameMainClass load the components for the startmenu page to be display
 *
 * @author the12, jty
 */
public class gameMainClass {
    public static void main(String[] args) {
        // This load the startmenu page when game is run.
        startMenu sM = new startMenu();
        // check if the startmenu is visible
        sM.setVisible(true);

    }

}

