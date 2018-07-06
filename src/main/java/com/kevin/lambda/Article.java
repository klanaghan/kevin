package com.kevin.lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Article
{
    private String mAuthor;
    private String mTitle;
    private Date mPublished;
    private List<String> mTags = new ArrayList<>();


    private Article(String title, String author, List<String> tags) {
        mTitle = title;
        mAuthor = author;
        mTags = tags;
    }

    public String getTitle() {
        return mTitle;
    }
    public Date published()
    {
        return mPublished;
    }

    public void setPublished(Date inPublished)
    {
        mPublished = inPublished;
    }


    public String getAuthor()
    {
        return mAuthor;
    }

    public void setAuthor(String inAuthor)
    {
        mAuthor = inAuthor;
    }

    public List<String> getTags()
    {
        return mTags;
    }

    public void setTags(List<String> inTags)
    {
        mTags = inTags;
    }


}
