package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.LinkedList;
import java.util.List;

public class CrypterXOR implements Crypter {

	private final char[] key;
	
	public CrypterXOR(String key) {

		this.key = key.toCharArray();

	}

	@Override
	public String encrypt(String message) throws CrypterException {

		message = message.replaceAll("[^@-_]", "");

		char[] chars = message.toCharArray();

		for (int i = 0; i < chars.length; i++) {

			chars[i] = (char) ((chars[i] - '@') ^ (key[i % key.length] - '@')+'@');

		}

		return String.valueOf(chars);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return encrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : cypherTexte) {
			ergebnis.add(decrypt(message));
		}
		return ergebnis;
	}
}
