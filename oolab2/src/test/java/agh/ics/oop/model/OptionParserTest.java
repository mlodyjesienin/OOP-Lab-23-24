package agh.ics.oop.model;

import org.junit.Test;

import static agh.ics.oop.OptionParser.optParser;
import static org.junit.Assert.assertEquals;

public class OptionParserTest {
    @Test
    public void optParserTest(){
        String[] example =  {"f","l","asd","r","p","b","b"};
        MoveDirection[] result =  {MoveDirection.FORWARD, MoveDirection.LEFT,MoveDirection.RIGHT,
                                    MoveDirection.BACKWARD,MoveDirection.BACKWARD};
        assertEquals(result, optParser(example));
    }
}
