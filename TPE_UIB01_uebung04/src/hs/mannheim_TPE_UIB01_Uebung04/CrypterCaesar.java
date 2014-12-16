package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class CrypterCaesar.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */

public class CrypterCaesar implements Crypter {

	/** Das Schlüsselattribut */
	
	private String key;

	/**
	 * In diesem Konstruktor wird ein Schlüssel initialisiert.
	 *
	 * @param key
	 *            der Schlüssel
	 */
	public CrypterCaesar(String key) {

		this.key = key;
	}
/** 
 	 * Methode, die für eine uebergebene Nachricht die Verschiebungszahl erzeugt 
 	 * und eine Ausnahme des Typs "CrypterException" wirft. Die Nachricht und  
 	 * die Verschiebungsziffer werden an eine private, interne ecrypt Methode  
 	 * weitergeleitet. Dabei greifen wir aus die ASCII Tabelle zu.
 	 *  
 	 * @param message die zu verschluesselnde Nachricht 
 	 * @return der verschluesselte Text 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
 	 */ 

	
	@Override
	public String encrypt(String message) throws CrypterException {

		char buchstabe = key.charAt(0);
		int key = (int) buchstabe - 64;

		message = message.toUpperCase();
		char[] k = message.toCharArray();

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (((int) (c) >= 65) && ((int) (c) <= (90 - key))) {
				c = (char) (c + key);
				k[i] = c;
			} else if (((int) (c) > (90 - key)) && ((int) (c) <= 90)) {
				c = (char) (c + key - 26);
				k[i] = c;
			}
		}
		message = new String(k);
		return message;

	}

	/**
	 * Diese Methode macht das selbe wie die encrypt Methode, 
	 * nur wird dieses mal eine Liste verwendet.
	 * 
	 * @param Liste der Elemente 
 	 * @return die verschluesselte Liste 
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

	
	@Override
	public String decrypt(String cypherText) throws CrypterException {

		char buchstabe = key.charAt(0);
		int key = (int) buchstabe + 64 * (-1);

		cypherText = cypherText.toUpperCase();
		char[] k = cypherText.toCharArray();

		for (int i = 0; i < cypherText.length(); i++) {
			char c = cypherText.charAt(i);
			if (((int) (c) >= (65 + key)) && ((int) (c) <= (90))) {
				c = (char) (c - key);
				k[i] = c;
			} else if (((int) (c) >= 65) && ((int) (c) < (65 + key))) {

				c = (char) (c - key + 26);

				k[i] = c;
			}
		}
		cypherText = new String(k);
		return cypherText;

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
