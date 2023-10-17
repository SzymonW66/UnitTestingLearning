package pl.learning.javastart.Chapter1.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalendarTest {
    private Calendar calendar =  new Calendar();
    @Test
    void shouldMonth1From2000Have31Days(){
        //when
        int days = calendar.getDaysCount(2000, 1);
        //then
        Assertions.assertEquals(31, days);
    }

    @Test
    void shouldMonth2From2100Have28Days() {
        //when
        int days = calendar.getDaysCount(2100, 2);
        //then
        Assertions.assertEquals(28, days);
    }
}
