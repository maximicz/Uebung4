package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class CrypterXOR.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */

public class CrypterXOR implements Crypter {

	/** The key
	 * 
	 */
	
	private final char[] key;
	
	/**
	* Konstruktur um ein XOR Verschluesselungsobjekt mit einem festgelegten
	* Schluessel zu erzeugen.
	*
	* @param key der gewuenschte Schluessel
	*/
	
	public CrypterXOR(String key) {

		this.key = key.toCharArray();

	}

	/**
	 *Diese Methode verschlüsselt die Nachricht, indem es die Einzelnen Zeichen 
	 *per XOR verbindet.
	 * 
	 * @param String 
 	 * @return String verschlüsselt 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		
		if(!checkMessage(message)){ 
			 			throw new CrypterException("Ungültige Zeichen in der Nachricht"); 
		}
		else {
		message = message.replaceAll("[^@-_]", "");

		char[] chars = message.toCharArray();

		for (int i = 0; i < chars.length; i++) {

			chars[i] = (char) ((chars[i] - '@') ^ (key[i % key.length] - '@')+'@');

		}

		return String.valueOf(chars);
		}
	}

	/**
	 *Diese Methode ruft mit einzelnen Strings die encrypt Methode auf und 
	 *verschlüsselt die Nachricht, indem es die Einzelnen Zeichen 
	 *per XOR verbindet.
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
	 *Diese Methode entschlüsselt die Nachricht, indem es die Einzelnen Zeichen 
	 *per XOR verbindet und somit den unverschlüsselten Text erhält.
	 * 
	 * @param String 
 	 * @return String verschlüsselt 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return encrypt(cypherText);
	}

	/**
	 *Diese Methode entschlüsselt die Liste, indem es mit einzelnen Strings die 
	 *decrypt methode aufruft, die die Einzelnen Zeichen 
	 *per XOR verbindet und somit den unverschlüsselten Text zurückliefert.
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
	
	public boolean checkMessage(String message){ 
 		message = message.toUpperCase(); 
 		for(int i = 0; i < message.length(); i++){ 
 			if(message.charAt(i) >= 64 || message.charAt(i) <= 95){ 
 				return true; 
 			} 
 		} 
 		return false; 
}
}
