package javafxbox.demo.raw;

import javafx.scene.layout.GridPane;
import javafxbox.demo.raw.interfaces.Letter;
import javafxbox.demo.raw.interfaces.Grid;
import javafxbox.demo.raw.interfaces.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OneGrid extends GridPane implements Grid {
    // list containing the letters that are displayed in the grid
    private List<Letter> generatedLetters = new ArrayList<>();
    private static final int NO_OF_TILES_IN_GRID = 9;
    private int gridNumber;
    private ArrayList<Tile> tiles = new ArrayList<>(NO_OF_TILES_IN_GRID);
    // selectedTiles can be bound to the text area where the words need to appear
    // so that they appear as the user selects them
    private List<Tile> selectedTiles = new ArrayList<>();
//    List<String> letterPopulation = new ArrayList<>(Arrays.asList("A", "A", "A", "A", "A", "A", "A", "A", "A", "B", "B", "C", "C", "D", "D", "D", "D", ));

    public OneGrid() {
    }

    /**
     * Constructor method for a grid
     * Has a grid number since all will be instances of OneGrid
     * @param gridNumber this is used to identify which grid we are dealing with
     */
    public OneGrid(int gridNumber) {
        this.gridNumber = gridNumber;
    }

    @Override
    public void generateLetters() {
        // there will always be 9 letters
        // so randomly generate 9 letters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int N = alphabet.length();
        Random r = new Random();

        for (int i = 0; i < NO_OF_TILES_IN_GRID; i++) {
            generatedLetters.add(new OneLetter(alphabet.charAt(r.nextInt(N))));
        }
    }

    public void setGeneratedLetters(List<SomeTile> tiles) {
        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).setLetter(generatedLetters.get(i));
            // no need to use this to set the text of the tile since it is taken care of in the method setLetter() already
//            tiles.get(i).setText(String.valueOf(tiles.get(i).getLetter().printCharacter()));
        }
    }

    @Override
    public void addSelectedTile(Tile tile) {
        selectedTiles.add(tile);

    }


    @Override
    public int getGridNumber() {
        return gridNumber;
    }

    @Override
    public void setGridNumber(int n) {
        this.gridNumber = n;
    }

    // check
    @Override
    public void resetGrid() {
        generatedLetters.clear();
        generateLetters();
        for (Tile thisTile: selectedTiles) {

        }


    }

    public static int getNoOfTilesInGrid() {
        return NO_OF_TILES_IN_GRID;
    }
}
