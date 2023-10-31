package agh.ics.oop.model;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static agh.ics.oop.OptionParser.optParser;
import static org.junit.Assert.assertEquals;

public class OptionParserTest {
    @Test
    public void testOptParser(){
        String[] example =  {"f","l","asd","r","p","b","b"};
        List <MoveDirection> result =  List.of(MoveDirection.FORWARD, MoveDirection.LEFT,MoveDirection.RIGHT,
                                    MoveDirection.BACKWARD,MoveDirection.BACKWARD);
        assertEquals(result, optParser(example));
    }
}
