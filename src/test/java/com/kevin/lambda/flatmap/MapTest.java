package com.kevin.lambda.flatmap;

import com.kevin.model.Gender;
import com.kevin.model.Person;
import org.junit.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MapTest
{
    Predicate<Person> isMaleOrAdult = p -> {
        if (p.isMale()) {
            return true;
        }
        if (p.isAdult()) {
            return true;
        }
        return false;
    };

    Predicate<Person> isAdult = p -> {

        if (p.isAdult()) {
            return true;
        }
        return false;
    };

    Function<Person, String> concatenateFirstAndLastName = p -> p.getFirstName() + " " + p.getLastName();

    @Test
    public void testIt()
    {
        LocalDate date = LocalDate.of(1979, 3, 15);

        Person p1 = new Person(Gender.FEMALE,
                LocalDate.of(1979, 3, 15),
                "Zeljka", "Smith");
        Person p2 = new Person(Gender.FEMALE, LocalDate.of(2006, 2, 3),
                "Tara", "Smith");

        Person p3 = new Person(Gender.MALE,
                LocalDate.of(1979, 8, 18),
                "Kevin", "Smith");
        Person p4 = new Person(Gender.MALE,
                LocalDate.of(2004, 5, 26),
                "Patrick", "Smith");

        List<Person> family = Arrays.asList(p1,p2,p3, p4);

        List<String> xxx  = family.stream().filter(isMaleOrAdult)
                .map(concatenateFirstAndLastName)
                .collect(Collectors.toList());

        assertEquals(3, xxx.size());

        xxx  = family.stream().filter(isAdult)
                .map(concatenateFirstAndLastName)
                .collect(Collectors.toList());

        assertEquals(2, xxx.size());
    }

}
