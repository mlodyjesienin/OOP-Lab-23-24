package agh.ics.oop.model;
import agh.ics.oop.Vector2d;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Vector2dTest {
    @Test
    public void testFollows(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(2,1);
        assertEquals(true, vector1.follows(vector2));
        assertEquals(false,vector2.follows(vector1));
    }

    @Test
    public void testPrecedes(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(2,1);
        assertEquals(false, vector1.precedes(vector2));
        assertEquals(true,vector2.precedes(vector1));
    }

    @Test
    public void testUpperRight(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(5,1);
        Vector2d vector3 = new Vector2d(5,3);
        assertEquals(vector3, vector1.upperRight(vector2));
    }

    @Test
    public void testLowerLeft(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(5,1);
        Vector2d vector3 = new Vector2d(2,1);
        assertEquals(vector3, vector1.lowerLeft(vector2));
    }

    @Test
    public void testAdd(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(5,1);
        Vector2d vector3 =  new Vector2d(7,4);
        assertEquals(vector3, vector1.add(vector2));
    }

    @Test
    public void testSubtract(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(5,1);
        Vector2d vector3 = new Vector2d(-3,2);
        assertEquals(vector3, vector1.subtract(vector2));
    }

    @Test
    public void testOpposite(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(-2,-3);
        assertEquals(vector2, vector1.opposite());
    }
    @Test
    public void testEquals(){
        Vector2d vector1 = new Vector2d(2,3);
        Vector2d vector2 = new Vector2d(2,3);
        Vector2d vector3 = new Vector2d(1,1);
        assertEquals(true,vector1.equals(vector2));
        assertEquals(false,vector1.equals(vector3));
    }
}
