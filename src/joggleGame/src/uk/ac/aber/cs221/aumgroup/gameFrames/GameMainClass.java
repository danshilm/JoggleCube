/*
 * @GameMainClass.java 2.5 2018/05/09
 *
 * Copyright (c) 2018 Aberystwyth University.
 * All rights reserved.
 *
 */
package uk.ac.aber.cs221.aumgroup.gameFrames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.Timer;
import uk.ac.aber.cs221.aumgroup.gameLogic.Dictionary;
import uk.ac.aber.cs221.aumgroup.gameLogic.Grid;
import uk.ac.aber.cs221.aumgroup.gameLogic.Letter;
import uk.ac.aber.cs221.aumgroup.gameLogic.LetterPopulation;
import uk.ac.aber.cs221.aumgroup.gameLogic.PositionInGrid;
import uk.ac.aber.cs221.aumgroup.gameLogic.Tile;

/**
 * This is the main class where the game is populated, where almost all the user
 * interactions are handled
 *
 * @author the12, dkm4, jty
 * @version 1.0 initial development (the12)
 * @version 2.0 moved the tile action handle here instead of Grid and added functionality for current word (dkm4)
 * @version 2.1 added javadoc (jty)
 * @version 2.2 added functionality for player score and list of correct words (dkm4)
 * @version 2.3 added countdown (dkm4, the12)
 * @version 2.4 moved and updated random generation of letters from Grid to here (dkm4)
 * @version 2.5 added keyboard functionality (dkm4)
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
	/**
	 * This is the list of grids through which they will be manipulated
	 */
	private List<Grid> allGrids;
	/**
	 * This will hold the letters making up the current word
	 */
	private List<Letter> currentWord = new ArrayList<>();
	/**
	 * This is the list of tiles that are currently selected by the user
	 */
	private List<Tile> selectedTiles = new ArrayList<>();
	/**
	 * This is the list of words that the user has already entered and are valid words which count towards the player score
	 */
	private List<String> correctWords = new ArrayList<>();
	/**
	 * This is the player score
	 */
	private int playerScore;
	/**
	 * This is the dictionary class that will be used to check for valid words
	 */
	private final Dictionary dict = new Dictionary();
	/**
	 * This will hold an instance of the field that shows the current word
	 */
	private javax.swing.JTextField currentWordField;
	// these 2 variables represent the amount of minutes and seconds that one game lasts for and is countdown to 0
	private int countdownMinutes = 3;
	private int countdownSeconds = 0;
	/**
	 * This is the list of all letters that have been generated and will be populated in the grids
	 */
	private List<Letter> generatedLetters = new ArrayList<>(NO_OF_TILES_IN_BOARD);
	/**
	 * Constant to represent the number of letters in the whole board
	 */
	private static final int NO_OF_TILES_IN_BOARD = 27;
	/**
	 * Constant to represent the number of letters in one grid
	 */
	private static final int NO_OF_TILES_IN_GRID = 9;
	// these are lists which hold all the tiles for each grid
	private List<Tile> grid1Tiles = new ArrayList<>(NO_OF_TILES_IN_GRID);
	private List<Tile> grid2Tiles = new ArrayList<>(NO_OF_TILES_IN_GRID);
	private List<Tile> grid3Tiles = new ArrayList<>(NO_OF_TILES_IN_GRID);
	/**
	 * This is the color that the tiles are highlighted when they have been selected by the user
	 */
	public Color selectedTilesColor = new Color(194, 202, 232);
	/**
	 * This is the color that the tiles are highlighted when they are valid letters to select from
	 */
	public Color selectableTilesColor = new Color(241, 194, 50);
	/**
	 * This is the list of characters that are accepted as keyboard input 
	 */
	List<Character> alphabets = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
	

	/**
	 * This is the constructor method for the gameMainClass
	 */
	public GameMainClass() {
	}

	/**
	 * This method is used so that there is only one instance of the StartMenu
	 * frame that is used
	 *
	 * @param startMenu the StartMenu frame used
	 */
	public void setStartMenu(StartMenu startMenu) {
		this.startMenu = startMenu;
	}

	/**
	 * This method is used so that there is only one instance of the PlayGame
	 * frame that is used and will be manipulated It also sets the grids so that
	 * they can be manipulated when required
	 * @param playGame the PlayGame frame used
	 */
	public void setPlayGame(PlayGame playGame) {
		this.playGame = playGame;
		allGrids = new ArrayList<>(Arrays.asList(playGame.getGrid1(), playGame.getGrid2(), playGame.getGrid3()));
		this.currentWordField = playGame.getCurrentWordField();
		this.playerScore = playGame.getScore();
	}

	/**
	 * This method is used so that there is only one instance of the PlaySavedGame
	 * frame that is used and will be manipulated It also sets the grids so that
	 * they can be manipulated when required
	 * @param playSavedGame the PlaySavedGame frame used
	 */
	public void setPlaySavedGame(PlaySavedGame playSavedGame) {
		this.playSavedGame = playSavedGame;
		allGrids = new ArrayList<>(Arrays.asList(playSavedGame.getGrid1(), playSavedGame.getGrid2(), playSavedGame.getGrid3()));
		this.currentWordField = playSavedGame.getCurrentWordField();
		this.playerScore = playSavedGame.getScore();
	}

	/**
	 * This method is used so that there is only one instance of the GameHelp
	 * frame that is used
	 * @param gameHelp the GameHelp frame used
	 */
	public void setGameHelp(GameHelp gameHelp) {
		this.gameHelp = gameHelp;
	}

	/**
	 * This method is used so that there is only one instance of the
	 * GameScoreBoard that is used
	 * @param gameScoreBoard the GameScoreBoard frame used
	 */
	public void setGameScoreBoard(GameScoreBoard gameScoreBoard) {
		this.gameScoreBoard = gameScoreBoard;
	}

	/**
	 * This method is used so that there is only one instance of the ScoreMenu
	 * frame that is used
	 * @param scoreMenu the ScoreMenu frame used
	 */
	public void setScoreMenu(ScoreMenu scoreMenu) {
		this.scoreMenu = scoreMenu;
	}

	/**
	 * This method is used so that there is only one instance of the SelectGame
	 * frame that is used
	 * @param selectGame the SelectGame frame used
	 */
	public void setSelectGame(SelectGame selectGame) {
		this.selectGame = selectGame;
	}

	/**
	 * This method is the getter method for the list of selected tiles
	 * @return list of tiles
	 */
	public List<Tile> getSelectedTiles() {
		return selectedTiles;
	}

	/**
	 * This method is called by the button on the StartMenu frame when the "New
	 * game" button is clicked and also starts the countdown as soon as it is
	 * displayed
	 */
	public void showPlayGame() {
		playGame = new PlayGame();
		playGame.setVisible(true);
		countdown();
	}

	/**
	 * This method is called by the button on the startMeu frame when the "Help"
	 * button is clicked
	 */
	public void showGameHelp() {
		gameHelp = new GameHelp();
		gameHelp.setVisible(true);
	}

	/**
	 * This method is called by the button on the StartMenu frame when the
	 * "Score Board" button is clicked
	 */
	public void showGameScoreBoard() {
		gameScoreBoard = new GameScoreBoard();
		gameScoreBoard.setVisible(true);
	}

	/**
	 * This method is called when the user chooses to load a saved game after
	 * loading the game from the file the user has chosen It initializes the
	 * game
	 */
	public void setPlaySavedGame() {
		playSavedGame = new PlaySavedGame();
	}

	/**
	 * This method is called when the user chooses to load a saved game after
	 * initializing It also sets the frame visible so the user can interact with
	 * the game
	 */
	public void showPlaySavedGame() {
		playSavedGame.setVisible(true);
		countdown();
	}

	/**
	 * This method is called when the user chooses to display the main menu It
	 * also sets it to visible
	 */
	public void showStartMenu() {
		startMenu = new StartMenu();
		startMenu.setVisible(true);
	}

	/**
	 * This method is called when the user chooses to load a game It shows the
	 * game files from which the user can load a previously saved game
	 */
	public void showSelectGame() {
		selectGame = new SelectGame();
		selectGame.setVisible(true);
	}

	/**
	 * This is the main method which is first fired up displaying the start menu
	 * of the game
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// This load the startmenu page when game is run.
		StartMenu sM = new StartMenu();
		sM.setVisible(true);
	}

	/**
	 * This method generated 27 letters, 9 for each grid, randomly It also
	 * checks if the letters being generated are not going over the maximum
	 * amount of that letter allowed on the board
	 */
	public void generateRandomLetters() {
		int letterPopulationSize = LetterPopulation.values().length;
		Random r = new Random();
		LetterPopulation randomLetterEnum;

		for (int indexVariable = 0; indexVariable < NO_OF_TILES_IN_BOARD; indexVariable++) {
			randomLetterEnum = LetterPopulation.values()[r.nextInt(letterPopulationSize)];
			// check that there is not already the max amount of a letter on the board
			while (!checkOverflow(randomLetterEnum)) {
				randomLetterEnum = LetterPopulation.values()[r.nextInt(letterPopulationSize)];
			}
			Letter tempLetter = new Letter(randomLetterEnum);
			generatedLetters.add(tempLetter);
		}
	}

	/**
	 * This is the method responsible for checking that any letter randomly
	 * generated is not exceeding the maximum number of occurrences allowed on
	 * the board
	 * @param someLetterEnum the randomly generated letter
	 * @return the number of times that letter has already been generated
	 */
	private Boolean checkOverflow(LetterPopulation someLetterEnum) {
		Letter testLetter = new Letter(someLetterEnum);
		int occurrences = 0;
		for (Letter oneLetter : generatedLetters) {
			if (oneLetter.printLetter().equals(testLetter.printLetter())) {
				occurrences++;
			}
		}
		return occurrences < testLetter.getNumAllowed();
	}

	// 0 - 8
	// 9 - 17
	// 18 - 26
	/**
	 * This method is used to populate all 3 grids with the 27 randomly
	 * generated letters Each grid will have 9 tiles which each represent a
	 * letter, therefore each grid is passed an array of 9 letters out of the 27
	 * generated letters
	 */
	public void populateGrids() {
		System.out.println(generatedLetters.size());
		List<Letter> oneGridLetters = null;
		for (Grid oneGrid : allGrids) {
			oneGridLetters = generatedLetters.subList((0 + (allGrids.indexOf(oneGrid) * 9)), (9 + (allGrids.indexOf(oneGrid) * 9)));
			oneGrid.populateGrid(oneGridLetters);
		}
	}

	/**
	 * This method is used to set the list of letters to be populated
	 * @param listToAdd list to add to the list of letters
	 */
	public void addToGeneratedList(List<Letter> listToAdd) {
		generatedLetters.addAll(listToAdd);
	}

	/**
	 * This method updates the field where the current word should show when the
	 * user clicks on a tile if the tile is selectable, it will add the letter
	 * that the tile represents to the field that shows the current word else it
	 * will clear that field
	 *
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
			currentWordString += currentWord.get(indexVariable).printLetter().toUpperCase();
		}
		currentWordField.setText(currentWordString);
	}

	/**
	 * This method is used to make sure a tile that is already selected, its
	 * selectable is set to true
	 *
	 * @param position position of neighbor tile to check if already selected
	 */
	private void setSelectableIfNotAlreadySelected(PositionInGrid position, Grid ownerGrid) {
		Boolean isAlreadyInSelected = false;
		for (Tile selectedTile : selectedTiles) {
			if (selectedTile.getOwnerGrid().getGridNo() == ownerGrid.getGridNo()) {
				if (selectedTile.getPos().getRowNumber() == position.getRowNumber()) {
					if (selectedTile.getPos().getColNumber() == position.getColNumber()) {
						isAlreadyInSelected = true;
					}
				}
			}
		}
		if (!isAlreadyInSelected) {
			for (Tile oneTile : ownerGrid.getAllTiles()) {
				if (oneTile.getPos().getRowNumber() == position.getRowNumber()) {
					if (oneTile.getPos().getColNumber() == position.getColNumber()) {
						oneTile.setIsTileSelectable(true);
						oneTile.highlightTile(selectableTilesColor);
					}
				}
			}
		}
	}

	/**
	 * This event is fired up when a Tile is clicked
	 *
	 * @param evt event being listened for
	 * @param warningLabel in case user clicks a non selectable tile, the label
	 * will show a warning
	 */
	public void handleTileAction(ActionEvent evt, JLabel warningLabel) {
		Tile clickedTile = (Tile) evt.getSource();
		int row = clickedTile.getPos().getRowNumber();
		int col = clickedTile.getPos().getColNumber();
		Grid ownerGrid = clickedTile.getOwnerGrid();

		/**
		 * When clicked,
		 *
		 * check if is selectable first if yes set all tiles selectable to false
		 * (we will set the neighbors selectable to true later) highlight all
		 * tiles white (we will highlight the neighbors later) set clickedTile
		 * selected to true add tile to selectedTiles list in grid set neighbor
		 * tiles selectable to true highlight neighbor tiles red if no empty
		 * selectedTiles list set all tiles selected to false (default) set all
		 * tiles selectable to true (default) highlight all tiles white display
		 * warning on label for 3 seconds
		 */
		if (clickedTile.getIsTileSelectable()) {
			// set all tiles selectable to false
			for (Grid oneGrid : allGrids) {
				for (Tile oneTile : oneGrid.getAllTiles()) {
					oneTile.setIsTileSelectable(false);
					oneTile.highlightTile(Color.WHITE);
				}
			}
			for (Tile selectedTile : selectedTiles) {
				selectedTile.highlightTile(selectedTilesColor);
			}
			clickedTile.setSelected(true);
			selectedTiles.add(clickedTile);
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
			setSelectableInNeighbourGrids(clickedTile, selectedTiles, ownerGrid);
		} else {
			// when user clicks on tile which is not selectable
			// clear tiles selected in all grids
			// and clear current word field
			clearTileSelection();
			clearCurrentWord();
			// display warning for 3 seconds
			warningLabel.setText("You clicked on an invalid tile! TRY AGAIN");
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
	 * This method clears the selection of tiles that are highlighted as well as
	 * reverts them back to their default
	 */
	public void clearTileSelection() {
		for (Grid oneGrid : allGrids) {
			selectedTiles.clear();
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
	 * This method is used to add a word to the list of correct words for the
	 * player
	 *
	 * @param list the list of correct words to add to
	 */
	public void addCurrentWordToList(JList list) {
		DefaultListModel listModel = (DefaultListModel) list.getModel();
		String currentWordString = "";
		for (int indexVariable = 0; indexVariable < currentWord.size(); indexVariable++) {
			currentWordString += currentWord.get(indexVariable).printLetter().toUpperCase();
		}
		listModel.addElement(currentWordString);

		// then clear the word selection from the grids and the current word field
		clearCurrentWord();
		clearTileSelection();
	}

	/**
	 * This method checks if the word input by the player is a valid one if so,
	 * then add the score of that word to the player score
	 *
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
		System.out.println("Current word: " + currentWordString);

		if (dict.search(currentWordString)) {
			if (newOrSavedGameCheck()) {
				playerScore = playGame.getScore();
			} else {
				playerScore = playSavedGame.getScore();
			}
			playerScore = newOrSavedGameCheck() ? playGame.getScore() : playSavedGame.getScore();
			int wordScore = 0;
			for (Letter letter : currentWord) {
				wordScore += letter.getLetterValue();
			}
			if (newOrSavedGameCheck()) {
				playGame.setScore(playerScore + (wordScore * wordScore));
			} else {
				playSavedGame.setScore(playerScore + (wordScore * wordScore));
			}
			scoreLabel.setText(Integer.toString(playerScore + (wordScore * wordScore)));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is called if the word input by the user is not a valid word
	 * it first clears the user selection and shows an appropriate warning
	 *
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
	 * This method is used if the word input by the user is already in the list
	 * of correct words it first clears the user selection then shows an
	 * appropriate warning
	 *
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
	 *
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

	/**
	 * This method is used to control the time available in one game When the
	 * timer hits zero, the window is closed and the results are saved The user
	 * is then prompted to enter additional details
	 */
	public void countdown() {
		if (playGame == null) {
			Thread counter = new Thread() {
				public void run() {
					try {
						while (countdownMinutes >= 0) {
							for (; countdownSeconds >= 0; countdownSeconds--) {
								if (countdownSeconds == 59) {
									playSavedGame.setCountdownSeconds("59");
								} else {
									playSavedGame.setCountdownSeconds(Integer.toString(countdownSeconds));
								}
								// this is just for cosmetic purposes since when the seconds go lower than 10
								// it appears only as one digit, so a 0 is added at the front of it
								// to maintain the 2 digit second display
								if (countdownSeconds < 10) {
									playSavedGame.setCountdownSeconds("0" + Integer.toString(countdownSeconds));
								}
								sleep(1000);
							}
							countdownMinutes--;
							playSavedGame.setCountdownMinutes(Integer.toString(countdownMinutes));
							countdownSeconds = 59;
						}
						// end game here
						playSavedGame.endSavedGame();
					} catch (InterruptedException ex) {
						System.err.println(ex.getMessage());
					}
				}
			};
			counter.start();
		} else {
			Thread counter = new Thread() {
				public void run() {
					try {
						while (countdownMinutes >= 0) {
							for (; countdownSeconds >= 0; countdownSeconds--) {
								if (countdownSeconds == 59) {
									playGame.setCountdownSeconds("59");
								} else {
									playGame.setCountdownSeconds(Integer.toString(countdownSeconds));
								}
								// this is just for cosmetic purposes since when the seconds go lower than 10
								// it appears only as one digit, so a 0 is added at the front of it
								// to maintain the 2 digit second display
								if (countdownSeconds < 10) {
									playGame.setCountdownSeconds("0" + Integer.toString(countdownSeconds));
								}
								sleep(1000);
							}
							countdownMinutes--;
							playGame.setCountdownMinutes(Integer.toString(countdownMinutes));
							countdownSeconds = 59;
						}
						// end game here
						playGame.endGame();
					} catch (InterruptedException ex) {
						System.err.println(ex.getMessage());
					}
				}
			};
			counter.start();
		}
	}

	/**
	 * This method is used to highlight the valid tiles in the other grids when a tile is clicked on
	 * @param tileInOriginGrid tile clicked on
	 * @param selectedTiles list of tiles currently selected
	 * @param ownerGridOfTile grid where the tile clicked is 
	 */
	public void setSelectableInNeighbourGrids(Tile tileInOriginGrid, List<Tile> selectedTiles, Grid ownerGridOfTile) {
		List<Grid> neighbourGrids = getNeighbourGrids(ownerGridOfTile);
		for (Grid eachGrid : neighbourGrids) {
			eachGrid.setSelectableTiles(tileInOriginGrid, selectedTiles);
		}
	}

	/**
	 * This method checks which tiles are valid neighbors and returns a lis tof those
	 * @param ownerGrid grid where the tile was clicked on
	 * @return list of neighbor tiles
	 */
	public List<Grid> getNeighbourGrids(Grid ownerGrid) {
		List<Grid> neighbourGrids = new ArrayList<>();
		switch (ownerGrid.getGridNo()) {
			case 1:
				neighbourGrids.add(allGrids.get(1));
				break;
			case 2:
				neighbourGrids.add(allGrids.get(0));
				neighbourGrids.add(allGrids.get(2));
				break;
			case 3:
				neighbourGrids.add(allGrids.get(1));
				break;
			default:
				System.err.println("This should never happen");
				break;
		}
		return neighbourGrids;
	}

	/**
	 * This method checks whether the game being played is a new one or one that has been loaded
	 * @return whether it is a new or saved game
	 */
	public Boolean newOrSavedGameCheck() {
		if (playSavedGame == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method is called when the user presses a key on the keyboard
	 * It goes through the list of all letters that are on the board and highlights the letter that corresponds as well as the valid neighbor tiles
	 * in the grid that the tile is and as well as the other valid neighboring grids
	 * @param evt the keyboard event being listened for
	 * @param warningLabel the label where to show a warning if its not a letter that was pressed
	 */
	public void tileKeyboardHandle(KeyEvent evt, JLabel warningLabel) {
		Tile typedTile = null;
		if (alphabets.indexOf(evt.getKeyChar()) < 0) {
			warningLabel.setText("Not a valid letter, TRY AGAIN");
			Timer t = new Timer(3000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					warningLabel.setText(null);
				}
			});
			t.setRepeats(false);
			t.start();
		} else {
			String letterPressed = Character.toString(evt.getKeyChar()).toUpperCase();
			if ("Q".equals(letterPressed)) {
				letterPressed += "U";
			}
			for (Grid thisGrid: allGrids) {
				for (Tile oneTile: thisGrid.getAllTiles()) {
					if (oneTile.getLetter().printLetter().toUpperCase().equals(letterPressed)) {
						typedTile = oneTile;
					}
				}
			}
			
			if (typedTile.getIsTileSelectable()) {
				int row = typedTile.getPos().getRowNumber();
				int col = typedTile.getPos().getColNumber();
				Grid ownerGrid = typedTile.getOwnerGrid();

				for (Grid oneGrid : allGrids) {
					for (Tile oneTile : oneGrid.getAllTiles()) {
						oneTile.setIsTileSelectable(false);
						oneTile.highlightTile(Color.WHITE);
					}
				}
				for (Tile selectedTile : selectedTiles) {
					selectedTile.highlightTile(selectedTilesColor);
				}
				typedTile.setSelected(true);
				selectedTiles.add(typedTile);
				updateCurrentWord(typedTile);
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
				setSelectableInNeighbourGrids(typedTile, selectedTiles, ownerGrid);

			} else {
				// when user clicks on tile which is not selectable
				// clear tiles selected in all grids
				// and clear current word field
				clearTileSelection();
				clearCurrentWord();
				// display warning for 3 seconds
				warningLabel.setText("You typed a non-selectable letter! TRY AGAIN");
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
	}
	
	/**
	 * This method is used to update the currently shown word when a key has been pressed
	 * @param typedTile the tile that has been pressed
	 */
	public void updateCurrentWord(Tile typedTile) {
		PositionInGrid positionOfClickedTile = typedTile.getPos();
		Grid ownerGrid = typedTile.getOwnerGrid();

		for (int i = 0; i < 9; i++) {
			if (ownerGrid.getAllTiles()[i].getPos().getRowNumber() == positionOfClickedTile.getRowNumber() && ownerGrid.getAllTiles()[i].getPos().getColNumber() == positionOfClickedTile.getColNumber()) {
				currentWord.add(ownerGrid.getAllTiles()[i].getLetter());
				break;
			}
		}

		String currentWordString = "";
		for (int indexVariable = 0; indexVariable < currentWord.size(); indexVariable++) {
			currentWordString += currentWord.get(indexVariable).printLetter().toUpperCase();
		}
		currentWordField.setText(currentWordString);
	}
}