package Carcassonne;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Carcassonne extends Application{
    public static void main(String[] args){
        Application.launch(Carcassonne.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Carcassonne");

        ArrayList<Player>players = new ArrayList<Player>();
        players.add(new Player(Game.RED_PAWNS));

        Board board = new Board();
        Cardset cardset = new Cardset(board);

        Game game = new Game(players, cardset, board);

        primaryStage.setFullScreen(true);
        primaryStage.setScene(game.board.getScene());
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
    }
}