package pl.learning.javastart.Chapter1.ex1;

import java.time.YearMonth;
import java.util.Date;

public class Calendar {
    public int getDaysCount(int year, int month){
        return YearMonth.of(year, month).lengthOfMonth();
    }
}
