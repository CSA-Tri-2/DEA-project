package com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

import com.nighthawk.spring_portfolio.mvc.sorting.SortingAnimationGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class MergeSort extends SortingAnimationGenerator {
    private ArrayList<HashMap<String, ArrayList<Integer>>> animations;
    public MergeSort(int length) {
        super(length);
        animations = new ArrayList<HashMap<String, ArrayList<Integer>>>();
    }

    public void mergeSortAnimation(int start, int end) {
        if (start < end) {
            int middle = (start+end)/2;
            mergeSortAnimation(start, middle);
            mergeSortAnimation(middle+1, end);
            merge(start, middle, end);
        }
        
    }

    public void merge(int start, int mid, int end) {
        int start2 = mid + 1;
        if (arr.get(start2) >= arr.get(start)) {
            return ;
        }
        while (start <= mid && start2 <= end+1) {
            HashMap<String, ArrayList<Integer>> animationEntry = new HashMap<String, ArrayList<Integer>>();
            ArrayList<Integer> pair = new ArrayList<Integer>();
            pair.add(start);
            pair.add(start2);
            if (arr.get(start) <= arr.get(start2)) {
                
                start++;
            } else {
                int temp = arr.get(start2);
                int index = start2;
                while (index > start) {
                    arr.set(index, arr.get(index--));
                }
                arr.set(index, temp);
                start++;
                mid++;
                start2++;
            }
            animationEntry.put("arr", arr);
            animationEntry.put("pair", pair); 
            animations.add(animationEntry);
        }

    }
}
