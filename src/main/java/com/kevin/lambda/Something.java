package com.kevin.lambda;

import com.kevin.model.Person;

import java.util.*;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Something
{
    public static int compose()
    {
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;

        int result = times2.compose(squared).apply(4);
        int result2 = times2.andThen(squared).apply(4);
         System.out.println ("Results from compose " + result + " andThen " + result2);
        return result;

    }
    public void bifunction()
    {
        BiFunction<String, List<Article>, List<Article>> byAuthor =
                (name, articles) -> articles.stream()
                        .filter(a -> a.getAuthor().equals(name))
                        .collect(Collectors.toList());

        BiFunction<String, List<Article>, List<Article>> byTag =
                (tag, articles) -> articles.stream()
                        .filter(a -> a.getTags().contains(tag))
                        .collect(Collectors.toList());

        Function<List<Article>, List<Article>> sortByDate =
                articles -> articles.stream()
                        .sorted((x, y) -> y.published().compareTo(x.published()))
                        .collect(Collectors.toList());

        Function<List<Article>, Optional<Article>> first =
                a -> a.stream().findFirst();

        // newest article
        Function<List<Article>, Optional<Article>> newest =
                first.compose(sortByDate);

        // newest article by an author

        BiFunction<String, List<Article>, Optional<Article>> newestByAuthor =
                byAuthor.andThen(newest);

// newest article for a given tag
        BiFunction<String, List<Article>, Optional<Article>> newestByTag =
                byTag.andThen(newest);




    }

    public Optional<Article> getFirstJavaArticle(List<Article> articles) {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }


    public List<Article> getAllJavaArticles(List<Article> articles) {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }


    public Map<String, List<Article>> groupByAuthor(List<Article> articles) {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }

    public Set<String> getDistinctTags(List<Article> articles) {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }
/*
    public static void main(String[] inArgs)
    {

        compose();

        Person a = new Person(3, "Kevin", "Lanaghan");
        Person a1 = new Person(3, "Mark", "Lanaghan");
        Person a2 = new Person(4, "Zeljka", "Lanaghan");

        Function<Person,Integer> f1 = inPerson ->inPerson.getAge();
        Function<Person,Integer> f2 = Person::getAge;
        //function pointer
        f1 = inPerson -> inPerson.getDaysOld();

        System.out.println(f1.apply(a));

        BinaryOperator<Integer> sum = binarySumOperator();


        System.out.println(f2.apply(a) + " " + sum.apply(3, 4)
                + " " +Integer.sum(3, 5));
        Consumer<String> printer = System.out::println;
        printer.accept("kevin");
        Comparator<Person> personAgeComparator = (ax, ay)-> a1.getAge() - a2.getAge();
        Comparator<Person> personFirstNameComparator = (ax, ay)-> a1.firstName.compareTo(a2.getFirstName());
        Comparator<Person> personLastNameComparator = (ax, ay)-> a1.lastName.compareTo(a2.getLastName());

        Function<Person, Integer> fp = (p)->p.getAge();
        System.out.print ("Compare P1.age :" + a1.getAge() + " A2.age : "  + a2.getAge() + " " +
                personAgeComparator.compare(a1,a2));
    }

    private static BinaryOperator<Integer> binarySumOperator()
    {
        BinaryOperator<Integer> sum = (s1, s2)-> s1 + s2;
        BinaryOperator<Integer> sum2 = (s1, s2)-> Integer.sum(s1,s2);
        BinaryOperator<Integer> sum3 = Integer::sum;
        return sum;
    }
    */
}
