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

	/* (non-Javadoc)
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message) throws CrypterException {
		
		return message;
	}

	/* (non-Javadoc)
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#encrypt(java.util.List)
	 */
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		return messages;
	}

	/* (non-Javadoc)
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#decrypt(java.lang.String)
	 */
	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return cypherText;
	}

	/* (non-Javadoc)
	 * @see hs.mannheim_TPE_UIB01_Uebung04.Crypter#decrypt(java.util.List)
	 */
	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return cypherTexte;
	}

}
