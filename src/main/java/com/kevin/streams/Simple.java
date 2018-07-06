package com.kevin.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Simple
{
    List<String> myList =
            Arrays.asList("a1", "a2", "b1", "c2", "c1", "c1");

    public void mapToObject()
    {
       IntStream.range(1,4).mapToObj(i -> "C"+i );
    }
    public void extractStartsWithCMapToUpperSort()
    {

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        List<String> yyy = myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted().collect(Collectors.toList());

        yyy.forEach(System.out::println);
    }
    public static void main(String[] inArgs)
    {
        Simple xxx = new Simple();

      //  xxx.mine();
    }
}
