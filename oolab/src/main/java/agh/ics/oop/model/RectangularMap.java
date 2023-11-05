package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap<Animal,Vector2d> {
    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d LOWER_CORNER;
    private final Vector2d UPPER_CORNER;
    private final MapVisualizer visualizer;
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        LOWER_CORNER = new Vector2d(0,0);
        UPPER_CORNER = new Vector2d(width,height);
        visualizer = new MapVisualizer(this);

    }

    public Vector2d getLOWER_CORNER() {
        return LOWER_CORNER;
    }

    public Vector2d getUPPER_CORNER() {
        return UPPER_CORNER;
    }

    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position){
        return !isOccupied(position) && position.precedes(UPPER_CORNER) && position.follows(LOWER_CORNER);
    }

    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            animals.put(position, animal);
            return true;
        }
        else return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d currPosition = animal.getPosition();
        if( animals.containsValue(animal)){
            animal.move(direction, this);
            Vector2d newPosition = animal.getPosition();
            //if(!currPosition.equals(newPosition) {
                animals.remove(currPosition);
                animals.put(newPosition, animal);

                //}


        }
    }
    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }
    public String toString(){
        return visualizer.draw(LOWER_CORNER, UPPER_CORNER);
    }
}
