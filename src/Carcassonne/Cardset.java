package Carcassonne;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Project Carcassonne
 * Created by Friday.
 */
public class Cardset {
    private ArrayList<Card> cards;
    private static String[] paths = {
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png",
            "C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png","C:/Users/Romain/Desktop/log.png"
    };

    public Cardset(){
        cards = new ArrayList<>();
        for(int i = 0; i < 72; i++){
            cards.add(new Card(paths[i]));
        }
    }

    private void shuffle(){
        Collections.shuffle(cards);
    }

    public Card pick(){
        return cards.remove(cards.size()-1);
    }
}
