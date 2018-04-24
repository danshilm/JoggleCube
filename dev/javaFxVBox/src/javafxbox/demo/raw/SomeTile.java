package javafxbox.demo.raw;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafxbox.demo.raw.interfaces.Grid;
import javafxbox.demo.raw.interfaces.Letter;
import javafxbox.demo.raw.interfaces.Tile;

public class SomeTile extends Button implements Tile {

    private BooleanProperty selected = new SimpleBooleanProperty(false);
    private Letter letter;
    private PositionInGrid pos;
    private BooleanProperty selectable = new SimpleBooleanProperty(true);
    private int gridNo;
    private Grid ownerGrid;

    public SomeTile() {
        super();
    }

    public SomeTile(PositionInGrid pos) {
        this.pos = pos;
    }

    public SomeTile(String text, PositionInGrid pos, int gridNo) {
        super(text);
        this.letter = new OneLetter(text);
        this.pos = pos;
        this.gridNo = gridNo;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
        super.setText(this.letter.printCharacter());
    }

    public void select() {
        if (selectable.getValue()) {
            selected.setValue(true);
            ownerGrid.addSelectedTile(this);
            selectable.setValue(false);
        }
    }

    @Override
    public boolean isSelected() {
        return selected.getValue();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public boolean isSelectable() {
        return selectable.get();
    }

    public BooleanProperty selectableProperty() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable.set(selectable);
    }

    @Override
    public void setGridNo(int n) {

    }

    @Override
    public int getGridNo() {
        return gridNo;
    }

    @Override
    public int getRowNoInGrid() {
        return pos.getRowNumber();
    }

    @Override
    public void setRowNoInGrid(int r) {

    }

    @Override
    public int getColNoInGrid() {
        return pos.getColNumber();
    }

    @Override
    public void setColNoInGrid(int c) {

    }
}
