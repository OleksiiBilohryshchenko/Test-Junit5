package com.matchers;

import com.example.Person;
import org.mockito.ArgumentMatcher;

public class PersonAgeMatcher implements ArgumentMatcher<Person> {
    private final int minAge;
    private final int maxAge;

    public PersonAgeMatcher(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean matches(Person person) {
        if (person == null) {
            return false;
        }
        return person.getAge() >= minAge && person.getAge() <= maxAge;
    }

    @Override
    public String toString() {
        return "Person with age between " + minAge + " and " + maxAge;
    }
}
