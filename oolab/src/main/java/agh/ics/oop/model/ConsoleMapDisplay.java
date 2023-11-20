package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int changesCounter = 0;
    @Override
    public void mapChanged(WorldMap<WorldElement, Vector2d, Animal> worldMap, String message) {
        changesCounter++;
        System.out.println("It is change no. " + changesCounter + " that occured on this Map.");
        System.out.println(message);
        System.out.println(worldMap);


    }
}
