package Carcassonne;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Project Carcassonne
 * Created by Romain on 17/11/2017.
 */
public class ButtonCarcassonne extends Button implements EventHandler {

    private boolean isMarked;
    private boolean isWall;
    private String color;
    private int heigh, width;
    private Pawn p;
    private Card parent;
    private Card.SidesType type;

    private static final int SIZE = 14;
    public ButtonCarcassonne(String color, Card.SidesType type) {
        super();
        this.color = color;
        this.heigh = SIZE;
        this.width = SIZE;
        this.type = type;
        setStyle("fx-background-value: " + color);
        setStyle("fx-heigh: " + heigh);
        setStyle("fx-width: " + width);
        setOnAction(this);
    }

    public boolean getWall() {
        return isWall;
    }

    public boolean getMark() {
        return isMarked;
    }

    public void setMark(boolean isMarked) {
        this.isMarked = isMarked;
    }

    public Card.SidesType getType() {
        return type;
    }


    public ButtonCarcassonne clone(){
        ButtonCarcassonne copy = new ButtonCarcassonne(color, type);
        copy.isMarked = this.isMarked;
        return copy;
    }

    public void setParent(Card parent) {
        this.parent = parent;
    }

    public Pawn getPawn(){ return p;}

    public void dropPawn(Pawn p) {
        this.p = p;
        switch (type){
            case village: p.setType(Pawn.Type.KNIGHT);
            case champ: p.setType(Pawn.Type.FARMER);
            case abbaye: p.setType(Pawn.Type.ABBE);
            case chemin: p.setType(Pawn.Type.BRIGAND);
        }
    }

    public void popPawn() {
        p.getOwner().getPawnBack(p);
        this.p = null;
    }

    public void marked() {
        isMarked = true;
    }

    public void shieldWall() {
        isWall = true;
    }

    @Override
    public void handle(Event event) {
        parent.dropPawnOn(this, parent.getParent().getParent().getActualPlayer().givePawn());
    }
}
