package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor child;
    Visitor adult;
    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5, 0,0);
        child = new Visitor(8,1.5, 0.0);
        adult = new Visitor(40,1.5, 0.0);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(4.50, dodgems.defaultPrice(), 0.1);
    }
    @Test
    public void childUnder12PaysHalf(){
        assertEquals(2.25, dodgems.priceFor(child), 0.1);
        assertEquals(4.5, dodgems.priceFor(adult), 0.1);
    }
}
