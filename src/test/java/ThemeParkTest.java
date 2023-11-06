import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.*;

public class ThemeParkTest {
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
    ThemePark themePark;

    @Before
    public void setUp() throws Exception {
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
        themePark = new ThemePark("The best park");

    }
    @Test
    public void startsEmpty() {
        assertEquals(0, themePark.placesCount());
    }
    @Test
    public void placesCount() {
        themePark.addPlace(rollerCoaster);
        themePark.addPlace(dodgems);
        themePark.addPlace(park);
        themePark.addPlace(playground);
        themePark.addPlace(candyflossStall);
        assertEquals(5, themePark.placesCount());
    }
    @Test
    public void emptyPlaceList() {
        themePark.addPlace(rollerCoaster);
        themePark.addPlace(dodgems);
        themePark.addPlace(park);
        themePark.addPlace(playground);
        themePark.addPlace(candyflossStall);
        themePark.emptyPlaceList();
        assertEquals(0, themePark.placesCount());
    }
    @Test
    public void returnsEveryIReviewedObject(){
        themePark.addPlace(rollerCoaster);
        themePark.addPlace(dodgems);
        themePark.addPlace(park);
        themePark.addPlace(playground);
        themePark.addPlace(candyflossStall);
        themePark.addPlace(iceCreamStall);
        themePark.addPlace(tobaccoStall);
        assertEquals(7, themePark.getAllReviewed().size());
    }
    @Test
    public void visitTest(){
        assertEquals(0, dodgems.getVisitCount());
        assertEquals(0, adult.getVisitedAttractions().size());
        themePark.visit(adult, dodgems);
        assertEquals(1, dodgems.getVisitCount());
        assertEquals(1, adult.getVisitedAttractions().size());
    }
    @Test
    public void hashMapAllReviews(){
        themePark.addPlace(rollerCoaster);
        HashMap<String, Integer> reviews = themePark.getAllReviews();
        Optional<Integer> blueRidgeRating = Optional.ofNullable(reviews.get("Blue Ridge"));
        assertEquals(Optional.of(10), blueRidgeRating);
    }
    @Test
    public void checkAllowedAttractionList(){
        themePark.addPlace(rollerCoaster);
        themePark.addPlace(dodgems);
        themePark.addPlace(park);
        themePark.addPlace(playground);
        assertEquals(3, themePark.getAllAllowedFor(child).size());
        assertEquals(4, themePark.getAllAllowedFor(adult).size());
    }
}