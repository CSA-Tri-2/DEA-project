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
public class HeapSort extends SortingAnimationGenerator {
    private ArrayList<HashMap<String, ArrayList<Integer>>> animations;
    public boolean sorted = false;

    public HeapSort(int length, ArrayList<Integer> array) {
        super(length, array);
        animations = new ArrayList<>();
        long start = System.nanoTime();
        addAnimationEntry(new ArrayList<>(arr), -1, -1);
        this.heapSortAnimation();
        addAnimationEntry(new ArrayList<>(arr), -1, -1);
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
    }

    public void addAnimationEntry(ArrayList<Integer> sortedArr, int num, int move) {
        HashMap<String, ArrayList<Integer>> animationEntry = new HashMap<>();
        ArrayList<Integer> integer = new ArrayList<>();
        animationEntry.put("arr", new ArrayList<>(sortedArr));
        integer.add(num);
        integer.add(move);
        animationEntry.put("int", integer);
        animations.add(animationEntry);
        this.swaps++;
    }

    public void heapSortAnimation() {
        if (!sorted) {
            heap();
        }
    }

    public void heap() {
        int n = arr.size();

        // making heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heaping(n, i);
            addAnimationEntry(new ArrayList<>(arr), i, -1);
        }

        // extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            addAnimationEntry(new ArrayList<>(arr), i, 0);

            heaping(i, 0);
            addAnimationEntry(new ArrayList<>(arr), i - 1, -1);
        }
        sorted = true;
    }

    // creating heaps
    private void heaping(int n, int i) {

        // largest number
        int largest = i;
        // right val
        int l = 2 * i + 1;
        // left val
        int r = 2 * i + 2;

        // finding largest val
        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;

        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;

        // if not reached largest num
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            // continue heaping
            heaping(n, largest);
            addAnimationEntry(new ArrayList<>(arr), i, largest);
        }
    }
}