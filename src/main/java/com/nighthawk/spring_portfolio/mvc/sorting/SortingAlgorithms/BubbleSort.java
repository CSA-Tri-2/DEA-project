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
public class BubbleSort extends SortingAnimationGenerator {
	private ArrayList<HashMap<String, ArrayList<Integer>>> animations;
	public boolean sorted = false;

	public BubbleSort(int length, ArrayList<Integer> array) {
		super(length, array);
		animations = new ArrayList<>();
		// long start = System.nanoTime();
		addAnimationEntry(new ArrayList<>(arr), -1, -1);
		this.BubbleSortAnimation();
		addAnimationEntry(new ArrayList<>(arr), -1, -1);
		// long end = System.nanoTime();
		// Integer elapsedTime = (int) (end - start);
		// HashMap<String, ArrayList<Integer>> animationTime = new HashMap<>();
		// ArrayList<Integer> timeValue = new ArrayList<>();
		// timeValue.add(elapsedTime);
		// animationTime.put("time", timeValue);
		// animations.add(animationTime);
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

	public void BubbleSortAnimation() {
		if (!sorted) {
			bubble();
		}
	}

	public void bubble() {
		int n = arr.size();
		int i, j, temp;
		boolean swapped;

		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {

					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			if (swapped == false)
				break;
		}
		sorted = true;
	}
}
