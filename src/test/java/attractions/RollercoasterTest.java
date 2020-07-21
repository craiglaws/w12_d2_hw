package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(20, 2.02, 20.0);
        visitor2 = new Visitor(13, 1.35, 12.0);
        visitor3 = new Visitor(9, 1.66, 17.0);
        visitor4 = new Visitor(11, 0.9, 15.0);
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
    public void hasAgeAndHeightLimit(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void canChargeDifferentPrices(){
        assertEquals(8.4, rollerCoaster.priceFor(visitor2), 0.01);
        assertEquals(16.8, rollerCoaster.priceFor(visitor1), 0.01);
    }
}
