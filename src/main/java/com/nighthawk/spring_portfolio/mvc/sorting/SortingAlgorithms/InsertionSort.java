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
public class InsertionSort extends SortingAnimationGenerator {
    private ArrayList<HashMap<String, ArrayList<Integer>>> animations;
    public boolean sorted = false;

    public InsertionSort(int length) {
        super(length);
        animations = new ArrayList<>();
        
        addAnimationEntry(arr, 1);
        this.insertionSortAnimation();
        addAnimationEntry(arr, 0);
    }

    public void addAnimationEntry(ArrayList<Integer> sortedArr, int start) {
        HashMap<String, ArrayList<Integer>> animationEntry = new HashMap<>();
        ArrayList<Integer> index = new ArrayList<>();
        animationEntry.put("arr", new ArrayList<>(sortedArr));
        index.add(start);
        animationEntry.put("index", index);
        animations.add(animationEntry);
    }

    public ArrayList<HashMap<String, ArrayList<Integer>>> getAnimations() {
        return animations;
    }

    public void insertionSortAnimation() {
        if (!sorted) {
            insertion();
        }
    }

    public void insertion() {
        // gets array length
        int n = arr.size();

        // searches through all values
        for (int i = 1; i < n; i++) {
            // gets original value
            int x = arr.get(i);
            // gets previous value to compare
            int j = i - 1;

            // while the index is within the range and if it is greater than the value after it
            while (j >= 0 && arr.get(j) > x) {
                // switch the two values
                arr.set(j + 1, arr.get(j));
                
                j = j - 1;
                
            }

            // move to the next value in the array, setting as new key
            arr.set(j + 1, x);
            addAnimationEntry(new ArrayList<>(arr), i);
        }

        sorted = true;
    }
}