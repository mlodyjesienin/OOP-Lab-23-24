package agh.ics.oop.model;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static agh.ics.oop.OptionParser.optParser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class OptionParserTest {
    @Test
    public void testOptParser(){
        String[] example =  {"f","l","r","b","b","r","f","l"};
        List <MoveDirection> result =  List.of( MoveDirection.FORWARD, MoveDirection.LEFT,MoveDirection.RIGHT,
                                                MoveDirection.BACKWARD,MoveDirection.BACKWARD, MoveDirection.RIGHT,
                                                MoveDirection.FORWARD, MoveDirection.LEFT);
        assertEquals(result, optParser(example));
        String[] example2 = {"f","l","ABC"};
        assertThrows(IllegalArgumentException.class , () -> optParser(example2));
    }
}
