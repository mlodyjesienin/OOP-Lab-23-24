package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {

    
    public RectangularMap(int width, int height){
        currentBound = new Boundary(new Vector2d(0,0), new Vector2d(width, height));
    }

    @Override
    public Boundary getCurrentBounds() {
        return currentBound;
    }

    public boolean canMoveTo(Vector2d position){
        return super.canMoveTo(position) && position.follows(getCurrentBounds().lowerCorner()) &&
                                            position.precedes(getCurrentBounds().upperCorner());
    }


}
