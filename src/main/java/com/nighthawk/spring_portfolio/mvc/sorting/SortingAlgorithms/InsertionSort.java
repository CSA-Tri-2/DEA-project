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
        
        addAnimationEntry(new ArrayList<>(arr));
        this.insertionSortAnimation();
        addAnimationEntry(new ArrayList<>(arr));
    }

    public void addAnimationEntry(ArrayList<Integer> sortedArr) {
        HashMap<String, ArrayList<Integer>> animationEntry = new HashMap<>();
        animationEntry.put("arr", new ArrayList<>(sortedArr));
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
            int jVal = arr.get(i - 1);
    
            // while the index is within the range and if it is greater than the value after it
            while (j >= 0 && arr.get(j) > x) {
                int oJ = jVal;
                int oX = x;

                // switch the two values
                arr.set(j + 1, arr.get(j));
    
                addAnimationEntry(new ArrayList<>(arr));
                System.out.println(new ArrayList<>(arr));
                System.out.println("while loop");

                j = j - 1;

                

                System.out.println("oJ: " + oJ + ", oX: " + oX);
                System.out.println("step");



                System.out.println();
            }
    
            // move to the next value in the array, setting as new key
            arr.set(j + 1, x);
            
            addAnimationEntry(new ArrayList<>(arr));
            System.out.println(new ArrayList<>(arr));
            System.out.println("for loop");
        }
    
        sorted = true;
    }    
}