package com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms;

import java.util.ArrayList;

import com.nighthawk.spring_portfolio.mvc.sorting.SortingAnimationGenerator; 

public class MergeSort extends SortingAnimationGenerator {
    public MergeSort() {
        super();
    }

    public void mergeSortAnimaion(int start, int end) {
        if (start < end) {
            int middle = (start+end)/2;
            mergeSortAnimaion(start, middle);
            mergeSortAnimaion(middle+1, end);
            merge(start, middle, end);
        }
        
    }

    public void merge(int start, int mid, int end) {
        int start2 = mid + 1;
        

    }
}
