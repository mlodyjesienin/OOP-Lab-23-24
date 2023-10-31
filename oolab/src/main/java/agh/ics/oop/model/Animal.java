package agh.ics.oop.model;

import agh.ics.oop.Vector2d;

import java.util.Map;

import static agh.ics.oop.model.MapDirection.NORTH;

public class Animal {
    private Vector2d position;
    private MapDirection direction = NORTH;

    public Animal(Vector2d position){
        this.position = position;
    }
    public Animal(){
        this(new Vector2d(2,2));
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString(){
        return this.position.toString() +", " + this.direction.toString();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        Vector2d potentialMove = new Vector2d(this.position.getX(), this.position.getY());
        switch(direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case BACKWARD ->  potentialMove = potentialMove.subtract(this.direction.toUnitVector());
            case FORWARD -> potentialMove = potentialMove.add(this.direction.toUnitVector());
        }
        if(potentialMove.getX() >=0 && potentialMove.getX() <5 && potentialMove.getY() >=0 && potentialMove.getY() <5){
            this.position = potentialMove;
        }
    }

}
