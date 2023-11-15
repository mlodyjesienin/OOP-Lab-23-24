package agh.ics.oop.model;

public interface UsefulWorldMap extends WorldMap<WorldElement, Vector2d>{
    @Override
    WorldElement objectAt(Vector2d position);
}
