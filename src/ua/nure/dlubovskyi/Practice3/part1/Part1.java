package ua.nure.dlubovskyi.Practice3.part1;

import java.util.Random;

public class Part1 {
	private static final String INPUT = "Login;Name;Email\n" + "ivanov;Ivan Ivanov;ivanov@mail.ru\n"
			+ "petrov;Petr Petrov;petrov@google.com\n" + "obama;Barack Obama;obama@google.com\n"
			+ "bush;George Bush;bush@mail.ru";

	/**
	 * @return string with logins and email.
	 */
	public static String convert1() {
		StringBuilder result = new StringBuilder();
		String[] values = INPUT.split("\n");
		String[] lines = new String[values.length];
		for (int i = 1; i < values.length; i++) {
			lines = values[i].split(";");
			result.append(lines[0] + " ==> " + lines[2] + "\n");
		}
		return result.toString();

	}

	/**
	 * @return string with names and email.
	 */
	public static String convert2() {
		String[] values = INPUT.split("\n");
		String[] elements = new String[values.length];
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < values.length; i++) {
			elements = values[i].split(";");
			result.append(elements[1] + " (email: " + elements[2] + ")" + "\n");
		}
		return result.toString();
	}

	/**
	 * @return string with email logins and email domains.
	 */
	public static String convert3() {
		String[] lines = INPUT.split("[;|\n]");
		String[] emails = new String[(INPUT.split("[\\n]")).length - 1]; // Creating array for email.
		int emailArrayIndex = 0;
		for (int i = 0; i < lines.length; i++) { // Filling an email array.
			if (lines[i].contains("@")) {
				emails[emailArrayIndex] = lines[i];
				emailArrayIndex++;
			}
		}
		StringBuilder mailRu = new StringBuilder("mail.ru ==> "); // Builder for mail.ru domain.
		StringBuilder google = new StringBuilder("google.com ==> "); // Builder for google.com domain.
		for (String email : emails) {
			if (mailRu.toString().contains(email) || google.toString().contains(email)) { // Checking for duplicates.
				continue;
			}
			if (email.contains("@mail.ru")) { // Checking for mail.ru domain
				mailRu.append(email.substring(0, email.indexOf("@")) + ", "); // Adding value to the builder.

			} else if (email.contains("@google.com")) { // Checking for google.com domain
				google.append(email.substring(0, email.indexOf("@")) + ", ");
			}
		}
		mailRu.setLength(mailRu.length() - 2);
		google.setLength(google.length() - 2);
		return mailRu + "\n" + google + "\n";
	}

	/**
	 * 
	 * @return string of all users with generating passwords.
	 */
	public static String convert4() {
		String[] values = INPUT.split("\n"); // Splitting
		String[] elements = new String[values.length];
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			elements = values[i].split(";"); // Formatting result.
			result.append(i == 0 ? elements[0] + ";" + elements[1] + ";" + elements[2] + ";" + "Password" + "\n"
					: elements[0] + ";" + elements[1] + ";" + elements[2] + ";" + generatePassword() + "\n");

		}
		return result.toString();
	}

	/**
	 * @return random generated password.
	 * 
	 */
	public static String generatePassword() {
		Random random = new Random();
		return random.nextInt(10) + "" + random.nextInt(10) + "" + random.nextInt(10) + "" + random.nextInt(10);
	}

	public static void main(String[] args) {
		System.out.println(convert1());
		System.out.println(convert2());
		System.out.println(convert3());
		System.out.println(convert4());

	}

}
