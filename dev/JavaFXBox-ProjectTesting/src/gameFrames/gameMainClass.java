/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFrames;

import java.awt.*;

/**
 *
 * @author MY PC
 */
public class gameMainClass {
    public static void main(String[] args){
        // This load the startmenu page when game is run.
            startMenu sM = new startMenu();
            sM.setVisible(true);

            for (Component thisComponent: sM.getComponents()) {
                System.out.println(thisComponent.toString());
            }

         }
    
}
