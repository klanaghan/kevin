package com.kevin.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Renewal
{

    public List<Article> justAuthor(List<Article> inArticles, String forName)
    {
        return inArticles.stream().filter(article->article.getAuthor().equals(forName))
                .collect(Collectors.toList());
    }

    public void createMultipy()
    {
        Function<Integer, Integer> ff = (c)->c * 3;
       int xxx =  ff.compose(ff).apply(3);
       System.out.println(xxx);

    }
    public void aa()
    {
        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
      //  assertEquals(asList("A", "B"), myList);

    }

    public void flatmap()
    {

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a","b"),
                Arrays.asList("c", "d"));


        System.out.println(list);

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

    }
    public void appendAnA( List<String> inArticles)
    {
        Function<String, String> append = (a)->("a-"+  a);
       inArticles.stream().map(append).collect(Collectors.toList());
    }

    // optional
    public static void main (String[] inStrings)
    {
        Renewal r = new Renewal();
        r.createMultipy();
        r.flatmap();
    }
}
