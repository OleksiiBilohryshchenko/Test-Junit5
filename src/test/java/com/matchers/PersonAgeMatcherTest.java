package com.matchers;

import com.example.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PersonAgeMatcherTest {
    public interface PersonService {
        void processPerson(Person person);
    }

    @Test
    public void testPersonAgeMatcher() {
        // Arrange
        PersonService mockService = mock(PersonService.class);
        Person person = new Person(25);

        // Act
        mockService.processPerson(person);

        // Assert
        verify(mockService).processPerson(argThat(new PersonAgeMatcher(20, 30)));
    }
}
