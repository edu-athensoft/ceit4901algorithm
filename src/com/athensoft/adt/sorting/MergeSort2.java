package com.athensoft.adt.sorting;

import java.util.Arrays;

/**
 * Merge Sort
 * without recursion
 * @author Athens
 *
 */
public class MergeSort2 {

	public static void main(String[] args) {
//		testMerge();
		testMergeSort();
	}

	private static void testMerge() {
		final int[] original = { 3, 4, 5, 6, 1, 2, 7, 8 };
		int[] out = new int[original.length];
		int mid = original.length / 2 - 1;
		System.out.println(Arrays.toString(merge(original, out, mid)));
	}

	private static void testMergeSort() {
		final int[] original = { 3, 4, 5, 6, 1, 9, 16, 13, 11, 2, 7, 8 };
		int[] out = new int[original.length];
		System.out.println(Arrays.toString(mergeSort(original, out)));
	}

	/**
	 * @param data original array
	 * @param out generated or temporary array
	 * @return sorted array
	 */
	private static int[] mergeSort(int[] data, int[] out) {
		final int N = data.length;
		for (int width = 1; width < N; width *= 2) {
			for (int i = 0; i < N; i = i + 2 * width) {
				merge(data, out, i, Math.min(i + width - 1, N - 1), Math.min(i + 2 * width - 1, N - 1));
			}
			System.arraycopy(out, 0, data, 0, N);
		}
		return out;
	}

	/**
	 * merge two ordered sub-arrays into one
	 * 
	 * @param data
	 * @param out
	 * @param LOW
	 * @param MID
	 * @param HIGH
	 * @return int[] merged sub-arrays
	 */
	private static int[] merge(int[] data, int[] out, final int LOW, final int MID, final int HIGH) {
		int i = LOW; // index of left[] and data[]
		int m = MID; // index of
		int j = MID + 1; // index of right[] of data[]
		int n = HIGH;
		int k = LOW; // index of out[]

		while (i <= m && j <= n) {
			if (data[i] < data[j]) {
				out[k++] = data[i++];
			} else {
				out[k++] = data[j++];
			}
		}

		while (i <= m) {
			out[k++] = data[i++];
		}

		while (j <= n) {
			out[k++] = data[j++];
		}

		return out;
	}

	private static int[] merge(int[] data, int[] out, final int MID) {
		return merge(data, out, 0, MID, data.length - 1);
	}

}
