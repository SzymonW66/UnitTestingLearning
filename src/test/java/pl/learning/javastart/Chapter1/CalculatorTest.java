package pl.learning.javastart.Chapter1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void shouldAdd1To1AndReturn2() {
        // given
        int a = 1;
        int b = 1;
        Calculator calculator = new Calculator();
        // when
        int result = calculator.add(a, b);
        // then
        Assertions.assertEquals(2, result);
    }

}