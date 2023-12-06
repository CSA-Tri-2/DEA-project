package com.nighthawk.spring_portfolio.mvc.sorting;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.MergeSort;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.InsertionSort;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.QuickSort;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.BubbleSort;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.BogoSort;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.HeapSort;

@RestController
@RequestMapping("/api/sorting")
public class SortingApiController {
    private JSONObject body; //last run result
    private HttpStatus status; //last run status
    String last_run = null; //last run day of month

    @PostMapping("/merge")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getMergeAnimations(@RequestBody MergeRequest request) {
        int length = request.getLength();
        ArrayList<Integer> array = request.getArray();
        MergeSort mergeSort = new MergeSort(length, array);
        System.out.println(mergeSort.toStringArr());
        return new ResponseEntity<>(mergeSort.getAnimations(), HttpStatus.OK);
    }

    @PostMapping("/quick")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getQuickAnimations(@RequestBody MergeRequest request) {
        int length = request.getLength();
        ArrayList<Integer> array = request.getArray();
        QuickSort quicksort = new QuickSort(length, array);
        System.out.println(quicksort.toStringArr());
        return new ResponseEntity<>(quicksort.getAnimations(), HttpStatus.OK);
    }

    @PostMapping("/insertion")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getInsertionAnimations(@RequestBody InsertionRequest request) {
        int length = request.getLength();
        ArrayList<Integer> array = request.getArray();
        InsertionSort insertionSort = new InsertionSort(length, array);
        System.out.println(insertionSort.toStringArr());
        return new ResponseEntity<>(insertionSort.getAnimations(), HttpStatus.OK);
    }

    @PostMapping("/bubble")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getBubbleAnimations(@RequestBody BubbleRequest request) {
        int length = request.getLength();
        ArrayList<Integer> array = request.getArray();
        BubbleSort bubbleSort = new BubbleSort(length, array);
        System.out.println(bubbleSort.toStringArr());
        return new ResponseEntity<>(bubbleSort.getAnimations(), HttpStatus.OK);
    }

    @PostMapping("/bogo")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getBogoAnimations(@RequestBody BogoRequest request) {
        int length = request.getLength();
        ArrayList<Integer> array = request.getArray();
        BogoSort bogoSort = new BogoSort(length, array);
        System.out.println(bogoSort.toStringArr());
        return new ResponseEntity<>(bogoSort.getAnimations(), HttpStatus.OK);
    }

    @PostMapping("/heap")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getHeapAnimations(@RequestBody BogoRequest request) {
        int length = request.getLength();
        ArrayList<Integer> array = request.getArray();
        HeapSort heapSort = new HeapSort(length, array);
        System.out.println(heapSort.toStringArr());
        return new ResponseEntity<>(heapSort.getAnimations(), HttpStatus.OK);
    }
}
