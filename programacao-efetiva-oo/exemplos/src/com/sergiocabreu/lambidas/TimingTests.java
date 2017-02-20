package com.sergiocabreu.lambidas;

import java.util.Arrays;

public class TimingTests {

	public static void main(String[] args) {

		for (int i = 3; i < 8; i++){
		
			int size = (int) Math.pow(10, i);
			System.out.printf("Sorting array of length %,d.%n", size);
			
			TiminUtils.timeOp(() -> sortArray(size));
		}
		
	}

	private static void sortArray(int size) {

		double[] nums = randonNums(size);
		
		Arrays.sort(nums);
	}

	private static double[] randonNums(int size) {

		double[] nums = new double[size];
		
		for (int i = 0; i < size; i++) {
			nums[i] = Math.random();
		}
		
		return nums;
	}
}
