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

    public MergeSort(int length, ArrayList<Integer> array) {
        super(length, array);
        animations = new ArrayList<>(); 
        addAnimationEntry(arr, -1, -1);
        this.mergeSortAnimation(0, length-1);
        addAnimationEntry(arr, -1, -1);

    }

    // Add an animation entry to the Animations arraylist.
    public void addAnimationEntry(ArrayList<Integer> sortedArr, int start, int end) {
        HashMap<String, ArrayList<Integer>> animationEntry = new HashMap<>();
        ArrayList<Integer> pair = new ArrayList<>();
        animationEntry.put("arr", new ArrayList<>(arr));
        pair.add(start);
        pair.add(end);
        animationEntry.put("pair", pair);
        animations.add(animationEntry);
    }

    // Standard Merge Sort algo
    public void mergeSortAnimation(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSortAnimation(start, middle);
            mergeSortAnimation(middle + 1, end);
            merge(start, middle, end);
        }
    }

    // Have to adopt an in-place sort here because I'm stupid LMAOOOOOOO
    public void merge(int start, int mid, int end) {
        int start2 = mid + 1;

        // Check if merging is necessary
        if (arr.get(mid) <= arr.get(start2)) {
            return;
        } 

        // Merge the two halves
        while (start <= mid && start2 <= end) {
            addAnimationEntry(arr, start, end);

            if (arr.get(start) <= arr.get(start2)) {
                start++;
            } else {
                int valueToInsert = arr.get(start2);
                int indexToInsert = start2;

                // Shift elements to the right to make space for the new element
                while (indexToInsert != start) {
                    arr.set(indexToInsert, arr.get(indexToInsert - 1));
                    indexToInsert--;
                }

                // Insert the element in its correct position
                arr.set(start, valueToInsert);

                // Update indices
                start++;
                mid++;
                start2++;
            }
        }
    }
}
