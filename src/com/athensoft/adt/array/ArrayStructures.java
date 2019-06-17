package com.athensoft.adt.array;

public class ArrayStructures {

	private int[] theArray = new int[50];
	private int arraySize = 10;

	public void generateRandomArray() {
		for (int i = 0; i < arraySize; i++)
			theArray[i] = (int) (Math.random() * 10) + 10;
	}

	public int getValueByIndex(int index) {

		if (index < arraySize)
			return theArray[index];
		return 0;
	}

	public boolean doseArrayContainThisValue(int searchValue) {
		boolean valueInArray = false;
		for (int i = 0; i < arraySize; i++) {
			if (theArray[i] == searchValue) {
				valueInArray = true;
			}
		}
		return valueInArray;
	}

	public void deleteIndex(int index) {

		if (index < arraySize) {
			for (int i = index; i < (arraySize - 1); i++) {
				theArray[i] = theArray[i + 1];

			}
			arraySize--;
		}

	}

	public void insertValueInTheEndOfArray(int value) {
		if (arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;

		}

	}

	public String LiearSearchForValue(int value) {

		boolean valueInArray = false;
		String indexsWithValue = "";
		System.out.print("The value of " + value + " is Found in the Index: ");

		for (int i = 0; i < arraySize; i++) {

			if (theArray[i] == value) {
				valueInArray = true;
				System.out.print(i + " ");
				indexsWithValue += i + " ";

			}
		}
		if (!valueInArray) {
			indexsWithValue = "None";
			System.out.print(indexsWithValue);
		}
		System.out.println();
		return indexsWithValue;
	}

	public static void main(String[] args) {

		ArrayStructures newArray = new ArrayStructures();

		newArray.generateRandomArray();

		newArray.printArray();

		System.out.println("the getValue is " + newArray.getValueByIndex(3));
		System.out.println("the value is " + newArray.doseArrayContainThisValue(17) + " in this array");

		newArray.deleteIndex(4);
		newArray.printArray();
		newArray.insertValueInTheEndOfArray(66);
		newArray.printArray();
		newArray.LiearSearchForValue(17);
	}

	public void printArray() {
		System.out.println("---------");
		for (int i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("---------");
		}

	}
}
