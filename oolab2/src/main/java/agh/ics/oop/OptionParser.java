package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;


public class OptionParser {
    public static MoveDirection[] optParser(String[] args) {
        int ind =0;
        MoveDirection[] tab = new MoveDirection [args.length] ;
        for (String x : args) {

            switch (x) {
                case "f" -> {
                    tab[ind] = MoveDirection.FORWARD;
                    ind++;
                }
                case "b" -> {
                    tab[ind] = MoveDirection.BACKWARD;
                    ind+=1;
                }
                case "r" -> {
                    tab[ind] = MoveDirection.RIGHT;
                    ind+=1;
                }
                case "l" -> {
                    tab[ind] = MoveDirection.LEFT;
                    ind+=1;
                }
            }
        }

        return Arrays.copyOfRange(tab,0,ind);
    }

}
