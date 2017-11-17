package Carcassonne;

import javafx.scene.control.Button;

/**
 * Project Carcassonne
 * Created by Romain on 17/11/2017.
 */
public class ButtonCarcassonne extends Button {

    private boolean isMarked;
    public boolean getMark(){return isMarked;}
    public void setMark(boolean isMarked){this.isMarked = isMarked;}
}
