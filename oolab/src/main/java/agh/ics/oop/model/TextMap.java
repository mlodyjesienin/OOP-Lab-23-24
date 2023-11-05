package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class TextMap implements WorldMap<String, Integer> {
    private final Map<Integer, String> objects = new HashMap<>();

    private Integer currSize;

    public TextMap(){
        this.currSize = 0;
    }

    @Override
    public boolean place(String object) {
        currSize++;
        objects.put(currSize,object);
        return true;

    }

    @Override
    public boolean isOccupied(Integer position) {
        return position <= currSize && position >=1;
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return position <= currSize && position >=1;
    }

    private Integer getKeyByValue(Map<Integer,String> map, String value){
        for (Map.Entry<Integer, String > entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    @Override
    public void move(String object, MoveDirection direction) {
        Integer key = getKeyByValue(objects,object);
        if(!(key==null)){
            switch (direction) {
                case BACKWARD -> {
                    if(canMoveTo(key-1)){
                        String leftNeighbour = objects.get(key-1);
                        objects.remove(key+1, leftNeighbour);
                        objects.remove(key, object);
                        objects.put(key, leftNeighbour);
                        objects.put(key+1,object);

                    }
                }
                case FORWARD -> {
                    if(canMoveTo(key+1)){
                        String rightNeighbour = objects.get(key+1);
                        objects.remove(key+1, rightNeighbour);
                        objects.remove(key, object);
                        objects.put(key, rightNeighbour);
                        objects.put(key+1,object);

                    }
                }
                case RIGHT -> {}
                case LEFT -> {}
            }
        }
    }

    @Override
    public String objectAt(Integer position) {
        return objects.get(position);
    }
}
