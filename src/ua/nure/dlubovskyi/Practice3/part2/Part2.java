package ua.nure.dlubovskyi.Practice3.part2;

public class Part2 {

	public String input;

	/**
	 * @param String
	 *            input
	 */
	public Part2(String input) {
		this.input = input;
	}

	/**
	 * Non parameters constructor.
	 */
	public Part2() {

	}

	/**
	 * Input setter.
	 * 
	 * @param input
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * Input getter.
	 * 
	 * @return
	 */
	public String getInput() {
		return input;
	}

	/**
	 * Method which find min and max words.
	 */
	public void findMinMax() {
		if (input == null) { // Checking for null string.
			System.out.println("Input can't be null!");
		}
		StringBuilder min = new StringBuilder();
		StringBuilder max = new StringBuilder();
		int currentMinValue = Integer.MAX_VALUE;
		int currentMaxValue = Integer.MIN_VALUE;
		String[] array = input.split("[^a-z&^A-Z]"); // RegExp for splitting input.
		for (int i = 0; i < array.length; i++) {
			if (max.toString().contains(array[i]) || min.toString().contains(array[i])) { // Checking for duplicates in
																							// result.
				continue;
			}
			if (array[i].length() < currentMinValue) { // Checking for less value.
				min.setLength(0); // Clear Sb.
				currentMinValue = array[i].length(); // Setting new min length.
				min.append(array[i] + ", ");
			} else if (array[i].length() == currentMinValue) { // Checking this string length is equal to current min.
				min.append(array[i] + ", ");
			} else if (array[i].length() > currentMaxValue) { // Checking for greater value.
				max.setLength(0);
				currentMaxValue = array[i].length();
				max.append(array[i] + ", ");
			} else if (array[i].length() == currentMaxValue) { // Checking this string length is equal to current max.
				max.append(array[i] + ", ");
			}
		}
		min.setLength(min.length() - 2);
		max.setLength(max.length() - 2);
		System.out.println("Min: " + min.toString() + "\nMax: " + max.toString());

	}

	public static void main(String[] args) {
		Part2 part2 = new Part2("When I was younger, so much younger than today I never needed anybody's "
				+ "help in any way But now these days are gone, I'm not so self-assured Now "
				+ "I find I've changed my mind I've opened up the doors");
		part2.findMinMax();
		part2.getInput();
	}
}
