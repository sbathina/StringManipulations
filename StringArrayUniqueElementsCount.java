package com.javaprep.core;

/**
*
* It is well known that launch codes work both forward and reverse,
* meaning that code "123" is effectively the same as code "321", a major
* security flaw which we have top people working to correct. Someone has stolen
* an extremely long list of launch codes, and you want to see how many
* "effective" codes were stolen, so that you know what codes to replace.
*
* Determine how many unique codes are contained in an array of nuclear launch
* codes.
*
* Please report the big-O runtime complexity of your solution
*
*
*/


public class StringArrayUniqueElementsCount {

	public static int getNumUniqueCodes(String[] codes) {

		return 0;

	}

	public static void main(String[] args) {
		String[][] tests = { { "xy", "yx" }, // expected 1
				{ "xy", "yx", "asdf", "fdsa" }, // expected 2
				{ "x", "x" }, // expected 1
				{ "xy", "yx", "asdf", "fdsa", "qwer", "yxy", "yxy" }, // expected
																		// 4
				{ "xy", "yx", "xy", "xy", "asdf", "fdsa", "qwer", "yxy", "yxy" }, // expected
																					// 4
				{ "" }, // expected 1
				{}, // expected 0
				{ "xy" }, // expected 1
				{ "xy", "yxz" }, // expected 2
				{ " abc", " cba" }, // expected 2
				{ "abc", "xyz", "abc", "123", "zyx" }, // expected 3
				{ "abcd", "dbca" } // expected 2
		};

		int[] expected = { 1, 2, 1, 4, 4, 1, 0, 1, 2, 2, 3, 2 };

		boolean allTestPassed = true;
		for (int i = 0; i < tests.length; i++) {
			int numDetected = getNumUniqueCodes(tests[i]);
			if (numDetected != expected[i]) {
				allTestPassed = false;
				System.out.println("Incorrect number of codes for test case " + i + ". Expected " + expected[i]
						+ ", but detected " + numDetected);
			}
		}
		if (allTestPassed) {
			System.out.println("All Tests Pass!");
		}
	}

}
