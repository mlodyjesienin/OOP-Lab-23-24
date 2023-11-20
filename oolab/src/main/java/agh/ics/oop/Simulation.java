package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Simulation {
    private final List <MoveDirection> directions;

    private final RectangularMap worldMap;
    private final List <Animal> animals;
    public Simulation(List <MoveDirection> directions, List <Vector2d> positions, RectangularMap worldMap){
        this.directions = directions;
        this.worldMap = worldMap;
        this.animals  = new LinkedList<>();
        for (Vector2d position : positions){
            this.animals.add(new Animal(position));
            try {
                this.worldMap.place(new Animal(position));
            }
            catch (PositionAlreadyOccupiedException ignored){

            }
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

            } else {
                currAnimal = animalsIterator.next();
                i++;
            }
            worldMap.move(currAnimal,direction);
        }


    }
}

