package com.kevin.generics.spike;


public class Value<T>
{
    public Class<T> mType;

    Object mValue;

    public Value(Class<T> inType, Object inValue)
    {
       mType = inType;
       mValue = inValue;
    }
    public T cast(Object obj) {
        return obj == null ? null : mType.cast(obj);
    }

    public Object get() {
        return mValue != null ? mValue : null;
    }
}
