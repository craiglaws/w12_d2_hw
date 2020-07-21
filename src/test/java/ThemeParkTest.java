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

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;

    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    ThemePark themePark;

    @Before
    public void before(){
        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);

        visitor1 = new Visitor(20, 2.02, 20.0);
        visitor2 = new Visitor(13, 1.35, 12.0);
        visitor3 = new Visitor(9, 1.66, 17.0);
        visitor4 = new Visitor(11, 0.9, 15.0);

        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 6);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 9);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);

        themePark = new ThemePark();
    }

    @Test
    public void canAddAttractionsAndStalls(){
        themePark.addAttraction(dodgems);
        themePark.addStall(iceCreamStall);
        assertEquals(1, themePark.getAttractions().size());
        assertEquals(1, themePark.getStalls().size());
    }

    @Test
    public void canReturnAllIReviewed(){
        themePark.addStall(iceCreamStall);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        assertEquals(3, themePark.getAllReviewed().size());
    }

    @Test
    public void attractionVisitedIncreaseCountAndAddToList(){
        themePark.visit(visitor1, rollerCoaster);
        assertEquals(1, visitor1.getVisitedAttractions().size());
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGetHashOfReviews(){
        themePark.addAttraction(rollerCoaster);
        themePark.addStall(iceCreamStall);
        assertEquals(2, themePark.getReviews().size());
    }
}
