package Carcassonne;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Project Carcassonne-master
 * Created by Lollipop on 01/11/2017.
 */
public class BoardTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testAddTile() throws Exception{
        Board b = new Board();
        Card c = new Card("markarth");

        b.addTile(c, 0, 0);

        Assert.assertTrue(b.contains(c));
    }

    @Test
    public void testSize() throws Exception{
        Board b = new Board();
        b.addTile(new Card("whiterun"), 5, 5);

        Assert.assertEquals(1, b.getNumTiles());
    }

    @Test
    public void testIsEmpty(){
        Board b = new Board();

        Assert.assertTrue(b.isEmpty());
    }

    @Test
    public void testAddTilesNegatif() throws Exception{
        Board b = new Board();

        exception.expect(TileOutOfRangeException.class);

        b.addTile(new Card(""), -8, 10);
    }

    @Test
    public void testAjoutAuMemeEndroit() throws Exception{
        Board b = new Board();

        b.addTile(new Card("solitude"), 0, 0);
        b.addTile(new Card("windhelm"), 0, 0);

        System.out.println(b);
    }
}
