package com.athensoft.adt.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		
//		testMerge();
		
		final int[] origin = {1,4,6,7,9,2,5,8};
//		int[] result = new int[origin.length];
		
		System.out.println(Arrays.toString(mergeSort(origin)));
	}
	
	private static int[] mergeSort(int[] origin) {
		final int SIZE = origin.length;
		int mid = SIZE / 2;
		int[] left = Arrays.copyOfRange(origin, 0, mid);
		int[] right = Arrays.copyOfRange(origin, mid, SIZE);
		if(SIZE>1) {
			return merge(mergeSort(left),mergeSort(right));
		}else {
			return origin;
		}
	}
	
	
	private static int[] merge(int[] left, int[] right) {
		final int LEFT_SIZE = left.length;
		final int RIGHT_SIZE = right.length;
		int[] result = new int[LEFT_SIZE + RIGHT_SIZE];
		
		int leftPos = 0;
		int rightPos = 0;
		int k = 0; 		//index of result[]
		
		while(leftPos<LEFT_SIZE && rightPos<RIGHT_SIZE) {
			if(left[leftPos] < right[rightPos]) {
				result[k++] = left[leftPos++];
			}else {
				result[k++] = right[rightPos++];
			}
		}
		
		//current index of result is k
		while(leftPos<LEFT_SIZE) {
			result[k++] = left[leftPos++];
		}
		
		while(rightPos<RIGHT_SIZE) {
			result[k++] = right[rightPos++];
		}
		
		return result;
	}
	
	private static void print(int[] array) {
		for(int item: array) {
			System.out.print(item+",");
		}
	}
	
	private static void testMerge() {
		final int[] left = {1,4,6,7,9};
		final int[] right = {2,5,8};
		
		int[] result = merge(left, right);
		print(result);
	}
}
