package com.athensoft.adt.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] num = {4,5,2,7,8,9,1,6,3,0};
		
		//printArray(sort(num));
		sort(num);
		

	}
	
	public static void printArray(int[] a) {
		for(int x : a) {
			System.out.print(x+"\t");
		}
		System.out.println();
	}
	
	public static int[] sort(int[] a) {
		int temp = 0;
		for(int i=0; i<a.length-1; i++) {
			for(int j=0; j<a.length-1-i; j++) {
				if(a[j]>a[j+1]) {
					temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			printArray(a);
		}
		return a;
	}

}
