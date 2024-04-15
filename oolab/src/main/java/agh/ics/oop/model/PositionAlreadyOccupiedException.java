package agh.ics.oop.model;

import agh.ics.oop.model.Vector2d;

public class PositionAlreadyOccupiedException extends Exception{
    public PositionAlreadyOccupiedException(Vector2d reason){
        super("Position " + reason +" is already occupied");
    }
}
