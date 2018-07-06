package com.kevin.generics.spike;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevinlanaghan on 1/23/17.
 */
public class Repo
{

    private Map<Class<?>, Object> values =
            new HashMap<Class<?>, Object>();

    public <T> void put(Class<T>  inKey, Object inValue)
    {
        if (inValue == null)
        {
            throw new NullPointerException("Type is null");
        }

        values.put(inKey, inValue);

    }

    public <T> T getValue(Class<T> type)
    {
        Object value= values.get(type);
        return type.cast(value);
    }

}
