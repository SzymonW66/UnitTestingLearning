package pl.learning.javastart.Chapter4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParamTest {
    @ValueSource(strings = {"example@example.com", "example2@example.com", "example3@example.pl"})
    @ParameterizedTest
    void shouldBeValid(String email) {
        //given
        EmailValidator emailValidator = new EmailValidator();
        //when
        boolean isVaild = emailValidator.isValid(email);
        //then
        assertThat(isVaild).isTrue();
    }

    @DisplayName("Should Be Fibonnaci Number")
    @ValueSource(ints = {1, 2, 3, 4, 6})
//    @EnumSource(value = SignupStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "PAID")
    @ParameterizedTest(name = "{arguments} sprawdzam czy działa")
    void shouldBeFibonnaciNumbers(int number) {
        //given
        FibonaciiGenerator fibonaciiGenerator = new FibonaciiGenerator();
        //when
        boolean ifFibo = fibonaciiGenerator.checkIfFibonacciNumber(number);
        //then
        assertThat(ifFibo).isTrue();
    }

//    @ParameterizedTest
//    @MethodSource("provideTestData")
//    void shouldProperlyRecognizeEmailProvider(String domain, EmailValidator expectedProviderType) {
//        // given
//        EmailValidator emailValidator = new EmailValidator();
//
//        // when
//        EmailProviderType providerType = emailValidator.determineProviderType(domain);
//
//        // then
//        assertThat(providerType).isEqualTo(expectedProviderType);
//    }
//
//    private static Stream<Arguments> provideTestData() {
//        return Stream.of(
//                Arguments.of("gmail.com", EmailProviderType.PROVIDER),
//                Arguments.of("trash-mail.com", EmailProviderType.TRASHMAIL),
//                Arguments.of("outlook.com", EmailProviderType.PROVIDER),
//                Arguments.of("kowalski.pl", EmailProviderType.PRIVATE)
//        );
//    }


}
