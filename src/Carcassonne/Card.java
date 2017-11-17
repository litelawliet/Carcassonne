package Carcassonne;

import javafx.scene.control.Button;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Card {
    private String path;
    private boolean isMarked;
    private Pawn[] sides = new Pawn[4];
    private Card[] adjacentes = new Card[8];
    private Button[] pix;

    private static ButtonCarcassonne champ = new ButtonCarcassonne();
    private static ButtonCarcassonne village = new ButtonCarcassonne();
    private static ButtonCarcassonne chemin = new ButtonCarcassonne();
    private static ButtonCarcassonne abbaye = new ButtonCarcassonne();

    public enum Sides{
        H,HG,HD,B,BG,BD,G,D
    }

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
