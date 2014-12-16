package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.List;

/**
 * The Class CrypterNull.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */

public class CrypterNull implements Crypter {

	/**
	 *Diese Methode gibt den String direkt wieder zurück, da keine Verschlüsselung
	 *stattfindet
	 * 
	 * @param String 
 	 * @return den String selbst 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		return message;
	}

	
	/**
	 *Diese Methode gibt die Liste direkt wieder zurück, da keine Verschlüsselung
	 *stattfindet
	 * 
	 * @param Liste 
 	 * @return die Liste selbst 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		return messages;
	}

	/**
	 *Diese Methode gibt den String direkt wieder zurück, da keine Entschlüsselung
	 *stattfindet
	 * 
	 * @param String 
 	 * @return den String selbst 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return cypherText;
	}

	/**
	 *Diese Methode gibt die Liste direkt wieder zurück, da keine Entschlüsselung
	 *stattfindet
	 * 
	 * @param Liste 
 	 * @return die Liste selbst 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return cypherTexte;
	}

}
