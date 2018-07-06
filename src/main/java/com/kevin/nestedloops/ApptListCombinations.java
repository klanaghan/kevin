package com.kevin.nestedloops;

import static java.lang.System.out;

class ApptListCombinations
{

    //Array containing the values of the cards
    static Symbol[] cardValues = Symbol.values();

    //Array to represent the positions of the cards,
    //they will hold different card values as the program executes
    static Symbol[] positions = new Symbol[cardValues.length];

    //A simple counter to show the number of combinations
    static int counter = 1;

    /*Names of cards to combine, add as many as you want, but be careful, we're
    talking about factorials here, so 4 cards = 24 different combinations (4! = 24),
    but 8 cards = 40320 combinations and 13 cards = 6.23 billion combinations!*/
    enum Symbol
    {
        AofSpades, TwoofSpades, ThreeofSpades, FourofSpades
    }


        /* I use a recursive (repeating itself) method, since nesting for loops inside
        * each other looks nasty and also requires one to know how many cards we will
        * combine. I used 4 cards so we could nest 4 for loops one after another, but
        * as I said, that's nasty programming. And if you add more cards, you would
        * need to nest more for loops. Using a recursive method looks better, and gives
        * you the freedom to combine as many cards as you want without changing code.
        */

    static void combinations(int locNumber)
    {

        //Recursive for loop nesting to iterate through all possible card combinations
        for (int valueNumber = 0; valueNumber < cardValues.length; valueNumber++)
        {
            positions[locNumber] = cardValues[valueNumber];
            if (locNumber < (cardValues.length - 1))
            {
                combinations(locNumber + 1);
            }

            //This if statement grabs and displays card combinations in which no card value
            // is repeated in the current "positions" array. Since in a single deck,
            // there are no repeated cards. It also appends the combination count at the end.
            if (locNumber == (cardValues.length - 1) && repeatedCards(positions))
            {
                for (int i = 0; i < cardValues.length; i++)
                {
                    out.print(positions[i]);
                    out.print(" ");
                }
                out.printf("%s", counter);
                counter++;
                out.println();
            }
        }
    }

    static boolean repeatedCards(Symbol[] cards)
    {

        /*Method used to check if any cards are repeated in the current "positions" array*/

        boolean booleanValue = true;

        for (int i = 0; i < cardValues.length; i++)
        {
            for (int j = 0; j < cardValues.length; j++)
            {
                if (i != j && cards[i] == cards[j])
                {
                    booleanValue = false;
                }
            }
        }
        return booleanValue;
    }

    public static void main(String args[])
    {

        //I send an argument of 0 because that is the first location which
        //we want to add value to. Every recursive call will then add +1 to the argument.
        combinations(0);
    }

}
