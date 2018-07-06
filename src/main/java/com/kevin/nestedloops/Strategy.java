package com.kevin.nestedloops;

import java.util.ArrayList;
import java.util.List;

public class Strategy
{
    List<String> mrns = new ArrayList<>();
    List<String> depts = new ArrayList<>();
    List<String> resourceid = new ArrayList<>();
    List<String> checkinStatus = new ArrayList<>();
    List<String> apptDateOrRange = new ArrayList<>();
    List<String> dateSpan = new ArrayList<>();
    List<String> apptId = new ArrayList<>();







    public List<List<String>> getIdLists()
    {
        return idLists;
    }

    List<List<String>> idLists = new ArrayList<>();

    public Strategy()
    {
        mrns.add("mrn : none");
        mrns.add("mrn : single");
        mrns.add("mrn : multiple");

        resourceid.add("resource :none");
        resourceid.add("resource :single");
        resourceid.add("resource :multiple");


        depts.add("dept : none");
        depts.add("dept : single");
        depts.add("dept : multiple");

        apptId.add("apptId : none");
        apptId.add("apptId : single");
        apptId.add("apptId : multiple");



        checkinStatus.add("checkInStatus : Scheduled");
        checkinStatus.add("checkInStatus : Canceled");
        checkinStatus.add("checkInStatus : Arrived");
        checkinStatus.add("checkInStatus : Completed");
        checkinStatus.add("checkInStatus : Active");
        checkinStatus.add("checkInStatus : Blank");
        checkinStatus.add("checkInStatus : No Show");
        checkinStatus.add("checkInStatus : Present");




        dateSpan.add("dateSpan : before");
        dateSpan.add("dateSpan : after");
        dateSpan.add("dateSpan : both");
        dateSpan.add("dateSpan : on");








        idLists.add(mrns);
        idLists.add(resourceid);
        idLists.add(depts);
        idLists.add(apptId);
        idLists.add(checkinStatus);
        idLists.add(dateSpan);




    }


    private void createCombinations(List<List<String>> inVariableLists, int index, String[] values)
    {
        List<String> variableList = inVariableLists.get(index);
        int i = 0;

       do
        {
            String variable = variableList.size() > 0 ? variableList.get(i) : null;
            values[index] = variable;

            if (index < inVariableLists.size() - 1)
            {
                createCombinations(inVariableLists, index + 1, values);

            }
            else
            {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < values.length; ++j)
                {
                    sb.append(" ").append(values[j]);
                }
                System.out.println(sb.toString());

            }
           i++;
        } while (i < variableList.size());
    }


    public static void main(String[] inArgs)
    {
        String[] values = new String[6];
        Strategy strategy = new Strategy();
        strategy.createCombinations(strategy.getIdLists(), 0, values);
    }
}
