package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Die Klasse CrypterSubstitution implementiert das Interface Cryptar und
 * verwendet eine eigen erzeugte Verschlüsselung. Die Buchstaben des Klartext
 * werden in die einzelnen Zeichen des Geheimtext substituiert.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */

public class CrypterSubstitution implements Crypter {

	/**
	 * Eine Map, welches den einzelnen Buchstaben auf den jeweiligen Zeichen
	 * abbildet.
	 */
	private Map<Character, Character> map = new HashMap<>();

	/** Der Schlüssel */
	private String key;

	/**
	 * Ein Schlüssel für die CrypterSubstitution wird in diesem Konstruktor
	 * erzeugt.
	 *
	 * @param key
	 *            der Schlüssel
	 */
	public CrypterSubstitution(String key) {
		this.key = key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int i = 0; i < alphabet.length(); ++i) {
			map.put(alphabet.charAt(i), key.charAt(i));
		}

		String a = new String("");
		for (int k = 0; k < message.length(); k++) {
			char c = message.charAt(k);
			a += Character.toString(map.get(c));
		}
		return a;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#encrypt(java.util.List)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0; i < alphabet.length(); ++i) {
			map.put(key.charAt(i), alphabet.charAt(i));
		}

		String a = new String("");
		for (int k = 0; k < cypherText.length(); k++) {
			char c = cypherText.charAt(k);
			a += Character.toString(map.get(c));
		}
		return a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#decrypt(java.util.List)
	 */
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
