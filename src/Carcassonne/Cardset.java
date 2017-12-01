package Carcassonne;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Cardset {
    private ArrayList<Card> cards;
    private static final String IMG_PATH = ".\\out\\production\\Carcassonne\\img\\pieces\\";
    private static String[] paths = {
            IMG_PATH+"1.txt",IMG_PATH+"1.txt",IMG_PATH+"1.txt",
            IMG_PATH+"1.txt",IMG_PATH+"1.txt",IMG_PATH+"1.txt",
            IMG_PATH+"1.txt",IMG_PATH+"1.txt",IMG_PATH+"1.txt",
            IMG_PATH+"2.txt",IMG_PATH+"2.txt",IMG_PATH+"2.txt",
            IMG_PATH+"3.txt",IMG_PATH+"3.txt",IMG_PATH+"4.txt",
            IMG_PATH+"5.txt",IMG_PATH+"6.txt",IMG_PATH+"6.txt",
            IMG_PATH+"6.txt",IMG_PATH+"7.txt",IMG_PATH+"7.txt",
            IMG_PATH+"7.txt",IMG_PATH+"8.txt",IMG_PATH+"8.txt",
            IMG_PATH+"8.txt",IMG_PATH+"8.txt",IMG_PATH+"8.txt",
            IMG_PATH+"8.txt",IMG_PATH+"8.txt",IMG_PATH+"8.txt",
            IMG_PATH+"9.txt",IMG_PATH+"9.txt",IMG_PATH+"9.txt",
            IMG_PATH+"9.txt",IMG_PATH+"10.txt",IMG_PATH+"10.txt",
            IMG_PATH+"10.txt",IMG_PATH+"10.txt",IMG_PATH+"10.txt",
            IMG_PATH+"11.txt",IMG_PATH+"11.txt",IMG_PATH+"12.txt",
            IMG_PATH+"12.txt",IMG_PATH+"12.txt",IMG_PATH+"13.txt",
            IMG_PATH+"13.txt",IMG_PATH+"13.txt",IMG_PATH+"13.txt",
            IMG_PATH+"14.txt",IMG_PATH+"14.txt",IMG_PATH+"15.txt",
            IMG_PATH+"15.txt",IMG_PATH+"15.txt",IMG_PATH+"16.txt",
            IMG_PATH+"16.txt",IMG_PATH+"17.txt",IMG_PATH+"17.txt",
            IMG_PATH+"17.txt",IMG_PATH+"17.txt",IMG_PATH+"18.txt",
            IMG_PATH+"18.txt",IMG_PATH+"18.txt",IMG_PATH+"19.txt",
            IMG_PATH+"20.txt",IMG_PATH+"20.txt",IMG_PATH+"21.txt"
    };

    public Cardset(Board b) {
        cards = new ArrayList<>();
        for(int i = 0; i < paths.length; i++){
            try {
                cards.add(new Card(paths[i],b));
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    private void shuffle(){
        Collections.shuffle(cards);
    }

    public Card pick(){
        return cards.remove(cards.size()-1);
    }
}
