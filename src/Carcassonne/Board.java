package Carcassonne;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Project Carcassonne-master
 * Created by Lollipop on 01/11/2017.
 */
public class Board {
    /*
      Classe du plateau virtuel
     */

    private Game g;

    // "Matrice" contenant les cartes paysage
    private ArrayList<ArrayList<Card>> tiles;

    // Carte centrale, celle à partir de laquelle on dessine
    private Card middleCard;
    private Scene scene;

    // Arrière plan (les cartes paysages) != pane global (qui contient plus de choses)
    private GridPane paysage;

    private final String IMG_PATH = ".\\img\\";
    private final int TILE_SIZE = 70; // en pixels

    /**
     * Constructeur.
     */
    public Board(Game g) {
        this.g = g;
        paysage = new GridPane();
        paysage.setStyle("-fx-background-color: transparent;");
        paysage.setAlignment(Pos.CENTER);
        tiles = new ArrayList<>();
        middleCard = null;

        try {
            addFirstTile(new Card("pieces\\5x1.jpg"));
            addTile(new Card("pieces\\5x1.jpg"), 0, 1);
        } catch (Exception e){}

        initScene();
    }

    public Board() {
        this(null);
    }

    private void initScene(){
        Image dos = new Image(getClass().getResourceAsStream("..\\img\\pieces\\dos.png"));
        Button b = new Button("Pioche ta race");
        b.setGraphic(new ImageView(dos));
        b.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        b.setOnAction(actionEvent ->{
            g.getCardset().pick();
            System.out.println("piocher");
        });
        StackPane p = new StackPane();
        p.getChildren().add(b);
        scene = new Scene(getPaysage(), Color.WHITE);
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
    public void addTile(Card c, int row, int col) throws TileOutOfRangeException, TileHasNoNeighborException, CardAlreadyThereException {
        if(c == null) return;

        if(row < 0 || col < 0) throw new TileOutOfRangeException(); // valeurs négatives

        // on vérifie qu'il n'y a pas déjà une carte sur place TODO test

        if(!this.hasNeighbors(row, col)) throw new TileHasNoNeighborException(); // la carte doit avoir une voisine
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

        // Il faut toujours qu'il y ait des tiles vides aux bords pour pouvoir ajouter d'autres tiles
        // à gauche
        if(tiles.get(row).get(0) != null){
            for (ArrayList<Card> line:tiles
                 ) {
                line.add(0, null);
            }
            col++;
        }

        // en haut
        if(tiles.get(0).contains(c)){
            tiles.add(0, new ArrayList<>());
            row++;
        }

        // à droite
        if(tiles.get(row).get(tiles.get(row).size()-1) != null){
            for (ArrayList<Card> line:tiles
                 ) {
                line.add(null);
                if(line != tiles.get(row)){
                    while(line.size() < tiles.get(row).size()){ // pour rééquilibrer la taille des lignes
                        line.add(null);
                    }
                }
            }
        }

        // en bas
        if(tiles.get(tiles.size()-1).get(col) != null){
            tiles.add(new ArrayList<>());
        }

        // remplissage dernière ligne si une nouvelle a été créée
        if(tiles.get(tiles.size()-1).isEmpty()){
            for(int i=0; i < tiles.get(row).size(); i++){
                tiles.get(tiles.size()-1).add(null);
            }
        }

        // idem en haut
        if(tiles.get(0).isEmpty() || tiles.get(1).contains(c)){ // cette condition est sujette à caution
            while(tiles.get(0).size() < tiles.get(row).size()){
                tiles.get(0).add(null);
            }
        }
    }

    /**
     * Pour ajouter la première carte paysage rapidement
     * @param c la carte en question
     */
    public void addFirstTile(Card c) throws TileOutOfRangeException, TileHasNoNeighborException, CardAlreadyThereException {
        this.addTile(c, 0, 0);
        this.middleCard = c;
    }

    /**
     * Permet de rajouter l'élément graphique de la Scene
     * @param path nom du fichier image
     * @param row ligne
     * @param col colonne
     */
    private void addGraphicTile(String path, int row, int col){
        //paysage.add(new ImageView(IMG_PATH + path), col, row);
        Button b = new Button();

        b.setMinSize(TILE_SIZE, TILE_SIZE); // 70 = taille en pixels
        b.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("..\\img\\" + path)) , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));

        paysage.add(b, col, row);
    }

    /**
     * Permet de rajouter une tile blanche graphiquement
     * @param row la ligne
     * @param col la colonne
     */
    private void addBlankTile(int row, int col){
        addGraphicTile("white.png", row, col);
    }


    /**
     * Crée un objet GridPane représentant les tiles
     * @return le gridpane en question
     */
    public GridPane getPaysage(){
        paysage.getChildren().removeAll();

        for(int i=0; i < tiles.size(); i++){
            for(int j=0; j < tiles.get(i).size(); j++){
                if(tiles.get(i).get(j) == null){
                    addBlankTile(i, j);
                }
                else{
                    addGraphicTile(tiles.get(i).get(j).getPath(), i, j);
                }
            }
        }

        return paysage;
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

    /**
     * Récupére la carte en x, y
     * @param x x
     * @param y y
     * @return la carte en x, y
     */
    public Card getTileAt(int x, int y){
        if(x > this.tiles.size() || y > this.tiles.get(x).size()) return null;
        return this.tiles.get(x).get(y);
    }

    /**
     * Vérifie que la carte a une voisine
     * @param row ligne
     * @param col colonne
     * @return true quand la carte a une voisine
     */
    public boolean hasNeighbors(int row, int col){
        if(middleCard == null) return true;// ne fait pas le check pour la première carte

        // Si on insère une carte
        if(row >= 0 && col >= 0 && row < tiles.size() && col < tiles.get(row).size()){
            if(tiles.get(row).get(col) != null){
                row--;
                col--;
            }
        }

        // le check
        try {
            if(row >= 1){
                if(tiles.get(row-1).get(col) != null) return true;
            }
        } catch (Exception e){/*nothing*/}

        try {
            if(row < tiles.size()-1){
                if(tiles.get(row+1).get(col) != null) return true;
            }
        } catch (Exception e){/*nothing*/}

        try {
            if(col >= 1){
                if(tiles.get(row).get(col-1) != null) return true;
            }
        } catch (Exception e){/*nothing*/}

        try {
            if(col < tiles.get(row).size()-1){
                if(tiles.get(row).get(col+1) != null) return true;
            }
        } catch (Exception e){/*nothing*/}

        return false;
    }

    public Scene getScene() {
        /*Group g = new Group();
        Scene scene = new Scene(g);
        g.getChildren().add(paysage);*/

        return scene;
    }


    // TODO
    // diverses précisions : pour récupérer la position de la carte (afin d'ajouter des cartes) : indexOf
}
