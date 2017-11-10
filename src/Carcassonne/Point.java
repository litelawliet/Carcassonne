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

    public int compteNormal(int nbrCartes){

        if (this.getColor() == Color.blue){
            
            switch (this.getType()){

                case ABBE: //1pts pour chaque carte autour de l'abbé + 1pts de base
                    this.points += nbrCartes;
                    break;

                case FARMER: //1pts pour chaque carte de pré
                    this.points += nbrCartes;
                    break;

                case KNIGHT: //Une ville de deux cartes = 2pts, une ville normale = 2pts/cartes
                    if(nbrCartes == 2){
                        this.points += nbrCartes;
                    }
                    else{
                        this.points += nbrCartes*2;
                    }
                    break;

                case BRIGAND: //1pts pour chaque carte chemin
                    this.points += nbrCartes;
                    break;

            }
        }
         
        else if(this.getColor() == Color.red){
            
            switch (this.getType()){
                    
                case ABBE: //1pts pour chaque carte autour de l'abbé + 1pts de base
                    this.points += nbrCartes;
                    break;
                    
                case FARMER: //1pts pour chaque carte de pré
                    this.points += nbrCartes;
                    break;
                    
                case KNIGHT: //Une ville de deux cartes = 2pts, une ville normale = 2pts/cartes
                    if(nbrCartes == 2){
                        this.points += nbrCartes;
                    }
                    else{
                        this.points += nbrCartes*2;
                    }
                    break;
                    
                case BRIGAND: //1pts pour chaque carte chemin
                    this.points += nbrCartes;
                    break;
                    
            }
        }
         
        else if(this.getColor() == Color.yellow){
            
            switch (this.getType()){
                    
                case ABBE: //1pts pour chaque carte autour de l'abbé + 1pts de base
                    this.points += nbrCartes;
                    break;
                    
                case FARMER: //1pts pour chaque carte de pré
                    this.points += nbrCartes;
                    break;
                    
                case KNIGHT: //Une ville de deux cartes = 2pts, une ville normale = 2pts/cartes
                    if(nbrCartes == 2){
                        this.points += nbrCartes;
                    }
                    else{
                        this.points += nbrCartes*2;
                    }
                    break;
                    
                case BRIGAND: //1pts pour chaque carte chemin
                    this.points += nbrCartes;
                    break;
                    
            }
        }
         
        else if(this.getColor() == Color.green){
            
            switch (this.getType()){
                    
                case ABBE: //1pts pour chaque carte autour de l'abbé + 1pts de base
                    this.points += nbrCartes;
                    break;
                    
                case FARMER: //1pts pour chaque carte de pré
                    this.points += nbrCartes;
                    break;
                    
                case KNIGHT: //Une ville de deux cartes = 2pts, une ville normale = 2pts/cartes
                    if(nbrCartes == 2){
                        this.points += nbrCartes;
                    }
                    else{
                        this.points += nbrCartes*2;
                    }
                    break;
                    
                case BRIGAND: //1pts pour chaque carte chemin
                    this.points += nbrCartes;
                    break;
                    
            }
        }
         
        return this.points;

     }

}
