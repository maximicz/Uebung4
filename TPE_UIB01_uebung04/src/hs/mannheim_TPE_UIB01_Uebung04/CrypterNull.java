package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.List;

public class CrypterNull implements Crypter {

	@Override
	public String encrypt(String message) throws CrypterException {
		
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		
		return cypherTexte;
	}

}
