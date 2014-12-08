package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.LinkedList;
import java.util.List;

public class CrypterReverse implements Crypter {

	
	@Override
	public String encrypt(String message) throws CrypterException {
		StringBuffer strBuf = new StringBuffer(message);
		return strBuf.reverse().toString();
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
		return encrypt(cypherTexte);
	}

}
