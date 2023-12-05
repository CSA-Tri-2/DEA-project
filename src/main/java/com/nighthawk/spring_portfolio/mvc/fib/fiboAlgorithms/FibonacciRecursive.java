package com.nighthawk.spring_portfolio.mvc.fib.fiboAlgorithms;

import java.util.ArrayList;

import com.nighthawk.spring_portfolio.mvc.fib.Fibonacci;

public class FibonacciRecursive extends Fibonacci {
    public ArrayList<Integer> FibonacciRecursive(int i, int nth) {
        if (i<nth) {
            if (i == 0) {
                fib.add(1);
            } else if (i == 1) {
                fib.add(1);
            } else {
                fib.add(fib.get(i - 2) + fib.get(i - 1));
            }
            FibonacciRecursive(i+1, nth);
        }

        return fib;
    }
}