package com.kevin.generics.spike;

import org.jdom2.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevinlanaghan on 1/23/17.
 */
public class SpikeTest
{

    public void testit()
    {
        Repo repo = new Repo();
        repo.put(StringExtractor.class, new StringExtractor());
        repo.put(IntegerExtractor.class, new IntegerExtractor());

        Map<String, Class<?>> fieldMap = new HashMap<>();
        fieldMap.put("field1", StringExtractor.class);
        fieldMap.put("field2", IntegerExtractor.class);

        Mapper mapper = new Mapper(repo, fieldMap);
        Element el = new Element("field1");
        el.setText("sometext");

    String x = mapper.extract(String.class, "field1", el );
        System.out.println(x);
    }


}
