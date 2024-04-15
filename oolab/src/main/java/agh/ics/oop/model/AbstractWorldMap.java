package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap<WorldElement,Vector2d, Animal> {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected Boundary currentBound;
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    private final Set<MapChangeListener> Listeners = new HashSet<>();
    private final UUID mapID = UUID.randomUUID();


    public void subscribe(MapChangeListener listener){
        Listeners.add(listener);
    }
    public void unsubscribe(MapChangeListener listener){
        Listeners.remove(listener);
    }
    private void mapChanged(String message){
        for (MapChangeListener listener : Listeners) {
            listener.mapChanged(this, message);
        }
    }

    public UUID getMapID() {
        return mapID;
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d currPosition = animal.getPosition();
        if (animals.containsValue(animal)) {
            animal.move(direction, this);
            Vector2d newPosition = animal.getPosition();
            animals.remove(currPosition);
            animals.put(newPosition, (Animal) animal);
            mapChanged("Old Pos: " + currPosition + " Moved " + direction + " New Pos:" + newPosition);
        }
    }
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            animals.put(position,animal);
            mapChanged("Placed new Animal at: " +  position);
        }
        else throw new PositionAlreadyOccupiedException(position);
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
    public  abstract Boundary getCurrentBounds();

    public String toString() {
       return visualizer.draw(getCurrentBounds().lowerCorner(), getCurrentBounds().upperCorner());
    }
}
