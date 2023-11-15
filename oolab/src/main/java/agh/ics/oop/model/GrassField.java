package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private final int grassCount;
    private final Map<Vector2d,Grass> grassMap = new HashMap<>();


    public GrassField(int grassCount){
        this.grassCount = grassCount;
        grassMapGenerator();
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        return grassMap.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grassMap.containsKey(position);
    }

    private void grassMapGenerator(){
        lowerCorner = new Vector2d(0,0);
        int boundary = (int) sqrt(10*grassCount);
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(boundary, boundary, grassCount);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grassMap.put(grassPosition, new Grass(grassPosition));
        }
    }

    public Vector2d getLowerCorner() {
        int boundary = (int) sqrt(10*grassCount);
        lowerCorner = new Vector2d(boundary,boundary);              // w tym zakresie generowalismy na starcie
        Vector2d position;                                          // trawy, dlatego mozemy byc pewni, że istnieje
                                                                    // obecny element "ponizej" tego ( i go wykryjemy).
        for (Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            position = entry.getKey();
            lowerCorner = lowerCorner.lowerLeft(position);
        }
        for (Map.Entry<Vector2d, Grass> entry : grassMap.entrySet()) {
            position = entry.getKey();
            lowerCorner = lowerCorner.lowerLeft(position);
        }
        return lowerCorner;
    }

    public Vector2d getUpperCorner() {
        upperCorner = new Vector2d(0,0);              // od (0,0) generowalismy na starcie
        Vector2d position;                                  // trawy, dlatego mozemy byc pewni, że istnieje
                                                            // obecny element "powyzej" tego ( i go wykryjemy).
        for (Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
            position = entry.getKey();
            upperCorner = upperCorner.upperRight(position);
        }
        for (Map.Entry<Vector2d, Grass> entry : grassMap.entrySet()) {
            position = entry.getKey();
            upperCorner = upperCorner.upperRight(position);
        }
        return upperCorner;
    }
}
