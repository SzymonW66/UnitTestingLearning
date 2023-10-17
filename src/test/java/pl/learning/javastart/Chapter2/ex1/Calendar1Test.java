package pl.learning.javastart.Chapter2.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.learning.javastart.Chapter1.ex1.Calendar;

public class Calendar1Test {
    Calendar calendar;
    @BeforeEach
    public void init() {
        Calendar calendar =  new Calendar();
    }

    @DisplayName("01.2000 -> 31")
    @Test
    void shouldMonth1From2000Have31Days(){
        //when
        int days = calendar.getDaysCount(2000, 1);
        //then
        Assertions.assertEquals(31, days);
    }

    @DisplayName("02.2100 -> 28")
    @Test
    void shouldMonth2From2100Have28Days() {
        //when
        int days = calendar.getDaysCount(2100, 2);
        //then
        Assertions.assertEquals(28, days);
    }
}

