package com.kevin.containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class KevinMultiSet<T, V>
{
    //Map<String, AtomicInteger> multiSet = new ConcurrentHashMap<>();
    private Map<? super T, V> kevin;
    List<V> list = new ArrayList<>();

    public KevinMultiSet()
    {
        kevin = new ConcurrentHashMap<T, V>();
    }

    public void put( T key, V element) {
       //  kevin.computeIfAbsent(element, e -> new AtomicInteger()).incrementAndGet();

    }
    public T get(T key)
    {
        return (T) kevin.get(key);
    }
    public static void main(String[] inArgs)
    {
        KevinMultiSet<String, String> a = new KevinMultiSet<>();


    }
}
