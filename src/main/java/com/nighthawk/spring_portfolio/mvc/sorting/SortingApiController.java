package com.nighthawk.spring_portfolio.mvc.sorting;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.MergeSort;

@RestController
@RequestMapping("/api/sorting")
public class SortingApiController {
    private JSONObject body; //last run result
    private HttpStatus status; //last run status
    String last_run = null; //last run day of month

    @GetMapping("/merge")
    public ResponseEntity<ArrayList<HashMap<String, ArrayList<Integer>>>> getMergeAnimations(@RequestBody MergeRequest request) {
        int length = request.getLength();
        MergeSort mergeSort = new MergeSort(length);
        System.out.println(mergeSort.toStringArr());
        return new ResponseEntity<>(mergeSort.getAnimations(), HttpStatus.OK);

    }
}
