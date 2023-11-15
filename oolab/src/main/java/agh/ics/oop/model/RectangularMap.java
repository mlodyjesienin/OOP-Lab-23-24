package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {

    
    public RectangularMap(int width, int height){
        lowerCorner = new Vector2d(0,0);
        upperCorner = new Vector2d(width,height);
    }


    public boolean canMoveTo(Vector2d position){
        return super.canMoveTo(position) && position.follows(lowerCorner) && position.precedes(upperCorner);
    }


}
