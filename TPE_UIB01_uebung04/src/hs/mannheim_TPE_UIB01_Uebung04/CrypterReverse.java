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

	
	/* (non-Javadoc)
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		StringBuffer strBuf = new StringBuffer(message);
		return strBuf.reverse().toString();
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return encrypt(cypherText);
	}

	/* (non-Javadoc)
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#decrypt(java.util.List)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		return encrypt(cypherTexte);
	}

}
