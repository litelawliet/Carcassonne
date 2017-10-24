package Carcassonne;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Card {
    private String path;
    private boolean isMarked;
    private Pawn[] sides = new Pawn[4];

    public Card(String path){
        this.path = path;
        isMarked = path.contains("mark");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public Pawn[] getSides() {
        return sides;
    }

    public void setSides(Pawn[] sides) {
        this.sides = sides;
    }
}
