package com.athensoft.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateRemover {

	public static void main(String[] args) {
		System.out.println(removeDuplicate());
//		
//		Integer a = 8;
//		Integer b = 8;
//		System.out.println(!a.equals(b));

	}
	
	public static List<Integer> removeDuplicate() {
		Integer[] arr = {8, 11, 20, 5, 20, 8, 0, 2, 4, 0, 8};
		
		List<Integer> arrList = Arrays.asList(arr);
		
		System.out.println("=====original array====");
//		for(Integer i: arr) {
//			System.out.print(i+",");
//		}
		
		System.out.println(arrList);
		System.out.println();
		
		System.out.println("=====processing====");
		System.out.println("size of original array is: "+arrList.size());
		
		List<Integer> resultArr = new ArrayList<>();
		
		resultArr.add(arr[0]);
		for(int i=0; i<arr.length; i++) {
			for(int k=0; k<resultArr.size(); k++) {
				if(resultArr.get(k)==arr[i]) {
					break;
				}
				if(k==resultArr.size()-1) {
					resultArr.add(arr[i]);
				}
			}
		}	
		
//		Integer[] result = new Integer[resultArr.size()];
		
		return resultArr;
	}

}
