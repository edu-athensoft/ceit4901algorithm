package com.athensoft.adt.sorting;

import java.util.Arrays;

public class MergeSortWithoutRecursion {

	public static void main(String[] args) {
		final int[] origin = {1,4,6,7,9,2,5,8};
		
		System.out.println(Arrays.toString(mergeSortWithoutRecursion(origin)));
	}

	private static int[] mergeSortWithoutRecursion(int[] origin) {
		final int LEN = origin.length;
        int k = 1;
        
        int[] result = new int[0];
        while(k < LEN)
        {
            result = mergePass(origin, k);
            k *= 2;         
        }
		return result;
	}

	private static int[] mergePass(int[] arr, final int k) {
		final int SIZE = arr.length;
		int low = 0;
//		int j;

		// 从前往后,将2个长度为k的子序列合并为1个
		
		int[] result = new int[0];
		while (low < SIZE-2*k+1) {
			int[] left = Arrays.copyOfRange(arr, low, low+k);
			int[] right = Arrays.copyOfRange(arr, low+k, low+2*k);
			result = new int[left.length+right.length];
			result = merge(left,right);
//			merge(arr, i, i + k-1, i + 2*k - 1);
			low += 2 * k;
		}

		// 这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
		if (low < SIZE-k) {
			int[] left = Arrays.copyOfRange(arr, low, low+k);
			int[] right = Arrays.copyOfRange(arr, low+k, SIZE);
			result =  merge(left, right);
//			merge(arr, low, low+k-1, SIZE-1);
		}
		
		return result;
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
}
