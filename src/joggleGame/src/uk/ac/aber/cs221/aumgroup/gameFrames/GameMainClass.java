/*
 * @GameMainClass.java 2.2 2018/05/05
 *
 * Copyright (c) 2018 Aberystwyth University.
 * All rights reserved.
 *
 */

package uk.ac.aber.cs221.aumgroup.gameFrames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.Timer;
import uk.ac.aber.cs221.aumgroup.gameLogic.Dictionary;
import uk.ac.aber.cs221.aumgroup.gameLogic.Grid;
import uk.ac.aber.cs221.aumgroup.gameLogic.Letter;
import uk.ac.aber.cs221.aumgroup.gameLogic.PositionInGrid;
import uk.ac.aber.cs221.aumgroup.gameLogic.Tile;

/**
 * This is the main class where the game is populated,
 * where almost all the user interactions are handled
 * 
 * @author the12, dkm4, jty
 * @version 1.0 initial development (the12)
 * @version 2.0 moved the tile action handle here instead of Grid and added functionality for current word (dkm4)
 * @version 2.1 added javadoc (jty)
 * @version 2.2 added functionality for player score and list of correct words (dkm4)
 * @see Grid
 * @see Letter
 * @see GameHelp
 * @see GameScoreBoard
 * @see ScoreMenu
 * @see PlayGame
 * @see StartMenu
 * @see PlaySavedGame
 * @see Dictionary
 */
public class GameMainClass {

	// instances of the frames that make up the game so as to manipulate these
	private StartMenu startMenu;
	private PlayGame playGame;
	private PlaySavedGame playSavedGame;
	private GameHelp gameHelp;
	private GameScoreBoard gameScoreBoard;
	private ScoreMenu scoreMenu;
	private SelectGame selectGame;
	// this is the list of grids through which they will be manipulated
	private List<Grid> allGrids;
	// this will hold the letters making up the current word
	private List<Letter> currentWord = new ArrayList<>();
	// this is the list of words that the user has already entered and are valid words which count towards the player score
	private List<String> correctWords = new ArrayList<>();
	// the score of the player
	private int playerScore;
	private Dictionary dict = new Dictionary();
	// this will hold an instance of the field that shows the current word
	private javax.swing.JTextField currentWordField;

	/**
	 * This is the constructor method for the gameMainClass
	 */
	public GameMainClass() {
	}
	
	/**
	 * This method is used so that there is only one instance of the StartMenu frame that is used
	 * @param startMenu the StartMenu frame used
	 */
	public void setStartMenu(StartMenu startMenu) {
		this.startMenu = startMenu;
	}

	/**
	 * This method is used so that there is only one instance of the PlayGame frame that is used and will be manipulated
 It also sets the grids so that they can be manipulated when required
	 * @param playGame the PlayGame frame used 
	 */
	public void setPlayGame(PlayGame playGame) {
		this.playGame = playGame;
		allGrids = new ArrayList<>(Arrays.asList(playGame.getGrid1(), playGame.getGrid2(), playGame.getGrid3()));
		this.currentWordField = playGame.getCurrentWordField();
		this.playerScore = playGame.getScore();
	}
	
	public void setPlaySavedGame(PlaySavedGame playSavedGame) {
		this.playSavedGame = playSavedGame;
		allGrids = new ArrayList<>(Arrays.asList(playSavedGame.getGrid1(), playSavedGame.getGrid2(), playSavedGame.getGrid3()));
	}

	/**
	 * This method is used so that there is only one instance of the GameHelp frame that is used
	 * @param gameHelp the GameHelp frame used
	 */
	public void setGameHelp(GameHelp gameHelp) {
		this.gameHelp = gameHelp;
	}
	
	/**
	 * This method is used so that there is only one instance of the GameScoreBoard that is used
	 * @param gameScoreBoard the GameScoreBoard frame used
	 */
	public void setGameScoreBoard(GameScoreBoard gameScoreBoard) {
		this.gameScoreBoard = gameScoreBoard;
	}

	/**
	 * This method is used so that there is only one instance of the ScoreMenu frame that is used
	 * @param scoreMenu the ScoreMenu frame used
	 */
	public void setScoreMenu(ScoreMenu scoreMenu) {
		this.scoreMenu = scoreMenu;
	}
	
	/**
	 * This method is used so that there is only one instance of the SelectGame frame that is used
	 * @param selectGame the SelectGame frame used
	 */
	public void setSelectGame(SelectGame selectGame) {
		this.selectGame = selectGame;
	}
	
	/**
	 * This method is called by the button on the StartMenu frame when the "New game" button is clicked
	 */
	public void showPlayGame() {
		playGame = new PlayGame();
		playGame.setVisible(true);
	}
	
	/**
	 * This method is called by the button on the startMeu frame when the "Help" button is clicked
	 */
	public void showGameHelp() {
		gameHelp = new GameHelp();
		gameHelp.setVisible(true);
	}
	
	/**
	 * This method is called by the button on the StartMenu frame when the "Score Board" button is clicked
	 */
	public void showGameScoreBoard() {
		gameScoreBoard = new GameScoreBoard();
		gameScoreBoard.setVisible(true);
	}
	
	public void setPlaySavedGame() {
		playSavedGame = new PlaySavedGame();
	}
	
	public void showPlaySavedGame() {
		playSavedGame.setVisible(true);
	}
	
	public void showStartMenu() {
		startMenu = new StartMenu();
		startMenu.setVisible(true);
	}
	
	
	
	public void showSelectGame() {
		selectGame = new SelectGame();
		selectGame.setVisible(true);
	}
	
	/**
	 * This is the main method which is first fired up
	 * displaying the start menu of the game
	 * @param args the command line arguments
	 */
    public static void main(String[] args){
        // This load the startmenu page when game is run.
		StartMenu sM = new StartMenu();
		sM.setVisible(true);
    }
	
	/**
	 * This method updates the field where the current word should show when the user clicks on a tile
	 * if the tile is selectable, it will add the letter that the tile represents to the field that shows the current word
	 * else it will clear that field
	 * @param evt the click event on the tile being listened for
	 */
	public void updateCurrentWord(java.awt.event.ActionEvent evt) {
		Tile clickedTile = (Tile) evt.getSource();
		PositionInGrid positionOfClickedTile = clickedTile.getPos();
		Grid ownerGrid = clickedTile.getOwnerGrid();
		
		for (int i = 0; i < 9; i++) {
			if (ownerGrid.getAllTiles()[i].getPos().getRowNumber() == positionOfClickedTile.getRowNumber() && ownerGrid.getAllTiles()[i].getPos().getColNumber() == positionOfClickedTile.getColNumber()) {
				currentWord.add(ownerGrid.getAllTiles()[i].getLetter());
				break;
			}
		}
		
		String currentWordString = "";
		for (int indexVariable = 0; indexVariable < currentWord.size(); indexVariable++) {
			currentWordString += currentWord.get(indexVariable).printLetter();
		}
		currentWordField.setText(currentWordString);
	}

	/**
	 * This method is used to make sure a tile that is already selected, its selectable is set to true
	 * @param position position of neighbor tile to check if already selected
	 */
	private void setSelectableIfNotAlreadySelected(PositionInGrid position, Grid ownerGrid) {
		Boolean isAlreadyInSelected = false;
		for (Tile selectedTile : ownerGrid.selectedTiles) {
			if (selectedTile.getPos() == position) {
				isAlreadyInSelected = true;
			}
		}
		if (isAlreadyInSelected) {
			System.out.println("Tile at position: " + position + "is already in selected tiles list");
		} else {
			for (Tile oneTile : ownerGrid.getAllTiles()) {
				if (oneTile.getPos().getRowNumber() == position.getRowNumber()) {
					if (oneTile.getPos().getColNumber() == position.getColNumber()) {
						oneTile.setIsTileSelectable(true);
						oneTile.highlightTile(Color.YELLOW);
					}
				}
			}
		}
	}

	/**
	 * This event is fired up when a Tile is clicked
	 * @param evt event being listened for
	 * @param warningLabel in case user clicks a non selectable tile, the label will show a warning
	 */
	public void handleTileAction(ActionEvent evt, JLabel warningLabel) {
		Tile clickedTile = (Tile) evt.getSource();
		int row = clickedTile.getPos().getRowNumber();
		int col = clickedTile.getPos().getColNumber();
		Grid ownerGrid = clickedTile.getOwnerGrid();
		
		/**
		 * When clicked,
		 *
		 * check if is selectable first
		 *		if yes
		 *			set all tiles selectable to false (we will set the neighbors selectable to true later)
		 *			highlight all tiles white (we will highlight the neighbors later)
		 *			set clickedTile selected to true
		 *			add tile to selectedTiles list in grid
		 *			set neighbor tiles selectable to true
		 *			highlight neighbor tiles red
		 * 		if no
		 *			empty selectedTiles list
		 *			set all tiles selected to false (default)
		 *			set all tiles selectable to true (default)
		 *			highlight all tiles white
		 *			display warning on label for 3 seconds
		 */
		if (clickedTile.getIsTileSelectable()) {
			// set all tiles selectable to false
			for (Tile oneTile : ownerGrid.getAllTiles()) {
				oneTile.setIsTileSelectable(false);
				oneTile.highlightTile(Color.WHITE);
			}
			clickedTile.setSelected(true);
			ownerGrid.selectedTiles.add(clickedTile);
			updateCurrentWord(evt);
			// this is to set all the neighbours selectable to true
			// so that the player can select another tile after
			
			// new and improved algo to set neighbours to selectable to true
			int row_limit = Grid.NO_OF_ROWS_IN_GRID - 1;
			if (row_limit > 0) {
				int column_limit = Grid.NO_OF_COLUMNS_IN_GRID - 1;
				for (int x = max(0, row - 1); x <= min(row + 1, row_limit); x++) {
					for (int y = max(0, col - 1); y <= min(col + 1, column_limit); y++) {
						if (x != row || y != col) {
							setSelectableIfNotAlreadySelected(new PositionInGrid(x, y), ownerGrid);
						}
					}
				}
			}
			ownerGrid.setSelectableInNeighbourGrids(new PositionInGrid(row, col));
		} else {
			// when user clicks on tile which is not selectable
			// clear tiles selected in all grids
			// and clear current word field
			clearTileSelection();
			clearCurrentWord();
			// display warning for 3 seconds
			warningLabel.setText("You clicked on an unselected tile!");
			Timer t = new Timer(3000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					warningLabel.setText(null);
				}
			});
			t.setRepeats(false);
			t.start();
		}
	}
	
	/**
	 * This method clears the selection of tiles that are highlighted
	 * as well as reverts them back to their default
	 */
	public void clearTileSelection() {
		for (Grid oneGrid: allGrids) {
			oneGrid.selectedTiles.clear();
			for (Tile oneTile : oneGrid.getAllTiles()) {
				oneTile.setSelected(false);
				oneTile.setIsTileSelectable(true);
				oneTile.highlightTile(Color.WHITE);
			}
		}
	}
	
	/**
	 * This method is used when the user clicks on a tile that is not selectable
	 * It clears the field where the current word should appear
	 */
	public void clearCurrentWord() {
		currentWord.clear();
		currentWordField.setText("");
	}
	
	/**
	 * This method is used to add a word to the list of correct words for the player
	 * @param list the list of correct words to add to
	 */
	public void addCurrentWordToList(JList list) {
		DefaultListModel listModel = (DefaultListModel) list.getModel();
		String currentWordString = "";
		for (int indexVariable = 0; indexVariable < currentWord.size(); indexVariable++) {
			currentWordString += currentWord.get(indexVariable).printLetter();
		}
		listModel.addElement(currentWordString);
		
		// then clear the word selection from the grids and the current word field
		clearCurrentWord();
		clearTileSelection();
	}
	
	/**
	 * This method checks if the word input by the player is a valid one
	 * if so, then add the score of that word to the player score
	 * @param scoreLabel the label showing the score to update
	 * @return whether the word input by the player is a valid word or not
	 * @throws FileNotFoundException in case the dictionary file is not found
	 */
	public Boolean isValidWordThenUpdateScore(JLabel scoreLabel) throws FileNotFoundException {
		dict.readFile();
		String currentWordString = "";
		for (int indexVariable = 0; indexVariable < currentWord.size(); indexVariable++) {
			currentWordString += currentWord.get(indexVariable).printLetter().toLowerCase();
		}
		
		if (dict.search(currentWordString)) {
			playerScore = playGame.getScore();
			int wordScore = 0;
			for (Letter letter: currentWord) {
				wordScore += letter.getLetterValue();
			}
			playGame.setScore(playerScore + (wordScore * wordScore));
			scoreLabel.setText(Integer.toString(playerScore));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method is called if the word input by the user is not a valid word
	 * it first clears the user selection and shows an appropriate warning
	 * @param warningLabel the label where to show the warning
	 */
	public void wrongWord(JLabel warningLabel) {
		clearCurrentWord();
		clearTileSelection();
		warningLabel.setText("Word is incorrect. TRY AGAIN");
		Timer t = new Timer(3000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					warningLabel.setText(null);
				}
			});
		t.setRepeats(false);
		t.start();
	}
	
	/**
	 * This method is used if the word input by the user is already in the list of correct words
	 * it first clears the user selection then shows an appropriate warning
	 * @param warningLabel the label where to show the warning
	 */
	public void wordAlreadyInList(JLabel warningLabel) {
		clearCurrentWord();
		clearTileSelection();
		warningLabel.setText("Word already added, TRY ANOTHER ONE");
		Timer t = new Timer(3000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					warningLabel.setText(null);
				}
			});
		t.setRepeats(false);
		t.start();
	}
	
	/**
	 * This method checks if the word input by the user has already been played
	 * @param currentWordsList the list of words to check 
	 * @return whether the word has already been played or not
	 */
	public Boolean isNotAlreadyInList(JList currentWordsList) {
		DefaultListModel currentWordsModel = (DefaultListModel) currentWordsList.getModel();
		String currentWordString = "";
		for (int indexVariable = 0; indexVariable < currentWord.size(); indexVariable++) {
			currentWordString += currentWord.get(indexVariable).printLetter();
		}
		System.out.println(currentWordsModel.indexOf(currentWordString));
		if (currentWordsModel.indexOf(currentWordString) >= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void printCurrentWord() {
		System.out.print("The current word is: ");
		for (Letter letter: currentWord) {
			System.out.print(letter.printLetter());
		}
		System.out.println("");
	}
}
