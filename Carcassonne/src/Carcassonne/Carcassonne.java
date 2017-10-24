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
        Group root = new Group();
        Scene scene = new Scene(root);

        ArrayList<Player>players = new ArrayList<Player>();
        players.add(new Player(Game.RED_PAWNS));

        Cardset cardset = new Cardset();

        Game game = new Game(players, cardset);

        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}