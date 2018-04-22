package ua.nure.dlubovskyi.Practice3.part3;

public class Part3 {

	/**
	 * @param string
	 * @return string where all first letters in upper case.
	 */
	public static String firstToUpper(String string) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			if (i == 0 || result.charAt(i - 1) == ' ') { // Checking for the first letter or letter after space.
				result.append(Character.toUpperCase(string.charAt(i))); // In case of truth up this letter and append.
			} else {
				result.append(string.charAt(i)); // Else append it.
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(firstToUpper("When I was younger\r\n" + "I never needed"));
	}
}