package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static agh.ics.oop.OptionParser.optParser;

public class World {
    public static void main(String[] args){
        GrassField exampleMap = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(1,2));
        Animal animal2 = new Animal(new Vector2d(2,2));
        Animal animal3 = new Animal(new Vector2d(3,0));
        Animal animal4 = new Animal(new Vector2d(6,6));
        RectangularMap examplemap2 = new RectangularMap(5,5);
        System.out.println(examplemap2.place(animal1));
        examplemap2.move(animal1,MoveDirection.FORWARD);
       // exampleMap.place(animal1);
       // exampleMap.place(animal2);
        //exampleMap.place(animal3);
        //exampleMap.place(animal4);
       // System.out.println(exampleMap.objectAt(new Vector2d(0,0)));
        System.out.println(examplemap2);
        //System.out.println(exampleMap);


    }

}
