package com.nighthawk.spring_portfolio.mvc.fib.fiboAlgorithms;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.nighthawk.spring_portfolio.mvc.fib.Fibonacci;

import java.util.stream.Collectors;

public class FibonacciStream extends Fibonacci {
    public ArrayList<Integer> FibonacciStream(int nth) {
        return Stream.iterate(new int[]{1, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(nth)
                .map(fib -> fib[0])
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
