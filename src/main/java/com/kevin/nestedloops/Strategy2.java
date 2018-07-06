package com.kevin.nestedloops;

import java.util.ArrayList;
import java.util.List;

public class Strategy2
{
    List<String> mrns = new ArrayList<>();
    List<String> depts = new ArrayList<>();
    List<String> resourceid = new ArrayList<>();

    public List<List<String>> getIdLists()
    {
        return idLists;
    }

    List<List<String>> idLists = new ArrayList<>();

    public Strategy2()
    {
        mrns.add("mrn : 0");
        mrns.add("mrn : 1");
       // resourceid.add("resource :21234");
      //    resourceid.add("resource :21235");
        depts.add("dept : 0");
        depts.add("dept : 1");
        idLists.add(mrns);
        idLists.add(resourceid);
        idLists.add(depts);
    }


    private void createCombinations(List<List<String>> focuses, int index, String[] values)
    {
        List<String> focus = focuses.get(index);

        for (String variable : focus)
        {
            values[index] = variable;

            if (index < focuses.size() - 1)
            {
                // there is at least one other focus
                createCombinations(focuses, index + 1, values);

            }
            else
            {
                // all values pinned down
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < values.length; ++i)
                {
                    sb.append(" ").append(values[i]);
                }
                System.out.println(sb.toString());

                // now do whatever you like to do with sb.toString()...
            }

        }
    }


    public static void main(String[] inArgs)
    {
        String[] values = new String[3];
        Strategy2 strategy = new Strategy2();
        strategy.createCombinations(strategy.getIdLists(), 0, values);

   
    }
}
