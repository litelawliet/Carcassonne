package Carcassonne;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Player {
    private ArrayList<Pawn> availablePawns;
    private ArrayList<Pawn> droppedPawns;
    private ArrayList<Card> hand;
    private int score;
    private Game game;

    public Player(Pawn[] pawns) {
        score = 0;
        availablePawns = new ArrayList<>();
        availablePawns.addAll(Arrays.asList(pawns));
        hand = new ArrayList<>();
        droppedPawns = new ArrayList<Pawn>();
    }

    public Card pick() {
        hand.add(game.getCardset().pick());
        return hand.get(hand.size() - 1);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public ArrayList<Pawn> getAvailablePawns() {
        return availablePawns;
    }

    public void setAvailablePawns(ArrayList<Pawn> availablePawns) {
        this.availablePawns = availablePawns;
    }

    public ArrayList<Pawn> getDroppedPawns() {
        return droppedPawns;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Pawn givePawn() {
        Pawn p = availablePawns.get(0);
        availablePawns.remove(0);
        droppedPawns.add(p);
        return p;
    }

    public void getPawnBack(Pawn p) {
        p.setType(Pawn.Type.NONE);
        availablePawns.add(p);
        droppedPawns.remove(p);
    }
}
