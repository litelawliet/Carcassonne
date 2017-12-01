package Carcassonne;

import javafx.scene.control.Button;

/**
 * Project Carcassonne
 * Created by Romain on 17/11/2017.
 */
public class ButtonCarcassonne extends Button {

    private boolean isMarked;
    private String color;
    private int heigh,width;
    private Pawn p;
    private Card parent;

    public ButtonCarcassonne(String color, int heigh, int width){
        super();
        this.color = color;
        this.heigh = heigh;
        this.width = width;
        setStyle("fx-background-value: "+color);
        setStyle("fx-heigh: "+heigh);
        setStyle("fx-width: "+width);
    }
    public boolean getMark(){return isMarked;}
    public void setMark(boolean isMarked){this.isMarked = isMarked;}
    public ButtonCarcassonne clone(){
        ButtonCarcassonne copy = new ButtonCarcassonne(color,heigh,width);
        copy.isMarked = this.isMarked;
        return copy;
    }

    public void setParent(Card parent){
        this.parent = parent;
    }

    public void dropPawn(Pawn p){
        this.p = p;
    }

    public void marked(){isMarked = true;}
}
