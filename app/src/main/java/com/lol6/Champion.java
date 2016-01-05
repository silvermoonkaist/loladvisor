package com.lol6;

/**
 * Created by jeff on 16. 1. 5..
 */
public class Champion {
    public String champion;
    public double rate;
    public int count;
    public Champion (String cname, double rate, int count){
        this.champion = cname;
        this.rate = rate;
        this.count = count;
        System.out.println("cname " + cname + "/rate " + rate + "/count " + count);
    }
}
