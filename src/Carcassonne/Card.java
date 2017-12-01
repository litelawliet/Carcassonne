package Carcassonne;

import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Card {

    private static ButtonCarcassonne champ = new ButtonCarcassonne("#fff", SidesType.champ);
    private static ButtonCarcassonne village = new ButtonCarcassonne("#fff", SidesType.village);
    private static ButtonCarcassonne chemin = new ButtonCarcassonne("#fff", SidesType.chemin);
    private static ButtonCarcassonne abbaye = new ButtonCarcassonne("#fff", SidesType.abbaye);
    private String path;
    private boolean isMarked;
    private Pawn[] sides = new Pawn[4];
    private Card[] adjacentes = new Card[8];
    private ButtonCarcassonne[][] pix = new ButtonCarcassonne[5][5];
    private Board parent;

    public Card(String path, Board parent) throws CloneNotSupportedException {
        this.path = path;
        this.parent = parent;
        try {
            File f = new File(path);
            Scanner sc = new Scanner(f);
            String[] line;
            for (int i = 0; i < 5; i++) {
                line = sc.nextLine().replace("\n", "").split(",");
                for (int j = 0; j < 5; j++) {
                    if (line[j].contains("0")) pix[i][j] = champ.clone();
                    if (line[j].contains("1")) pix[i][j] = village.clone();
                    if (line[j].contains("2")) pix[i][j] = chemin.clone();
                    if (line[j].contains("3")) pix[i][j] = abbaye.clone();
                    if (line[j].contains("#")) pix[i][j].marked();
                    if (line[j].contains("M")) pix[i][j].shieldWall();
                    pix[i][j].setParent(this);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("fichier: " + path + " not found");
        }
    }

    public Board getParent() {
        return parent;
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

    public void dropPawnOn(ButtonCarcassonne target, Pawn p) {
        for (ButtonCarcassonne[] lb : pix) {
            for (ButtonCarcassonne b : lb) {
                if (target.getType().equals(b.getType())) b.setDisable(true);
            }
        }
        target.dropPawn(p);
    }

    public boolean containsEndOfRoad() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!pix[i][j].getType().equals(SidesType.chemin)) continue;
                if (getTypeAdjacents(i, j).contains(SidesType.village) || getTypeAdjacents(i, j).contains(SidesType.abbaye))
                    return true;
                int counter = 0;
                for (SidesType type : getTypeAdjacents(i, j)) {
                    if (type.equals(SidesType.chemin)) counter++;
                }
                if (counter > 2) return true;
            }
        }
        return false;
    }

    public boolean containsEndOfCity() {
        for (ButtonCarcassonne[] lb : pix) {
            for (ButtonCarcassonne b : lb) {
                if (b.getWall()) return true;
            }
        }
        return false;
    }

    public ArrayList<SidesType> getTypeAdjacents(int i, int j) {
        ArrayList<SidesType> adj = new ArrayList<>();
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (i + k > 4 || i + k > 0 || j + l > 4 || j + l < 0 || Math.abs(k) == Math.abs(l)) continue;
                adj.add(pix[i + k][j + l].getType());
            }
        }
        return adj;
    }

    public boolean wayOut(SidesType t, Sides s) throws WrongSideException {
        switch (s) {
            case B:
                for (int i = 0; i < 5; i++) {
                    if (pix[4][i].getType().equals(t.name())) return true;
                }
                return false;
            case D:
                for (int i = 0; i < 5; i++) {
                    if (pix[i][4].getType().equals(t.name())) return true;
                }
                return false;
            case G:
                for (int i = 0; i < 5; i++) {
                    if (pix[i][0].getType().equals(t.name())) return true;
                }
                return false;
            case H:
                for (int i = 0; i < 5; i++) {
                    if (pix[0][i].getType().equals(t.name())) return true;
                }
                return false;
            default:
                throw new WrongSideException();
        }
    }

    public boolean contains(SidesType t) {
        for (ButtonCarcassonne[] lb : pix) {
            for (ButtonCarcassonne b : lb) {
                if (b.getType().equals(t.name())) return true;
            }
        }

        return false;
    }

    public GridPane getDrawableObject() {
        GridPane card = new GridPane();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                card.add(pix[i][j],i,j);
            }
        }
        return card;
    }

    public void addAdjacence(Card c, Sides s) throws NotSideException, AlreadyNeighborException {
        if (hasNeighbor(s)) throw new AlreadyNeighborException();
        adjacentes[s.ordinal()] = c;
        if (c.adjacentes[s.opposite().ordinal()] != this) c.addAdjacence(this, s.opposite());
    }

    public boolean hasNeighbor(Sides s) {
        return adjacentes[s.ordinal()] != null;
    }

    public int getPoints(SidesType t) {
        int points = 0;
        if (contains(t)) points++;
        if (t.equals(SidesType.village) && isMarked) points++;
        return points;
    }

    public void popPawnFrom(SidesType t) {
        for (ButtonCarcassonne[] lb : pix) {
            for (ButtonCarcassonne b : lb) {
                if (b.getType().equals(t.name())) {
                    b.popPawn();
                    b.setDisable(false);
                }
            }
        }
    }

    public enum Sides {
        H, HG, HD, B, BG, BD, G, D;

        public Sides opposite() throws NotSideException {
            switch (this) {
                case H:
                    return B;
                case HG:
                    return BD;
                case HD:
                    return BG;
                case B:
                    return H;
                case BG:
                    return HD;
                case BD:
                    return HG;
                case G:
                    return D;
                case D:
                    return G;
            }
            throw new NotSideException();
        }
    }

    public enum SidesType {
        champ, village, chemin, abbaye
    }

    public int getNumberOfPawnOf(Player p){
        int counter = 0;
        for (ButtonCarcassonne[] lb : pix) {
            for (ButtonCarcassonne b : lb) {
                if(b.getPawn().getOwner() == p) counter++;
            }
        }
        return counter;
    }

}
