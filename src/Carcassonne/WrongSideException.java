package Carcassonne;

/**
 * Project Carcassonne
 * Created by Romain on 01/12/2017.
 */
public class WrongSideException extends Throwable {
    @Override
    public String getMessage() {
        return "Wrong side of the card past in parameter";
    }
}
