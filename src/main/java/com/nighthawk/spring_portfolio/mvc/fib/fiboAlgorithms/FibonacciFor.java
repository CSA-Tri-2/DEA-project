package com.nighthawk.spring_portfolio.mvc.fib.fiboAlgorithms;

import java.util.ArrayList;

import com.nighthawk.spring_portfolio.mvc.fib.Fibonacci;

public class FibonacciFor extends Fibonacci {
    public ArrayList<Integer> FibonacciFor(int nth) {
        // long start = System.currentTimeMillis();
        ArrayList<Integer> fib = new ArrayList<>();
        for (int i = 0; i < nth; i++) {
            if (i == 0) {
                fib.add(1);
            } else if (i == 1) {
                fib.add(1);
            } else {
                fib.add(fib.get(i - 2) + fib.get(i - 1));
            }
        }
        // long end = System.currentTimeMillis();
        // long time = (end - start);
        return fib;
    }
}