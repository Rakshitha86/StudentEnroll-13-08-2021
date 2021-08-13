package com.xworkz.enroll.utility;

import java.security.SecureRandom;

public class RandomPasswordGenerator {

	public static String generateRandomPassword(int len) {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int randomIndex = secureRandom.nextInt(chars.length());
			stringBuilder.append(chars.charAt(randomIndex));
		}

		return stringBuilder.toString();
	}
}
