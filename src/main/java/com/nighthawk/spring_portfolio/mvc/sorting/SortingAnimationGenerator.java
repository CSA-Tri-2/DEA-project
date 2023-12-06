package com.nighthawk.spring_portfolio.mvc.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public abstract class SortingAnimationGenerator {
    protected ArrayList<Integer> arr;
    protected int swaps;

    public SortingAnimationGenerator(int length) {
        arr = new ArrayList<Integer>();
        System.out.println("I am ran");
        for (int i = 0; i < length; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
    }

    public SortingAnimationGenerator(int length, ArrayList<Integer> array) {
        arr = array;
    }
    
    public String toStringArr() {
        int n = this.arr.size();
        String array = "";
        for (int i = 0; i < n; i++) {
             array = array + this.arr.get(i) + " ";
        }
        return array;
    }
    
}

