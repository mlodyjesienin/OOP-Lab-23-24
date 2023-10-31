package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Simulation {
    private  List <MoveDirection> directions;
    private  List <Vector2d> positions;

    private List <Animal> animals;
    public Simulation(List <MoveDirection> directions, List <Vector2d> positions ){
        this.directions = directions;
        this.positions = positions;
        this.animals  = new LinkedList<>();
        for (Vector2d position : positions){
            this.animals.add(new Animal(position));
        }
    }

    public void run() {
        Iterator<Animal> animalsIterator = animals.iterator();
        Animal currAnimal;
        int i=0;
        for (MoveDirection directions : directions) {
            if (!animalsIterator.hasNext()) {
                animalsIterator = animals.iterator();
                i =1;
                currAnimal = animalsIterator.next();
                currAnimal.move(directions);
                System.out.print("zwierze nr: ");
                System.out.print(i);
                System.out.print(" ");
                System.out.println(currAnimal.toString());
            } else {
                currAnimal = animalsIterator.next();
                i++;
                currAnimal.move(directions);
                System.out.print("zwierze nr: ");
                System.out.print(i);
                System.out.print(" ");
                System.out.println(currAnimal.toString());
            }
        }


    }
}

