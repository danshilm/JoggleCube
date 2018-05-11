/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameFrames;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import uk.ac.aber.cs221.aumgroup.gameFrames.GameMainClass;
import uk.ac.aber.cs221.aumgroup.gameLogic.*;

/**
 *
 * @author naail
 */
public class ScoreMenu extends javax.swing.JFrame {
   //class variables
    
   //grids
   private Grid pGgrid1;
   private Grid pGgrid2;
   private Grid pGgrid3;
   //playerScore is the current player's score
   private int playerScore=0;
   //players stores all the previous players or ten best players
   private ArrayList<Player> players = new ArrayList<>();
   //gamePlayer is the current player
   private Player gamePlayer = new Player();
   //stores whether the game played was a new one
   private boolean isNew;
   //stores the path of the file loaded or to be saved
   private File loadedFile;
   private GameMainClass main;
   
   
    /**
     * Creates new form ScoreMenu
     */
    public ScoreMenu() {
        initComponents();
        //display the game over menu to the user
        gameOverPane.setVisible(true);
        //do not display the highScorePane or saveGamePane yet
        highScorePane.setVisible(false);
        saveGamePane.setVisible(false);
        //check whether it is a new game
        //checking();
		main = new GameMainClass();
		main.setScoreMenu(this);
    }
    
    /**
     * This method check the game type then
     * it calls the required method(s) and displays
     * the appropriate pane(s). 
     */
    public void checking(){
        
        //is a new game
        if(isNew()){
            
            //load the highscore file
            try {
                //System.out.println("Reading highScore file");
                loadScoreBoard();
            } catch (Exception ex) {
                System.err.println("File not found");
            }
            /*
            add the game player to the list of best players to check
            if its score is among the ten best
            */
            players.add(gamePlayer);
            //if player is among best ten then record its name
            if(isAmongBest()){
                gameOverPane.setVisible(false);
                highScorePane.setVisible(true);
            }else{
                gameOverPane.setVisible(true);
                saveGameButton.setVisible(true);
                highScorePane.setVisible(false);
            }


        }//upon completion of a saved game, the player has to enter its name
        else{
            gameOverPane.setVisible(false);
            saveGameButton.setVisible(false);
            highScorePane.setVisible(true);
            highScoreText.setText("Saving game");
        }
    }
    
    /**
     * This method sets the game type
     * @param isNew whether it is a new game or not
     */
    public void setGameType(boolean isNew){
        this.isNew = isNew;
    }
    
    /**
     * The method returns whether the game is a new game or a loaded game
     * @return true or false
     */
    public boolean isNew(){
        return isNew;
    }
    
    /**
     * This method sets the name of the file from which the game was loaded
     * @param filename
     */
    public void setFilename(String filename){
        loadedFile = new File("resources/savedGames/"+filename);
    }

    /**
     * This method gets the details of all the players who have played the saved game
     * @param previousPlayers all the players who have played the game before
     */
    public void setPlayers(ArrayList<Player> previousPlayers){
        for(Player p:previousPlayers){
            players.add(p);
        }
    }
    /**
     * This method gets all the details of the game played
     * @param grid1 the first grid
     * @param grid2 the second grid
     * @param grid3 the third grid
     * @param score the player's score
     */
    public void getCopyPlayedGame(Grid grid1,Grid grid2,Grid grid3,int score){
        pGgrid1 = grid1;
        pGgrid2 = grid2;
        pGgrid3 = grid3;
        gamePlayer.setScore(score);
    }

    /**
     * This method check if the player's score is among the top ten
     * @return true or false
     */
    private boolean isAmongBest(){
        
        //sort the players according to their score in descending order
       Collections.sort(players,Collections.reverseOrder());
       
       /*if players contains less than 10 Player
       then it is automatically in the top 10
       */
       if(players.size() < 11){
            return true;
       }//if players cantain more than 10 Player and gamePlayer rank is less than 10
       else if((players.size() > 10) && (players.indexOf(gamePlayer) < 10)){

           return true;
       }
       //players's size is more than and gamePlayer's rank is more than 10
       return false;
    }

    /**
     * This method updates the highScore file
     * @throws IOException 
     */
    private void updateScoreBoard() throws IOException{
         PrintWriter outfile = new PrintWriter(new FileWriter("highScore.txt"));

            
            //get number of players in the list
            int numPlayers = players.size();
            
            //only the ten best scores have to be stored
            if (numPlayers > 10){
                numPlayers = 10;
            }
            
            //copy the number of players details to be stored in the file
            outfile.println(numPlayers);
            
            //copy the details of the best layers to the highScore file
            for(int i=0; i<numPlayers; i++){
                Player p = players.get(i);
                //write the player's name
                outfile.println(p.getName());
                //write the player's score
                outfile.println(p.getScore());
            }
        //close the file
        outfile.close();
    }
    /**
     * This method saves a new game
     * @param filename the directory and the filename in which the new game has to be saved
     * @throws IOException
     */
    public void saveNewGame(File filename) throws IOException{
        PrintWriter outfile = new PrintWriter(new FileWriter(filename));

        //save the 3 grids in the file
        pGgrid1.saveGrid(outfile);
        pGgrid2.saveGrid(outfile);
        pGgrid3.saveGrid(outfile);

        //print the number of players who have played the game
        //for a new game the number of players is alwasys one
        outfile.println("1");
        
        //write the player's name
        outfile.println(gamePlayer.getName());
        
        //write the player's score
        outfile.println(gamePlayer.getScore());
        
        //close the file
        outfile.close();
    }
    /**
     * This method loads the high score file
     * @throws Exception
     */
    public void loadScoreBoard()
            throws Exception{

        Player player;

        try{
            Scanner infile = new Scanner(new FileReader("highScore.txt"));
             String line = infile.nextLine().trim();

             //check whether the file is empty, if not, copy the file's content into an arrayList
           if (!line.isEmpty()){
               //get the number of players deatails stored in the file
                int numplayers = Integer.parseInt(line);

            //get all the best players from the file
            for(int i=0; i<numplayers; i++) {
                
              //read the current player's name from the file
                String name = infile.nextLine();
                //read the current player's score from the file
                int pscore = Integer.parseInt(infile.nextLine());
                
               //instantiate that player
                player = new Player(name, pscore);
                
                //add the player to the list of best players
                players.add(player);
            }
        }
        //close the file
        infile.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * This method saves a loaded game.
     * It writes the letters in the grid, the number of previous players
     * and those players name and score to the file
     * @throws IOException 
     */
     public void saveLoadGame() throws IOException{
        PrintWriter outfile = new PrintWriter(new FileWriter(loadedFile));

        //save the grids
        pGgrid1.saveGrid(outfile);
        pGgrid2.saveGrid(outfile);
        pGgrid2.saveGrid(outfile);

        //sort the players according to their score in descending order
        Collections.sort(players,Collections.reverseOrder());
        
        //write the number of previous players to the file
        outfile.println(players.size());
       
        //For each of the player's name and score in players write it to the file
        for(Player p : players){
            //write the player name
            outfile.println(p.getName());
            //write the player score
            outfile.println(p.getScore());
        }
        
        //close the file
        outfile.close();

    }

     /**
      * This method check if a textField contain any special characters or is empty
      * and then it updates the label if needed
      * @param textField the input to be checked
      * @param label
      * @return null or the player's input text
      */
    private String characterCheck(JTextField textField,JLabel label){
        
        //name or filename cannot contain special characters
        if(!textField.getText().matches("\\w*")){
            label.setText("Special characters not allowed");
            //clear the text field
            textField.setText("");
            return null;
        }//JTextFiled returns empty string not null
        else if(textField.getText().equals("")){
            return null;
        }
        /*have to check if the input is a word cannot just 
        check if it is not null*/
        else if(textField.getText().matches("\\w*")){
            return textField.getText();
        }
        return null;
    }

    public void close(){
        //close the current window
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        gameOverPane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        exitGameButton = new javax.swing.JButton();
        saveGameButton = new javax.swing.JButton();
        loadSavedGameButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        highScorePane = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        highScoreNameLabel = new javax.swing.JLabel();
        confirmNameButton = new javax.swing.JButton();
        highScoreNameField = new javax.swing.JTextField();
        highScoreText = new javax.swing.JLabel();
        saveGamePane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        saveGameNameField = new javax.swing.JTextField();
        filenameField = new javax.swing.JTextField();
        confirmSaveButton = new javax.swing.JButton();
        saveGameNameLabel = new javax.swing.JLabel();
        cancelSaveButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        saveGameFilenameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 221, 255));

        exitGameButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exitGameButton.setText("Exit Game");
        exitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameButtonActionPerformed(evt);
            }
        });

        saveGameButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveGameButton.setText("Save Game");
        saveGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameButtonActionPerformed(evt);
            }
        });

        loadSavedGameButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loadSavedGameButton.setText("Load Game");
        loadSavedGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadSavedGameButtonActionPerformed(evt);
            }
        });

        newGameButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newGameButton.setText("New Game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadSavedGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(saveGameButton)
                .addGap(18, 18, 18)
                .addComponent(newGameButton)
                .addGap(18, 18, 18)
                .addComponent(loadSavedGameButton)
                .addGap(18, 18, 18)
                .addComponent(exitGameButton)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout gameOverPaneLayout = new javax.swing.GroupLayout(gameOverPane);
        gameOverPane.setLayout(gameOverPaneLayout);
        gameOverPaneLayout.setHorizontalGroup(
            gameOverPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameOverPaneLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        gameOverPaneLayout.setVerticalGroup(
            gameOverPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameOverPaneLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(45, 221, 255));

        highScoreNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        highScoreNameLabel.setText("Enter Name");

        confirmNameButton.setText("Ok");
        confirmNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmNameButtonActionPerformed(evt);
            }
        });

        highScoreNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highScoreNameFieldActionPerformed(evt);
            }
        });

        highScoreText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        highScoreText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScoreText.setText("HIGH SCORE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highScoreText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(highScoreNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScoreNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(highScoreText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(highScoreNameLabel)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(highScoreNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout highScorePaneLayout = new javax.swing.GroupLayout(highScorePane);
        highScorePane.setLayout(highScorePaneLayout);
        highScorePaneLayout.setHorizontalGroup(
            highScorePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highScorePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        highScorePaneLayout.setVerticalGroup(
            highScorePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highScorePaneLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(45, 221, 255));

        saveGameNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameNameFieldActionPerformed(evt);
            }
        });

        confirmSaveButton.setText("OK");
        confirmSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSaveButtonActionPerformed(evt);
            }
        });

        saveGameNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveGameNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saveGameNameLabel.setText("Enter your name");

        cancelSaveButton.setText("Cancel");
        cancelSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSaveButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SAVE GAME");

        saveGameFilenameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveGameFilenameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        saveGameFilenameLabel.setText("Enter filename");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveGameNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveGameFilenameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(cancelSaveButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(confirmSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(filenameField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(saveGameNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(saveGameNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveGameNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveGameFilenameLabel)
                .addGap(4, 4, 4)
                .addComponent(filenameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout saveGamePaneLayout = new javax.swing.GroupLayout(saveGamePane);
        saveGamePane.setLayout(saveGamePaneLayout);
        saveGamePaneLayout.setHorizontalGroup(
            saveGamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveGamePaneLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        saveGamePaneLayout.setVerticalGroup(
            saveGamePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saveGamePaneLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLayeredPane1.setLayer(gameOverPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(highScorePane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(saveGamePane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(gameOverPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(268, 268, 268)
                    .addComponent(highScorePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(saveGamePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(125, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(gameOverPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(250, 250, 250)
                    .addComponent(highScorePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(163, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(192, 192, 192)
                    .addComponent(saveGamePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(139, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void highScoreNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highScoreNameFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_highScoreNameFieldActionPerformed

    private void confirmNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmNameButtonActionPerformed
        // TODO add your handling code here:
        String name = null;
       // highScoreNameLabel.setText("Enter your Name");
        name = characterCheck(highScoreNameField,highScoreNameLabel);
        gamePlayer.setName(name);

        //if the name field is not empty
        if(name != null){
            //check if it is a new game
            if(isNew()){

                try {
                    //update the highscore file
                    updateScoreBoard();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
                //take the user back to the gameOver pane 
                highScorePane.setVisible(false);
                gameOverPane.setVisible(true);
                saveGameButton.setVisible(true);

            }//if it is a saved game we have to get the player's name to save it among the previous players
            else if(!isNew()){
                
                try {
                    //add gamePlayer among the previous players
                    players.add(gamePlayer);
					System.out.println(gamePlayer.getName());
					System.out.println(gamePlayer.getScore());
                    //save the game
                    saveLoadGame();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
                //take the player back to the gameOver pane
                highScorePane.setVisible(false);
                gameOverPane.setVisible(true);
                //prevent the player from saving an already saved game
                saveGameButton.setVisible(false);

            }
        }
    }//GEN-LAST:event_confirmNameButtonActionPerformed

   
    private void confirmSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSaveButtonActionPerformed
        // TODO add your handling code here:
        //name stores the ioutput of the charcter check method
        String name = null;
        saveGameNameLabel.setText("Enter your name");
        saveGameFilenameLabel.setText("Enter filename");
        // if the player is not among the top ten then ask him for its name
        if(!isAmongBest()){
            //check the user's input
            name = characterCheck(saveGameNameField,saveGameNameLabel);
            //set gamePlayer's name
            gamePlayer.setName(name);
            
        }
        
        //filename is set to null so that a file without name is not created
        String filename = null;
        //check the filename input by the user
        filename = characterCheck(filenameField,saveGameFilenameLabel);
        boolean fileNotExist = false;
        //if the input is correct check whether file exixts already
        if((filename != null)&&(gamePlayer.getName()!= null)){
            filename = filename+".txt";
            File savedFiles = new File("resources/savedGames/"+filename);
            try {    
                fileNotExist = savedFiles.createNewFile();
                if(!fileNotExist){
                saveGameFilenameLabel.setText("Filename already exists");
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }     
        }
       
        //if the filename entered is not 
        if((fileNotExist)){
             File nameFile = new File("resources/savedGames/"+ filenameField.getText() + ".txt");

            try {
                saveNewGame(nameFile);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            //take the user back to the score menu
            saveGamePane.setVisible(false);
            saveGameButton.setVisible(false);
            gameOverPane.setVisible(true);
        }
    }//GEN-LAST:event_confirmSaveButtonActionPerformed

    private void cancelSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSaveButtonActionPerformed
        // TODO add your handling code here:
        saveGamePane.setVisible(false);
        gameOverPane.setVisible(true);
    }//GEN-LAST:event_cancelSaveButtonActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        // TODO add your handling code here:
        close();
		main.showPlayGame();
//        playGame pG = new playGame();
//        pG.setVisible(true);
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void loadSavedGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadSavedGameButtonActionPerformed
        // TODO add your handling code here:
        close();
		main.showSelectGame();
//        SelectGame sG = new SelectGame();
//        sG.setVisible(true);

    }//GEN-LAST:event_loadSavedGameButtonActionPerformed

    private void saveGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameButtonActionPerformed
        // TODO add your handling code here:
        gameOverPane.setVisible(false);
        saveGamePane.setVisible(true);
        //if it is a new game and the player is among the best ten
        // the system would already have the name of the player
        if(isAmongBest()){
            //do not ask the player for its name again
            saveGameNameLabel.setVisible(false);
            saveGameNameField.setVisible(false);
        }//if the player is not among the top ten, ask for its name
        else{
            saveGameNameLabel.setVisible(true);
            saveGameNameField.setVisible(true);
        }
    }//GEN-LAST:event_saveGameButtonActionPerformed

    private void exitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameButtonActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_exitGameButtonActionPerformed

    private void saveGameNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveGameNameFieldActionPerformed

    /**
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
            java.util.logging.Logger.getLogger(ScoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelSaveButton;
    private javax.swing.JButton confirmNameButton;
    private javax.swing.JButton confirmSaveButton;
    private javax.swing.JButton exitGameButton;
    private javax.swing.JTextField filenameField;
    private javax.swing.JPanel gameOverPane;
    private javax.swing.JTextField highScoreNameField;
    private javax.swing.JLabel highScoreNameLabel;
    private javax.swing.JPanel highScorePane;
    private javax.swing.JLabel highScoreText;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loadSavedGameButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton saveGameButton;
    private javax.swing.JLabel saveGameFilenameLabel;
    private javax.swing.JTextField saveGameNameField;
    private javax.swing.JLabel saveGameNameLabel;
    private javax.swing.JPanel saveGamePane;
    // End of variables declaration//GEN-END:variables
}
