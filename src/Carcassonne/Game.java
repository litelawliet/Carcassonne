package Carcassonne;

import java.awt.*;
import java.util.ArrayList;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Game {

    public Board board;
    private Cardset cardset;
    private ArrayList<Player> players;
    private int[][] scoreboard;
    public static Pawn[] RED_PAWNS =
            {new Pawn(Color.RED),new Pawn(Color.RED),new Pawn(Color.RED),new Pawn(Color.RED),new Pawn(Color.RED),new Pawn(Color.RED),new Pawn(Color.RED),new Pawn(Color.RED)};
    public static Pawn[] GREEN_PAWNS =
            {new Pawn(Color.GREEN),new Pawn(Color.GREEN),new Pawn(Color.GREEN),new Pawn(Color.GREEN),new Pawn(Color.GREEN),new Pawn(Color.GREEN),new Pawn(Color.GREEN),new Pawn(Color.GREEN)};
    public static Pawn[] YELLOW_PAWNS =
            {new Pawn(Color.YELLOW),new Pawn(Color.YELLOW),new Pawn(Color.YELLOW),new Pawn(Color.YELLOW),new Pawn(Color.YELLOW),new Pawn(Color.YELLOW),new Pawn(Color.YELLOW),new Pawn(Color.YELLOW)};
    public static Pawn[] BLUE_PAWNS =
            {new Pawn(Color.BLUE),new Pawn(Color.BLUE),new Pawn(Color.BLUE),new Pawn(Color.BLUE),new Pawn(Color.BLUE),new Pawn(Color.BLUE),new Pawn(Color.BLUE),new Pawn(Color.BLUE)};

    public Game(ArrayList<Player> players, Cardset cardset){
        this.cardset = cardset;
        board = new Board();
        this.players = new ArrayList<>();
        this.players.addAll(players);
        scoreboard = new int[50][4];
        for(int i = 0; i < 4; i++){
            scoreboard[0][i] = i+1;
        }
    }

    public Cardset getCardset() {
        return cardset;
    }

    public void setCardset(Cardset cardset) {
        this.cardset = cardset;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
