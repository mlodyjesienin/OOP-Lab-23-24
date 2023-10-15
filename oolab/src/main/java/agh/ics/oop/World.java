package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import static agh.ics.oop.OptionParser.optparser;

public class World {
     public static void main(String[] args){
        System.out.println("system wystartowal");
        MoveDirection[] tab = optparser(args);
        run(tab);
        System.out.println("system zakonczyl dzialane");
    }
    static void run(MoveDirection[] args){
        for(MoveDirection x : args){
            switch(x){
                case FORWARD -> System.out.println("zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("zwierzak idzie do tyłu");
                case RIGHT-> System.out.println("zwierzak skręca w prawo");
                case LEFT -> System.out.println("zwierzak skręca w lewo");
            }
        }
    }
}
