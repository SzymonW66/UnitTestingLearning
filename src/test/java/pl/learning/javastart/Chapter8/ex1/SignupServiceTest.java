package pl.learning.javastart.Chapter8.ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class SignupServiceTest {

    @Mock SignupRepository signupRepository;
    @Mock DateTimeProvider dateTimeProvider;
    @InjectMocks SignupService signupService;
    @Captor ArgumentCaptor<Signup> argumentCaptor;

    @BeforeEach
    void init() {
        ZonedDateTime now = ZonedDateTime.of(2020, 7, 26,
                13, 45, 0, 0,
                ZoneId.of("Europe/Warsaw"));
        lenient().when(dateTimeProvider.now()).thenReturn(now);
    }

    @Test
    void shouldSetCourseId(){
        //when
        signupService.createSignup(1L, 2L);

        //then
        verify(signupRepository).save(argumentCaptor.capture());

        Signup signup = argumentCaptor.getValue();
        assertThat(signup.getCourseId()).isEqualTo(2L);
    }

    @Test
    void shouldSetUserId(){
        //when
        signupService.createSignup(1L, 2L);

        //then
        verify(signupRepository).save(argumentCaptor.capture());

        Signup signup = argumentCaptor.getValue();
        assertThat(signup.getUserId()).isEqualTo(1L);
    }

    @Test
    void shouldAddOneYear(){
        //given
        ZonedDateTime now  = ZonedDateTime.of(2020, 8, 26,
                13, 45, 0, 0,
                ZoneId.of("Europe/Warsaw"));

        ZonedDateTime inAYear = ZonedDateTime.of(2021, 8, 26,
                13, 45, 0, 0,
                ZoneId.of("Europe/Warsaw"));

        when(dateTimeProvider.now()).thenReturn(now);

        //when
        signupService.createSignup(1L, 2L);

        //then
        verify(signupRepository).save(argumentCaptor.capture());
        Signup signup = argumentCaptor.getValue();
        assertThat(signup.getFrom().isEqual(now));
        assertThat(signup.getTo().isEqual(inAYear));
    }

    @Test
    void shouldAddOneYearIfAlreadyExists() {
        // give
        ZonedDateTime end = ZonedDateTime.of(2021, 8, 26,
                13, 45, 0, 0,
                ZoneId.of("Europe/Warsaw"));

        Signup s1 = Mockito.mock(Signup.class);
        when(s1.getCourseId()).thenReturn(2L);
        when(s1.getTo()).thenReturn(end);

        Set<Signup> signups = new HashSet<>(Collections.singletonList(s1));
        when(signupRepository.findUserById(1L)).thenReturn(signups);

        // when
        signupService.createSignup(1L, 2L);

        // then
        verify(signupRepository).save(argumentCaptor.capture());

        Signup signup = argumentCaptor.getValue();
        assertThat(signup.getFrom()).isEqualTo(end);

        ZonedDateTime inAYear = ZonedDateTime.of(2022, 8, 26,
                13, 45, 0, 0,
                ZoneId.of("Europe/Warsaw"));

        assertThat(signup.getTo()).isEqualTo(inAYear);
    }

}