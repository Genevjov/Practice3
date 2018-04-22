package ua.nure.dlubovskyi.Practice3.part4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Part4 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(hash("password", "SHA-256"));
		System.out.println(hash("passwort", "SHA-256"));

	}

	/**
	 * @param value
	 * @param algorithm
	 * @return encrypted data using transmitted algorithm
	 * @throws NoSuchAlgorithmException
	 * @see {@link DatatypeConverter}
	 * @see MessageDigest
	 */
	public static String hash(String value, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm); // Getting an algorithm.
		digest.update(value.getBytes()); // Converting data to bytes.
		byte[] bytes = digest.digest(); // Creating byte array with converted.
		return DatatypeConverter.printHexBinary(bytes); // Returning an encrypted value from array.
	}
}
