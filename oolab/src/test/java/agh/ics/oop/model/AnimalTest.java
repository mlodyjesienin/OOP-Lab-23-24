package agh.ics.oop.model;

import agh.ics.oop.Vector2d;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void integralAnimalTest(){
        Animal animal = new Animal();
        Animal animal2 = new Animal(new Vector2d(3,3));
        Animal animal3 = new Animal(new Vector2d(4,4));

        animal2.move(MoveDirection.FORWARD);
        animal3.move(MoveDirection.FORWARD);


        assertEquals(MapDirection.NORTH,animal.getDirection());
        assertEquals(new Vector2d(3,4),animal2.getPosition());
        assertEquals(new Vector2d(4,4),animal3.getPosition());


    }
}


