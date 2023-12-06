package com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

import com.nighthawk.spring_portfolio.mvc.sorting.SortingAnimationGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class QuickSort extends SortingAnimationGenerator {
    private ArrayList<HashMap<String, ArrayList<Integer>>> animations;

    public QuickSort(int length, ArrayList<Integer> array) {
        super(length, array);
        animations = new ArrayList<>();
        long start = System.nanoTime();
        this.addAnimationEntry(this.arr, -1, -1, -1);
        this.quickSortAnimation(0, length-1);
        this.addAnimationEntry(this.arr, -1, -1, -1);
        long end = System.nanoTime();
        Integer elapsedTime = (int) (end - start);
        HashMap<String, ArrayList<Integer>> animationTime = new HashMap<>();
        ArrayList<Integer> timeValue = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> animationSwaps = new HashMap<>();
		ArrayList<Integer> swapsValue = new ArrayList<>();
		swapsValue.add(this.swaps);
		animationSwaps.put("swaps", swapsValue);
		animations.add(animationSwaps);
        timeValue.add(elapsedTime);
        animationTime.put("time", timeValue);
        animations.add(animationTime);
        this.swaps++;
    }

    // Add an animation entry to the Animations arraylist.
    public void addAnimationEntry(ArrayList<Integer> sortedArr, int pivotPos, int current, int pivot) {
        HashMap<String, ArrayList<Integer>> animationEntry = new HashMap<>();
        ArrayList<Integer> values = new ArrayList<>();
        animationEntry.put("arr", new ArrayList<>(arr));
        values.add(pivotPos);
        values.add(current);
        values.add(pivot);
        animationEntry.put("values", values);
        animations.add(animationEntry);

    }

    // Standard Merge Sort algo
    public void quickSortAnimation(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);
            quickSortAnimation(low, pivot-1);
            quickSortAnimation(pivot+1, high);
        }
    }

    public int partition(int low, int high){
        int pivot = this.arr.get(high);
        int pivotPos = low-1;
        int current = low;
        while(current <= high) {
            if (this.arr.get(current)<pivot) {
                pivotPos++;
                this.addAnimationEntry(this.arr, pivot, current, high);
                Collections.swap(this.arr, pivotPos, current);
            }
            current++;
        }
        this.addAnimationEntry(this.arr, pivot, current, high);
        Collections.swap(this.arr, pivotPos+1, high);
        return pivotPos+1;

    }
}
