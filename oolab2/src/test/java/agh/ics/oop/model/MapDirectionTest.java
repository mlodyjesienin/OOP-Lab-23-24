package agh.ics.oop.model;
import org.junit.Test;
import static org.junit.Assert.*;

import static agh.ics.oop.model.MapDirection.EAST;
import static agh.ics.oop.model.MapDirection.SOUTH;
import static agh.ics.oop.model.MapDirection.WEST;
import static agh.ics.oop.model.MapDirection.NORTH;



public class MapDirectionTest {
    @Test
    public void testNext(){
        assertEquals(NORTH, WEST.next());
        assertEquals(WEST, SOUTH.next());
        assertEquals(EAST, NORTH.next());
        assertEquals(SOUTH, EAST.next());
    }

    @Test
    public void testPrevious(){
        assertEquals(NORTH, EAST.previous());
        assertEquals(WEST, NORTH.previous());
        assertEquals(EAST, SOUTH.previous());
        assertEquals(SOUTH, WEST.previous());
    }
    @Test
    public void testToString(){
        assertEquals("Wschód", EAST.toString());
        assertEquals("Zachód", WEST.toString());
        assertEquals("Południe", SOUTH.toString());
        assertEquals("Północ", NORTH.toString());

    }
}
