package agh.ics.oop.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TextMapTest {
    @Test
    public void TextMapIntegralTest(){
        //GIVEN
        String string1 =  "Kocham";
        String string2 = "Programowaine";
        String string3 = "A szczególnie";
        String string4 = "Obiektowe!";
        TextMap exampleMap = new TextMap();

        //WHEN
        exampleMap.place(string1);
        exampleMap.place(string2);
        exampleMap.place(string3);
        exampleMap.place(string4);

        exampleMap.move(string1,MoveDirection.BACKWARD);
        exampleMap.move(string3, MoveDirection.FORWARD);
        exampleMap.move(string2, MoveDirection.LEFT);


        //THEN
        assertEquals(string1, exampleMap.objectAt(1));
        assertEquals(string3,exampleMap.objectAt(4));
        assertEquals(string2, exampleMap.objectAt(2));
        assertEquals(string4, exampleMap.objectAt(3));
        assertEquals(false,exampleMap.canMoveTo(0));
        assertEquals(false,exampleMap.canMoveTo(5));
        assertEquals(true,exampleMap.canMoveTo(4));
    }
}
