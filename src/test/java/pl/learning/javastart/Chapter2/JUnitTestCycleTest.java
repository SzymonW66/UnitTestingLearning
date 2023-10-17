package pl.learning.javastart.Chapter2;

import org.junit.jupiter.api.*;

import java.util.Random;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) - to powoduje zmianę, że test jest zależy od poprzedniego testu. Jakbyśmy dodali
// counter do tych testów to wyszło by 1 2 3 dla kolejnych 3 testów a nie 1 1 1 przy nie zależnych testach, często jest to stosowane
// w testach integracyjnych, żeby najpierw przestestować np logowanie, a potem czy przenosi odpowiednio do strony
public class JUnitTestCycleTest {
    Random random;

    @BeforeEach
    public void init() {
        System.out.println("Init ()");
        random = new Random();
        random.setSeed(7238423L);
    }

    @AfterEach
    public void after() {
        System.out.println("After ()");

    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All ()");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All ()");
    }

    @DisplayName("TUTAJ WPISUJE SIĘ NAZWY TESTU JAKIE MAJĄ BYĆ WYŚWIETLONE")
    @Test
    public void test11() {
        System.out.println("Test 1 " + random.nextInt());
    }

    @Test
    //nazwy testów powinny być samookreślające się i sugerujące poprawną odpowiedź
    public void test12() {
        System.out.println("Test 2 " + random.nextInt());
    }
}
