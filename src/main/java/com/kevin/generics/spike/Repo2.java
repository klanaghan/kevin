package com.kevin.generics.spike;


import java.util.HashMap;
import java.util.Map;

public class Repo2
{

    private Map<String, Object> values =
            new HashMap<String, Object>();

    public <T> void putColumn(String inKey, Object  inValue)
    {
        if (inValue == null)
        {
            throw new NullPointerException("Type is null");
        }

        values.put(inKey, inValue);

    }

    public <T> T getValue(String inKey, Class<T> type)
    {
        Object value= values.get(inKey);
        return type.cast(value);

    }

    public void testName() throws Exception
    {
        Repo2 r2 = new Repo2();
        r2.putColumn("stringExtractor", new StringExtractor());
        r2.putColumn("integerExtractor", new IntegerExtractor());


        StringExtractor se = r2.getValue("stringExtractor", StringExtractor.class);

    }
}
