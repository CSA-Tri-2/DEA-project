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

    @PostMapping("/insertion")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getInsertionAnimations(@RequestBody InsertionRequest request) {
        int length = request.getLength();
        InsertionSort insertionSort = new InsertionSort(length);
        System.out.println(insertionSort.toStringArr());
        return new ResponseEntity<>(insertionSort.getAnimations(), HttpStatus.OK);
    }
}
