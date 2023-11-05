package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Simulation {
    private  List <MoveDirection> directions;
    private  List <Vector2d> positions;

    private RectangularMap worldMap;
    private List <Animal> animals;
    public Simulation(List <MoveDirection> directions, List <Vector2d> positions, RectangularMap worldMap){
        this.directions = directions;
        this.positions = positions;
        this.worldMap = worldMap;
        this.animals  = new LinkedList<>();
        for (Vector2d position : positions){
            this.animals.add(new Animal(position));
            this.worldMap.place(new Animal(position));
        }
    }

    public void run() {
        Iterator<Animal> animalsIterator = animals.iterator();
        Animal currAnimal;
        int i=0;
        for (MoveDirection direction : directions) {
            if (!animalsIterator.hasNext()) {
                animalsIterator = animals.iterator();
                i =1;
                currAnimal = animalsIterator.next();
                //currAnimal.move(directions, worldMap);
                //System.out.print(" ");
            } else {
                currAnimal = animalsIterator.next();
                i++;
                //currAnimal.move(directions, worldMap);
                //System.out.print(" ");
            }
            worldMap.move(currAnimal,direction);
            System.out.println(currAnimal.getPosition());
            System.out.println(direction);
            System.out.print("ruch zwierzecia nr: ");
            System.out.println(i);
            System.out.println(worldMap);
        }


    }
}

