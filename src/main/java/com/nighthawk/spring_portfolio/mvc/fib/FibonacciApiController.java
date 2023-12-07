package com.nighthawk.spring_portfolio.mvc.fib;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.fib.fiboAlgorithms.FibonacciFor;
import com.nighthawk.spring_portfolio.mvc.fib.fiboAlgorithms.FibonacciRecursive;
import com.nighthawk.spring_portfolio.mvc.fib.fiboAlgorithms.FibonacciStream;
import com.nighthawk.spring_portfolio.mvc.fib.fiboAlgorithms.FibonacciWhile;

@RestController
@RequestMapping("/api/sorting")
public class FibonacciApiController {
    private JSONObject body; // last run result
    private HttpStatus status; // last run status
    String last_run = null; // last run day of month

    @PostMapping("/fibFor")
    public ResponseEntity<ArrayList<Integer>> getFibonacciFor(@RequestBody FibRequest request) {
        int startTime = (int)System.currentTimeMillis();

        int length = request.getLength();
        FibonacciFor fibonacciFor = new FibonacciFor();
        ArrayList<Integer> fibonacciSeries = fibonacciFor.FibonacciFor(length);
        System.out.println(fibonacciFor.toStringArr(fibonacciSeries));
        int endTime = (int)System.currentTimeMillis();
        int elapsedTime = endTime - startTime;
        fibonacciSeries.add(elapsedTime);

        return new ResponseEntity<>(fibonacciSeries, HttpStatus.OK);
    }

    @PostMapping("/fibRecursive")
    public ResponseEntity<ArrayList<Integer>> getFibonacciRecursive(@RequestBody FibRequest request) {
        int startTime = (int)System.currentTimeMillis();

        int length = request.getLength();
        FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
        ArrayList<Integer> fibonacciSeries = fibonacciRecursive.FibonacciRecursive(0, length);
        System.out.println(fibonacciRecursive.toStringArr(fibonacciSeries));
        int endTime = (int)System.currentTimeMillis();
        int elapsedTime = endTime - startTime;
        fibonacciSeries.add(elapsedTime);

        return new ResponseEntity<>(fibonacciSeries, HttpStatus.OK);
    }

    @PostMapping("/fibStream")
    public ResponseEntity<ArrayList<Integer>> getFibonacciStream(@RequestBody FibRequest request) {
        int startTime = (int)System.currentTimeMillis();

        int length = request.getLength();
        FibonacciStream fibonacciStream = new FibonacciStream();
        ArrayList<Integer> fibonacciSeries = fibonacciStream.FibonacciStream(length);
        System.out.println(fibonacciStream.toStringArr(fibonacciSeries));
        int endTime = (int)System.currentTimeMillis();
        int elapsedTime = endTime - startTime;
        fibonacciSeries.add(elapsedTime);

        return new ResponseEntity<>(fibonacciSeries, HttpStatus.OK);
    }

    @PostMapping("/fibWhile")
    public ResponseEntity<ArrayList<Integer>> getFibonacciWhile(@RequestBody FibRequest request) {
        int startTime = (int)System.currentTimeMillis();

        int length = request.getLength();
        FibonacciWhile fibonacciWhile = new FibonacciWhile();
        ArrayList<Integer> fibonacciSeries = fibonacciWhile.FibonacciWhile(length);
        System.out.println(fibonacciWhile.toStringArr(fibonacciSeries));
        int endTime = (int)System.currentTimeMillis();
        int elapsedTime = endTime - startTime;
        fibonacciSeries.add(elapsedTime);

        return new ResponseEntity<>(fibonacciSeries, HttpStatus.OK);
    }
}
