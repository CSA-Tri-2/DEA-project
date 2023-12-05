package com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    public InsertionSort(int length, ArrayList<Integer> array) {
        super(length, array);
        animations = new ArrayList<>();
        long start = System.nanoTime();
        addAnimationEntry(new ArrayList<>(arr), -1, -1);
        this.insertionSortAnimation();
        addAnimationEntry(new ArrayList<>(arr), -1, -1);
        long end = System.nanoTime();
        Integer elapsedTime = (int) (end - start);
        HashMap<String, ArrayList<Integer>> animationTime = new HashMap<>();
        ArrayList<Integer> timeValue = new ArrayList<>();
        timeValue.add(elapsedTime);
        animationTime.put("time", timeValue);
        animations.add(animationTime);
    }

    public void addAnimationEntry(ArrayList<Integer> sortedArr, int num, int move) {
        HashMap<String, ArrayList<Integer>> animationEntry = new HashMap<>();
        ArrayList<Integer> integer = new ArrayList<>();
        animationEntry.put("arr", new ArrayList<>(sortedArr));
        integer.add(num);
        integer.add(move + 1);
        animationEntry.put("int", integer);
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
    
        Set<ArrayList<Integer>> allArrays = new HashSet<>();
    
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
    
                ArrayList<Integer> newArray = new ArrayList<>(arr);
    
                // check duplicates and replace first occurrence with x
                for (int k = j; k >= 0; k--) {
                    newArray.set(k + 1, x);
                    break;
                }
                if (j != -1) {
                    addAnimationEntry(newArray, i, j);
                    allArrays.add(newArray);
                }
            }
    
            // move to the next value in the array, setting as new key
            arr.set(j + 1, x);
    
            addAnimationEntry(arr, i, j);
            allArrays.add(arr);
        }
    
        sorted = true;
    }

    public static boolean hasDuplicates(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}