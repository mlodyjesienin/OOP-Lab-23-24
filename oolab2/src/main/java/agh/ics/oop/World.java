package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;

import static agh.ics.oop.OptionParser.optParser;
import static agh.ics.oop.model.MapDirection.EAST;

public class World {
     public static void main(String[] args){
         Vector2d position1 = new Vector2d(1,2);
         System.out.println(position1);
         Vector2d position2 = new Vector2d(-2,1);
         MapDirection direction1 =  EAST;
         System.out.println(direction1.toUnitVector()) ;
         System.out.println(direction1.next());
         System.out.println(position2);
         System.out.println(position1.add(position2));

         //System.out.println("system wystartowal");
         //MoveDirection[] tab = optParser(args);
         //run(tab);
         //System.out.println("system zakonczyl dzialane");

    }
    static void run(MoveDirection[] args){
        for(MoveDirection x : args){
            switch(x){
                case FORWARD -> System.out.println("zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("zwierzak idzie do tyłu");
                case RIGHT-> System.out.println("zwierzak skręca w prawo");
                case LEFT -> System.out.println("zwierzak skręca w lewo");
            }
        }
    }
}
