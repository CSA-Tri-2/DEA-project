package com.nighthawk.spring_portfolio.mvc.fib;

import java.util.ArrayList;

import com.nighthawk.spring_portfolio.mvc.fib.fibmethods.FibFor;  

public class Fibonacci {
    int size;
    ArrayList<Integer> fib = new ArrayList<>();

    public ArrayList<Integer> calculateFibonacciFor(int nth) {
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

        return fib;
    }

    public ArrayList<Integer> calculateFibonacciWhile(int nth) {
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

    public String toStringArr() {
        int n = this.fib.size();
        String array = "";
        for (int i = 0; i < n; i++) {
             array = array + this.fib.get(i) + " ";
        }
        return array;
    }

    public static void main(String type) {
        Fibonacci fibonacci = new Fibonacci();
        if (type == "while") {
            ArrayList<Integer> result = fibonacci.calculateFibonacciWhile(20);
            System.out.println(result);
        }
        else if (type == "for") {
            ArrayList<Integer> result = fibonacci.calculateFibonacciFor(20);
            System.out.println(result);
        }

        // Print the result
    }
}
