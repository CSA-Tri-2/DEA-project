package com.nighthawk.spring_portfolio.mvc.fib;

import java.util.ArrayList;  

public class Fibonacci {
    int size;
    ArrayList<Long> list;

    public String toStringArr() {
        int n = this.list.size();
        String array = "";
        for (int i = 0; i < n; i++) {
             array = array + this.list.get(i) + " ";
        }
        return array;
    }
}
