package com.kevin.generics.spike;

/**
 * Created by kevinlanaghan on 1/24/17.
 */
public class DateExtractor extends  Column
{
private String mDateFormat;

    public DateExtractor(Class inType, String inFormat)
    {
        super(inType);
        mDateFormat = inFormat;
    }

}
