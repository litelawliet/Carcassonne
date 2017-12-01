package Carcassonne;

import java.awt.*;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Pawn {
    public static String RED_PAWN = "";
    private Color color;
    private Player owner;
    private Type type;
    public Pawn(Color color) {
        this.color = color;
        this.owner = owner;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        NONE,
        KNIGHT,
        FARMER,
        ABBE,
        BRIGAND,
    }
}
