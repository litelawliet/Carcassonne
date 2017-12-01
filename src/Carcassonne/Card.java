package Carcassonne;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Card {

    private String path;
    private boolean isMarked;
    private Pawn[] sides = new Pawn[4];
    private Card[] adjacentes = new Card[8];
    private ButtonCarcassonne[][] pix = new ButtonCarcassonne[5][5];

    private static ButtonCarcassonne champ = new ButtonCarcassonne("#fff", 5,5);
    private static ButtonCarcassonne village = new ButtonCarcassonne("#fff", 5,5);
    private static ButtonCarcassonne chemin = new ButtonCarcassonne("#fff", 5,5);
    private static ButtonCarcassonne abbaye = new ButtonCarcassonne("#fff", 5,5);

    public enum Sides{
        H,HG,HD,B,BG,BD,G,D
    }

    public Card(String path){
        this.path = path;
        try {
            File f = new File(path);
            Scanner sc = new Scanner(f);
            String[] line;
            for(int i = 0; i<5; i++){
                line = sc.nextLine().replace("\n","").split(",");
                for (int j = 0; j < 5; j++) {
                    if(line[j].contains("0")) pix[i][j] = champ.clone();
                    if(line[j].contains("1")) pix[i][j] = village.clone();
                    if(line[j].contains("2")) pix[i][j] = chemin.clone();
                    if(line[j].contains("3")) pix[i][j] = abbaye.clone();
                    if(line[j].contains("#")) pix[i][j].marked();
                    pix[i][j].setParent(this);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fichier: "+path+" not found");
        }
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

    public void dropPawnOnRoad(ButtonCarcassonne target){
        for(ButtonCarcassonne[] lb : pix){
            for(ButtonCarcassonne b : lb){
                if(b == target) continue;
                b.setDisable(true);
            }
        }
    }
}
