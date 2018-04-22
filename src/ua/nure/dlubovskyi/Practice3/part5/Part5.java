package ua.nure.dlubovskyi.Practice3.part5;

import java.util.LinkedHashMap;
import java.util.Map;

public class Part5 {
	/**
	 * Map that contains main Roman values.
	 */
	private static Map<String, Integer> romanNums = new LinkedHashMap<String, Integer>();

	// Filling the map on class loading.
	static {
		romanNums.put("C", 100);
		romanNums.put("XC", 90);
		romanNums.put("L", 50);
		romanNums.put("XL", 40);
		romanNums.put("X", 10);
		romanNums.put("IX", 9);
		romanNums.put("V", 5);
		romanNums.put("IV", 4);
		romanNums.put("I", 1);
	}

	/*
	 * This method fills an intermediate Roman digits to string.
	 */
	public static String numConvertor(String romanValue, int decimalValue) {
		if (romanValue == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < decimalValue; i++) {
			result.append(romanValue); // Appending equal Roman number (like III) to result.
		}
		return result.toString();
	}

	/**
	 * @param num
	 * @return converted to Roman value
	 * 
	 */
	public static String decimalToRoman(int decimalNum) {
		StringBuilder romanNum = new StringBuilder();
		for (Map.Entry<String, Integer> mapEntry : romanNums.entrySet()) {
			int numMatch = decimalNum / mapEntry.getValue(); // Taking integer from division to fill a Roman number.
			romanNum.append(numConvertor(mapEntry.getKey(), numMatch));
			decimalNum %= mapEntry.getValue(); // Getting the next part of the number.
		}
		return romanNum.toString();
	}

	/**
	 * 
	 * @param s
	 * @return converted to decimal value.
	 */
	public static int romanToDecimal(String s) {
		int res = 0; // Result converted value.
		String temp = new String(s);
		while (!temp.equals("")) {
			for (Map.Entry<String, Integer> entry : romanNums.entrySet()) {
				if (temp.contains(entry.getKey()) && entry.getKey().length() == 2) { // Checking for a Roman number
																						// containing which length more
																						// than 2.

					res += entry.getValue(); // Sum containing decimal value from map.
					temp = temp.replaceFirst(entry.getKey(), ""); // Shift to the next part of a Roman number.
				}
			}
			for (Map.Entry<String, Integer> entry : romanNums.entrySet()) { // A similar operation of the previous, but
																			// with numbers which length is 1.
				if (temp.contains(entry.getKey())) {
					res += entry.getValue();
					temp = temp.replaceFirst(entry.getKey(), "");
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i + " ====> " + decimalToRoman(i) + " ====> " + romanToDecimal(decimalToRoman(i)));
		}
	}
}
