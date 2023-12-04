package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionParser.optParser;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> moves = optParser(args);


        List<Vector2d> positions = List.of(new Vector2d(1, 2), new Vector2d(2, 2),
                new Vector2d(3, 0), new Vector2d(6, 6));
        ConsoleMapDisplay exampleDisplay = new ConsoleMapDisplay();
        //RectangularMap exampleMap = new RectangularMap(10, 10);
        //GrassField exampleGrassMap =  new GrassField(10);

        SimulationEngine exampleEngine = null;
        for (int k = 0; k < 10; k++) {
            RectangularMap exampleMap = new RectangularMap(10, 10);
            GrassField exampleGrassMap = new GrassField(10);
            exampleMap.subscribe(exampleDisplay);
            exampleGrassMap.subscribe(exampleDisplay);
            Simulation recSimulation = new Simulation(moves, positions, exampleMap);
            Simulation grassSimulation = new Simulation(moves, positions, exampleGrassMap);
            List<Simulation> Simulations = new ArrayList<>();
            Simulations.add(recSimulation);
            Simulations.add(grassSimulation);
            exampleEngine = new SimulationEngine(Simulations);
            //exampleEngine.runSync();
        }
        try{
            exampleEngine.runAsyncInThreadPool();
        }catch(InterruptedException e){
            System.out.println("exception" + e);
        }

        System.out.println("SYSTEM ZAKONCZYL DZIALANIE");



    }
}
