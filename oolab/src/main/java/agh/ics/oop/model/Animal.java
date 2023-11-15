package agh.ics.oop.model;

import static agh.ics.oop.model.MapDirection.NORTH;
import agh.ics.oop.model.RectangularMap;
public class Animal implements WorldElement{
    private Vector2d position;
    private MapDirection direction = NORTH;

    public Animal(Vector2d position){
        this.position = position;
    }
    public Animal(){
        this(new Vector2d(2,2));
    }

    public MapDirection getDirection() { return direction; }

    public Vector2d getPosition() {
        return new Vector2d(position.getX(), position.getY());
    }

    @Override
    public String toString(){
        return switch (this.direction){
            case NORTH -> "N";
            case WEST -> "W";
            case EAST -> "E";
            case SOUTH -> "S";
        };
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Animal))
            return false;
        return (this.position).equals(((Animal) other).getPosition()) && this.direction.equals(((Animal) other).getDirection());
    }

    public void move(MoveDirection direction, MoveValidator validator){
        Vector2d potentialMove = new Vector2d(this.position.getX(), this.position.getY());
        switch(direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case BACKWARD ->  potentialMove = potentialMove.subtract(this.direction.toUnitVector());
            case FORWARD -> potentialMove = potentialMove.add(this.direction.toUnitVector());
        }
        if(validator.canMoveTo(potentialMove)) this.position = potentialMove;
    }

}
