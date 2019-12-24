package com.athensoft.adt.array;

/**
 * @author Rickless
 *
 */
public class ArrayDemo {

	public int[] myArray;
	
	public ArrayDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public static int[] createArray() {
		final int ARRAY_SIZE = 50;
		int[] indexArray = new int[ARRAY_SIZE];
		return indexArray;
	}

	/**
	 * @param ARRAY_SIZE
	 * @return
	 */
	public static int[] createArray(final int ARRAY_SIZE) {
		int[] indexArray = new int[ARRAY_SIZE];
		return indexArray;
	}

	/**
	 * @param targetArray
	 */
	public static void printArray(int[] targetArray) {
		for (int i = 0; i < targetArray.length; i++) {
			System.out.println(i + ":" + targetArray[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 int[]myArray = createArray(10);
		printArray(myArray);
	
	}
	
	public int getValueByIndex(int index) {

		if (index < myArray.length)
			return myArray[index];
		return 0;
	}

}
