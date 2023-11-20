package agh.ics.oop.model;

public interface MapChangeListener {
    void mapChanged(WorldMap<WorldElement,Vector2d, Animal> worldMap, String message);
}
