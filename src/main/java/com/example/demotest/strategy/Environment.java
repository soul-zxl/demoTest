package com.example.demotest.strategy;

/**
 * @author Administrator
 */
public class Environment {
    private medium medium;

    public Environment(medium medium) {
        this.medium = medium;
    }

    public void setMedium(medium medium){
        this.medium = medium;
    }


    /**
     * 计算价格
     */

    public double quote(double booksPrice) {
        return this.medium.differentBrackets(booksPrice);

    }
}