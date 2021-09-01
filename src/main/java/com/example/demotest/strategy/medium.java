package com.example.demotest.strategy;

/**
 * 中级
 */
public class medium implements member{
    @Override
    public double differentBrackets(double price) {
        return price*0.9;
    }
}
