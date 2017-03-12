/**
 * Author: Shyam Bathina
 * Date: Mar 11, 2017
 * File Desc:This class implements 3 methods that can be used to return an array 
 * that has no duplicates while preserving the original order
 */
package com.sample.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class DeDup {

	public static void main(String[] args) {

		int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18,
				4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
				19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

		printArray(randomIntegers, "Original Array");

		int[] noDupesArray1 = convertToPrimitiveArray(removeDupUsingList(randomIntegers));
		int[] noDupesArray2 = convertToPrimitiveArray(removeDupUsingLinkedHashSet(randomIntegers));
		int[] noDupesArray3 = removeDuplicatesWithoutUsingCollections(randomIntegers);

		printArray(noDupesArray1, "removeDupUsingList");
		printArray(noDupesArray2, "removeDupUsingLinkedHashSet");
		printArray(noDupesArray3, "removeDuplicatesWithoutUsingCollections");
	}

	/**
	 * Option 1: Using ArrayList that preserves the order of elements
	 * 
	 * Pros: Type safety, cleaner and less complex code Cons: Memory usage and
	 * cpu timeis more than option 3
	 * 
	 * @param randomIntegers
	 * 
	 * @return
	 */
	private static Integer[] removeDupUsingList(int[] randomIntegers) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i : randomIntegers) {
			if (!intList.contains(i)) {
				intList.add(i);
			}
		}
		return (Integer[]) intList.toArray(new Integer[intList.size()]);
	}

	/**
	 * Option 2: Using LinkedHashSet which stores unique values and preserves
	 * order
	 * 
	 * Pros: Type Safety, cleaner and less code Cons: Memory usage and cpu time
	 * is more than Option 3
	 * 
	 * @param randomIntegers
	 * 
	 * @return
	 */
	private static Integer[] removeDupUsingLinkedHashSet(int[] randomIntegers) {
		LinkedHashSet<Integer> lhset = new LinkedHashSet<Integer>();

		for (int i : randomIntegers) {
			lhset.add(i);
		}
		return (Integer[]) lhset.toArray(new Integer[lhset.size()]);
	}

	/**
	 * Option 3: Without collections api
	 * 
	 * Pros: Requires less memory for int array when compared to ArrayList
	 * (Option 1) or LinkedHashSet (Option 2). Also, it's faster than the other
	 * 2 options
	 * 
	 * Cons: 1. This implementation is specific to int primitive type. This can
	 * be generalized to accept other primitive types. 2. Removing an element
	 * without using collections is cumbersome. 3. Type Safety
	 * 
	 * @param randomIntegers
	 * 
	 * @return
	 */
	private static int[] removeDuplicatesWithoutUsingCollections(int[] randomIntegers) {
		int length = randomIntegers.length;
		int[] uniqueArray = new int[length];
		int uniqueIndex = 0;
		for (int i = 0; i < length; i++) {
			boolean exists = false;
			for (int k = 0; k < uniqueArray.length; k++) {
				if (uniqueArray[k] == randomIntegers[i]) {
					exists = true;
				}
			}

			if (!exists) {
				uniqueArray[uniqueIndex] = randomIntegers[i];
				uniqueIndex++;
			}
		}
		int[] uniqueArrayWithCorrentLength = Arrays.copyOf(uniqueArray, uniqueIndex);
		return uniqueArrayWithCorrentLength;
	}

	/**
	 * Utility method to convert Integer ObjectArray to Primitive int array
	 * 
	 * @param objectArray
	 * @return
	 */
	private static int[] convertToPrimitiveArray(Integer[] objectArray) {
		if (objectArray != null) {
			int[] primitiveArray = new int[objectArray.length];
			int index = 0;
			for (Integer integer : objectArray) {
				primitiveArray[index] = integer.intValue();
				index++;
			}
			return primitiveArray;
		}
		return null;
	}

	/**
	 * Print values of the array
	 * 
	 * @param noDupesArray
	 * @param methodName
	 */
	private static void printArray(int[] noDupesArray, String methodName) {
		StringBuffer sb1 = new StringBuffer("");
		for (int i = 0; i < noDupesArray.length; i++)
			sb1.append(noDupesArray[i]).append(",");

		System.out.println(methodName + "= {" + sb1.toString().substring(0, sb1.length() - 1) + "} Length = "
				+ noDupesArray.length);
	}
}