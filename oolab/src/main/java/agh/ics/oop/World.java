package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;

import java.util.LinkedList;
import java.util.List;
import static agh.ics.oop.OptionParser.optParser;
import static agh.ics.oop.model.MapDirection.EAST;

public class World {
    public static void main(String[] args){
       // Animal animal1 = new Animal();
        //System.out.println(animal1.toString());
        //List <MoveDirection> moves = optParser(args);

        List<MoveDirection> directions = optParser(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(directions,positions);
        simulation.run();


    }
    static void run(List <MoveDirection> moves){
        for(MoveDirection simple_move : moves){
            switch(simple_move){
                case FORWARD -> System.out.println("zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("zwierzak idzie do tyłu");
                case RIGHT-> System.out.println("zwierzak skręca w prawo");
                case LEFT -> System.out.println("zwierzak skręca w lewo");
            }
        }
    }
}
