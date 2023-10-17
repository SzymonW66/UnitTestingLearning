package pl.learning.javastart.Chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnit5AssertionTest {

    JUnit5Assertion jUnit5Assertion = new JUnit5Assertion();

    @Test
    void shouldNotBePrimeFor1() {
        //given

        //when
        boolean result = jUnit5Assertion.isPrimeNumber(1);
        //then
        assertFalse(result);
    }

    @Test
    void shouldNotBePrimeFor0() {
        //given
        //when
        boolean result = jUnit5Assertion.isPrimeNumber(0);
        //then
        assertFalse(result);
    }

    @Test
    void shouldNotBePrimeFor10() {
        //given
        //when
        boolean result = jUnit5Assertion.isPrimeNumber(10);
        //then
        assertFalse(result);
    }

    @Test
    void shouldNotBePrimefor13() {
        //given
        //when
        boolean result = jUnit5Assertion.isPrimeNumber(13);
        //then
        assertTrue(result);
    }

    @Test
    void shouldReturnVaildCode(){
        //when
       JUnit5Assertion.Code code = jUnit5Assertion.getCode("a");
       //then
        assertEquals("a", code.getKey());
        assertNotNull(code.getCreatedAtTimestamp());
        assertNotNull(code.getCode());
    }

    @Test
    void shouldReturnSameObjects() {
        //when
        JUnit5Assertion.Code code1 = jUnit5Assertion.getCode("a");
        JUnit5Assertion.Code code2 = jUnit5Assertion.getCode("a");
        //then
        assertSame(code1, code2);
    }

    @Test
    void shouldReturnDifferentObjects() {
        //whem
        JUnit5Assertion.Code code1 = jUnit5Assertion.getCode("a");
        JUnit5Assertion.Code code2 = jUnit5Assertion.getCode("b");
        //then
        assertNotSame(code1, code2);
    }


}