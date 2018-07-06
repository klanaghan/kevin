package com.kevin.generics.spike;


import org.jdom2.Element;

/**
 * Created by kevinlanaghan on 1/24/17.
 */
public class StringExtractor extends Column
{
    public StringExtractor()
    {
        super(StringExtractor.class);
    }

    public String extract(String inElementName, Element inElement)
    {
        return inElement.getChild(inElementName).getText();
    }

}
