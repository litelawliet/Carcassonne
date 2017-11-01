package Carcassonne;

import java.util.ArrayList;

/**
 * Project Carcassonne-master
 * Created by Lollipop on 01/11/2017.
 */
public class Board {
    /*
      Classe du plateau virtuel
     */

    // "Matrice" contenant les cartes paysage
    private ArrayList<ArrayList<Card>> tiles;

    /**
     * Constructeur.
     */
    public Board() {
        this.tiles = new ArrayList<>();
    }

    public ArrayList<ArrayList<Card>> getTiles() {
        return tiles;
    }

    public String toString(){
        StringBuilder res = new StringBuilder();

        for (ArrayList<Card> line:this.tiles
                ) {
            res.append(line.toString()).append("\n");
        }

        return res.toString();
    }

    /**
     * Ajoute une carte paysage au jeu.
     * @param c la carte à ajouter
     */
    public void addTile(Card c, int row, int col) throws TileOutOfRangeException {
        if(c == null) return;

        if(row < 0 || col < 0) throw new TileOutOfRangeException();

        // Row = numéro liste dans la grosse liste
        // Col = numéro carte dans la liste row

        // si row n'existe pas on la crée
        while(tiles.size()-1 < row){
            tiles.add(new ArrayList<>());
        }

        // si col n'existe pas on la crée
        while(tiles.get(row).size()-1 < col) {
            tiles.get(row).add(null);
        }

        tiles.get(row).set(col, c);

        // Il faut toujours qu'il y ait des tiles vides à "gauche" et en "haut" pour pouvoir ajouter d'autres tiles
        //à gauche
        if(tiles.get(row).get(0) != null){
            for (ArrayList<Card> line:tiles
                 ) {
                line.add(0, null);
            }
        }

        // en haut
        if(!tiles.get(0).isEmpty()){
            tiles.add(0, new ArrayList<>());
        }
    }

    /**
     * Pour ajouter la première carte paysage rapidement
     * @param c la carte en question
     */
    public void addFirstTile(Card c) throws TileOutOfRangeException {
        this.addTile(c, 0, 0);
    }

    /**
     * Vérifie si le plateau contient telle carte
     * @param c la carte à vérifier
     */
    public boolean contains(Card c){
        for (ArrayList<Card> line:this.tiles
             ) {
            if(line.contains(c)) return true;
        }

        return false;
    }

    /**
     * Retourne le nombre de cartes paysage en jeu
     * @return le nombre de cartes paysages en jeu
     */
    public int getNumTiles() {
        int res = 0;

        for (ArrayList<Card> line:this.tiles
                ) {
            for (Card c:line
                 ) {
                if(c != null) res++;
            }
        }

        return res;
    }

    /**
     * Teste si le plateau est vide, càd aucune carte paysage
     * @return true si vide
     */
    public boolean isEmpty(){
        return getNumTiles() == 0;
    }

    // TODO
    // diverses précisions : pour récupérer la position de la carte (afin d'ajouter des cartes) : indexOf
    // il faut un test comme quoi la carte est compatible avec sa voisine
}
