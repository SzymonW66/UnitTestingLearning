package pl.learning.javastart.Chapter6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

class PasswordResetMailContentProviderTest {

    @Mock
    RandomProvider randomProvider = mock(RandomProvider.class);

   @Test
    void shouldPreparePasswordResetEmail(){
       when(randomProvider.generateRandom()).thenReturn("asdfghjkl1234567890");
       PasswordResetMailContentProvider passwordResetMailContentProvider = new PasswordResetMailContentProvider(randomProvider);

       //when
       String resetMail = passwordResetMailContentProvider.createResetMailContent();

       //then
       assertThat(resetMail).isEqualTo("Cześć co tam");
   }


}