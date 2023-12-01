package com.nighthawk.spring_portfolio.mvc.fib;

import java.util.ArrayList;

public class FibonacciWhile extends Fibonacci {
    public ArrayList<Integer> FibonacciWhile(int nth) {
        ArrayList<Integer> fib = new ArrayList<>();
        int i=0;
        while (i<nth) {
            if (i == 0) {
                fib.add(1);
            } else if (i == 1) {
                fib.add(1);
            } else {
                fib.add(fib.get(i - 2) + fib.get(i - 1));
            }
            i++;
        }

        return fib;
    }
}
