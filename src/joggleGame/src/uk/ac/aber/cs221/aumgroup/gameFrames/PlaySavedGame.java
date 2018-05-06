/*
 * @PlaySavedGame.java 2.0 2018/05/06
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import uk.ac.aber.cs221.aumgroup.gameLogic.Letter;
import uk.ac.aber.cs221.aumgroup.gameLogic.Tile;
import uk.ac.aber.cs221.aumgroup.gameLogic.Grid;
import uk.ac.aber.cs221.aumgroup.gameLogic.Player;
import uk.ac.aber.cs221.aumgroup.gameLogic.PositionInGrid;

/**
 * The PlaySavedGame implements the load game option that
 * prompts the user to choose the saved file he wishes to load
 * and loads it, allowing the user to play
 * 
 * @author nah37, the12, dkm4
 * @version 1.0 initial development
 * @version 2.0 added score board of past top 10 players
 * @see Grid
 * @see Tile
 */
public class PlaySavedGame extends javax.swing.JFrame {
	
    /**
     * Creates new form PlaySavedGame as well as populate the grids
	 * and passes a reference of the frame to the main class
     */
    public PlaySavedGame() {
        initComponents();
        populateGrids();
		main = new GameMainClass();
		main.setPlaySavedGame(this);
		
    }
	
	public void loadFile(String filename) 
           throws IOException{
        Scanner infile =  new Scanner(new FileReader("savedGames/"+filename));
        Player player;
        //set the letters of the grids   
        grid1Tiles = new Tile[] { g1R0C0, g1R0C1, g1R0C2, g1R1C0, g1R1C1, g1R1C2, g1R2C0, g1R2C1, g1R2C2 };
        grid1.setAllTiles(grid1Tiles);
        grid1.setLetters(readLetters(infile));
        grid1.populateGrid();
        
        grid2Tiles = new Tile[] { g2R0C0, g2R0C1, g2R0C2, g2R1C0, g2R1C1, g2R1C2, g2R2C0, g2R2C1, g2R2C2 };
        grid2.setAllTiles(grid2Tiles);
        grid2.setLetters(readLetters(infile));
        grid2.populateGrid();
        
        grid3Tiles = new Tile[] { g3R0C0, g3R0C1, g3R0C2, g3R1C0, g3R1C1, g3R1C2, g3R2C0, g3R2C1, g3R2C2 };
        grid3.setAllTiles(grid3Tiles);
        grid3.setLetters(readLetters(infile));
        grid3.populateGrid();
        
        //get the number of players who have played the game
        int numPlayers = Integer.parseInt(infile.nextLine());
        scoreBoardPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.insets = new Insets(5,20,5,20);
        
        for(int playerNo=0; playerNo<numPlayers; playerNo++){
            //read player name
            String name = infile.nextLine();
            //add the player's name to the scoreboard
            JLabel nameLabel = new JLabel(name);
            nameLabel.setSize(new Dimension(200,50));
            gbConstraints.gridx = 0;
            scoreBoardPanel.add(nameLabel,gbConstraints);
            
            //read player score
            String score = infile.nextLine();
            JLabel scoreLabel = new JLabel(score);
            scoreLabel.setSize(new Dimension(200,50));
            gbConstraints.gridx = 1;
            scoreBoardPanel.add(scoreLabel,gbConstraints);
            player = new Player(name,Integer.parseInt(score));
            previousPlayers.add(player);
        }
        
        
    }
	
	/**
	 * This method is used to read the letters that make up each grid from the file that the player has chosen
	 * @param infile the file from which to read the grids from
	 * @return an array list of letters that are to be populated in the grids
	 * @throws IOException if the file cannot be read
	 */
    private List<Letter> readLetters(Scanner infile) throws IOException{
        List<Letter> gridLetters = new ArrayList<>(9);
        Letter letter;
        
            //read the three lines corresponding to the letters in a grid
        for(int row=0; row<3; row++){
            String rowLetters="";
            rowLetters = infile.nextLine();
            
            //the first letter in the line is at position 0
            int pos=0;
            //add the letters in the list 
            while(pos < rowLetters.length()){
                //instantiate Letter
                 letter = new Letter();
                //Qu is considered as one letter
                if(rowLetters.charAt(pos)== 'Q'){
                    //Q is followed by u
                    letter.setCharacter("Qu");
                    //increment pos so that in the next iteration u is not read as a different letter
                    pos++;
                    //add Qu to the list
                    gridLetters.add(letter);
                }else{
                    System.out.println(valueOf(rowLetters.charAt(pos)));
                    letter.setCharacter(valueOf(rowLetters.charAt(pos)));
                    gridLetters.add(letter);
                }
                //increment pos to read next letter
                pos++;
            
            }
        }
        return gridLetters;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        countdownIcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        correctWordsList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        clearWordBtn = new javax.swing.JButton();
        addWordBtn = new javax.swing.JButton();
        currentWordField = new javax.swing.JTextField();
        changeViewBtn = new javax.swing.JButton();
        grid1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Grid();
        g1R0C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(0, 0));
        g1R0C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(0, 1));
        g1R0C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(0, 2));
        g1R1C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(1, 2));
        g1R1C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(1, 1));
        g1R1C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(1, 0));
        g1R2C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(2, 0));
        g1R2C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(2, 1));
        g1R2C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid1, new PositionInGrid(2, 2));
        grid2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Grid();
        g2R0C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(0, 0));
        g2R0C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(0, 1));
        g2R0C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(0, 2));
        g2R1C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(1, 2));
        g2R1C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(1, 1));
        g2R1C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(1, 0));
        g2R2C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(2, 0));
        g2R2C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(2, 1));
        g2R2C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid2, new PositionInGrid(2, 2));
        grid3 = new uk.ac.aber.cs221.aumgroup.gameLogic.Grid();
        g3R0C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(0, 0));
        g3R0C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(0, 1));
        g3R0C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(0, 2));
        g3R1C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(1, 2));
        g3R1C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(1, 1));
        g3R1C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(1, 0));
        g3R2C0 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(2, 0));
        g3R2C1 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(2, 1));
        g3R2C2 = new uk.ac.aber.cs221.aumgroup.gameLogic.Tile(grid3, new PositionInGrid(2, 2));
        warningLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        scoreBoardPanel = new javax.swing.JPanel();
        nameHeader = new javax.swing.JLabel();
        scoreHeader = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        scoreIcon = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Game Play"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(45, 221, 255));

        countdownIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/aber/cs221/aumgroup/gameIcons/Programming-Watch-icon.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));

        correctWordsList.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        correctWordsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(correctWordsList);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CORRECT WORDS");

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));

        clearWordBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clearWordBtn.setText("Clear Word");
        clearWordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearWordBtn(evt);
            }
        });

        addWordBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addWordBtn.setText("Add word");
        addWordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWordBtn(evt);
            }
        });

        currentWordField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        currentWordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentWordField.setName("currentWordField"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentWordField, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(clearWordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addWordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentWordField)
                    .addComponent(addWordBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(clearWordBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        changeViewBtn.setText("Change View");

        grid1.setBackground(new java.awt.Color(45, 221, 255));
        grid1.setGridNo(1);

        g1R0C0.setBackground(new java.awt.Color(255, 255, 255));
        g1R0C0.setText("A");
        g1R0C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.A));
        g1R0C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R0C0.setName("g1R0C0"); // NOI18N
        g1R0C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R0C1.setBackground(new java.awt.Color(255, 255, 255));
        g1R0C1.setText("Q");
        g1R0C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.Qu));
        g1R0C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R0C1.setName("g1R0C1"); // NOI18N
        g1R0C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R0C2.setBackground(new java.awt.Color(255, 255, 255));
        g1R0C2.setText("W");
        g1R0C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.W));
        g1R0C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R0C2.setName("g1R0C2"); // NOI18N
        g1R0C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R1C2.setBackground(new java.awt.Color(255, 255, 255));
        g1R1C2.setText("M");
        g1R1C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.M));
        g1R1C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R1C2.setName("g1R1C2"); // NOI18N
        g1R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R1C1.setBackground(new java.awt.Color(255, 255, 255));
        g1R1C1.setText("D");
        g1R1C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.D));
        g1R1C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R1C1.setName("g1R1C1"); // NOI18N
        g1R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R1C0.setBackground(new java.awt.Color(255, 255, 255));
        g1R1C0.setText("V");
        g1R1C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.V));
        g1R1C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R1C0.setName("g1R1C0"); // NOI18N
        g1R1C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R2C0.setBackground(new java.awt.Color(255, 255, 255));
        g1R2C0.setText("S");
        g1R2C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.S));
        g1R2C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R2C0.setName("g1R2C0"); // NOI18N
        g1R2C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R2C1.setBackground(new java.awt.Color(255, 255, 255));
        g1R2C1.setText("A");
        g1R2C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.A));
        g1R2C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R2C1.setName("g1R2C1"); // NOI18N
        g1R2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R2C2.setBackground(new java.awt.Color(255, 255, 255));
        g1R2C2.setText("W");
        g1R2C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.W));
        g1R2C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g1R2C2.setName("g1R2C2"); // NOI18N
        g1R2C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        javax.swing.GroupLayout grid1Layout = new javax.swing.GroupLayout(grid1);
        grid1.setLayout(grid1Layout);
        grid1Layout.setHorizontalGroup(
            grid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grid1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(grid1Layout.createSequentialGroup()
                            .addComponent(g1R1C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(g1R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g1R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(grid1Layout.createSequentialGroup()
                            .addComponent(g1R0C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g1R0C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g1R0C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(grid1Layout.createSequentialGroup()
                        .addComponent(g1R2C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(g1R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(g1R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        grid1Layout.setVerticalGroup(
            grid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grid1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g1R0C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1R0C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1R0C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g1R1C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(grid1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g1R2C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        grid2.setBackground(new java.awt.Color(45, 221, 255));
        grid2.setGridNo(2);

        g2R0C0.setBackground(new java.awt.Color(255, 255, 255));
        g2R0C0.setText("A");
        g2R0C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.A));
        g2R0C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R0C0.setName("g2R0C0"); // NOI18N
        g2R0C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R0C1.setBackground(new java.awt.Color(255, 255, 255));
        g2R0C1.setText("Q");
        g2R0C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.Qu));
        g2R0C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R0C1.setName("g2R0C1"); // NOI18N
        g2R0C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R0C2.setBackground(new java.awt.Color(255, 255, 255));
        g2R0C2.setText("W");
        g2R0C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.W));
        g2R0C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R0C2.setName("g2R0C2"); // NOI18N
        g2R0C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R1C2.setBackground(new java.awt.Color(255, 255, 255));
        g2R1C2.setText("M");
        g2R1C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.M));
        g2R1C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R1C2.setName("g2R1C2"); // NOI18N
        g2R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R1C1.setBackground(new java.awt.Color(255, 255, 255));
        g2R1C1.setText("D");
        g2R1C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.D));
        g2R1C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R1C1.setName("g2R1C1"); // NOI18N
        g2R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R1C0.setBackground(new java.awt.Color(255, 255, 255));
        g2R1C0.setText("V");
        g2R1C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.V));
        g2R1C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R1C0.setName("g2R1C0"); // NOI18N
        g2R1C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R2C0.setBackground(new java.awt.Color(255, 255, 255));
        g2R2C0.setText("S");
        g2R2C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.S));
        g2R2C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R2C0.setName("g2R2C0"); // NOI18N
        g2R2C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R2C1.setBackground(new java.awt.Color(255, 255, 255));
        g2R2C1.setText("A");
        g2R2C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.A));
        g2R2C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R2C1.setName("g2R2C1"); // NOI18N
        g2R2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R2C2.setBackground(new java.awt.Color(255, 255, 255));
        g2R2C2.setText("W");
        g2R2C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.W));
        g2R2C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g2R2C2.setName("g2R2C2"); // NOI18N
        g2R2C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        javax.swing.GroupLayout grid2Layout = new javax.swing.GroupLayout(grid2);
        grid2.setLayout(grid2Layout);
        grid2Layout.setHorizontalGroup(
            grid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grid2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(grid2Layout.createSequentialGroup()
                            .addComponent(g2R1C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(g2R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g2R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(grid2Layout.createSequentialGroup()
                            .addComponent(g2R0C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g2R0C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g2R0C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(grid2Layout.createSequentialGroup()
                        .addComponent(g2R2C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(g2R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(g2R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        grid2Layout.setVerticalGroup(
            grid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grid2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g2R0C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2R0C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2R0C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g2R1C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(grid2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g2R2C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        grid3.setBackground(new java.awt.Color(45, 221, 255));
        grid3.setGridNo(3);

        g3R0C0.setBackground(new java.awt.Color(255, 255, 255));
        g3R0C0.setText("A");
        g3R0C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.A));
        g3R0C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R0C0.setName("g3R0C0"); // NOI18N
        g3R0C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R0C1.setBackground(new java.awt.Color(255, 255, 255));
        g3R0C1.setText("Q");
        g3R0C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.Qu));
        g3R0C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R0C1.setName("g3R0C1"); // NOI18N
        g3R0C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R0C2.setBackground(new java.awt.Color(255, 255, 255));
        g3R0C2.setText("W");
        g3R0C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.W));
        g3R0C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R0C2.setName("g3R0C2"); // NOI18N
        g3R0C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R1C2.setBackground(new java.awt.Color(255, 255, 255));
        g3R1C2.setText("M");
        g3R1C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.M));
        g3R1C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R1C2.setName("g3R1C2"); // NOI18N
        g3R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R1C1.setBackground(new java.awt.Color(255, 255, 255));
        g3R1C1.setText("D");
        g3R1C1.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.D));
        g3R1C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R1C1.setName("g3R1C1"); // NOI18N
        g3R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R1C0.setBackground(new java.awt.Color(255, 255, 255));
        g3R1C0.setText("V");
        g3R1C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.V));
        g3R1C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R1C0.setName("g3R1C0"); // NOI18N
        g3R1C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R2C0.setBackground(new java.awt.Color(255, 255, 255));
        g3R2C0.setText("S");
        g3R2C0.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.S));
        g3R2C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R2C0.setName("g3R2C0"); // NOI18N
        g3R2C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R2C1.setBackground(new java.awt.Color(255, 255, 255));
        g3R2C1.setText("A");
        g3R2C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R2C1.setName("g3R2C1"); // NOI18N
        g3R2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R2C2.setBackground(new java.awt.Color(255, 255, 255));
        g3R2C2.setText("W");
        g3R2C2.assignLetter(new Letter(uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation.W));
        g3R2C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R2C2.setName("g3R2C2"); // NOI18N
        g3R2C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        javax.swing.GroupLayout grid3Layout = new javax.swing.GroupLayout(grid3);
        grid3.setLayout(grid3Layout);
        grid3Layout.setHorizontalGroup(
            grid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grid3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(grid3Layout.createSequentialGroup()
                            .addComponent(g3R1C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(g3R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g3R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(grid3Layout.createSequentialGroup()
                            .addComponent(g3R0C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g3R0C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(g3R0C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(grid3Layout.createSequentialGroup()
                        .addComponent(g3R2C0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(g3R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(g3R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        grid3Layout.setVerticalGroup(
            grid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grid3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g3R0C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3R0C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3R0C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g3R1C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(grid3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(g3R2C0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        warningLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 0, 0));

        nameHeader.setText("Name");

        scoreHeader.setText("Score");

        javax.swing.GroupLayout scoreBoardPanelLayout = new javax.swing.GroupLayout(scoreBoardPanel);
        scoreBoardPanel.setLayout(scoreBoardPanelLayout);
        scoreBoardPanelLayout.setHorizontalGroup(
            scoreBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scoreBoardPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(nameHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(scoreHeader)
                .addGap(56, 56, 56))
        );
        scoreBoardPanelLayout.setVerticalGroup(
            scoreBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scoreBoardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scoreBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameHeader)
                    .addComponent(scoreHeader))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(scoreBoardPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(grid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(312, 312, 312)
                                        .addComponent(changeViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(grid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(grid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 13, Short.MAX_VALUE)))))))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(grid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(changeViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(grid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(grid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)))))
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        scoreIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/aber/cs221/aumgroup/gameIcons/favourites-star-SH-icon.png"))); // NOI18N

        scoreLabel.setFont(new java.awt.Font("Agency FB", 1, 28)); // NOI18N
        scoreLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(countdownIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scoreIcon)
                        .addGap(18, 18, 18)
                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(countdownIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        countdownIcon.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * This method is used to populate the 3 grids with tiles
	 * that each have a randomly generated letter
	 */
    private void populateGrids() {
		grid1Tiles = new Tile[] { g1R0C0, g1R0C1, g1R0C2, g1R1C0, g1R1C1, g1R1C2, g1R2C0, g1R2C1, g1R2C2 };
        grid1.setAllTiles(grid1Tiles);
        grid1.generateRandomLetters();
        grid1.populateGrid();
		grid2Tiles = new Tile[] { g2R0C0, g2R0C1, g2R0C2, g2R1C0, g2R1C1, g2R1C2, g2R2C0, g2R2C1, g2R2C2 };
        grid2.setAllTiles(grid2Tiles);
        grid2.generateRandomLetters();
        grid2.populateGrid();
		grid3Tiles = new Tile[] { g3R0C0, g3R0C1, g3R0C2, g3R1C0, g3R1C1, g3R1C2, g3R2C0, g3R2C1, g3R2C2 };
        grid3.setAllTiles(grid3Tiles);
        grid3.generateRandomLetters();
        grid3.populateGrid();
    }
    
	/**
	 * This is the method that handle the user clicking on a tile
	 * If the tile is selectable, it will highlight the tiles that the user can use next
	 * else it will display a warning
	 * @param evt the event being listened for
	 */
    private void handleTileAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleTileAction
        main.handleTileAction(evt, warningLabel);
    }//GEN-LAST:event_handleTileAction
	/**
	 * This is the method called when the player clicks on the "clear" button
	 * It clears the selection of tiles as well as the currently selected word shown
	 * @param evt the event being listened for
	 */
    private void clearWordBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearWordBtn
		main.clearTileSelection();
		main.clearCurrentWord();
    }//GEN-LAST:event_clearWordBtn
	/**
	 * This method is used when the player clicks on the "add word" button
	 * It first checks if the player has already input this word
	 * if he has, a warning is shown
	 * then it checks if the word is a valid word
	 * if it is, then the score is updated and the word is added to the list of correct words for that player
	 * if the word is not a valid one, a warning is shown
	 * @param evt the event being listened for
	 */
    private void addWordBtn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWordBtn
        main.printCurrentWord();
		try {
			if (main.isNotAlreadyInList(correctWordsList)) {
				if (main.isValidWordThenUpdateScore(scoreLabel)) {
					main.addCurrentWordToList(correctWordsList);
				} else {
					main.wrongWord(warningLabel);
				}
			} else {
				main.wordAlreadyInList(warningLabel);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(PlayGame.class.getName()).log(Level.SEVERE, null, ex);
		}
    }//GEN-LAST:event_addWordBtn
	
	/**
	 * This is the getter method for the text field where the currently selected word is shown
	 * @return JTextField displaying the current word
	 */
	public javax.swing.JTextField getCurrentWordField() {
		return currentWordField;
	}
	
	/**
	 * This method is used to update the contents of the current word field
	 * @param word the currently selected word that has to be displayed
	 */
	public void updateCurrentWordField(String word) {
		currentWordField.setText(word);
	}

	/**
	 * This method is used to get the first grid
	 * @return the first grid
	 */
	public Grid getGrid1() {
		return grid1;
	}
	
	/**
	 * This method is used to get the second grid
	 * @return the second grid
	 */
	public Grid getGrid2() {
		return grid2;
	}
	
	/**
	 * This method is used to get the third grid
	 * @return the third grid
	 */
	public Grid getGrid3() {
		return grid3;
	}
	
	/**
	 * This is the getter method for the player score being displayed
	 * @return the player's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * This is the setter method for the player score
	 * @param score new score of the player
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
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
            java.util.logging.Logger.getLogger(PlaySavedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaySavedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaySavedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaySavedGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaySavedGame().setVisible(true);
            }
			
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWordBtn;
    private javax.swing.JButton changeViewBtn;
    private javax.swing.JButton clearWordBtn;
    private javax.swing.JList<String> correctWordsList;
    private javax.swing.JLabel countdownIcon;
    public javax.swing.JTextField currentWordField;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R0C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R0C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R0C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R1C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R1C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R1C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R2C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R2C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g1R2C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R0C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R0C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R0C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R1C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R1C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R1C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R2C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R2C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g2R2C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R0C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R0C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R0C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R1C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R1C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R1C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R2C0;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R2C1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Tile g3R2C2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Grid grid1;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Grid grid2;
    private uk.ac.aber.cs221.aumgroup.gameLogic.Grid grid3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel nameHeader;
    private javax.swing.JPanel scoreBoardPanel;
    private javax.swing.JLabel scoreHeader;
    private javax.swing.JLabel scoreIcon;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
	private Tile[] grid1Tiles;
	private Tile[] grid2Tiles;
	private Tile[] grid3Tiles;
	private GameMainClass main;
	private int score = 0;
	private ArrayList<Player> previousPlayers = new ArrayList<>();
    private String savedFile;
	private DefaultListModel<String> playerWordList = new DefaultListModel<>();
}
