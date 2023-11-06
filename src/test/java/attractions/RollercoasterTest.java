package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor child;
    Visitor adult;
    Visitor tallAdult;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10,12,1.45);
        child = new Visitor(13,1.5, 0.0);
        adult = new Visitor(88,1.6, 12.0);
        tallAdult = new Visitor(50,2.1, 50.0);
    }


    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }
    @Test
    public void hasDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.1);
    }
    @Test
    public void canRide(){
        assertTrue(rollerCoaster.isAllowedTo(child));
    }
    @Test
    public void doublePrice200Height(){
        assertEquals(16.8, rollerCoaster.priceFor(tallAdult), 0.1);
    }
}
