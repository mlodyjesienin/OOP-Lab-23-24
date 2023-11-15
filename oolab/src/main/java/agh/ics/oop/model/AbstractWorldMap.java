package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap<WorldElement,Vector2d> {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected Vector2d lowerCorner;
    protected Vector2d upperCorner;
    protected final MapVisualizer visualizer = new MapVisualizer(this);

    public void move(WorldElement animal, MoveDirection direction) {
        Vector2d currPosition = animal.getPosition();
        if (animals.containsValue((Animal) animal)) {
            ((Animal) animal).move(direction, this);
            Vector2d newPosition = animal.getPosition();
            animals.remove(currPosition);
            animals.put(newPosition, (Animal) animal);
        }
    }
    public boolean place(WorldElement animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            animals.put(position, (Animal) animal);
            return true;
        }
        else return false;
    }
    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }
    public Vector2d getLowerCorner(){
        return lowerCorner;
    }
    public Vector2d getUpperCorner(){
        return upperCorner;
    }
    public String toString() {
       return visualizer.draw(getLowerCorner(),getUpperCorner());
    }
}
