package pl.learning.javastart.Chapter2.ex1;

import java.time.YearMonth;

public class Calendar1 {
    public int getDaysCount(int year, int month){
        return YearMonth.of(year, month).lengthOfMonth();
    }
}
