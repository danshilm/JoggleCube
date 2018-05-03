/*
 * @playGame.java 2.0 2018/05/04
 *
 * Copyright (c) 2018 Aberystwyth University.
 * All rights reserved.
 *
 */


package uk.ac.aber.cs221.aumgroup.gameFrames;

import uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation;
import uk.ac.aber.cs221.aumgroup.gameLogic.Letter;
import uk.ac.aber.cs221.aumgroup.gameLogic.Tile;
import uk.ac.aber.cs221.aumgroup.gameLogic.Grid;
import uk.ac.aber.cs221.aumgroup.gameLogic.PositionInGrid;

/**
 * The playGame implements the play game option that
 * displays the gamegird and allow the user to play
 * the game
 *
 * @author dkm4, the12, jty
 * @version 2.0 (24th April 2018)
 */
public class playGame extends javax.swing.JFrame {

    /**
     * Creates new form playGame
     */
    public playGame() {
        initComponents();
        populateGrids();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        countdownIcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
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
        jTextField2 = new javax.swing.JTextField();
        scoreIcon = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Game Play");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(45, 221, 255)); //set background color

        countdownIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/aber/cs221/aumgroup/gameIcons/Programming-Watch-icon.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));

        jList1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            /**
             * The getSize reutrns the length size of the word input
             * @return the length of the strings
             */
            public int getSize() {
                return strings.length;
            }

            /**
             * The getElementAt return the letter on the grid
             * @param i the letter grid on the game grid
             * @return the element of the grid at position i
             */
            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CORRECT WORDS");

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));

        clearWordBtn.setFont(new java.awt.Font("Tahoma", 0, 24));
        clearWordBtn.setText("Clear Word"); // add name of the button

        addWordBtn.setFont(new java.awt.Font("Tahoma", 0, 24));
        addWordBtn.setText("Add word"); // add name of the button

        currentWordField.setFont(new java.awt.Font("Tahoma", 1, 24));
        currentWordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        // set the properties the the jpanel
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
        // set the properties the the jpanel
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
        g1R0C0.assignLetter(new Letter(LetterPopulation.A));
        g1R0C0.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R0C0.setName("g1R0C0");
        g1R0C0.addActionListener(new java.awt.event.ActionListener() {
            /**
             * This class deals with the action performed once it
             * is clicked
             * @param evt the event that will performed
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R0C1.setBackground(new java.awt.Color(255, 255, 255));
        g1R0C1.setText("Q");
        g1R0C1.assignLetter(new Letter(LetterPopulation.Qu));
        g1R0C1.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R0C1.setName("g1R0C1");
        g1R0C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R0C2.setBackground(new java.awt.Color(255, 255, 255));
        g1R0C2.setText("W");
        g1R0C2.assignLetter(new Letter(LetterPopulation.W));
        g1R0C2.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R0C2.setName("g1R0C2");
        g1R0C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R1C2.setBackground(new java.awt.Color(255, 255, 255));
        g1R1C2.setText("M");
        g1R1C2.assignLetter(new Letter(LetterPopulation.M));
        g1R1C2.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R1C2.setName("g1R1C2");
        g1R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R1C1.setBackground(new java.awt.Color(255, 255, 255));
        g1R1C1.setText("D");
        g1R1C1.assignLetter(new Letter(LetterPopulation.D));
        g1R1C1.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R1C1.setName("g1R1C1");
        g1R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R1C0.setBackground(new java.awt.Color(255, 255, 255));
        g1R1C0.setText("V");
        g1R1C0.assignLetter(new Letter(LetterPopulation.V));
        g1R1C0.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R1C0.setName("g1R1C0");
        g1R1C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R2C0.setBackground(new java.awt.Color(255, 255, 255));
        g1R2C0.setText("S");
        g1R2C0.assignLetter(new Letter(LetterPopulation.S));
        g1R2C0.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R2C0.setName("g1R2C0");
        g1R2C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R2C1.setBackground(new java.awt.Color(255, 255, 255));
        g1R2C1.setText("A");
        g1R2C1.assignLetter(new Letter(LetterPopulation.A));
        g1R2C1.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R2C1.setName("g1R2C1");
        g1R2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g1R2C2.setBackground(new java.awt.Color(255, 255, 255));
        g1R2C2.setText("W");
        g1R2C2.assignLetter(new Letter(LetterPopulation.W));
        g1R2C2.setFont(new java.awt.Font("Agency FB", 1, 24));
        g1R2C2.setName("g1R2C2");
        g1R2C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        javax.swing.GroupLayout grid1Layout = new javax.swing.GroupLayout(grid1);
        grid1.setLayout(grid1Layout); //set the layout of the grid 1
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
        g2R0C0.assignLetter(new Letter(LetterPopulation.A));
        g2R0C0.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R0C0.setName("g2R0C0");
        g2R0C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R0C1.setBackground(new java.awt.Color(255, 255, 255));
        g2R0C1.setText("Q");
        g2R0C1.assignLetter(new Letter(LetterPopulation.Qu));
        g2R0C1.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R0C1.setName("g2R0C1");
        g2R0C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R0C2.setBackground(new java.awt.Color(255, 255, 255));
        g2R0C2.setText("W");
        g2R0C2.assignLetter(new Letter(LetterPopulation.W));
        g2R0C2.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R0C2.setName("g2R0C2");
        g2R0C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R1C2.setBackground(new java.awt.Color(255, 255, 255));
        g2R1C2.setText("M");
        g2R1C2.assignLetter(new Letter(LetterPopulation.M));
        g2R1C2.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R1C2.setName("g2R1C2");
        g2R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R1C1.setBackground(new java.awt.Color(255, 255, 255));
        g2R1C1.setText("D");
        g2R1C1.assignLetter(new Letter(LetterPopulation.D));
        g2R1C1.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R1C1.setName("g2R1C1");
        g2R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R1C0.setBackground(new java.awt.Color(255, 255, 255));
        g2R1C0.setText("V");
        g2R1C0.assignLetter(new Letter(LetterPopulation.V));
        g2R1C0.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R1C0.setName("g2R1C0"); // NOI18N
        g2R1C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R2C0.setBackground(new java.awt.Color(255, 255, 255));
        g2R2C0.setText("S");
        g2R2C0.assignLetter(new Letter(LetterPopulation.S));
        g2R2C0.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R2C0.setName("g2R2C0"); // NOI18N
        g2R2C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R2C1.setBackground(new java.awt.Color(255, 255, 255));
        g2R2C1.setText("A");
        g2R2C1.assignLetter(new Letter(LetterPopulation.A));
        g2R2C1.setFont(new java.awt.Font("Agency FB", 1, 24));
        g2R2C1.setName("g2R2C1");
        g2R2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g2R2C2.setBackground(new java.awt.Color(255, 255, 255));
        g2R2C2.setText("W");
        g2R2C2.assignLetter(new Letter(LetterPopulation.W));
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
        g3R0C0.assignLetter(new Letter(LetterPopulation.A));
        g3R0C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R0C0.setName("g3R0C0"); // NOI18N
        g3R0C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R0C1.setBackground(new java.awt.Color(255, 255, 255));
        g3R0C1.setText("Q");
        g3R0C1.assignLetter(new Letter(LetterPopulation.Qu));
        g3R0C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R0C1.setName("g3R0C1"); // NOI18N
        g3R0C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R0C2.setBackground(new java.awt.Color(255, 255, 255));
        g3R0C2.setText("W");
        g3R0C2.assignLetter(new Letter(LetterPopulation.W));
        g3R0C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R0C2.setName("g3R0C2"); // NOI18N
        g3R0C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R1C2.setBackground(new java.awt.Color(255, 255, 255));
        g3R1C2.setText("M");
        g3R1C2.assignLetter(new Letter(LetterPopulation.M));
        g3R1C2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R1C2.setName("g3R1C2"); // NOI18N
        g3R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R1C1.setBackground(new java.awt.Color(255, 255, 255));
        g3R1C1.setText("D");
        g3R1C1.assignLetter(new Letter(LetterPopulation.D));
        g3R1C1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R1C1.setName("g3R1C1"); // NOI18N
        g3R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R1C0.setBackground(new java.awt.Color(255, 255, 255));
        g3R1C0.setText("V");
        g3R1C0.assignLetter(new Letter(LetterPopulation.V));
        g3R1C0.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        g3R1C0.setName("g3R1C0"); // NOI18N
        g3R1C0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleTileAction(evt);
            }
        });

        g3R2C0.setBackground(new java.awt.Color(255, 255, 255));
        g3R2C0.setText("S");
        g3R2C0.assignLetter(new Letter(LetterPopulation.S));
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
        g3R2C2.assignLetter(new Letter(LetterPopulation.W));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        scoreIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/ac/aber/cs221/aumgroup/gameIcons/favourites-star-SH-icon.png"))); // NOI18N

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(countdownIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scoreIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(countdownIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(scoreIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(78, Short.MAX_VALUE))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This class populate the grid with the letters
     */
    private void populateGrids() {
        grid1Tiles = new Tile[]{g1R0C0, g1R0C1, g1R0C2, g1R1C0, g1R1C1, g1R1C2, g1R2C0, g1R2C1, g1R2C2};
        grid1.setAllTiles(grid1Tiles);
        grid1.generateRandomLetters();
        grid1.populateGrid();
        grid2Tiles = new Tile[]{g2R0C0, g2R0C1, g2R0C2, g2R1C0, g2R1C1, g2R1C2, g2R2C0, g2R2C1, g2R2C2};
        grid2.setAllTiles(grid2Tiles);
        grid2.generateRandomLetters();
        grid2.populateGrid();
        grid3Tiles = new Tile[]{g3R0C0, g3R0C1, g3R0C2, g3R1C0, g3R1C1, g3R1C2, g3R2C0, g3R2C1, g3R2C2};
        grid3.setAllTiles(grid3Tiles);
        grid3.generateRandomLetters();
        grid3.populateGrid();
    }

    /**
     * This handlieTileAction will allow the grid to light
     * up the same tile clicked on the other grid
     *
     * @param evt
     */
    private void handleTileAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleTileAction

        Tile tile = (Tile) evt.getSource();
        Grid parent = (Grid) tile.getParent();
        if (parent == grid1) {
            grid1.handleTileAction(evt, warningLabel);
        } else if (parent == grid2) {
            grid2.handleTileAction(evt, warningLabel);
        } else if (parent == grid3) {
            grid3.handleTileAction(evt, warningLabel);
        }
    }//GEN-LAST:event_handleTileAction

    /**
     * This main class set the nimbus and displays the gamegrid with all its
     * function avaialable
     *
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
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playGame().setVisible(true);
            }

        });
    }

    // Variables declaration //GEN-BEGIN:variables
    private javax.swing.JButton addWordBtn;
    private javax.swing.JButton changeViewBtn;
    private javax.swing.JButton clearWordBtn;
    private javax.swing.JLabel countdownIcon;
    private javax.swing.JTextField currentWordField;
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
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel scoreIcon;
    private javax.swing.JLabel warningLabel;
    private Tile[] grid1Tiles;
    private Tile[] grid2Tiles;
    private Tile[] grid3Tiles;
// End of variables declaration //GEN-END:variables
}
