package com.athensoft.linear.sorting;

/**
 * Quicksort Algorithm
 * 
 * 1. pick a Pivot from the array
 *    here I choose the first element from the unsorted array
 * 2. partitioning
 * 3. recursively apply above steps to sub-arrays
 * 
 * @author Athensoft
 *
 */
public class QuickSort {

	private static int pivot = 0;
	
	public static void main(String[] args) {
		int[] num = {3,6,2,78,23,657,23,2,0,545,32,5};
		
		System.out.println("The original array: ");
		printArray(num);
		System.out.println("=====");
		
		sort(num);
		System.out.println("The sorted array: ");
		printArray(num);
	}
	
	public static int[] sort(int[] a) {
		quickSort(a, 0, a.length-1);
		return a;
	}
	
	private static void quickSort(int[] a, int index_left, int index_right) {
		final int CUTOFF = 2;
		
		if(CUTOFF < index_right - index_left) {
			pivot = getPivot(a, index_left, index_right);
			
			int i = index_left;
			int j = index_right-1;
			
			while(true) {
				while (a[++i] < pivot) {}
				while (a[--j] > pivot) {}
				if(i<j) {
					swap(a,i,j);
				}else {
					break;
				}
			}
			swap(a, i, index_right-1);
			
			printArray(a);
			System.out.println("=====");
			
			//quicksort for sub-arrays
			quickSort(a, index_left, i-1);
			quickSort(a, i+1, index_right);
			
			
			
		}else {
			if(a[index_left]>a[index_right]) {
				a = swap(a, index_left, index_right);
			}
		}
	}
	
	
	/**
	 * set the median as Pivot
	 * first, center and last element of the array
	 * 
	 * @param a
	 * @param index_left
	 * @param index_right
	 * @return
	 */
	private static int getPivot(int[] a, int index_left, int index_right) {
		int INDEX_LEFT = index_left;
		int INDEX_RIGHT = index_right;
		int INDEX_CENTER = (INDEX_LEFT+INDEX_RIGHT)/2;
		
		System.out.println("index = "+INDEX_LEFT+","+INDEX_CENTER+","+INDEX_RIGHT);
		System.out.println("value before = "+a[INDEX_LEFT]+","+a[INDEX_CENTER]+","+a[INDEX_RIGHT]);
		
		if(a[INDEX_LEFT]>a[INDEX_CENTER]) {
			a = swap(a, INDEX_LEFT, INDEX_CENTER);
		}
		
		if(a[INDEX_LEFT]>a[INDEX_RIGHT]) {
			a = swap(a, INDEX_LEFT, INDEX_RIGHT);
		}
		
		if(a[INDEX_CENTER]>a[INDEX_RIGHT]) {
			a = swap(a, INDEX_CENTER, INDEX_RIGHT);
		}
		//a[INDEX_LEFT] <= a[INDEX_CENTER] <= a[INDEX_RIGHT]
		
		System.out.println("value after = "+a[INDEX_LEFT]+","+a[INDEX_CENTER]+","+a[INDEX_RIGHT]);
		
		//set the median to the position of right-1
		a = swap(a, INDEX_CENTER, INDEX_RIGHT-1);
		printArray(a);
		
		pivot = a[INDEX_RIGHT-1];
		System.out.println("pivot = "+pivot);
		
		return pivot;
	}
	
	private static int[] swap(int[] a, final int INDEX_I, final int INDEX_J) {
		int temp =0;
		temp = a[INDEX_I];
		a[INDEX_I] = a[INDEX_J];
		a[INDEX_J] = temp;
		return a;
	}
	
	private static void printArray(int[] a) {
		for(int x: a) {
			System.out.print(x+",");
		}
		System.out.println();
	}

}
