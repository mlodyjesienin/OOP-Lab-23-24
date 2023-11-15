package agh.ics.oop.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GrassMapTest {
    @Test
    public void GrassMapIntegralTest(){
        //GIVEN
        GrassField exampleMap = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(10, 10));
        Animal animal3 = new Animal(new Vector2d(6, 1));
        Animal animal4 = new Animal(new Vector2d(3, 0));
        Animal animal5 = new Animal(new Vector2d(4, 3));
        Animal animal6 = new Animal(new Vector2d(4, 2));
        Vector2d upperCorner = new Vector2d(10,10);
        Vector2d lowerCorner = new Vector2d(0,0);


        //WHEN
        exampleMap.place(animal1);
        exampleMap.place(animal2);
        exampleMap.place(animal3);
        exampleMap.place(animal4);
        exampleMap.place(animal5);
        exampleMap.place(animal6);

        exampleMap.move(animal1, MoveDirection.RIGHT);
        exampleMap.move(animal1, MoveDirection.FORWARD);

        exampleMap.move(animal2, MoveDirection.FORWARD);

        exampleMap.move(animal3, MoveDirection.RIGHT);
        exampleMap.move(animal3, MoveDirection.FORWARD);

        exampleMap.move(animal4, MoveDirection.BACKWARD);

        exampleMap.move(animal6, MoveDirection.FORWARD);


        //THEN
        assertEquals(MapDirection.EAST, animal1.getDirection());
        assertEquals(new Vector2d(3, 2), animal1.getPosition());

        assertEquals(new Vector2d(10, 11), animal2.getPosition());
        assertEquals(MapDirection.NORTH, animal2.getDirection());
        assertEquals(upperCorner.add(new Vector2d(0,1)), exampleMap.getUpperCorner());

        assertEquals(new Vector2d(7, 1), animal3.getPosition());
        assertEquals(MapDirection.EAST, animal3.getDirection());

        assertEquals(new Vector2d(3, -1), animal4.getPosition());
        assertEquals(lowerCorner.add(new Vector2d(0,-1)), exampleMap.getLowerCorner());

        assertEquals(new Vector2d(4, 2), animal6.getPosition());
    }
}
