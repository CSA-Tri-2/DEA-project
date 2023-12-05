package com.nighthawk.spring_portfolio.mvc.fib;

import java.util.ArrayList;

public class Fibonacci {
    public String toStringArr() {
        int n = this.fib.size();
        String array = "";
        for (int i = 0; i < n; i++) {
             array = array + this.fib.get(i) + " ";
        }
        return array;
    }

    // testing class
    // public static void main(String type) {
    //     Fibonacci fibonacci = new Fibonacci();
    //     if (type == "while") {
    //         ArrayList<Integer> result = fibonacci.FibonacciWhile(20);
    //         System.out.println(result);
    //     }
    //     else if (type == "for") {
    //         ArrayList<Integer> result = fibonacci.FibonacciFor(20);
    //         System.out.println(result);
    //     }
    //     else if (type == "recursive") {
    //         ArrayList<Integer> result = fibonacci.FibonacciRecursive(0, 20);
    //         System.out.println(result);
    //     }
    //     else if (type == "stream") {
    //         ArrayList<Integer> result = fibonacci.FibonacciStream(20);
    //         System.out.println(result);
    //     }
    // }
}