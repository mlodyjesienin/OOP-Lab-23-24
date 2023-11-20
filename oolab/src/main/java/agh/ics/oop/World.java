package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

import static agh.ics.oop.OptionParser.optParser;

public class World {
    public static void main(String[] args){
        try {
            List<MoveDirection> moves = optParser(args);


            List<Vector2d> positions = List.of(new Vector2d(1, 2), new Vector2d(2, 2),
                                               new Vector2d(3, 0),new Vector2d(6, 6));
            ConsoleMapDisplay exampleDisplay = new ConsoleMapDisplay();
            RectangularMap exampleMap = new RectangularMap(10, 10);
            exampleMap.subscribe(exampleDisplay);
            Simulation simulation = new Simulation(moves, positions, exampleMap);
            simulation.run();
        }
        catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        Animal animal1 = new Animal(new Vector2d(1,2));
        Animal animal2 = new Animal(new Vector2d(2,2));
        Animal animal3 = new Animal(new Vector2d(3,0));
        Animal animal4 = new Animal(new Vector2d(6,6));


    }

}
