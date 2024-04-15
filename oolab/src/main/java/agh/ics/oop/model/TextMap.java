package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TextMap  implements WorldMap<String, Integer,String>{
    private final Map<Integer, String> objects = new HashMap<>();
    private final UUID mapID = UUID.randomUUID();


    private Integer currSize;

    public TextMap(){
        this.currSize = 0;
    }

    public void place(String object) {
        currSize++;
        objects.put(currSize,object);

    }

    @Override
    public UUID getMapID() {
        return mapID;
    }

    public boolean isOccupied(Integer position) {
        return position <= currSize && position >=1;
    }

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


    public String objectAt(Integer position) {
        return objects.get(position);
    }
}
