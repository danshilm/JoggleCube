package raw;

public class PositionInGrid {
    private int rowNumber;
    private int colNumber;

    public PositionInGrid(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    /**
     * Overridden toString method to display position of element
     * @return row and column position of element
     */
    public String toString() {
        return "PositionInGrid{row:" + rowNumber + ", col:" + colNumber;
    }
}
