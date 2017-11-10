//Pas encore sur pour ca

package Carcassonne;

import java.awt.*;

public class Point extends Pawn{

    private int points;
    Player player;

    public Point() {
        super(Color.gray);
        this.points = 0;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

     public void compteNormal(){

        if (this.getColor() == Color.blue){
            switch (this.getType()){

                case ABBE:
                    this.points += 1;
                    //en attente
                    break;

                case FARMER:
                    this.points += 1;
                    //en attente
                    break;

                case KNIGHT:
                    this.points += 1;
                    //en attente
                    break;

                case BRIGAND:
                    this.points += 1;
                    //en attente
                    break;

            }
        }

     }

}
