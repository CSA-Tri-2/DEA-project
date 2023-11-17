package com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAnimationGenerator;

import java.util.ArrayList; 

public class InsertionSort extends SortingAnimationGenerator {
  public InsertionSort() {
    super();
  }

  public void insertionSortAnimation(int arr[]) {
    
  } 

  public void insertion(int arr[]) {
    // gets array length
    int n = arr.length;

    // searches through all values
    for (int i = 1; i < n; i++) {
      // gets original value
      int x = arr[i];
      // gets previous value to compare
      int j = i - 1;
  
      // while the index is within the range and if it is greater than the value after it
      while (j >= 0 && arr[j] > x) {
        // switch the two values
        arr[j + 1] = arr[j];
        j = j - 1;
      }

      // move to the next value in the array, setting as new key
      arr[j + 1] = x;
    }
  }
}
