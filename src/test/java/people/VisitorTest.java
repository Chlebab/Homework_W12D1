package people;

import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    RollerCoaster rollerCoaster;
    Visitor child;
    Visitor adult;
    Visitor tallAdult;
    Dodgems dodgems;
    Park park;
    Playground playground;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10,12,1.45);
        dodgems = new Dodgems("Bumper Cars", 5,0,0);
        park = new Park("Leafy Meadows", 9,0,0);
        playground = new Playground("Fun Zone", 7,15,0);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 10);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 8);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1,2);
        child = new Visitor(13,1.5, 0.0);
        adult = new Visitor(88,1.6, 12.0);
        tallAdult = new Visitor(50,2.1, 50.0);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }
    @Test
    public void visitedAttractionStartsZero(){
        assertEquals(0, visitor.getVisitedAttractions().size());
    }
    @Test
    public void canAddAttraction(){
        visitor.addVisitedAttraction(park);
        visitor.addVisitedAttraction(dodgems);
        assertEquals(2, visitor.getVisitedAttractions().size());
    }
}
