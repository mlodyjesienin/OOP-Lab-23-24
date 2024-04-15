package agh.ics.oop.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void integralAnimalTest(){
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(3,1));
        Animal animal3 = new Animal(new Vector2d(4,4));



        assertEquals(MapDirection.NORTH,animal1.getDirection());
        assertEquals(new Vector2d(2,2), animal1.getPosition());
        assertEquals(new Vector2d(3,1),animal2.getPosition());
        assertEquals(new Vector2d(4,4),animal3.getPosition());


    }

}


