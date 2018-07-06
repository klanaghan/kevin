package com.kevin.lambda;

import com.kevin.model.Person;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T>
{
    public int compare(T t1, T t2);

    public static Comparator<Person> comparing(Function<Person, Integer> f)
    {
     return (p1, p2)->f.apply(p1) - f.apply(p2);
    }

}
