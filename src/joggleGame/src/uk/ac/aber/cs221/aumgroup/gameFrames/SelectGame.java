/*
 * @SelectGame.java 1.0 2018/05/05
 *
 * Copyright (c) 2018 Aberystwyth University.
 * All rights reserved.
 *
 */
package uk.ac.aber.cs221.aumgroup.gameFrames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;

/**
 * The SelectGame implements the load game option that allows the user
 to select a game file to load the game from and play that game
 * @author nah37
 * @version 1.0 initial development
 */
public class SelectGame extends javax.swing.JFrame {
	
    private int fileNo = 0;
	private GameMainClass main;
	
    /**
     * Creates new form SelectGame
     */
    public SelectGame() {
        initComponents();
		main = new GameMainClass();
		main.setSelectGame(this);
        loadSavedGames();
    }

    public void close(){
		//close the current window
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
	
    private void loadSavedGames(){
        File gamesFolder = new File("resources/savedGames");
        File[] savedGames = gamesFolder.listFiles();
       
        //JButton[] buttons = new JButton[savedGames.length];
        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();
        //set the spacing between the buttons
        gbConstraints.insets = new Insets(5,0,0,0);
        //make all the buttons of the same width
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        gbConstraints.weightx = 1;
        
		for(fileNo=0; fileNo <savedGames.length; fileNo++){
			//dispay the button one below the other
			gbConstraints.gridy = fileNo;
			// buttons[fileNo].setText(savedGames[fileNo].getName());
			JButton button = new JButton(savedGames[fileNo].getName());
			String filename = savedGames[fileNo].getName();
			button.setSize(new Dimension(400,50));
			jPanel1.add(button,gbConstraints); 
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					close();
					PlaySavedGame pSavedGame = new PlaySavedGame();
					main.setPlaySavedGame(pSavedGame);
					pSavedGame.setFilename(filename);
					try {
						pSavedGame.loadFile(filename);
					} catch (IOException ex) {
						System.err.println(ex.getMessage());
					}
					 main.showPlaySavedGame();
	 //               pSavedGame.setVisible(true);
				}
			});
		}
    }
	
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filePanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        mainMenuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        filePanel.setViewportView(jPanel1);

        mainMenuButton.setText("Main Menu");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(filePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainMenuButton)
                    .addComponent(filePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        close();
		main.showStartMenu();
//        startMenu sM = new startMenu();
//        sM.setVisible(true);
    }//GEN-LAST:event_mainMenuButtonActionPerformed

    /**
     * The main class which implements the nimbus and display the form
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane filePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mainMenuButton;
    // End of variables declaration//GEN-END:variables
}
