package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class CrypterReverse.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */

public class CrypterReverse implements Crypter {

	
	/**
	 *Diese Methode verdreht die Reihenfolge der Buchstaben, sodass der Text 
	 *rückwärts geschrieben wird
	 * 
	 * @param String 
 	 * @return String rückwärts 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		StringBuffer strBuf = new StringBuffer(message);
		return strBuf.reverse().toString();
	}

	/**
	 *Diese Methode gibt die Strings einzeln an die Ecrypt Methode, sodass der 
	 *Text rückwärts geschrieben wird
	 * 
	 * @param Liste 
 	 * @return Liste rückwärts 
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
	 *Diese Methode gibt den String an die Encrypt Methode weiter, diese verdreht
	 * die Reihenfolge der Buchstaben, sodass der Text 
	 *vorwärts geschrieben wird
	 * 
	 * @param String rückwärts 
 	 * @return String  
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return encrypt(cypherText);
	}
	
	/**
	 *Diese Methode gibt die Strings einzeln an die encrypt Methode, diese 
	 *verdreht die Reihenfolge der Buchstaben, sodass der Text 
	 *vorwärts geschrieben wird
	 * 
	 * @param Liste Rückwärts 
 	 * @return Liste vorwärts 
 	 * @throws CrypterException ein Fehler bei der Verschluesselung tritt auf 
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		return encrypt(cypherTexte);
	}

}
