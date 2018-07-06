package com.kevin.nestedloops;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by kevinlanaghan on 2/11/17.
 */
public class PerformOperations
{

    public static void nestedLoopOperation(int[] counters, int[] length, int level)
    {
        if (level == counters.length)
        {
            performOperation(counters);
        }
        else
        {
            for (counters[level] = 0; counters[level] < length[level]; counters[level]++)
            {
                nestedLoopOperation(counters, length, level + 1);
            }
        }
    }

    public static void performOperation(int[] counters)
    {
        String counterAsString = "";
        for (int level = 0; level < counters.length; level++)
        {
            counterAsString = counterAsString + counters[level];
            if (level < counters.length - 1)
            {
                counterAsString = counterAsString + ",";
            }
        }
        System.out.println(counterAsString);
    }

    private void printResults(Stack<String> inResults)
    {

    }


    public static void nestedFors(int n, int size)
    {
        assert n > size;
        assert size > 0;

        int[] i = new int[n];
        int l = n - 1;
        while (l >= 0)
        {
            if (l == n - 1)
            {
                System.out.println(Arrays.toString(i));
            }
            i[l]++;
            if (i[l] == size - l)
            {
                i[l] = 0;
                l--;
            }
            else if (l < n - 1)
            {
                l++;
            }
        }
    }

    public static void main(String inArgs[])
    {
        int depth = 3;
        int[] length = new int[depth];
        int[] counters = new int[depth];

        nestedLoopOperation(counters, length, 0);
    }
}


