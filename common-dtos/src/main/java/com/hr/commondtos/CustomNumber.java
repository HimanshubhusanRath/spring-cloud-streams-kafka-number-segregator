package com.hr.commondtos;

public class CustomNumber
{
    public CustomNumber()
    {

    }

    public CustomNumber(final int number)
    {
        this.number  = number;
    }

    private int number;

    public void setNumber(final int number)
    {
        this.number = number;
    }

    public int getNumber()
    {
        return this.number;
    }

}
