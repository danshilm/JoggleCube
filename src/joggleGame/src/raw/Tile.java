package raw;

import javax.swing.*;
import java.awt.*;

public class Tile extends JButton {

    private Letter letter;
    private Boolean selected = false;
    private Boolean selectable = true;
    private Grid ownerGrid;
    private PositionInGrid pos;

	public Tile() {
	}

    /**
     * This is the constructor for a tile
     * @param ownerGrid the grid that the tile belongs to
     * @param pos the position of the tile
     */
    public Tile(Grid ownerGrid, PositionInGrid pos) {
        this.ownerGrid = ownerGrid;
        this.pos = pos;
    }

    /**
     * This method sets a letter for the tile as well as displays it on the JButton itself
     * @param letter the letter to be displayed
     */
    public void assignLetter(Letter letter) {
        super.setText(letter.printLetter());
        this.letter = letter;
    }

    /**
     * Getter method for PositionInGrid
     * @return position of tile
     */
    public PositionInGrid getPos() {
        return pos;
    }

    /**
     * Getter method for selectable
     * @return whether the tile is selectable or not
     */
    public Boolean getSelectable() {
        return selectable;
    }

    /**
     * Setter method for selectable
     * @param selectable set whether the tile can be selected or not
     */
    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    /**
     * Getter method for Tile
     * @return whether the tile is selected or not
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     * Setter method for selected
     * @param selected set whether the tile is selected or not
     */
    public void setSelected(boolean selected) {
        this.selected = true;
    }

    /**
     * This is used to highlight a tile
     * @param colour the color to highlight the tile
     */
    public void highlightTile(Color colour) {
        this.setBackground(colour);
    }

    /**
     * toString method overridden to be cleaner and not show information that is not essential
     * @return details about the tile
     */
    public String toString() {
        return "Tile{ letter=" + letter.printLetter() + " selected=" + selected + " selectable=" + selectable + " position=" + pos.toString() + " }";
    }
}
