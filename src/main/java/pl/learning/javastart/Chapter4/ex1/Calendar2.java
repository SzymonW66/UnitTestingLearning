package pl.learning.javastart.Chapter4.ex1;

import java.time.YearMonth;

public class Calendar2 {
    public int getDaysCount(int year, int month){
        return YearMonth.of(year, month).lengthOfMonth();
    }
}
