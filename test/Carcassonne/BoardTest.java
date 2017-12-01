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
        Card c = new Card("markarth",b);

        b.addTile(c, 0, 0);

        Assert.assertTrue(b.contains(c));
    }

    @Test
    public void testSize() throws Exception{
        Board b = new Board();
        b.addTile(new Card("whiterun",b), 0, 0);

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

        b.addTile(new Card("",b), -8, 10);
    }

    @Test
    public void testGetTile() throws Exception{
        Board b = new Board();
        Card c = new Card("dawnstar",b);
        b.addTile(c, 0, 0);

        Assert.assertEquals(c, b.getTileAt(1, 1));
    }

    @Test
    public void testAjoutAuMemeEndroit() throws Exception{
        Board b = new Board();
        Card c1 = new Card("solitude",b);
        Card c2 = new Card("windhelm",b);


        b.addTile(c1, 0, 0);
        b.addTile(c2, 0, 0);

        Assert.assertEquals(c1, b.getTileAt(2, 2));
        Assert.assertEquals(c2, b.getTileAt(1, 1));
    }

    @Test
    public void testAjoutSansVoisin() throws Exception{
        Board b = new Board();

        b.addFirstTile(new Card("solitude",b));

        exception.expect(TileHasNoNeighborException.class);

        b.addTile(new Card("morthal",b), 3, 5); // cette carte n'a pas de voisines
    }

    @Test
    public void testAjoutDouble() throws Exception{
        Board b = new Board();

        b.addFirstTile(new Card("solitude",b)); // 1, 1
        b.addTile(new Card("morthal",b), 2, 1);
    }

    @Test
    public void testPose2CartesMemeEmplacement() throws Exception{
        Board b = new Board();

        b.addFirstTile(new Card("yolo",b));

        exception.expect(CardAlreadyThereException.class);
        b.addTile(new Card("swag",b),1 ,1);
    }
}
