package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor child;
    Visitor adult;


    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7,15,0);
        child = new Visitor(14,1.1, 0.0);
        adult = new Visitor(88,1.8, 12.0);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void meetsAgeRequirment(){
        assertTrue(playground.isAllowedTo(child));
        assertFalse(playground.isAllowedTo(adult));
    }

}
