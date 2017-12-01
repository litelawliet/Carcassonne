package Carcassonne;

/**
 * Project Carcassonne
 * Created by Romain on 01/12/2017.
 */
public class AlreadyNeighborException extends Throwable {
    @Override
    public String getMessage() {
        return "There's already a neighbor here";
    }
}
