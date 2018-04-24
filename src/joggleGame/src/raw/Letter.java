package raw;

public class Letter {

    private LetterEnum character;
    private int numAllowed;
    private int letterValue;
    private int numOnGrid;

    public Letter() {
    }

    public Letter(LetterEnum character) {
        this.character = character;
        this.numAllowed = character.getNumAllowed();
        this.letterValue = character.getLetterValue();
    }

    public int getNumAllowed() {
        return numAllowed;
    }

    public String printLetter() {
        return character.toString();
    }
}
