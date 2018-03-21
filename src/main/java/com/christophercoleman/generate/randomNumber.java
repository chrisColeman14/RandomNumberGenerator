package com.christophercoleman.generate;

import java.util.Random;
/**
 * Created by Chris on 3/4/2017.
 */
public class randomNumber {

    static final int DEFAULT_SIZE = 1000;
    int maxNumberLimit = 0, number = 0;
    String textView;

    public randomNumber(int setMax)
    {
        if(checkInput(setMax))
            maxNumberLimit = setMax;
        else
            maxNumberLimit = DEFAULT_SIZE;
        textView = "#";
    }

    public randomNumber()
    {
        textView = "#";
    }

    public int getRandomNumber()
    {
        return number;
    }

    public void setRandomNumber()
    {
        Random r = new Random();
        int rand = r.nextInt(maxNumberLimit) + 1;
        number = rand;
    }

    public void setMaxNumberLimit(int setMax)
    {
        if(checkInput(setMax))
            maxNumberLimit = setMax;
        else
            maxNumberLimit = DEFAULT_SIZE;
    }

    public int getMaxNumberLimit()
    {
        return maxNumberLimit;
    }

    public boolean checkInput(int number)
    {
        if(number > 0)
            return true;
        else
            return false;
    }
}
