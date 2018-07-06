package com.kevin.generics.spike;

import org.jdom2.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevinlanaghan on 1/24/17.
 */
public class Mapper
{
    private Map<Class<?>, Object> mMap = new HashMap<>();
    private Repo mRepo2;
    private Map<String, Class<?>>  mData;

    public Mapper(Repo inRepo, Map<String, Class<?>> inData)
    {
        mRepo2= inRepo;
        mData = inData;
    }


    public <T> T extract(Class<T> inClass, String elementName, Element inElement)

    {
       Class<?> type =  mData.get(elementName);
       T value = inClass.cast(mRepo2.getValue(type));
       return value;

    }


}
