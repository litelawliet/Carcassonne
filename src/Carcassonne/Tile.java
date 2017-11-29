package Carcassonne;

import javafx.scene.control.Button;

/**
 * Project Carcassonne
 * Created by Lollipop on 29/11/2017.
 */
public class Tile extends Button {
    private int row;
    private int col;

    public Tile(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
