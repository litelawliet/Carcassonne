package Carcassonne;

/**
 * Project Carcassonne
 * Created by Romain on 01/12/2017.
 */
public class NotSideException extends Throwable {
    @Override
    public String getMessage() {
        return "Value past in parameter is not a side";
    }
}
