package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class OptionParser {
    public static List <MoveDirection> optParser(String[] args) {
        List<MoveDirection> moves = new LinkedList<>();
        for (String simple_move : args) {

            switch (simple_move) {
                case "f" -> {
                    moves.add(MoveDirection.FORWARD);
                }
                case "b" -> {
                    moves.add(MoveDirection.BACKWARD);
                }
                case "r" -> {
                    moves.add(MoveDirection.RIGHT);
                }
                case "l" -> {
                    moves.add(MoveDirection.LEFT);
                }
            }
        }

        return moves;
    }

}
