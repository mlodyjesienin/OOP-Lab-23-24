package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int changesCounter = 0;
    @Override
    public void mapChanged(WorldMap<WorldElement, Vector2d, Animal> worldMap, String message) {
        synchronized (this) {
            changesCounter++;
            System.out.println("It is change no. " + changesCounter + " that occured.");
            System.out.println(worldMap.getMapID());
            System.out.println(message);
            System.out.println(worldMap);
        }


    }
}
