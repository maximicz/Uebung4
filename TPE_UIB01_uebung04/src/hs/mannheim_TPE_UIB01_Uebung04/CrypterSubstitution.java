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
	 * Konstruktor
	 * Ein Schlüssel für die CrypterSubstitution wird in diesem Konstruktor
	 * erzeugt.
	 *
	 * @param key
	 *            der Schlüssel
	 */
	public CrypterSubstitution(String key) {
		this.key = key;
	}

	/**
	 *Diese Methode ersetzt das normale Alphabet durch den übergegeben Schlüssel
	 *und verschlüsselt dadurch die Nachricht
	 * 
	 * @param String 
 	 * @return String verschlüsselt 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
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

	/**
	 *Diese Methode ersetzt das normale Alphabet durch den übergegeben Schlüssel
	 *und verschlüsselt dadurch die Nachricht
	 * 
	 * @param Liste
 	 * @return Liste verschlüsselt 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	/**
	 *Diese Methode ersetzt das normale Alphabet durch den übergegeben Schlüssel
	 *und entverschlüsselt dadurch die Nachricht
	 * 
	 * @param String verschlüsselt
 	 * @return String entschlüsselt
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
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

	/**
	 *Diese Methode ersetzt das normale Alphabet durch den übergegeben Schlüssel
	 *und entschlüsselt dadurch die Nachricht
	 * 
	 * @param Liste verschlüsselt 
 	 * @return Liste unverschlüsselt
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
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
