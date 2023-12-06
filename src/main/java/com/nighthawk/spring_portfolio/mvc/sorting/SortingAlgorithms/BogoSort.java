package com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.nighthawk.spring_portfolio.mvc.sorting.SortingAnimationGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class BogoSort extends SortingAnimationGenerator {
	private ArrayList<HashMap<String, ArrayList<Integer>>> animations;
	public boolean sorted = false;

	public BogoSort(int length, ArrayList<Integer> array) {
		super(length, array);
		animations = new ArrayList<>();
		long start = System.nanoTime();
		addAnimationEntry(new ArrayList<>(arr), -1, -1);
		this.BogoSortAnimation();
		addAnimationEntry(new ArrayList<>(arr), -1 , -1);
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

	public ArrayList<HashMap<String, ArrayList<Integer>>> getAnimations() {
		return animations;
	}

	public void BogoSortAnimation() {
		if (!sorted) {
			bogo();
		}
	}

	public void bogo() {
		while (!isSorted(arr)) {
            int min = 0;
            int max = 4;
            int i = min + (int) (Math.random() * (max - min + 1));
            int j = min + (int) (Math.random() * (max - min + 1));

            shuffle(arr);
            addAnimationEntry(new ArrayList<>(arr), i, j);
        }
        sorted = true;
	}

    private void shuffle(ArrayList<Integer> a) {
        Random rand = new Random();
        for (int i = 1; i < a.size(); i++) {
            int j = rand.nextInt(i + 1);
            swap(a, i, j);
        }
    }

    private void swap(ArrayList<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    private boolean isSorted(ArrayList<Integer> a) {
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) < a.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
